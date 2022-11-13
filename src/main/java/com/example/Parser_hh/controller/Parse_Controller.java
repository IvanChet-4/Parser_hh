package com.example.Parser_hh.controller;

import com.example.Parser_hh.entity.Resume_Entity;
import com.example.Parser_hh.repository.Resume_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/parse")
public class Parse_Controller {

    @Autowired
    private Resume_Repo resume_repo;

    @GetMapping("/all")
    public ResponseEntity getParsers (){
        ArrayList<Resume_Entity> resume_entities = (ArrayList<Resume_Entity>) resume_repo.findAll();
        return ResponseEntity.ok(resume_entities);
    }

}
