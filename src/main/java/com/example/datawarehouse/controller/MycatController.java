package com.example.datawarehouse.controller;

import com.example.datawarehouse.service.MycatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping
public class MycatController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Resource
    private final MycatService mycatService;

    public MycatController(MycatService mycatService) {
        this.mycatService = mycatService;
    }

    //主页
    @GetMapping(path = "/mycat")
    public ModelAndView home() {
        ModelAndView m = new ModelAndView();
        m.setViewName("home");
        return m;
    }

    //调试的页面
    @GetMapping(path = "/test")
    public ModelAndView test() {
        ModelAndView m = new ModelAndView();
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        // 中间功能代码块
        List<Map<String, Object>> results = mycatService.QueryMovieByYears();
        // 结束时间
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

    //调试带有参数查询的界面
    @GetMapping(path = "/canshu")
    public ModelAndView result() {
        ModelAndView m = new ModelAndView();
        m.setViewName("test");
        return m;
    }


    @PostMapping(path = "/query")
    public ModelAndView query(
            @RequestParam("year") String year
            ) {
        ModelAndView m = new ModelAndView();
        // 开始时间
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

//    public int queryMovieByYearAndQuarterly(@PathVariable String name) {

}
