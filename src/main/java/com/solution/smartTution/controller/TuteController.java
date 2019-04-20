package com.solution.smartTution.controller;

import com.solution.smartTution.model.Tute;
import com.solution.smartTution.services.TuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/smartTution")
public class TuteController {


        @Autowired
        private TuteService tuteService;

        @GetMapping("/tute")
        public Iterable<Tute> fetchTutes(){
            return tuteService.fetch();

        }
        @GetMapping("/tute/{tuteid}")
        public ResponseEntity<Tute> fetchTuteById(@PathVariable("tuteid") int id){
            return tuteService.fetchSingleItem(id);

        }
        @PostMapping("/tute")
        public ResponseEntity<Tute> addTute(@RequestBody Tute tute){
            return tuteService.insert(tute);

        }

        @DeleteMapping("/tute/{tuteid}")
        public Map<String, Boolean> deleteTute(@PathVariable ("tuteid") int id){
            return tuteService.remove(id);

        }@PutMapping("/tute/{tuteid}")
        public ResponseEntity<Tute> updateTute(@PathVariable ("tuteid") int id, @RequestBody Tute tute){
            return tuteService.update(id, tute);

        }
}
