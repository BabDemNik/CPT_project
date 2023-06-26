package com.example.cpt_project.domain.service;

import com.example.cpt_project.domain.models.Users;
import com.example.cpt_project.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository UserRepository;

    @Override
    public void crete(Users users) {
        UserRepository.save(users);
    }

    @Override
    public List<Users> readAll() {
        return UserRepository.findAll();
    }


    public Users read(Long id) {
        return UserRepository.findUsersById(id);
    }



    public Users readByLogAndPas(String login){
        return UserRepository.findUsersByLogin(login);
    }

    @Override
    public boolean update(Users user, Long id) {
        if (UserRepository.existsById(id)){
            user.setId(id);
            UserRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if(UserRepository.existsById(id)){
            UserRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
