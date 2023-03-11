package org.example.spring_boot_lesson.repository;

import org.example.spring_boot_lesson.IntegrationBaseTest;
import org.example.spring_boot_lesson.entity.CompanyEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CompanyRepositoryTest extends IntegrationBaseTest {

    private static final Integer APPLE_ID = 1;

    @Autowired
    private CompanyRepository companyRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testFindById() {
        Optional<CompanyEntity> optionalCompanyEntity = companyRepository.findById(APPLE_ID);
        assertTrue(optionalCompanyEntity.isPresent());
        optionalCompanyEntity.ifPresent(company -> assertEquals("Apple", company.getName()));
    }

    @Test
    void testSave() {
        CompanyEntity samsung = CompanyEntity.builder().name("Samsung").build();
        companyRepository.save(samsung);
        assertNotNull(samsung.getId());
    }
}