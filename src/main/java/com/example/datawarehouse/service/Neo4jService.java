package com.example.datawarehouse.service;

import com.example.datawarehouse.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class Neo4jService {
    @Resource
    private final Neo4jRepository neo4jRepository;

    public Neo4jService(Neo4jRepository neo4jRepository) {
        this.neo4jRepository = neo4jRepository;
    }

    public List<Map<String, Object>> getMovieByDirector(String director) {
        return neo4jRepository.findMovieByDirector(director);
    }

    public List<Map<String, Object>> getMovieByActor(String actor) {
        return neo4jRepository.findMovieByActor(actor);
    }

    public List<Map<String, Object>> getMovieByTitle(String title) {
        return neo4jRepository.findMovieByTitle(title);
    }

    public List<Map<String, Object>> getMovieByType(String type) {
        return neo4jRepository.findMovieByType(type);
    }

    public List<Map<String, Object>> getMovieByCustomer_rating(float customer_rating) {
        return neo4jRepository.findMovieByCustomer_rating(customer_rating);
    }

    public List<Map<String, Object>> getMovieByImdbRating(float imdbRating) {
        return neo4jRepository.findMovieByImdbRating(imdbRating);
    }

    public List<Map<String, Object>> getRelationBetActorAndActor(int count) {
        return neo4jRepository.findActorToActor(count);
    }

    public List<Map<String, Object>> getRelationBetDirectorAndActor(int count) {
        return neo4jRepository.findDirectorToActor(count);
    }

    public List<Map<String, Object>> getMovieByStarringActor(String actor) {
        return neo4jRepository.findMovieByStarringActor(actor);
    }

    public List<Map<String, Object>> getMovieWithPositiveComment() {
        return neo4jRepository.findMovieWithPositiveComment();
    }

    public List<Map<String, Object>> getMovieByYear(LocalDate date) {
        return neo4jRepository.findMovieByYear(date);
    }
    public List<Map<String, Object>> getMovieByYearAndMonth(LocalDate date) {
        return neo4jRepository.findMovieByYearAndMonth(date);
    }
    public List<Map<String, Object>> getMovieByYearAndQuarterly(String year,String quarterly) {
        return neo4jRepository.findMovieByYearAndQuarterly(year,quarterly);
    }
    public String getAll(
            String year,
            String month,
            String quarterly,
            String movieName,
            String actorName,
            String DirectorName,
            String actorName1,
            String num,
            String type,
            String grade,
            String Positive
    ){
        return neo4jRepository.findAll(year,month,quarterly,movieName,actorName,DirectorName,actorName1,num,type,grade,Positive);
    }
}

