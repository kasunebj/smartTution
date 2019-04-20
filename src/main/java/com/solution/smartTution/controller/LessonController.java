package com.solution.smartTution.controller;

import com.solution.smartTution.model.Lesson;
import com.solution.smartTution.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/smartTution")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @GetMapping("/lesson")
    public Iterable<Lesson> fetchLessons(){
        return lessonService.fetch();

    }
    @GetMapping("/lesson/{lessonid}")
    public ResponseEntity<Lesson> fetchLessonById(@PathVariable("lessonid") int id){
        return lessonService.fetchSingleItem(id);

    }
    @PostMapping("/lesson")
    public ResponseEntity<Lesson> addLesson(@RequestBody Lesson lesson){
        return lessonService.insert(lesson);

    }

    @DeleteMapping("/lesson/{lessonid}")
    public Map<String, Boolean> deleteLesson(@PathVariable ("lessonid") int id){
        return lessonService.remove(id);

    }@PutMapping("/lesson/{lessonid}")
    public ResponseEntity<Lesson> updateLesson(@PathVariable ("lessonid") int id, @RequestBody Lesson lesson){
        return lessonService.update(id, lesson);

    }

}
