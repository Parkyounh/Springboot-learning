package com.du.fileupload1001.repository;

import com.du.fileupload1001.entity.ImageEntity;
import com.du.fileupload1001.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

    List<ImageEntity> findByStudent_Id(Long studentId);
}
