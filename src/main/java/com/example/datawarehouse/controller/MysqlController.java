package com.example.datawarehouse.controller;

import com.example.datawarehouse.service.MysqlService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping
public class MysqlController {

    private final MysqlService mysqlService;

    public MysqlController(MysqlService mysqlService) {
        this.mysqlService = mysqlService;
    }

    @GetMapping(path = "/mysql")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @PostMapping(path = "/FindMovieByYear")
    public ModelAndView FindMovieByYear(@RequestParam("year") String year) {
        ModelAndView m = new ModelAndView();
        List<Map<String, Object>> results = mysqlService.FindMovieByYear(year);
        List<Map<String, Object>> temps = results.subList(1,2);
        Set<String> keys = temps.get(0).keySet();
        m.addObject("time", results.get(0).get("time"));
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }

    @PostMapping(path = "/FindMovieByYearAndMonth")
    public ModelAndView FindMovieByYearAndMonth(
            @RequestParam("year") String year,
            @RequestParam("month") String month
    ) {
        ModelAndView m = new ModelAndView();
        List<Map<String, Object>> results = mysqlService.FindMovieByYearAndMonth(year, month);
        List<Map<String, Object>> temps = results.subList(1,2);
        Set<String> keys = temps.get(0).keySet();
        m.addObject("time", results.get(0).get("time"));
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }

    @PostMapping(path = "/FindMovieByYearAndQuarterly")
    public ModelAndView FindMovieByYearAndQuarterly(
            @RequestParam("year") String year,
            @RequestParam("quarterly") String quarterly
    ) {
        ModelAndView m = new ModelAndView();
        List<Map<String, Object>> results = mysqlService.FindMovieByYearAndQuarterly(year, quarterly);
        List<Map<String, Object>> temps = results.subList(1,2);
        Set<String> keys = temps.get(0).keySet();
        m.addObject("time", results.get(0).get("time"));
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }

    @PostMapping(path = "/FindMovieVersionsByName")
    public ModelAndView FindMovieVersionsByName(
            @RequestParam("name") String name
    ) {
        ModelAndView m = new ModelAndView();
        List<Map<String, Object>> results = mysqlService.FindMovieVersionsByName(name);
        List<Map<String, Object>> temps = results.subList(1,2);
        Set<String> keys = temps.get(0).keySet();
        m.addObject("time", results.get(0).get("time"));
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }

    @PostMapping(path = "/FindMovieBydirectorDirectorName")
    public ModelAndView FindMovieBydirectorDirectorName(
            @RequestParam("directorName") String directorName
    ) {
        ModelAndView m = new ModelAndView();
        List<Map<String, Object>> results = mysqlService.FindMovieBydirectorDirectorName(directorName);
        List<Map<String, Object>> temps = results.subList(1,2);
        Set<String> keys = temps.get(0).keySet();
        m.addObject("time", results.get(0).get("time"));
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }

    @PostMapping(path = "/FindMovieBydirectorActorName")
    public ModelAndView FindMovieBydirectorActorName(
            @RequestParam("ActorName") String ActorName
    ) {
        ModelAndView m = new ModelAndView();
        List<Map<String, Object>> results = mysqlService.FindMovieBydirectorActorName(ActorName);
        List<Map<String, Object>> temps = results.subList(1,2);
        Set<String> keys = temps.get(0).keySet();
        m.addObject("time", results.get(0).get("time"));
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }

    @PostMapping(path = "/FindRelationshipOfDirectorAndActorByNum")
    public ModelAndView FindRelationshipOfDirectorAndActorByNum(
            @RequestParam("num") String num
    ) {
        ModelAndView m = new ModelAndView();
        List<Map<String, Object>> results = mysqlService.FindRelationshipOfDirectorAndActorByNum(num);
        List<Map<String, Object>> temps = results.subList(1,2);
        Set<String> keys = temps.get(0).keySet();
        m.addObject("time", results.get(0).get("time"));
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }

    @PostMapping(path = "/FindRelationshipOfActorAndActorByNum")
    public ModelAndView FindRelationshipOfActorAndActorByNum(
            @RequestParam("num") String num
    ) {
        ModelAndView m = new ModelAndView();
        List<Map<String, Object>> results = mysqlService.FindRelationshipOfActorAndActorByNum(num);
        List<Map<String, Object>> temps = results.subList(1,2);
        Set<String> keys = temps.get(0).keySet();
        m.addObject("time", results.get(0).get("time"));
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }

    @PostMapping(path = "/FindMovieCountByType")
    public ModelAndView FindMovieCountByType(
            @RequestParam("type") String type
    ) {
        ModelAndView m = new ModelAndView();
        List<Map<String, Object>> results = mysqlService.FindMovieCountByType(type);
        List<Map<String, Object>> temps = results.subList(1,2);
        Set<String> keys = temps.get(0).keySet();
        m.addObject("time", results.get(0).get("time"));
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }

    @PostMapping(path = "/FindMovieCountByGrade")
    public ModelAndView FindMovieCountByGrade(
            @RequestParam("grade") String grade
    ) {
        ModelAndView m = new ModelAndView();
        List<Map<String, Object>> results = mysqlService.FindMovieCountByGrade(grade);
        List<Map<String, Object>> temps = results.subList(1,2);
        Set<String> keys = temps.get(0).keySet();
        m.addObject("time", results.get(0).get("time"));
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }

    @PostMapping(path = "/FindMovieCountByPositiveReviews")
    public ModelAndView FindMovieCountByPositiveReviews(
            @RequestParam("Positive") String Positive
    ) {
        ModelAndView m = new ModelAndView();
        List<Map<String, Object>> results = mysqlService.FindMovieCountByPositiveReviews();
        List<Map<String, Object>> temps = results.subList(1,2);
        Set<String> keys = temps.get(0).keySet();
        m.addObject("time", results.get(0).get("time"));
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }
}
