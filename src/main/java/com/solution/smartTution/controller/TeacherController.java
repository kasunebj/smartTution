package com.solution.smartTution.controller;

import com.solution.smartTution.model.Teacher;
import com.solution.smartTution.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

    @RestController
    @RequestMapping("/smartTution")
    public class TeacherController {
        @Autowired
        private TeacherService teacherService;

        @GetMapping("/teacher")
        public Iterable<Teacher> fetchTeachers(){
            return teacherService.fetch();

        }
        @GetMapping("/teacher/{teacherid}")
        public ResponseEntity<Teacher> fetchTeacherById(@PathVariable("teacherid") int id){
            return teacherService.fetchSingleItem(id);

        }
        @PostMapping("/teacher")
        public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher){
            return teacherService.insert(teacher);

        }

        @DeleteMapping("/teacher/{teacherid}")
        public Map<String, Boolean> deleteTeacher(@PathVariable ("teacherid") int id){
            return teacherService.remove(id);

        }@PutMapping("/teacher/{teacherid}")
        public ResponseEntity<Teacher> updateTeacher(@PathVariable ("teacherid") int id, @RequestBody Teacher teacher){
            return teacherService.update(id, teacher);

        }
}
