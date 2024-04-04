package com.wb.authservice.security.permission.repos;

import com.wb.authservice.security.permission.models.ApplicationUserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationUserPermissionRepo
        extends JpaRepository<ApplicationUserPermission, Long> {

    @Query("select ap from ApplicationUser_permissions ap where ap.permissions.nome like %?1% and ap.applicationUser = ?#{principal} order by ap.id")
    List<ApplicationUserPermission> findAllByNameWithUserFormToken(String permission);

    @Query("select ap from ApplicationUser_permissions ap where ap.permissions.nome like %?1% and ap.applicationUser.username = ?2")
    List<ApplicationUserPermission> findAllByPermissionByUsername(String name, String username);
}
