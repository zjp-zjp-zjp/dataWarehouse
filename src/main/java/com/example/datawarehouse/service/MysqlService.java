package com.example.datawarehouse.service;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MysqlService {

    private Connection conn;

    public MysqlService() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://47.101.197.145:3306/user_db", "root", "password123A.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param year
     * @return count of the movie
     * @apiNote :count(formatedate)这样更加快
     */
    public List<Map<String, Object>> FindMovieByYear(String year) {
        String sql = "SELECT count(FormatDate)  FROM movie_date where DATE_FORMAT(FormatDate,'%Y')=?";
        PreparedStatement pst;
        ResultSet resultSet;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, year);
            long startMilliSec = System.currentTimeMillis();
            resultSet = pst.executeQuery();
            long endMilliSec = System.currentTimeMillis();
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("time", endMilliSec - startMilliSec);
            list.add(hashMap);
            Map<String, Object> map = new HashMap<>();
            if(resultSet.next())
                map.put("count", resultSet.getInt(1));
            else
                map.put("count",0);
            list.add(map);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }

    /**
     * @param year month
     * @return count of the movie
     * @apiNote :count(formatedate)这样更加快
     */
    public List<Map<String, Object>> FindMovieByYearAndMonth(String year, String month) {
        String sql = "SELECT count(*) FROM movie_date where DATE_FORMAT(FormatDate,'%Y')=? and DATE_FORMAT(FormatDate,'%c')=?";
        PreparedStatement pst;
        ResultSet resultSet;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, year);
            pst.setString(2, month);
            long startMilliSec = System.currentTimeMillis();
            resultSet = pst.executeQuery();
            long endMilliSec = System.currentTimeMillis();
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("time", endMilliSec - startMilliSec);
            list.add(hashMap);
            Map<String, Object> map = new HashMap<>();
            if(resultSet.next())
                map.put("count", resultSet.getInt(1));
            else
                map.put("count",0);
            list.add(map);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }

    /**
     * @param year quarterly
     * @return count of the movie
     */
    public List<Map<String, Object>> FindMovieByYearAndQuarterly(String year, String quarterly) {
        String sql = "select t1.count from (SELECT FLOOR((DATE_FORMAT(FormatDate,'%c')-1)/3)+1 as quarterly,count(\t*) as count\n" +
                "FROM movie_date\n" +
                "WHERE DATE_FORMAT(FormatDate,'%Y') = ?\n" +
                "GROUP BY FLOOR((DATE_FORMAT(FormatDate,'%c')-1)/3)+1\n" +
                "ORDER BY quarterly) t1 where quarterly = ?;\n";
        PreparedStatement pst;
        ResultSet resultSet;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, year);
            pst.setString(2, quarterly);
            long startMilliSec = System.currentTimeMillis();
            resultSet = pst.executeQuery();
            long endMilliSec = System.currentTimeMillis();
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("time", endMilliSec - startMilliSec);
            list.add(hashMap);
            Map<String, Object> map = new HashMap<>();
            if(resultSet.next())
                map.put("count", resultSet.getInt(1));
            else
                map.put("count",0);
            list.add(map);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }

    /**
     * @param name
     * @return count of the movie version
     */
    public List<Map<String, Object>> FindMovieVersionsByName(String name) {
        String sql = "select pages from details where title=?";
        PreparedStatement pst;
        ResultSet resultSet;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            long startMilliSec = System.currentTimeMillis();
            resultSet = pst.executeQuery();
            long endMilliSec = System.currentTimeMillis();
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("time", endMilliSec - startMilliSec);
            list.add(hashMap);
            Map<String, Object> map = new HashMap<>();
            if(resultSet.next())
                map.put("count", resultSet.getInt(1));
            else
                map.put("count",0);
            list.add(map);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }

    /**
     * @param directorName
     * @return count of the movie num
     */
    public List<Map<String, Object>> FindMovieBydirectorDirectorName(String directorName) {
        String sql = "select director,count(director) as count\n" +
                "from director_movie\n" +
                "where director=?";
        PreparedStatement pst;
        ResultSet resultSet;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, directorName);//设置条件id
            long startMilliSec = System.currentTimeMillis();
            resultSet = pst.executeQuery();
            long endMilliSec = System.currentTimeMillis();
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("time", endMilliSec - startMilliSec);
            list.add(hashMap);
            Map<String, Object> map = new HashMap<>();
            if (resultSet.next()) {
                map.put("director", resultSet.getString("director"));
                map.put("count", resultSet.getInt("count"));
            }else{
                map.put("director", "");
                map.put("count", 0);
            }
            list.add(map);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }

    /**
     * @param ActorName
     * @return count of the movie num
     */
    public List<Map<String, Object>> FindMovieBydirectorActorName(String ActorName) {
        String sql = "select actor,count(actor) as count\n" +
                "from actor_movie\n" +
                "where actor=?";
        PreparedStatement pst;
        ResultSet resultSet;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, ActorName);
            long startMilliSec = System.currentTimeMillis();
            resultSet = pst.executeQuery();
            long endMilliSec = System.currentTimeMillis();
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("time", endMilliSec - startMilliSec);
            list.add(hashMap);
            Map<String, Object> map = new HashMap<>();
            if (resultSet.next()) {
                map.put("actor", resultSet.getString("actor"));
                map.put("count", resultSet.getInt("count"));
            }else{
                map.put("actor", "");
                map.put("count", 0);
            }
            list.add(map);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }

    /**
     * @param num
     * @return list of the connection relationship more than num
     */
    public List<Map<String, Object>> FindRelationshipOfDirectorAndActorByNum(String num) {
        String sql = "select actor,director,count \n" +
                "from actor_director_count \n" +
                "where count >=?\n";
        PreparedStatement pst;
        ResultSet resultSet;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, num);
            long startMilliSec = System.currentTimeMillis();
            resultSet = pst.executeQuery();
            long endMilliSec = System.currentTimeMillis();
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("time", endMilliSec - startMilliSec);
            list.add(hashMap);
            Map<String, Object> map = new HashMap<>();
            if (resultSet.next()) {
                map.put("actor", resultSet.getString("actor"));
                map.put("director", resultSet.getString("director"));
                map.put("count", resultSet.getInt("count"));
            }else{
                map.put("actor", "");
                map.put("director", resultSet.getString("director"));
                map.put("count", 0);
            }
            list.add(map);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }

    /**
     * @param num
     * @return list of the connection relationship more than num
     */
    public List<Map<String, Object>> FindRelationshipOfActorAndActorByNum(String num) {
        String sql = "select actor, actor_1,count \n" +
                "from actors_actors_count \n" +
                "where count >=?\n";
        PreparedStatement pst;
        ResultSet resultSet;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, num);
            long startMilliSec = System.currentTimeMillis();
            resultSet = pst.executeQuery();
            long endMilliSec = System.currentTimeMillis();
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("time", endMilliSec - startMilliSec);
            list.add(hashMap);
            Map<String, Object> map = new HashMap<>();
            if (resultSet.next()) {
                map.put("actor", resultSet.getString("actor"));
                map.put("actor_1", resultSet.getString("actor_1"));
                map.put("count", resultSet.getInt("count"));
            }else{
                map.put("actor", "");
                map.put("actor_1", "");
                map.put("count", 0);
            }
            list.add(map);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }

    /**
     * @param type
     * @return list of the movie by type
     */
    public List<Map<String, Object>> FindMovieCountByType(String type) {
        String sql = "Select count(*) from details where type like concat('%',?,'%')";
        PreparedStatement pst;
        ResultSet resultSet;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, type);
            long startMilliSec = System.currentTimeMillis();
            resultSet = pst.executeQuery();
            long endMilliSec = System.currentTimeMillis();
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("time", endMilliSec - startMilliSec);
            list.add(hashMap);
            Map<String, Object> map = new HashMap<>();
            if(resultSet.next())
                map.put("count", resultSet.getInt(1));
            else
                map.put("count",0);
            list.add(map);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }

    /**
     * @param grade
     * @return list of the movie by grade
     */
    public List<Map<String, Object>> FindMovieCountByGrade(String grade) {
        String sql = "Select count(asin) from details where customer_rating > ?";
        PreparedStatement pst;
        ResultSet resultSet;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, grade);
            long startMilliSec = System.currentTimeMillis();
            resultSet = pst.executeQuery();
            long endMilliSec = System.currentTimeMillis();
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("time", endMilliSec - startMilliSec);
            list.add(hashMap);
            Map<String, Object> map = new HashMap<>();
            if(resultSet.next())
                map.put("count", resultSet.getInt(1));
            else
                map.put("count",0);
            list.add(map);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }

    /**
     * @return list of the movie by Positive reviews
     */
    public List<Map<String, Object>> FindMovieCountByPositiveReviews() {
        String sql = "select * from positive_movie";
        PreparedStatement pst;
        ResultSet resultSet;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            long startMilliSec = System.currentTimeMillis();
            resultSet = pst.executeQuery();
            long endMilliSec = System.currentTimeMillis();
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("time", endMilliSec - startMilliSec);
            list.add(hashMap);
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("asin", resultSet.getString(1));
                list.add(map);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }
}
