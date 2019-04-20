package com.solution.smartTution.controller;

import java.util.Map;

import com.solution.smartTution.model.TutionClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solution.smartTution.services.ClassService;

@RestController
@RequestMapping("/smartTution")
public class TutionController {
	
	@Autowired
	private ClassService classService;

    @GetMapping("/classes")
    public Iterable<TutionClass> fetchClasses(){
    	return classService.fetch();
    	
    }
    @GetMapping("/classes/{classid}")
    public ResponseEntity<TutionClass> fetchClassById(@PathVariable("classid") int id){
    	return classService.fetchSingleItem(id);

    }
    @PostMapping("/classes")
    public ResponseEntity<TutionClass> addClass(@RequestBody TutionClass classinfo){
    	return classService.insert(classinfo);

    }
    
    @DeleteMapping("/classes/{classid}")
    public Map<String, Boolean> deleteClass(@PathVariable ("classid") int id){
    	return classService.remove(id);

    }@PutMapping("/classes/{classid}")
    public ResponseEntity<TutionClass> updateClass(@PathVariable ("classid") int id, @RequestBody TutionClass clasinfo){
    	return classService.update(id, clasinfo);

    }



}
