package com.solution.smartTution.services;

import com.solution.smartTution.model.Teacher;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface TeacherService {

     Iterable<Teacher> fetch();


     ResponseEntity<Teacher> fetchSingleItem(int id);

    ResponseEntity<Teacher> insert(Teacher teacher);

    Map<String, Boolean> remove(int id);


     ResponseEntity<Teacher> update(int teacher_id , Teacher teacher);
}
