package com.solution.smartTution.repositories;

import com.solution.smartTution.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepo extends JpaRepository<Lesson,Integer> {

}
