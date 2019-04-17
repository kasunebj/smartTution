package com.solution.smartTution.repositories;

import com.solution.smartTution.model.Tute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuteRepo extends JpaRepository<Tute,Integer> {
}
