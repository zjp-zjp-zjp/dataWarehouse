package com.example.datawarehouse.controller;

import com.example.datawarehouse.service.MycatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping(path = "/mycat")
    public ModelAndView home() {
        ModelAndView m = new ModelAndView();
        m.setViewName("home");
        return m;
    }

    @GetMapping(path = "/test")
    public ModelAndView test() {
        ModelAndView m = new ModelAndView();
        List<Map<String, Object>> results = mycatService.QueryMovieByYears();
        Set<String> keys = new HashSet<>();
        if (results != null) {
            List<Map<String, Object>> temps = results.subList(0, 1);
            for (Map<String, Object> temp : temps) {
                keys = temp.keySet();
            }
        }
        m.addObject("keys", keys);
        m.addObject("results", results);
        m.setViewName("temp");
        return m;
    }

//    @GetMapping(path = "/time")
//    public double time() {
//        String sql = "declare @d datetime\n" +
//                "set @d=getdate()\n" +
//                "/*你的SQL脚本开始*/\n" +
//                "SELECT * FROM details\n" +
//                "/*你的SQL脚本结束*/\n" +
//                "select [语句执行花费时间(毫秒)]=datediff(ms,@d,getdate()) \n";
//
//
//    }


    @GetMapping(path = "/result")
    public ModelAndView result() {
        ModelAndView m = new ModelAndView();
        m.setViewName("result");
        return m;
    }

    @GetMapping(path = "/queryVersionByMovieNam/{name}")
    public int queryMovieByYearAndQuarterly(@PathVariable String name) {
        // 开始时间
        long startMilliSec = 0;
        startMilliSec = System.currentTimeMillis();
        // 中间功能代码块
        //功能代码开始
        String sql = "select * from employee where name=?";
        List<Map<String, Object>> maps;
        Object[] objects = new Object[1];
        objects[0] = name;
        maps = jdbcTemplate.queryForList(sql, objects);
         //功能代码结束
        // 结束时间
        long endMilliSec = 0;
        endMilliSec = System.currentTimeMillis();
        // 打印花费时间
        Long temp = (endMilliSec - startMilliSec);
        System.out.println("花费时间："+
                (((temp/86400000)>0)?((temp/86400000)+"d"):"")+
                ((((temp/86400000)>0)||((temp%86400000/3600000)>0))?((temp%86400000/3600000)+"h"):(""))+
                ((((temp/3600000)>0)||((temp%3600000/60000)>0))?((temp%3600000/60000)+"m"):(""))+
                ((((temp/60000)>0)||((temp%60000/1000)>0))?((temp%60000/1000)+"s"):(""))+
                ((temp%1000)+"ms"));
        return maps.size();
    }

//    @GetMapping(path = "/getall")
//    public int getall(){
//
//
//    }


}
