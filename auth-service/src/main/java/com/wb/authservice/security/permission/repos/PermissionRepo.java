package com.wb.authservice.security.permission.repos;

import com.wb.authservice.security.permission.models.CustomPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepo extends JpaRepository<CustomPermission, Long> {

    @Query("select p from CustomPermission p where p.nome like %?1% order by p.nome")
    List<CustomPermission> findAll(String permissionName);

    @Query("select p from CustomPermission p where p.nome = ?1")
    CustomPermission findByName(String permissionName);
}
