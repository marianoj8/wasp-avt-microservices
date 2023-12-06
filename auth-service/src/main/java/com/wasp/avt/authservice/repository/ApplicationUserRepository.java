package com.wasp.avt.authservice.repository;

import com.wasp.avt.authservice.model.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    @Query("select u from ApplicationUser u where u.username = ?1")
    ApplicationUser findByUsername(String username);
}
