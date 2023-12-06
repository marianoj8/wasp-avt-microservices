package com.wasp.avt.organizationservice.repository;

import com.wasp.avt.organizationservice.model.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    @Query("select o from Organization o where o.code = ?1")
    Organization getOrganizationByCode(String code);
    @Query("select o from Organization o where o.name like %?1%")
    List<Organization> fetch(String name);
}
