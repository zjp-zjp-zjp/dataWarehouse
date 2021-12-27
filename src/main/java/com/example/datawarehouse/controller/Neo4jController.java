package com.example.datawarehouse.controller;

import com.example.datawarehouse.service.Neo4jService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(path = "neo4j")
public class Neo4jController {
    @Resource
    private final Neo4jService neo4jService;


    public Neo4jController(Neo4jService neo4jService) {
        this.neo4jService = neo4jService;
    }
    @PostMapping(path = "findmoviebydirector")
    public ModelAndView neo4j_findmoviebydirector_post(@RequestParam String directorName){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String,Object>> results2=neo4jService.getMovieByDirector(directorName);
        long endMilliSec1 = 0;
        endMilliSec1 = System.currentTimeMillis();
        // 打印花费时间
        Long time2 = (endMilliSec1 - startMilliSec1);
        Set<String> keys2 = new HashSet<>();
        if (results2 != null) {
            List<Map<String, Object>> temps2 = results2.subList(0, 1);
            for (Map<String, Object> temp : temps2) {
                keys2 = temp.keySet();
            }
        }
        m.addObject("time2", time2);
        m.addObject("keys2", keys2);
        m.addObject("results2", results2);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebyactor")
    public ModelAndView neo4j_findmoviebyactor_post(@RequestParam String ActorName){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String,Object>> results2=neo4jService.getMovieByActor(ActorName);
        long endMilliSec1 = 0;
        endMilliSec1 = System.currentTimeMillis();
        // 打印花费时间
        Long time2 = (endMilliSec1 - startMilliSec1);
        Set<String> keys2 = new HashSet<>();
        if (results2 != null) {
            List<Map<String, Object>> temps2 = results2.subList(0, 1);
            for (Map<String, Object> temp : temps2) {
                keys2 = temp.keySet();
            }
        }
        m.addObject("time2", time2);
        m.addObject("keys2", keys2);
        m.addObject("results2", results2);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebystarringactor")
    public ModelAndView neo4j_findmoviebystarringactor_post(@RequestParam String actor){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String,Object>> results2=neo4jService.getMovieByStarringActor(actor);
        long endMilliSec1 = 0;
        endMilliSec1 = System.currentTimeMillis();
        // 打印花费时间
        Long time2 = (endMilliSec1 - startMilliSec1);
        Set<String> keys2 = new HashSet<>();
        if (results2 != null) {
            List<Map<String, Object>> temps2 = results2.subList(0, 1);
            for (Map<String, Object> temp : temps2) {
                keys2 = temp.keySet();
            }
        }
        m.addObject("time2", time2);
        m.addObject("keys2", keys2);
        m.addObject("results2", results2);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebytitle")
    public ModelAndView neo4j_findmoviebytitle_post(@RequestParam String name){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String,Object>> results2=neo4jService.getMovieByTitle(name);
        long endMilliSec1 = 0;
        endMilliSec1 = System.currentTimeMillis();
        // 打印花费时间
        Long time2 = (endMilliSec1 - startMilliSec1);
        Set<String> keys2 = new HashSet<>();
        if (results2 != null) {
            List<Map<String, Object>> temps2 = results2.subList(0, 1);
            for (Map<String, Object> temp : temps2) {
                keys2 = temp.keySet();
            }
        }
        m.addObject("time2", time2);
        m.addObject("keys2", keys2);
        m.addObject("results2", results2);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebytype")
    public ModelAndView neo4j_findmoviebytype_post(@RequestParam String type){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String,Object>> results2=neo4jService.getMovieByType(type);
        long endMilliSec1 = 0;
        endMilliSec1 = System.currentTimeMillis();
        // 打印花费时间
        Long time2 = (endMilliSec1 - startMilliSec1);
        Set<String> keys2 = new HashSet<>();
        if (results2 != null) {
            List<Map<String, Object>> temps2 = results2.subList(0, 1);
            for (Map<String, Object> temp : temps2) {
                keys2 = temp.keySet();
            }
        }
        m.addObject("time2", time2);
        m.addObject("keys2", keys2);
        m.addObject("results2", results2);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebycustomer_rating")
    public ModelAndView neo4j_findmoviebycustomer_rating_post(@RequestParam String grade){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String,Object>> results2=neo4jService.getMovieByCustomer_rating(Float.parseFloat(grade));
        long endMilliSec1 = 0;
        endMilliSec1 = System.currentTimeMillis();
        // 打印花费时间
        Long time2 = (endMilliSec1 - startMilliSec1);
        Set<String> keys2 = new HashSet<>();
        if (results2 != null) {
            List<Map<String, Object>> temps2 = results2.subList(0, 1);
            for (Map<String, Object> temp : temps2) {
                keys2 = temp.keySet();
            }
        }
        m.addObject("time2", time2);
        m.addObject("keys2", keys2);
        m.addObject("results2", results2);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebyimdbrating")
    public ModelAndView neo4j_findmoviebyimdbrating_post(@RequestParam float imdb_rating){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String,Object>> results2=neo4jService.getMovieByImdbRating(imdb_rating);
        long endMilliSec1 = 0;
        endMilliSec1 = System.currentTimeMillis();
        // 打印花费时间
        Long time2 = (endMilliSec1 - startMilliSec1);
        Set<String> keys2 = new HashSet<>();
        if (results2 != null) {
            List<Map<String, Object>> temps2 = results2.subList(0, 1);
            for (Map<String, Object> temp : temps2) {
                keys2 = temp.keySet();
            }
        }
        m.addObject("time2", time2);
        m.addObject("keys2", keys2);
        m.addObject("results2", results2);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findrelationbetweenactorandactor")
    public ModelAndView neo4j_findrelationbetweenactorandactor_post(@RequestParam String num){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String,Object>> results2=neo4jService.getRelationBetActorAndActor(Integer.parseInt(num));
        long endMilliSec1 = 0;
        endMilliSec1 = System.currentTimeMillis();
        // 打印花费时间
        Long time2 = (endMilliSec1 - startMilliSec1);
        Set<String> keys2 = new HashSet<>();
        if (results2 != null) {
            List<Map<String, Object>> temps2 = results2.subList(0, 1);
            for (Map<String, Object> temp : temps2) {
                keys2 = temp.keySet();
            }
        }
        m.addObject("time2", time2);
        m.addObject("keys2", keys2);
        m.addObject("results2", results2);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findrelationbetweendirectorandactor")
    public ModelAndView neo4j_findrelationbetweendirectorandactor_post(@RequestParam String num){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String,Object>> results2=neo4jService.getRelationBetDirectorAndActor(Integer.parseInt(num));
        long endMilliSec1 = 0;
        endMilliSec1 = System.currentTimeMillis();
        // 打印花费时间
        Long time2 = (endMilliSec1 - startMilliSec1);
        Set<String> keys2 = new HashSet<>();
        if (results2 != null) {
            List<Map<String, Object>> temps2 = results2.subList(0, 1);
            for (Map<String, Object> temp : temps2) {
                keys2 = temp.keySet();
            }
        }
        m.addObject("time2", time2);
        m.addObject("keys2", keys2);
        m.addObject("results2", results2);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviewithpositivecomment")
    public ModelAndView neo4j_findmoviewithpositivecomment_post(){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String,Object>> results2=neo4jService.getMovieWithPositiveComment();
        long endMilliSec1 = 0;
        endMilliSec1 = System.currentTimeMillis();
        // 打印花费时间
        Long time2 = (endMilliSec1 - startMilliSec1);
        Set<String> keys2 = new HashSet<>();
        if (results2 != null) {
            List<Map<String, Object>> temps2 = results2.subList(0, 1);
            for (Map<String, Object> temp : temps2) {
                keys2 = temp.keySet();
            }
        }
        m.addObject("time2", time2);
        m.addObject("keys2", keys2);
        m.addObject("results2", results2);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebyyear")
    public ModelAndView neo4j_findmoviebyyear_post(@RequestParam String year){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        LocalDate _date=LocalDate.of(Integer.parseInt(year),11,11);
        List<Map<String,Object>> results2=neo4jService.getMovieByYear(_date);
        long endMilliSec1 = 0;
        endMilliSec1 = System.currentTimeMillis();
        // 打印花费时间
        Long time2 = (endMilliSec1 - startMilliSec1);
        Set<String> keys2 = new HashSet<>();
        if (results2 != null) {
            List<Map<String, Object>> temps2 = results2.subList(0, 1);
            for (Map<String, Object> temp : temps2) {
                keys2 = temp.keySet();
            }
        }
        m.addObject("time2", time2);
        m.addObject("keys2", keys2);
        m.addObject("results2", results2);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebyyearandmonth")
    public ModelAndView neo4j_findmoviebyyearandmonth_post(@RequestParam String year,@RequestParam String month){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();LocalDate _date=LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),11);
        List<Map<String,Object>> results2=neo4jService.getMovieByYearAndMonth(_date);
        long endMilliSec1 = 0;
        endMilliSec1 = System.currentTimeMillis();
        // 打印花费时间
        Long time2 = (endMilliSec1 - startMilliSec1);
        Set<String> keys2 = new HashSet<>();
        if (results2 != null) {
            List<Map<String, Object>> temps2 = results2.subList(0, 1);
            for (Map<String, Object> temp : temps2) {
                keys2 = temp.keySet();
            }
        }
        m.addObject("time2", time2);
        m.addObject("keys2", keys2);
        m.addObject("results2", results2);
        m.setViewName("result");
        return m;
    }
    @PostMapping(path = "findmoviebyyearandquarterly")
    public ModelAndView neo4j_findmoviebyyearandquarterly_post(@RequestParam String year,@RequestParam String quarterly){
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String,Object>> results2=neo4jService.getMovieByYearAndQuarterly(year,quarterly);
        long endMilliSec1 = 0;
        endMilliSec1 = System.currentTimeMillis();
        // 打印花费时间
        Long time2 = (endMilliSec1 - startMilliSec1);
        Set<String> keys2 = new HashSet<>();
        if (results2 != null) {
            List<Map<String, Object>> temps2 = results2.subList(0, 1);
            for (Map<String, Object> temp : temps2) {
                keys2 = temp.keySet();
            }
        }
        m.addObject("time2", time2);
        m.addObject("keys2", keys2);
        m.addObject("results2", results2);
        m.setViewName("result");
        return m;
    }
}
