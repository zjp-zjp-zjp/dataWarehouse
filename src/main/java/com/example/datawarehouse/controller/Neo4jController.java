package com.example.datawarehouse.controller;

import com.example.datawarehouse.service.Neo4jService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping(path = "neo4j")
public class Neo4jController {
    @Resource
    private final Neo4jService neo4jService;

    public Neo4jController(Neo4jService neo4jService) {
        this.neo4jService = neo4jService;
    }
    @PostMapping(path = "findmoviebydirector")
    public ModelAndView neo4j_findmoviebydirector_post(@RequestParam String director){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        List<Map<String,Object>> results=neo4jService.getMovieByDirector(director);
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps = results.subList(0, 1);
            for (Map<String, Object> temp : temps) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebyactor")
    public ModelAndView neo4j_findmoviebyactor_post(@RequestParam String actor){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        List<Map<String,Object>> results=neo4jService.getMovieByActor(actor);
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps = results.subList(0, 1);
            for (Map<String, Object> temp : temps) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebystarringactor")
    public ModelAndView neo4j_findmoviebystarringactor_post(@RequestParam String actor){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        List<Map<String,Object>> results=neo4jService.getMovieByStarringActor(actor);
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps = results.subList(0, 1);
            for (Map<String, Object> temp : temps) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebytitle")
    public ModelAndView neo4j_findmoviebytitle_post(@RequestParam String title){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        List<Map<String,Object>> results=neo4jService.getMovieByTitle(title);
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps = results.subList(0, 1);
            for (Map<String, Object> temp : temps) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebytype")
    public ModelAndView neo4j_findmoviebytype_post(@RequestParam String type){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        List<Map<String,Object>> results=neo4jService.getMovieByType(type);
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps = results.subList(0, 1);
            for (Map<String, Object> temp : temps) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebycustomer_rating")
    public ModelAndView neo4j_findmoviebycustomer_rating_post(@RequestParam float customer_rating){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        List<Map<String,Object>> results=neo4jService.getMovieByCustomer_rating(customer_rating);
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps = results.subList(0, 1);
            for (Map<String, Object> temp : temps) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebyimdbrating")
    public ModelAndView neo4j_findmoviebyimdbrating_post(@RequestParam float imdb_rating){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        List<Map<String,Object>> results=neo4jService.getMovieByImdbRating(imdb_rating);
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps = results.subList(0, 1);
            for (Map<String, Object> temp : temps) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findrelationbetweenactorandactor")
    public ModelAndView neo4j_findrelationbetweenactorandactor_post(@RequestParam int count){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        List<Map<String,Object>> results=neo4jService.getRelationBetActorAndActor(count);
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps = results.subList(0, 1);
            for (Map<String, Object> temp : temps) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findrelationbetweendirectorandactor")
    public ModelAndView neo4j_findrelationbetweendirectorandactor_post(@RequestParam int count){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        List<Map<String,Object>> results=neo4jService.getRelationBetDirectorAndActor(count);
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps = results.subList(0, 1);
            for (Map<String, Object> temp : temps) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviewithpositivecomment")
    public ModelAndView neo4j_findmoviewithpositivecomment_post(){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        List<Map<String,Object>> results=neo4jService.getMovieWithPositiveComment();
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps = results.subList(0, 1);
            for (Map<String, Object> temp : temps) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebyyear")
    public ModelAndView neo4j_findmoviebyyear_post(@RequestParam String date){
        date=date+"-11-11";
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        LocalDate _date=LocalDate.parse(date);
        List<Map<String,Object>> results=neo4jService.getMovieByYear(_date);
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps = results.subList(0, 1);
            for (Map<String, Object> temp : temps) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebyyearandmonth")
    public ModelAndView neo4j_findmoviebyyearandmonth_post(@RequestParam String date){
        date=date+"-11";
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        LocalDate _date=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-M-d"));
        List<Map<String,Object>> results=neo4jService.getMovieByYearAndMonth(_date);
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps = results.subList(0, 1);
            for (Map<String, Object> temp : temps) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebyyearandquarterly")
    public ModelAndView neo4j_findmoviebyyearandquarterly_post(@RequestParam String year,@RequestParam String quarterly){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        List<Map<String,Object>> results=neo4jService.getMovieByYearAndQuarterly(year,quarterly);
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps = results.subList(0, 1);
            for (Map<String, Object> temp : temps) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }
}
