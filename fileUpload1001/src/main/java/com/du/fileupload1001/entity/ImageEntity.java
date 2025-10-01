package com.du.fileupload1001.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String filePath;

    // 단방향 다대일 (ManyToOne) 관계 설정
    // Image는 Student를 참조하지만, Student는 Image에 대해 모름.
    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩 설정
    @JoinColumn(name = "student_id") // DB 테이블에 생성될 외래 키 컬럼 이름
    private StudentEntity student;

}
