package com.example.ToDO_web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ToDO_web.model.ToDo;
@Repository
public interface IToDorepo extends JpaRepository<ToDo, Long>{
	

}
