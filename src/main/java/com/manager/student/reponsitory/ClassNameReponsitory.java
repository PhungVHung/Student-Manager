package com.manager.student.reponsitory;

import com.manager.student.entity.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassNameReponsitory extends JpaRepository<ClassName, Integer> {
}
