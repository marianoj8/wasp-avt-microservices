package com.wasp.avt.departmentservice.repository;

import com.wasp.avt.departmentservice.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("select d from Department d where d.id = ?1")
    Department getDepartmentById(Long id);

    @Query("select d from Department d where d.code = ?1")
    Department getDepartmentByCode(String code);
}
