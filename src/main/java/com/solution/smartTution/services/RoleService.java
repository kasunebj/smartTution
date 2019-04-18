package com.solution.smartTution.services;

import com.solution.smartTution.model.Role;
import com.solution.smartTution.model.Teacher;
import com.solution.smartTution.model.TutionClass;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface RoleService {
     Iterable<Role> fetch();


     ResponseEntity<Role> fetchSingleItem(int id);


     ResponseEntity<Role> insert(Role role);


     Map<String, Boolean> remove(int id);


     ResponseEntity<Role> update(int role_id , Role role);
}
