package com.wasp.avt.authservice.security.permission.repos;

import com.wasp.avt.authservice.security.permission.models.CustomRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepo extends JpaRepository<CustomRole, Long> {

    @Query("select r from CustomRole r where r.nome like %?1%")
    List<CustomRole> findAll(String roleName);

    @Query("select r from CustomRole r where r.nome = ?1")
    CustomRole findByName(String roleName);
}
