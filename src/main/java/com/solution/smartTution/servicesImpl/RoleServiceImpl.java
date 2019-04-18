package com.solution.smartTution.servicesImpl;

import com.solution.smartTution.model.Role;
import com.solution.smartTution.model.TutionClass;
import com.solution.smartTution.repositories.RoleRepo;
import com.solution.smartTution.services.RoleService;
import com.solution.smartTution.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Iterable<Role> fetch() {
        return roleRepo.findAll();
    }

    @Override
    public ResponseEntity<Role> fetchSingleItem(int id) {
        try{
            Role role = roleRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(""));
            return ResponseEntity.ok().body(role);

        }catch(Exception E){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Role> insert(Role role) {
        try{
            roleRepo.save(role);
            return ResponseEntity.ok().body(role);
        }catch (Exception E){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> remove(int id) {
        Map<String,Boolean> map = new HashMap<>();
        try{
            Role role =roleRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(""));
             map.put("Deleted Successfully", true);
             return map;
        }catch(Exception E){
            map.put("Deleteion unsuccessfull",false);
            return map;
        }}


    @Override
    public ResponseEntity<Role> update(int role_id, Role role) {
        try{
        Role role1 = roleRepo.findById(role_id).orElseThrow(()->new ResourceNotFoundException(""));
        role1.setName(role.getName());
        role1.setUsers(role1.getUsers());
        roleRepo.save(role1);
        return ResponseEntity.ok().body(role);
        }catch(Exception E){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
