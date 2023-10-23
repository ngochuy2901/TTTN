package com.store.library.repository;

import com.store.library.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Long> {
//    @Query(value = "query", nativeQuery = true)
    Admin findByUsername(String username);
}