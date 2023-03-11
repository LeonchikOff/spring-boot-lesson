package org.example.spring_boot_lesson.repository;

import org.example.spring_boot_lesson.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeCustomRepository {
    List<EmployeeEntity> findEmployeesViaCustomQuery();
}
