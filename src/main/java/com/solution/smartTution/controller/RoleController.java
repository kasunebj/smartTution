package com.solution.smartTution.controller;


import com.solution.smartTution.model.Role;
import com.solution.smartTution.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

    @RestController
    @RequestMapping("/smartTution")
    public class RoleController {
        @Autowired
        private RoleService roleservice;

        @GetMapping("/role")
        public Iterable<Role> fetchRoles(){
            return roleservice.fetch();

        }
        @GetMapping("/role/{roleid}")
        public ResponseEntity<Role> fetchRoleById(@PathVariable("roleid") int id){
            return roleservice.fetchSingleItem(id);

        }
        @PostMapping("/role")
        public ResponseEntity<Role> addRole(@RequestBody Role role){
            return roleservice.insert(role);

        }

        @DeleteMapping("/role/{roleid}")
        public Map<String, Boolean> deleteRole(@PathVariable ("roleid") int id){
            return roleservice.remove(id);

        }@PutMapping("/role/{roleid}")
        public ResponseEntity<Role> updateRole(@PathVariable ("roleid") int id, @RequestBody Role role){
            return roleservice.update(id, role);

        }
}
