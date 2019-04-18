package com.solution.smartTution.services;

import com.solution.smartTution.model.Teacher;
import com.solution.smartTution.model.Tute;
import com.solution.smartTution.model.TutionClass;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface TuteService {
     Iterable<Tute> fetch();


     ResponseEntity<Tute> fetchSingleItem(int id);


     ResponseEntity<Tute> insert(Tute classinfo);


     Map<String, Boolean> remove(int id);


     ResponseEntity<Tute> update(int tute_id , Tute tute);
}
