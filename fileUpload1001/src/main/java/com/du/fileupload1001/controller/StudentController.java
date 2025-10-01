package com.du.fileupload1001.controller;

import com.du.fileupload1001.entity.ImageEntity;
import com.du.fileupload1001.entity.StudentEntity;
import com.du.fileupload1001.repository.ImageRepository;
import com.du.fileupload1001.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final ImageRepository imageRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String studentPage(Model model){
        List<StudentEntity> studentEntityList = studentService.findAll();
        model.addAttribute("student",studentEntityList);
        return "list";
    }

    @PostMapping("/new")
    public String newStudentPage(@ModelAttribute StudentEntity studentEntity){
        studentService.insert(studentEntity);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String studentDetailPage(@PathVariable Long id, Model model){
        StudentEntity studentEntity = studentService.findById(id);
        model.addAttribute("one",studentEntity);

        // 해당 학생의 이미지 목록을 직접 리포지토리를 사용해 조회하여 전달
        List<ImageEntity> imageList = imageRepository.findByStudent_Id(id);
        model.addAttribute("images", imageList);

        return "detail";
    }

    // ---  이미지 업로드 기능 추가 (컨트롤러에서 직접 처리)  ---
    @PostMapping("/uploadImage")
    @Transactional // 컨트롤러에서 DB 저장을 직접 하므로 반드시 트랜잭션을 적용해야 합니다.
    public String uploadImage(
            @RequestParam("studentId") Long studentId,
            @RequestParam("file") MultipartFile file) throws IOException {

        // 1. 학생 Entity 조회 (관계 설정을 위해 필요)
        StudentEntity student = studentService.findById(studentId);

        // 2. 파일 저장 로직 (Controller에 직접 구현)
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            String newFilename = uuid + "_" + originalFilename;

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            File destFile = new File(uploadDir, newFilename);
            file.transferTo(destFile);

            // 3. ImageEntity 생성 및 관계 설정
            ImageEntity image = new ImageEntity();
            image.setFileName(originalFilename);
            image.setFilePath("/uploads/" + newFilename);

            // ImageEntity의 ManyToOne 관계 설정
            image.setStudent(student);

            // 4. ImageEntity 저장
            imageRepository.save(image); // ⭐️ Repository 직접 사용
        }

        // 성공 후 학생 상세 페이지로 리다이렉트
        return "redirect:/detail/" + studentId;
    }
}
