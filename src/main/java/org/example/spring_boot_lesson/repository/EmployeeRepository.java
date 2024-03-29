package org.example.spring_boot_lesson.repository;

import org.example.spring_boot_lesson.entity.EmployeeEntity;
import org.example.spring_boot_lesson.projection.EmployeeNameView;
import org.example.spring_boot_lesson.projection.EmployeeNativeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>, EmployeeCustomRepository {

    Optional<EmployeeEntity> findByFirstNameContaining(String firstName);

    //-JPQL
    // @Query("select employee from EmployeeEntity employee where employee.firstName=:firstName and employee.salary =:salary")
    //-Native
    @Query(value = "select e.* from employee e where e.first_name=:firstName and e.salary=:salary", nativeQuery = true)
    // SpringJPAQuery
    List<EmployeeEntity> findAllByFirstNameAndSalary(@Param("firstName") String firstName, @Param("salary") Integer salary);

    List<EmployeeNameView> findAllBySalaryGreaterThan(Integer salary);

    @SuppressWarnings("SpringDataRepositoryMethodReturnTypeInspection")
    @Query(value =
            "select e.id as id, e.first_name || ' ' || e.last_name as fullName " +
            "from employee e where e.salary > :salary", nativeQuery = true)
    List<EmployeeNativeView> findAllBySalaryGreaterThanNative(@Param("salary") Integer salary);
}
