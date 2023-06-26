package com.example.cpt_project.domain.controllers;

import com.example.cpt_project.domain.models.Users;
import com.example.cpt_project.domain.service.UserService;
import com.example.cpt_project.domain.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    private final UserService userService;
    private final UserServiceImp userServiceImp;

    @Autowired
    public UsersController(UserService userService, UserServiceImp userServiceImp){this.userService = userService;
        this.userServiceImp = userServiceImp;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody Users user){
        userService.crete(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<Users>> read(){
        final List<Users> users = userService.readAll();

        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Users> read(@PathVariable(name = "id") Long id){
        final  Users user = userServiceImp.read(id);

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/users/{login}")
    public ResponseEntity<Users> readByLog(@PathVariable(name = "login") String log){
        final Users user = userServiceImp.readByLogAndPas(log);

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Users user){
        final boolean  update = userService.update(user, id);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        final boolean delete = userService.delete(id);

        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


}
