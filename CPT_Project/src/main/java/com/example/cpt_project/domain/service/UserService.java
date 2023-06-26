package com.example.cpt_project.domain.service;

import com.example.cpt_project.domain.models.Users;

import java.util.List;

public interface UserService {

    // Cоздание нового пользователя
    void crete(Users users);

    // Вывод всех пользователей
    List<Users> readAll();



    // Обнавление пользователя по id
    boolean update(Users user, Long id);

    // Удаление пользователя по id
    boolean delete(Long id);

}
