package com.example.JavaBooksHub.repository;

import com.example.JavaBooksHub.model.ERole;
import com.example.JavaBooksHub.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
