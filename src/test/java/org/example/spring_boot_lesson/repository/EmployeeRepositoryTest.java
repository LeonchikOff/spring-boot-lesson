package org.example.spring_boot_lesson.repository;

import org.example.spring_boot_lesson.IntegrationBaseTest;
import org.example.spring_boot_lesson.entity.EmployeeEntity;
import org.example.spring_boot_lesson.projection.EmployeeNameView;
import org.example.spring_boot_lesson.projection.EmployeeNativeView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeRepositoryTest extends IntegrationBaseTest {

    private static final Integer LEON_ID = 1;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    void testFindById() {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(LEON_ID);
        assertTrue(optionalEmployeeEntity.isPresent());
    }

    @Test
    void findByFirstName() {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findByFirstNameContaining("eon");
        assertTrue(optionalEmployeeEntity.isPresent());
    }

    @Test
    void findAllByFirstNameAndSalary() {
        List<EmployeeEntity> byFirstNameAndSalary = employeeRepository.findAllByFirstNameAndSalary("Leon", 1000);
        assertThat(byFirstNameAndSalary, hasSize(1));
    }

    @Test
    void findAllBySalaryGreaterThan() {
        List<EmployeeNameView> employeeNameViews = employeeRepository.findAllBySalaryGreaterThan(500);
        assertThat(employeeNameViews, hasSize(2));
    }

    @Test
    void findAllBySalaryGreaterThanNative() {
        List<EmployeeNativeView> employeeNativeViews = employeeRepository.findAllBySalaryGreaterThanNative(700);
        assertThat(employeeNativeViews, hasSize(2));
    }

    @Test
    void findEmployeesViaCustomQuery() {
        List<EmployeeEntity> employeesViaCustomQuery = employeeRepository.findEmployeesViaCustomQuery();
        assertThat(employeesViaCustomQuery, hasSize(0));
    }

}