package com.sopra.Factory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.Factory.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer>{

}
