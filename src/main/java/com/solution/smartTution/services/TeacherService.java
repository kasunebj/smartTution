package com.solution.smartTution.services;

import com.solution.smartTution.model.Teacher;
import com.solution.smartTution.model.TutionClass;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface TeacherService {

     Iterable<Teacher> fetch();


     ResponseEntity<Teacher> fetchSingleItem(int id);


     ResponseEntity<Teacher> insert(TutionClass classinfo);


     Map<String, Boolean> remove(int id);


     ResponseEntity<TutionClass> update(int teacher_id , Teacher teacher);
}
