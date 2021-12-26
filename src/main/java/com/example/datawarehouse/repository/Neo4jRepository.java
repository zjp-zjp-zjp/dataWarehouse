package com.example.datawarehouse.repository;

import org.neo4j.driver.Record;
import org.neo4j.driver.*;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.neo4j.driver.Values.parameters;
@Repository
public class Neo4jRepository implements AutoCloseable {
    private final Driver driver;
    public Neo4jRepository()
    {
        driver = GraphDatabase.driver( "bolt://192.168.1.104:7687", AuthTokens.basic( "neo4j", "zjp5683zjp" ) );
    }
    @Override
    public void close() throws Exception
    {
        driver.close();
    }
    public String getmonth(LocalDate date){
        System.out.println(date);
        switch (date.getMonthValue()){
            case 1:{
                return "January";
            }
            case 2:{
                return "Febrary";
            }
            case 3:{
                return "March";
            }
            case 4:{
                return "April";
            }
            case 5:{
                return "May";
            }
            case 6:{
                return "June";
            }
            case 7:{
                return "July";
            }
            case 8:{
                return "August";
            }
            case 9:{
                return "September";
            }
            case 10:{
                return "October";
            }
            case 11:{
                return "November";
            }
            case 12:{
                return "December";
            }
            default:{
                return "";
            }
        }
    }
    public String getmonth(String month){
        switch (Integer.parseInt(month)){
            case 1:{
                return "January";
            }
            case 2:{
                return "Febrary";
            }
            case 3:{
                return "March";
            }
            case 4:{
                return "April";
            }
            case 5:{
                return "May";
            }
            case 6:{
                return "June";
            }
            case 7:{
                return "July";
            }
            case 8:{
                return "August";
            }
            case 9:{
                return "September";
            }
            case 10:{
                return "October";
            }
            case 11:{
                return "November";
            }
            case 12:{
                return "December";
            }
            default:{
                return "";
            }
        }
    }
    public List<Map<String,Object>> findMovieByDirector(String director){
        Session session=driver.session();
        Result result=session.run("MATCH (m1:Movie) WHERE m1.Director = $director RETURN m1.Director AS name,COUNT(m1) AS count",parameters("director",director));
//        for (Result it = result; it.hasNext(); ) {
//            Record record = it.next();
//            movies.add(new Movie(record.get("m").get("MediaFormat").asString(),record.get("m").get("Producers").asString(),record.get("m").get("Writers").asString(),record.get("m").get("ASIN").asString(),record.get("m").get("imdbRating").asString(),record.get("m").get("Numberofdiscs").asString(),record.get("m").get("type").asString(),record.get("m").get("title").asString(),record.get("m").get("Studio").asString(),record.get("m").get("MPAArating").asString(),record.get("m").get("Runtime").asString(),record.get("m").get("customer_rating").asString(),record.get("m").get("pages").asString(),record.get("m").get("Language").asString(),record.get("m").get("PackageDimensions").asString(),record.get("m").get("Subtitles").asString(),record.get("m").get("IsDiscontinuedByManufacturer").asString(),record.get("m").get("Director").asString(),record.get("m").get("Actors").asString(),record.get("m").get("AspectRatio").asString(),record.get("m").get("ProductDimensions").asString(),record.get("m").get("Itemmodelnumber").asString(),record.get("m").get("Dubbed").asString(),record.get("m").get("Releasedate").asString()));
//        }
//        return movies;
        List<Map<String,Object>> results=new ArrayList<>();
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            results.add(record.asMap());
        }
        return results;
    }
    public List<Map<String,Object>> findMovieByActor(String actor){
        Session session=driver.session();
        Result result=session.run("MATCH (m:Movie)-[r:has_actor]->(a:Actor) WHERE a.name=$actor RETURN a.name AS name,COUNT(m) AS count",parameters("actor",actor));
//        for (Result it = result; it.hasNext(); ) {
//            Record record = it.next();
//            movies.add(new Movie(record.get("m").get("MediaFormat").asString(),record.get("m").get("Producers").asString(),record.get("m").get("Writers").asString(),record.get("m").get("ASIN").asString(),record.get("m").get("imdbRating").asString(),record.get("m").get("Numberofdiscs").asString(),record.get("m").get("type").asString(),record.get("m").get("title").asString(),record.get("m").get("Studio").asString(),record.get("m").get("MPAArating").asString(),record.get("m").get("Runtime").asString(),record.get("m").get("customer_rating").asString(),record.get("m").get("pages").asString(),record.get("m").get("Language").asString(),record.get("m").get("PackageDimensions").asString(),record.get("m").get("Subtitles").asString(),record.get("m").get("IsDiscontinuedByManufacturer").asString(),record.get("m").get("Director").asString(),record.get("m").get("Actors").asString(),record.get("m").get("AspectRatio").asString(),record.get("m").get("ProductDimensions").asString(),record.get("m").get("Itemmodelnumber").asString(),record.get("m").get("Dubbed").asString(),record.get("m").get("Releasedate").asString()));
//        }
//        return movies;
        List<Map<String,Object>> results=new ArrayList<>();
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            results.add(record.asMap());
        }
        return results;
    }
    public List<Map<String,Object>> findMovieByTitle(String title){
        Session session=driver.session();
        Result result=session.run("MATCH (m:Movie) WHERE m.title CONTAINS $title RETURN $title AS title, COUNT(m) AS count",parameters("title",title));
//        for (Result it = result; it.hasNext(); ) {
//            Record record = it.next();
//            movies.add(new Movie(record.get("m").get("MediaFormat").asString(),record.get("m").get("Producers").asString(),record.get("m").get("Writers").asString(),record.get("m").get("ASIN").asString(),record.get("m").get("imdbRating").asString(),record.get("m").get("Numberofdiscs").asString(),record.get("m").get("type").asString(),record.get("m").get("title").asString(),record.get("m").get("Studio").asString(),record.get("m").get("MPAArating").asString(),record.get("m").get("Runtime").asString(),record.get("m").get("customer_rating").asString(),record.get("m").get("pages").asString(),record.get("m").get("Language").asString(),record.get("m").get("PackageDimensions").asString(),record.get("m").get("Subtitles").asString(),record.get("m").get("IsDiscontinuedByManufacturer").asString(),record.get("m").get("Director").asString(),record.get("m").get("Actors").asString(),record.get("m").get("AspectRatio").asString(),record.get("m").get("ProductDimensions").asString(),record.get("m").get("Itemmodelnumber").asString(),record.get("m").get("Dubbed").asString(),record.get("m").get("Releasedate").asString()));
//        }
//        return movies;
        List<Map<String,Object>> results=new ArrayList<>();
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            results.add(record.asMap());
        }
        return results;
    }
    public List<Map<String,Object>> findMovieByType(String type){
        Session session=driver.session();
        Result result=session.run("MATCH (m:Movie) WHERE m.type CONTAINS $type RETURN $type AS type, COUNT(m) AS count",parameters("type",type));
//        for (Result it = result; it.hasNext(); ) {
//            Record record = it.next();
//            movies.add(new Movie(record.get("m").get("MediaFormat").asString(),record.get("m").get("Producers").asString(),record.get("m").get("Writers").asString(),record.get("m").get("ASIN").asString(),record.get("m").get("imdbRating").asString(),record.get("m").get("Numberofdiscs").asString(),record.get("m").get("type").asString(),record.get("m").get("title").asString(),record.get("m").get("Studio").asString(),record.get("m").get("MPAArating").asString(),record.get("m").get("Runtime").asString(),record.get("m").get("customer_rating").asString(),record.get("m").get("pages").asString(),record.get("m").get("Language").asString(),record.get("m").get("PackageDimensions").asString(),record.get("m").get("Subtitles").asString(),record.get("m").get("IsDiscontinuedByManufacturer").asString(),record.get("m").get("Director").asString(),record.get("m").get("Actors").asString(),record.get("m").get("AspectRatio").asString(),record.get("m").get("ProductDimensions").asString(),record.get("m").get("Itemmodelnumber").asString(),record.get("m").get("Dubbed").asString(),record.get("m").get("Releasedate").asString()));
//        }
//        return movies;
        List<Map<String,Object>> results=new ArrayList<>();
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            results.add(record.asMap());
        }
        return results;
    }
    public List<Map<String,Object>> findMovieByCustomer_rating(float customer_rating){
        Session session=driver.session();
        Result result=session.run("MATCH (m:Movie) WHERE toFloat(m.customer_rating) > $customer_rating RETURN COUNT(m) AS count",parameters("customer_rating",customer_rating));
//        for (Result it = result; it.hasNext(); ) {
//            Record record = it.next();
//            movies.add(new Movie(record.get("m").get("MediaFormat").asString(),record.get("m").get("Producers").asString(),record.get("m").get("Writers").asString(),record.get("m").get("ASIN").asString(),record.get("m").get("imdbRating").asString(),record.get("m").get("Numberofdiscs").asString(),record.get("m").get("type").asString(),record.get("m").get("title").asString(),record.get("m").get("Studio").asString(),record.get("m").get("MPAArating").asString(),record.get("m").get("Runtime").asString(),record.get("m").get("customer_rating").asString(),record.get("m").get("pages").asString(),record.get("m").get("Language").asString(),record.get("m").get("PackageDimensions").asString(),record.get("m").get("Subtitles").asString(),record.get("m").get("IsDiscontinuedByManufacturer").asString(),record.get("m").get("Director").asString(),record.get("m").get("Actors").asString(),record.get("m").get("AspectRatio").asString(),record.get("m").get("ProductDimensions").asString(),record.get("m").get("Itemmodelnumber").asString(),record.get("m").get("Dubbed").asString(),record.get("m").get("Releasedate").asString()));
//        }
//        return movies;
        List<Map<String,Object>> results=new ArrayList<>();
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            results.add(record.asMap());
        }
        return results;
    }
    public List<Map<String,Object>> findMovieByImdbRating(float imdbRating){
        Session session=driver.session();
        Result result=session.run("MATCH (m:Movie) WHERE toFloat(m.imdbRating) >= $imdbRating RETURN COUNT(m) AS count",parameters("imdbRating",imdbRating));
//        for (Result it = result; it.hasNext(); ) {
//            Record record = it.next();
//            movies.add(new Movie(record.get("m").get("MediaFormat").asString(),record.get("m").get("Producers").asString(),record.get("m").get("Writers").asString(),record.get("m").get("ASIN").asString(),record.get("m").get("imdbRating").asString(),record.get("m").get("Numberofdiscs").asString(),record.get("m").get("type").asString(),record.get("m").get("title").asString(),record.get("m").get("Studio").asString(),record.get("m").get("MPAArating").asString(),record.get("m").get("Runtime").asString(),record.get("m").get("customer_rating").asString(),record.get("m").get("pages").asString(),record.get("m").get("Language").asString(),record.get("m").get("PackageDimensions").asString(),record.get("m").get("Subtitles").asString(),record.get("m").get("IsDiscontinuedByManufacturer").asString(),record.get("m").get("Director").asString(),record.get("m").get("Actors").asString(),record.get("m").get("AspectRatio").asString(),record.get("m").get("ProductDimensions").asString(),record.get("m").get("Itemmodelnumber").asString(),record.get("m").get("Dubbed").asString(),record.get("m").get("Releasedate").asString()));
//        }
//        return movies;
        List<Map<String,Object>> results=new ArrayList<>();
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            results.add(record.asMap());
        }
        return results;
    }
    public List<Map<String,Object>> findActorToActor(int count){
        Session session=driver.session();
        Result result=session.run("MATCH p=(a1:Actor)-[r:actor_cooperate_with_actor]->(a2:Actor) WHERE toInteger(r.count)>$count RETURN a1.name AS actor1,a2.name AS actor2,r.count AS count",parameters("count",count));
//        for (Result it = result; it.hasNext(); ) {
//            Record record = it.next();
//            relations.add(new Cooperate(record.get("a1").get("name").asString(), record.get("a2").get("name").asString(), Integer.parseInt(record.get("r").get("count").asString())));
//        }
//        return relations;
        List<Map<String,Object>> results=new ArrayList<>();
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            results.add(record.asMap());
        }
        return results;
    }
    public List<Map<String,Object>> findDirectorToActor(int count){
        Session session=driver.session();
        Result result=session.run("MATCH p=(d:Director)-[r:director_cooperate_with_actor]->(a:Actor) WHERE toInteger(r.count)>$count RETURN d.name AS director,a.name AS actor,r.count AS count",parameters("count",count));
//        for (Result it = result; it.hasNext(); ) {
//            Record record = it.next();
//            relations.add(new Cooperate(record.get("d").get("name").asString(), record.get("a").get("name").asString(), Integer.parseInt(record.get("r").get("count").asString())));
//        }
//        return relations;
        List<Map<String,Object>> results=new ArrayList<>();
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            results.add(record.asMap());
        }
        return results;
    }
    public List<Map<String,Object>> findMovieByStarringActor(String actor){
        Session session=driver.session();
        Result result=session.run("MATCH p=(m:Movie)-[r:stared_by]->(a:Actor) WHERE a.name=$actor RETURN a.name AS name, COUNT(m) AS count",parameters("actor",actor));
        List<Map<String,Object>> results=new ArrayList<>();
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            results.add(record.asMap());
        }
        return results;
    }
    public List<Map<String,Object>> findMovieWithPositiveComment(){
        Session session=driver.session();
        Result result=session.run("MATCH (n:Has_positive) RETURN COUNT(n) AS count");
        List<Map<String,Object>> results=new ArrayList<>();
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            results.add(record.asMap());
        }
        return results;
    }
    public List<Map<String,Object>> findMovieByYear(LocalDate date){
        Session session=driver.session();
        Result result=session.run("MATCH (m:Movie) WHERE m.Releasedate CONTAINS $year RETURN $year AS year,COUNT(m) AS count",parameters("year",String.valueOf(date.getYear())));
        List<Map<String,Object>> results=new ArrayList<>();
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            results.add(record.asMap());
        }
        return results;
    }
    public List<Map<String,Object>> findMovieByYearAndMonth(LocalDate date){
        Session session=driver.session();
        Result result=session.run("MATCH (m:Movie) WHERE m.Releasedate CONTAINS $year AND m.Releasedate CONTAINS $month RETURN $year AS year,$month AS month,COUNT(m) AS count",parameters("year",String.valueOf(date.getYear()),"month",getmonth(date)));
        List<Map<String,Object>> results=new ArrayList<>();
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            results.add(record.asMap());
        }
        return results;
    }
    public List<Map<String,Object>> findMovieByYearAndQuarterly(String year,String quarterly){
        Session session=driver.session();
        String month1=String.valueOf(3*Integer.parseInt(quarterly)-2);
        String month2=String.valueOf(3*Integer.parseInt(quarterly)-1);
        String month3=String.valueOf(3*Integer.parseInt(quarterly));
        Result result=session.run("MATCH (m:Movie) WHERE m.Releasedate CONTAINS $year AND m.Releasedate CONTAINS $month1 OR m.Releasedate CONTAINS $month2 OR m.Releasedate CONTAINS $month3 RETURN $year AS year,$quarterly AS quarterly,COUNT(m) AS count",parameters("year",year,"month1",getmonth(month1),"month2",getmonth(month2),"month3",getmonth(month3),"quarterly",quarterly));
        List<Map<String,Object>> results=new ArrayList<>();
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            results.add(record.asMap());
        }
        return results;
    }
}
//    public ArrayList<Movie> findMovieByImdbRating(float imdbRating){
//        Session session=driver.session();
//        ArrayList<Movie> movies = new ArrayList<Movie>();
//        Result result=session.run("MATCH (m:Movie) WHERE toFloat(m.imdbRating) >= $imdbRating RETURN m",parameters("imdbRating",imdbRating));
//        for (Result it = result; it.hasNext(); ) {
//            Record record = it.next();
//            movies.add(new Movie(record.get("m").get("MediaFormat").asString(),record.get("m").get("Producers").asString(),record.get("m").get("Writers").asString(),record.get("m").get("ASIN").asString(),record.get("m").get("imdbRating").asString(),record.get("m").get("Numberofdiscs").asString(),record.get("m").get("type").asString(),record.get("m").get("title").asString(),record.get("m").get("Studio").asString(),record.get("m").get("MPAArating").asString(),record.get("m").get("Runtime").asString(),record.get("m").get("customer_rating").asString(),record.get("m").get("pages").asString(),record.get("m").get("Language").asString(),record.get("m").get("PackageDimensions").asString(),record.get("m").get("Subtitles").asString(),record.get("m").get("IsDiscontinuedByManufacturer").asString(),record.get("m").get("Director").asString(),record.get("m").get("Actors").asString(),record.get("m").get("AspectRatio").asString(),record.get("m").get("ProductDimensions").asString(),record.get("m").get("Itemmodelnumber").asString(),record.get("m").get("Dubbed").asString(),record.get("m").get("Releasedate").asString()));
//        }
//        return movies;
//    }
//    public ArrayList<Cooperate> findActorToActor(int count){
//        Session session=driver.session();
//        ArrayList<Cooperate> relations = new ArrayList<Cooperate>();
//        Result result=session.run("MATCH p=(a1:Actor)-[r:actor_cooperate_with_actor]->(a2:Actor) WHERE toInteger(r.count)>$count RETURN a1,a2,r",parameters("count",count));
//        for (Result it = result; it.hasNext(); ) {
//            Record record = it.next();
//            relations.add(new Cooperate(record.get("a1").get("name").asString(), record.get("a2").get("name").asString(), Integer.parseInt(record.get("r").get("count").asString())));
//        }
//        return relations;
//    }
