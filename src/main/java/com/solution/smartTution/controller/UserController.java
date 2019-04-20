package com.solution.smartTution.controller;

import com.solution.smartTution.model.User;
import com.solution.smartTution.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/smartTution")
public class UserController {


        @Autowired
        private UserService userService;

        @GetMapping("/user")
        public Iterable<User> fetchUsers(){
            return userService.fetch();

        }
        @GetMapping("/user/{userid}")
        public ResponseEntity<User> fetchUserById(@PathVariable("userid") int id){
            return userService.fetchSingleItem(id);

        }
        @PostMapping("/user")
        public ResponseEntity<User> addUser(@RequestBody User user){
            return userService.insert(user);

        }

        @DeleteMapping("/user/{userid}")
        public Map<String, Boolean> deleteUser(@PathVariable ("userid") int id){
            return userService.remove(id);

        }@PutMapping("/user/{userid}")
        public ResponseEntity<User> updateUser(@PathVariable ("userid") int id, @RequestBody User user){
            return userService.update(id, user);

        }
}
