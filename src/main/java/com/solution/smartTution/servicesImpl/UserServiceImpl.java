package com.solution.smartTution.servicesImpl;

import com.solution.smartTution.model.User;
import com.solution.smartTution.repositories.UserRepo;
import com.solution.smartTution.services.UserService;
import com.solution.smartTution.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EmailClass emailClass;

    @Override
    public Iterable<User> fetch() {
        return userRepo.findAll();
    }

    @Override
    public ResponseEntity<User> fetchSingleItem(int id) {

            try {
                User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(""));
                return ResponseEntity.ok().body(user);
            } catch (ResourceNotFoundException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

    }

    @Override
    public ResponseEntity<User> insert(User classinfo) {
        try{
            userRepo.save(classinfo);
            emailClass.emailGenerater(classinfo.getEmail());
            return ResponseEntity.ok().body(classinfo);
        }catch (Exception E){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public Map<String, Boolean> remove(int id) {
        Map<String,Boolean> map = new HashMap<>();
        try{
            User user= userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(""));
            userRepo.delete(user);
            map.put("succefully deleted", true);
        }catch(Exception E){
            map.put("deletion unsuccessful",false);
            return map;
        }
        return null;
    }

    @Override
    public ResponseEntity<User> update(int user_id, User user) {
        try{
            User user1 =userRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException(""));
            user1.setDob(user.getDob());
            user1.setEmail(user.getEmail());
            user1.setFname(user.getFname());
            user1.setLname(user.getLname());
            user1.setNic(user.getNic());
            user1.setRole(user.getRole());
            user1.setSchool(user.getSchool());
            user1.setTutes(user.getTutes());
            user1.setTutionClasses(user.getTutionClasses());
            user1.setNic(user.getNic());
            user1.setUsername(user.getUsername());

            userRepo.save(user1);
            return ResponseEntity.ok().body(user1);
        }catch(Exception E){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}
