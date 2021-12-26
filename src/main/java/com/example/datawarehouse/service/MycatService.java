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

    /**
     *
     * @param year month
     * @return count of the movie
     * @apiNote :count(formatedate)这样更加快
     */
    public List<Map<String, Object>> FindMovieByYearAndMonth(String year,String month){
        String sql="SELECT count(*)  FROM movie_date where DATE_FORMAT(FormatDate,'%Y')=? and DATE_FORMAT(FormatDate,'%m')=?";
        List<Map<String, Object>> maps;
        Object[] objects = new Object[2];
        objects[0] = year;
        objects[1] = month;
        maps = jdbcTemplate.queryForList(sql, objects);
        return maps;
    }

    /**
     *
     * @param year quarterly
     * @return count of the movie
     */
    public List<Map<String, Object>> FindMovieByYearAndQuarterly(String year,String quarterly){
        String sql="SELECT count(*)  FROM movie_date where DATE_FORMAT(FormatDate,'%Y')=? " +
                "and DATE_FORMAT(FormatDate,'%m')=? " +
                "or DATE_FORMAT(FormatDate,'%m')=? " +
                "or DATE_FORMAT(FormatDate,'%m')=? ";
        int a=1;
        try  {
            a = 3*Integer.parseInt(quarterly);
        }  catch  (NumberFormatException e) {
            e.printStackTrace();
        }
        List<Map<String, Object>> maps;
        Object[] objects = new Object[4];
        objects[0] = year;
        objects[1] = a;
        objects[2] = a+1;
        objects[3] = a+2;
        maps = jdbcTemplate.queryForList(sql, objects);
        return maps;
    }

    /**
     *
     * @param name
     * @return count of the movie version
     */
    public List<Map<String, Object>> FindMovieVersionsByName(String name){
        String sql="select count(title) as count from details where title=?";
        List<Map<String, Object>> maps;
        Object[] objects = new Object[1];
        objects[0] = name;
        maps = jdbcTemplate.queryForList(sql, objects);
        return maps;
    }

    /**
     *
     * @param directorName
     * @return count of the movie num
     */
    public List<Map<String, Object>> FindMovieBydirectorDirectorName(String directorName){
        String sql="select name,count(name) as count\n" +
                "from movie_director\n" +
                "where name=?";
        List<Map<String, Object>> maps;
        Object[] objects = new Object[1];
        objects[0] = directorName;
        maps = jdbcTemplate.queryForList(sql, objects);
        return maps;
    }

    /**
     *
     * @param ActorName
     * @return count of the movie num
     */
    public List<Map<String, Object>> FindMovieBydirectorActorName(String ActorName){
        String sql="select name,count(name) as count\n" +
                "from movie_actor\n" +
                "where name=?";
        List<Map<String, Object>> maps;
        Object[] objects = new Object[1];
        objects[0] = ActorName;
        maps = jdbcTemplate.queryForList(sql, objects);
        return maps;
    }

    /**
     *
     * @param num
     * @return list of the connection relationship more than num
     */
    public List<Map<String, Object>> FindRelationshipOfDirectorAndActorByNum(String num){
        String sql="select actor,director \n" +
                "from actor_director \n" +
                "where count >=?\n";
        List<Map<String, Object>> maps;
        Object[] objects = new Object[1];
        objects[0] = num;
        maps = jdbcTemplate.queryForList(sql, objects);
        return maps;
    }

    /**
     *
     * @param num
     * @return list of the connection relationship more than num
     */
    public List<Map<String, Object>> FindRelationshipOfActorAndActorByNum(String num){
        String sql="select actor as actor1,actor_1 as actor2 \n" +
                "from actors_actors \n" +
                "where count >=?\n";
        List<Map<String, Object>> maps;
        Object[] objects = new Object[1];
        objects[0] = num;
        maps = jdbcTemplate.queryForList(sql, objects);
        return maps;
    }

    /**
     *
     * @param type
     * @return list of the movie by type
     */
    public List<Map<String, Object>> FindMovieCountByType(String type){
        String sql="Select count(*) from details where type like concat('%',?,'%')";
        List<Map<String, Object>> maps;
        Object[] objects = new Object[1];
        objects[0] = type;
        maps = jdbcTemplate.queryForList(sql, objects);
        return maps;
    }

    /**
     *
     * @param grade
     * @return list of the movie by grade
     */
    public List<Map<String, Object>> FindMovieCountByGrade(String grade){
        String sql="Select count(asin) from details where customer_rating > ?";
        List<Map<String, Object>> maps;
        Object[] objects = new Object[1];
        objects[0] = grade;
        maps = jdbcTemplate.queryForList(sql, objects);
        return maps;
    }

    /**
     *
     * @param Positive
     * @return list of the movie by Positive reviews
     */
    public List<Map<String, Object>> FindMovieCountByPositiveReviews(Integer Positive){
        String sql="";
        List<Map<String, Object>> maps;
        Object[] objects = new Object[1];
        objects[0] = Positive;
        maps = jdbcTemplate.queryForList(sql, objects);
        return maps;
    }

}
