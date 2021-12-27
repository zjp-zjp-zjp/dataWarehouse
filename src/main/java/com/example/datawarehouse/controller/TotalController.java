package com.example.datawarehouse.controller;

import com.example.datawarehouse.service.MycatService;
import com.example.datawarehouse.service.MysqlService;
import com.example.datawarehouse.service.Neo4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

@RestController
@RequestMapping
public class TotalController {
    @Resource
    private final Neo4jService neo4jService;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Resource
    private final MycatService mycatService;
    @Resource
    private final MysqlService mysqlService;

    public TotalController(Neo4jService neo4jService, JdbcTemplate jdbcTemplate, MycatService mycatService, MysqlService mysqlService) {
        this.neo4jService = neo4jService;
        this.jdbcTemplate = jdbcTemplate;
        this.mycatService = mycatService;
        this.mysqlService = mysqlService;
    }

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @PostMapping(path = "/FindMovieByYear")
    public ModelAndView FindMovieByYear(@RequestParam("year") String year) {
        ModelAndView m = new ModelAndView();
        List<Map<String, Object>> results1 = mysqlService.FindMovieByYear(year);
        List<Map<String, Object>> temps = results1.subList(1, 2);
        Set<String> keys1 = temps.get(0).keySet();
        m.addObject("time1", results1.get(0).get("time"));
        m.addObject("keys1", keys1);
        m.addObject("results1", results1);

        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        LocalDate _date = LocalDate.of(Integer.parseInt(year), 11, 11);
        List<Map<String, Object>> results2 = neo4jService.getMovieByYear(_date);
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

        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        // 中间功能代码块
        List<Map<String, Object>> results = mycatService.FindMovieByYear(year);
        // 结束时间
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps1 = results.subList(0, 1);
            for (Map<String, Object> temp : temps1) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
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
        List<Map<String, Object>> results1 = mysqlService.FindMovieByYearAndMonth(year, month);
        List<Map<String, Object>> temps = results1.subList(1, 2);
        Set<String> keys1 = temps.get(0).keySet();
        m.addObject("time1", results1.get(0).get("time"));
        m.addObject("keys1", keys1);
        m.addObject("results1", results1);

        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        LocalDate _date = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 11);
        List<Map<String, Object>> results2 = neo4jService.getMovieByYearAndMonth(_date);
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

        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        // 中间功能代码块
        List<Map<String, Object>> results = mycatService.FindMovieByYearAndMonth(year, month);
        // 结束时间
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps1 = results.subList(0, 1);
            for (Map<String, Object> temp : temps1) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
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
        List<Map<String, Object>> results1 = mysqlService.FindMovieByYearAndQuarterly(year, quarterly);
        List<Map<String, Object>> temps = results1.subList(1, 2);
        Set<String> keys1 = temps.get(0).keySet();
        m.addObject("time1", results1.get(0).get("time"));
        m.addObject("keys1", keys1);
        m.addObject("results1", results1);

        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String, Object>> results2 = neo4jService.getMovieByYearAndQuarterly(year, quarterly);
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

        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        // 中间功能代码块
        List<Map<String, Object>> results = mycatService.FindMovieByYearAndQuarterly(year, quarterly);
        // 结束时间
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps1 = results.subList(0, 1);
            for (Map<String, Object> temp : temps1) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
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
        List<Map<String, Object>> results1 = mysqlService.FindMovieVersionsByName(name);
        List<Map<String, Object>> temps = results1.subList(1, 2);
        Set<String> keys1 = temps.get(0).keySet();
        m.addObject("time1", results1.get(0).get("time"));
        m.addObject("keys1", keys1);
        m.addObject("results1", results1);

        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String, Object>> results2 = neo4jService.getMovieByTitle(name);
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

        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        // 中间功能代码块
        List<Map<String, Object>> results = mycatService.FindMovieVersionsByName(name);
        // 结束时间
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps1 = results.subList(0, 1);
            for (Map<String, Object> temp : temps1) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
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
        List<Map<String, Object>> results1 = mysqlService.FindMovieBydirectorDirectorName(directorName);
        List<Map<String, Object>> temps = results1.subList(1, 2);
        Set<String> keys1 = temps.get(0).keySet();
        m.addObject("time1", results1.get(0).get("time"));
        m.addObject("keys1", keys1);
        m.addObject("results1", results1);

        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String, Object>> results2 = neo4jService.getMovieByDirector(directorName);
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

        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        // 中间功能代码块
        List<Map<String, Object>> results = mycatService.FindMovieBydirectorDirectorName(directorName);
        // 结束时间
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps1 = results.subList(0, 1);
            for (Map<String, Object> temp : temps1) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
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
        List<Map<String, Object>> results1 = mysqlService.FindMovieBydirectorActorName(ActorName);
        List<Map<String, Object>> temps = results1.subList(1, 2);
        Set<String> keys1 = temps.get(0).keySet();
        m.addObject("time1", results1.get(0).get("time"));
        m.addObject("keys1", keys1);
        m.addObject("results1", results1);

        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String, Object>> results2 = neo4jService.getMovieByActor(ActorName);
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

        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        // 中间功能代码块
        List<Map<String, Object>> results = mycatService.FindMovieBydirectorActorName(ActorName);
        // 结束时间
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps1 = results.subList(0, 1);
            for (Map<String, Object> temp : temps1) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
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
        List<Map<String, Object>> results1 = mysqlService.FindRelationshipOfDirectorAndActorByNum(num);
        List<Map<String, Object>> temps = results1.subList(1, 2);
        Set<String> keys1 = temps.get(0).keySet();
        m.addObject("time1", results1.get(0).get("time"));
        m.addObject("keys1", keys1);
        m.addObject("results1", results1);

        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String, Object>> results2 = neo4jService.getRelationBetDirectorAndActor(Integer.parseInt(num));
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

        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        // 中间功能代码块
        List<Map<String, Object>> results = mycatService.FindRelationshipOfDirectorAndActorByNum(num);
        // 结束时间
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps1 = results.subList(0, 1);
            for (Map<String, Object> temp : temps1) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
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
        List<Map<String, Object>> results1 = mysqlService.FindRelationshipOfActorAndActorByNum(num);
        List<Map<String, Object>> temps = results1.subList(1, 2);
        Set<String> keys1 = temps.get(0).keySet();
        m.addObject("time1", results1.get(0).get("time"));
        m.addObject("keys1", keys1);
        m.addObject("results1", results1);

        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String, Object>> results2 = neo4jService.getRelationBetDirectorAndActor(Integer.parseInt(num));
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

        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        // 中间功能代码块
        List<Map<String, Object>> results = mycatService.FindRelationshipOfActorAndActorByNum(num);
        // 结束时间
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps1 = results.subList(0, 1);
            for (Map<String, Object> temp : temps1) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
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
        List<Map<String, Object>> results1 = mysqlService.FindMovieCountByType(type);
        List<Map<String, Object>> temps = results1.subList(1, 2);
        Set<String> keys1 = temps.get(0).keySet();
        m.addObject("time1", results1.get(0).get("time"));
        m.addObject("keys1", keys1);
        m.addObject("results1", results1);

        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String, Object>> results2 = neo4jService.getMovieByType(type);
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

        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        // 中间功能代码块
        List<Map<String, Object>> results = mycatService.FindMovieCountByType(type);
        // 结束时间
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps1 = results.subList(0, 1);
            for (Map<String, Object> temp : temps1) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
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
        List<Map<String, Object>> results1 = mysqlService.FindMovieCountByGrade(grade);
        List<Map<String, Object>> temps = results1.subList(1, 2);
        Set<String> keys1 = temps.get(0).keySet();
        m.addObject("time1", results1.get(0).get("time"));
        m.addObject("keys1", keys1);
        m.addObject("results1", results1);

        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String, Object>> results2 = neo4jService.getMovieByCustomer_rating(Float.parseFloat(grade));
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

        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        // 中间功能代码块
        List<Map<String, Object>> results = mycatService.FindMovieCountByGrade(grade);
        // 结束时间
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps1 = results.subList(0, 1);
            for (Map<String, Object> temp : temps1) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
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
        List<Map<String, Object>> results1 = mysqlService.FindMovieCountByPositiveReviews();
        List<Map<String, Object>> temps = results1.subList(1, 2);
        Set<String> keys1 = temps.get(0).keySet();
        m.addObject("time1", results1.get(0).get("time"));
        m.addObject("keys1", keys1);
        m.addObject("results1", results1);

        long startMilliSec1 = 0;
        startMilliSec1 = System.currentTimeMillis();
        List<Map<String, Object>> results2 = neo4jService.getMovieWithPositiveComment();
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

        int a = 1;
        try {
            a = Integer.parseInt(Positive);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        // 中间功能代码块
        List<Map<String, Object>> results = mycatService.FindMovieCountByPositiveReviews(a);
        // 结束时间
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long time = (endMilliSec - startMilliSec);
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps1 = results.subList(0, 1);
            for (Map<String, Object> temp : temps1) {
                keys = temp.keySet();
            }
        }
        m.addObject("time", time);
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("result");
        return m;
    }

    @GetMapping(path = "/queryForAll")
    public ModelAndView queryForAll() {
        ModelAndView m = new ModelAndView();
        m.setViewName("test");
        return m;
    }

    @PostMapping(path = "/queryForAll")
    public List<String> queryForAll(
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
    ) throws ParseException {
        String[] results = new String[3];
        String sql = "select count(*) from details where ";
        String[] MONTH = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        if (!year.equals(""))
            sql += "Releasedate like '%" + year + "%' and ";
        if (!month.equals("")) {
            sql += "Releasedate like '%" + MONTH[Integer.parseInt(month) - 1] + "%' and ";
        }
        if (!movieName.equals("")) {
            sql += "title like '%" + movieName + "%' and ";
        }
        if (!actorName.equals("")) {
            sql += "actor like '%" + actorName + "%' and ";
        }
        if (!DirectorName.equals("")) {
            sql += "Director like '%" + DirectorName + "%' and ";
        }
        if (!type.equals("")) {
            sql += "type like '%" + type + "%' and ";
        }
        if (!grade.equals("")) {
            sql += "customer_rating > " + grade + " and ";
        }
        sql = sql.substring(0, sql.length() - 5);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://47.101.197.145:3306/user_db", "root", "password123A.");
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                results[0] = resultSet.getString(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        results[1] = "1";
        results[2] = neo4jService.getAll(year,month,quarterly,movieName,actorName,DirectorName,actorName1,num,type,grade,Positive);
        return List.of(results);

    }
}
