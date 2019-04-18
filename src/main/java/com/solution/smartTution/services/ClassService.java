package com.solution.smartTution.services;


import com.solution.smartTution.model.TutionClass;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public interface ClassService {

     Iterable<TutionClass> fetch();


     ResponseEntity<TutionClass> fetchSingleItem(int id);


     ResponseEntity<TutionClass> insert(TutionClass classinfo);


     Map<String, Boolean> remove(int id);


     ResponseEntity<TutionClass> update(int classinfo_id , TutionClass classinfo);
}
