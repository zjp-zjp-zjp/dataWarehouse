package com.example.datawarehouse.controller;

import com.example.datawarehouse.entity.Cooperate;
import com.example.datawarehouse.entity.Movie;
import com.example.datawarehouse.service.Neo4jService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "neo4j")
public class Neo4jController {
    @Resource
    private final Neo4jService neo4jService;

    public Neo4jController(Neo4jService neo4jService) {
        this.neo4jService = neo4jService;
    }
    @PostMapping(path = "findmoviebydirector")
    public ArrayList<Movie> neo4j_findmoviebydirector_post(@RequestParam String director){
        return neo4jService.getMovieByDirector(director);
    }
    @PostMapping(path = "findmoviebyactor")
    public ArrayList<Movie> neo4j_findmoviebyactor_post(@RequestParam String actor){
        return neo4jService.getMovieByActor(actor);
    }
    @PostMapping(path = "findmoviebytitle")
    public ArrayList<Movie> neo4j_findmoviebytitle_post(@RequestParam String title){
        return neo4jService.getMovieByTitle(title);
    }
    @PostMapping(path = "findmoviebytype")
    public ArrayList<Movie> neo4j_findmoviebytype_post(@RequestParam String type){
        return neo4jService.getMovieByType(type);
    }
    @PostMapping(path = "findmoviebycustomer_rating")
    public ArrayList<Movie> neo4j_findmoviebycustomer_rating_post(@RequestParam float customer_rating){
        return neo4jService.getMovieByCustomer_rating(customer_rating);
    }
    @PostMapping(path = "findmoviebyimdbrating")
    public ArrayList<Movie> neo4j_findmoviebyimdbrating_post(@RequestParam float imdb_rating){
        return neo4jService.getMovieByImdbRating(imdb_rating);
    }
    @PostMapping(path = "findrelationbetweenactorandactor")
    public ArrayList<Cooperate> neo4j_findrelationbetweenactorandactor_post(@RequestParam int count){
        return neo4jService.getRelationBetActorAndActor(count);
    }
}
