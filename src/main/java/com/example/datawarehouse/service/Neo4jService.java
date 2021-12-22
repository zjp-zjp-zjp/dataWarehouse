package com.example.datawarehouse.service;

import com.example.datawarehouse.entity.Movie;
import com.example.datawarehouse.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class Neo4jService{
    @Resource
    private final Neo4jRepository neo4jRepository;

    public Neo4jService(Neo4jRepository neo4jRepository) {
        this.neo4jRepository = neo4jRepository;
    }
    public ArrayList<Movie> getMovieByDirector(String director){
        return neo4jRepository.findMovieByDirector(director);
    }
}

