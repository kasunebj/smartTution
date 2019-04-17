package com.solution.smartTution.services;

import java.util.Map;

import com.solution.smartTution.model.TutionClass;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface LessonService {
	public Iterable<TutionClass> fetch();


    public ResponseEntity<TutionClass> fetchSingleItem(int id);


    public ResponseEntity<TutionClass> insert(TutionClass classinfo);


    public Map<String, Boolean> remove(int id);


    public ResponseEntity<TutionClass> update(int classinfo_id , TutionClass classinfo);
}

