package com.solution.smartTution.services;

import java.util.Map;

import com.solution.smartTution.model.Lesson;
import com.solution.smartTution.model.TutionClass;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface LessonService {
	 Iterable<Lesson> fetch();


     ResponseEntity<Lesson> fetchSingleItem(int id);


     ResponseEntity<Lesson> insert(Lesson lesson);


     Map<String, Boolean> remove(int id);


     ResponseEntity<Lesson> update(int lesson_id , Lesson lesson);
}

