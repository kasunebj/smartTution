package com.solution.smartTution.servicesImpl;

import com.solution.smartTution.model.Tute;
import com.solution.smartTution.repositories.TuteRepo;
import com.solution.smartTution.services.TuteService;
import com.solution.smartTution.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class TuteServiceImpl implements TuteService {
    @Autowired
    private TuteRepo tuteRepo;

    @Override
    public Iterable<Tute> fetch() {
        return tuteRepo.findAll();
    }

    @Override
    public ResponseEntity<Tute> fetchSingleItem(int id) {
        try {
            Tute tute = tuteRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(""));
            return ResponseEntity.ok().body(tute);
        }catch(Exception E){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Tute> insert(Tute tute) {
        try {
            tuteRepo.save(tute);
            return  ResponseEntity.ok().body(tute);
        }
        catch (Exception E){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> remove(int id) {
        Map<String,Boolean> map = new HashMap<>();
        try {
            tuteRepo.deleteById(id);
            map.put("deleted successfully",true);
            return map;

        }catch (Exception E){
            map.put("deletion unsuccessfull",false);
            return map;
        }
    }

    @Override
    public ResponseEntity<Tute> update(int tute_id, Tute tute) {
        try{
            Tute tute1 = tuteRepo.findById(tute_id).orElseThrow(()->new ResourceNotFoundException(""));
            tuteRepo.save(tute1);
            return ResponseEntity.ok().body(tute1);

        }catch (Exception E){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
