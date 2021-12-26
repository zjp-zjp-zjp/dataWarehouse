package com.example.datawarehouse.service;

import com.example.datawarehouse.entity.Cooperate;
import com.example.datawarehouse.entity.Movie;
import com.example.datawarehouse.repository.Neo4jRepository;
import org.neo4j.driver.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Neo4jService{
    @Resource
    private final Neo4jRepository neo4jRepository;

    public Neo4jService(Neo4jRepository neo4jRepository) {
        this.neo4jRepository = neo4jRepository;
    }
    public List<Map<String,Object>> getMovieByDirector(String director){
        return neo4jRepository.findMovieByDirector(director);
    }
    public List<Map<String,Object>> getMovieByActor(String actor){
        return neo4jRepository.findMovieByActor(actor);
    }
    public List<Map<String,Object>> getMovieByTitle(String title){
        return neo4jRepository.findMovieByTitle(title);
    }
    public List<Map<String,Object>> getMovieByType(String type){
        return neo4jRepository.findMovieByType(type);
    }
    public List<Map<String,Object>> getMovieByCustomer_rating(float customer_rating){
        return neo4jRepository.findMovieByCustomer_rating(customer_rating);
    }
    public List<Map<String,Object>> getMovieByImdbRating(float imdbRating){
        return neo4jRepository.findMovieByImdbRating(imdbRating);
    }
    public List<Map<String,Object>> getRelationBetActorAndActor(int count){
        return neo4jRepository.findActorToActor(count);
    }
    public List<Map<String,Object>> getRelationBetDirectorAndActor(int count){
        return neo4jRepository.findDirectorToActor(count);
    }
    public List<Map<String,Object>> getMovieByStarringActor(String actor){
        return neo4jRepository.findMovieByStarringActor(actor);
    }
    public List<Map<String,Object>> getMovieWithPositiveComment(){
        return neo4jRepository.findMovieWithPositiveComment();
    }
}

