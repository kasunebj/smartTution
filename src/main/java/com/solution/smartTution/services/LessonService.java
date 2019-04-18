package com.solution.smartTution.services;

import java.util.Map;

import com.solution.smartTution.model.TutionClass;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface LessonService {
	 Iterable<TutionClass> fetch();


     ResponseEntity<TutionClass> fetchSingleItem(int id);


     ResponseEntity<TutionClass> insert(TutionClass classinfo);


     Map<String, Boolean> remove(int id);


     ResponseEntity<TutionClass> update(int classinfo_id , TutionClass classinfo);
}

