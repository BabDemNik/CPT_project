package com.example.cpt_project.domain.repository;

import com.example.cpt_project.domain.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findUsersById(Long id);
    Users findUsersByLogin(String login);
}
