package com.solution.smartTution.model;
// Generated Apr 17, 2019 11:31:41 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name="role"
    ,catalog="tution"
)
public class Role  implements java.io.Serializable {


     private int id;
     private String name;
     private Set<User> users = new HashSet<User>(0);

    public Role() {
    }

	
    public Role(int id) {
        this.id = id;
    }
    public Role(int id, String name, Set<User> users) {
       this.id = id;
       this.name = name;
       this.users = users;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="role")
    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }




}

