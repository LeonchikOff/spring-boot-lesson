package org.example.spring_boot_lesson.repository;

import lombok.RequiredArgsConstructor;
import org.example.spring_boot_lesson.entity.EmployeeEntity;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {

    private final EntityManager entityManager;

    @Override
    public List<EmployeeEntity> findEmployeesViaCustomQuery() {
        return Collections.emptyList();
    }
}
