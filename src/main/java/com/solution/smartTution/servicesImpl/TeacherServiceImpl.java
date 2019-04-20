package com.solution.smartTution.servicesImpl;
import com.solution.smartTution.model.Teacher;
import com.solution.smartTution.repositories.TeacherRepo;
import  com.solution.smartTution.services.TeacherService;
import com.solution.smartTution.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public Iterable<Teacher> fetch() {
        return teacherRepo.findAll();
    }

    @Override
    public ResponseEntity<Teacher> fetchSingleItem(int id) {
        try{
        Teacher teacher = teacherRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(""));
        return ResponseEntity.ok().body(teacher);
    }catch (Exception E){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }}

    @Override
    public ResponseEntity<Teacher> insert(Teacher teacher) {
      try {
          teacherRepo.save(teacher);
          return ResponseEntity.ok().body(teacher);
      }catch(Exception E){
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }

    @Override
    public Map<String, Boolean> remove(int id) {
        Map<String,Boolean> map = new HashMap<>();
        try{
            teacherRepo.deleteById(id);
            map.put("delete succeessful",true);
          return map;
        }catch (Exception E){
            map.put("delete unsuccessful",false);
            return map;
        }
    }

    @Override
    public ResponseEntity<Teacher> update(int teacher_id, Teacher teacher) {
        try{
            Teacher teacher1 = teacherRepo.findById(teacher_id).orElseThrow(()-> new ResourceNotFoundException(""));
            teacher1.setDescription(teacher.getDescription());
            teacher1.setExperience(teacher.getExperience());
            teacher1.setName(teacher.getName());
            teacher1.setQualification(teacher.getQualification());
            teacher1.setTutionClasses(teacher.getTutionClasses());
             teacherRepo.save(teacher1);

            return ResponseEntity.ok().body(teacher1);
        }catch (Exception E){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
