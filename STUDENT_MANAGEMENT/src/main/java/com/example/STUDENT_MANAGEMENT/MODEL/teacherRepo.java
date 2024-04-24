package com.example.STUDENT_MANAGEMENT.MODEL;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.STUDENT_MANAGEMENT.ENTITY.*;

public interface teacherRepo extends JpaRepository<Teacher,Long> {

}
