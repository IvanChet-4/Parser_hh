package com.example.Parser_hh.repository;

import com.example.Parser_hh.entity.Resume_Entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Resume_Repo extends CrudRepository<Resume_Entity, Integer> {
}
