package com.solution.smartTution.services;

import com.solution.smartTution.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
     Iterable<User> fetch();


     ResponseEntity<User> fetchSingleItem(int id);


     ResponseEntity<User> insert(User classinfo);


     Map<String, Boolean> remove(int id);


     ResponseEntity<User> update(int user_id, User classinfo);
}
