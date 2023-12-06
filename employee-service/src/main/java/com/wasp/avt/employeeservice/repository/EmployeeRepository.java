package com.wasp.avt.employeeservice.repository;

import com.wasp.avt.employeeservice.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.email = ?1")
    Employee getByEmail(String code);
}
