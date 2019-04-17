package com.solution.smartTution.repositories;

import com.solution.smartTution.model.TutionClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassInfoRepo extends JpaRepository<TutionClass,Integer> {
	
}
