package com.wb.core.repository;

import com.wb.core.models.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query("SELECT c FROM cliente c where c.id = ?1")
    ClientEntity findOne(Long id);
}
