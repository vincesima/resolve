package com.resolve.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://vincesima.com", "http://www.vincesima.com", "http://localhost:8100"})
public class UserController {

    @Autowired
    UserRepo repo;


        @GetMapping(path = "/users")
        public List<User> getAll(){
            return repo.findAll();
        }

        @GetMapping(value = "/users/{id}")
        public User getUser(@PathVariable Long id){
            return repo.getOne(id);
        }

        @PostMapping(path = "/users", consumes = "application/json", produces = "application/json")
        public void addTask(@RequestBody User user) {
            repo.save(user);
        }
    }

