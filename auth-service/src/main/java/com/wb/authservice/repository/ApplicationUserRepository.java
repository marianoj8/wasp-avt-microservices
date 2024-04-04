package com.wb.authservice.repository;

import com.wb.authservice.model.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    @Query("select u from ApplicationUser u where u.username = ?1")
    ApplicationUser findByUsername(String username);
}
