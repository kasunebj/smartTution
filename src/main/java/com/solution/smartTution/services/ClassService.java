package com.solution.smartTution.services;


import com.solution.smartTution.model.TutionClass;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public interface ClassService {

    public Iterable<TutionClass> fetch();


    public ResponseEntity<TutionClass> fetchSingleItem(int id);


    public ResponseEntity<TutionClass> insert(TutionClass classinfo);


    public Map<String, Boolean> remove(int id);


    public ResponseEntity<TutionClass> update(int classinfo_id , TutionClass classinfo);
}
