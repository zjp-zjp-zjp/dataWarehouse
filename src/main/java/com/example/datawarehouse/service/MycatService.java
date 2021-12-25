package com.example.datawarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class MycatService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询所有年份的电影
    public List<Map<String, Object>> QueryMovieByYears(){
        String sql="SELECT DATE_FORMAT(FormatDate,'%Y') as year,count(*)\n" +
                "FROM movie_date\n" +
                "GROUP BY DATE_FORMAT(FormatDate,'%Y')\n" +
                "ORDER BY year asc;\n";
        List<Map<String, Object>> maps;
        maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    //查询所有的电影通过月份
    public int QueryMovieByMonths(String name){
        String sql="SELECT DATE_FORMAT(FormatDate,'%Y-%m') as month,count(*)\n" +
                "FROM movie_date\n" +
                "GROUP BY DATE_FORMAT(FormatDate,'%Y-%m')\n" +
                "ORDER BY month asc;\n";
        List<Map<String, Object>> maps;
        Object []objects=new Object[1];
        objects[0]=name;
        maps = jdbcTemplate.queryForList(sql,objects);
        return maps.size();
    }

    //查询所有的电影通过季度
    public int QueryMovieByFloors(String name){
        String sql="SELECT FLOOR((DATE_FORMAT(FormatDate,'%m')-1)/3)+1 as quarterly,min(FormatDate) as st,count(\t*)\n" +
                "FROM movie_date\n" +
                "WHERE DATE_FORMAT(FormatDate,'%Y') = 2011\n" +
                "GROUP BY FLOOR((DATE_FORMAT(FormatDate,'%m')-1)/3)+1\n" +
                "ORDER BY quarterly asc;\n";
        List<Map<String, Object>> maps;
        Object []objects=new Object[1];
        objects[0]=name;
        maps = jdbcTemplate.queryForList(sql,objects);
        return maps.size();
    }

    //查询所有的电影通过周几（默认周一为1）
    public int QueryMovieByDays(String name){
        String sql="SELECT DAYOFWEEK(FormatDate) as d,count(*)\n" +
                "FROM movie_date\n" +
                "GROUP BY DAYOFWEEK(FormatDate)\n" +
                "ORDER BY d asc;\n";
        List<Map<String, Object>> maps;
        Object []objects=new Object[1];
        objects[0]=name;
        maps = jdbcTemplate.queryForList(sql,objects);
        return maps.size();
    }

    //查找某一部电影有多少个版本
    public int CountMovieVersionsByName(String name){
        String sql="select title,count(*) as count\n" +
                "from details group by title order by count desc;\n";
        List<Map<String, Object>> maps;
        Object []objects=new Object[1];
        objects[0]=name;
        maps = jdbcTemplate.queryForList(sql,objects);
        return maps.size();
    }

    /**
     *
     * @param year
     * @return count of the movie
     * @apiNote :count(formatedate)这样更加快
     */
    public List<Map<String, Object>> FindMovieByYear(String year){
        String sql="SELECT count(FormatDate)  FROM movie_date where DATE_FORMAT(FormatDate,'%Y')=?";
        List<Map<String, Object>> maps;
        Object[] objects = new Object[1];
        objects[0] = year;
        maps = jdbcTemplate.queryForList(sql, objects);
        return maps;
    }



}
