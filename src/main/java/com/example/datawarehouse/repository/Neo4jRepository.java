package com.example.datawarehouse.repository;

import org.neo4j.driver.Record;
import org.neo4j.driver.*;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
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
//    public Date calculateDate(String origin){
//        String month;
//        String day;
//        String year;
//        String temp[]=origin.split(", ");
//        year=temp[1];
//        String temp0[]=temp[0].split(" ");
//        day=temp0[1];
//        switch (temp0[0]){
//            case "January":{
//                month="1";
//                break;
//            }
//            case "Febrary":{
//                month="2";
//                break;
//            }
//            case "March":{
//                month="3";
//                break;
//            }
//            case "April":{
//                month="4";
//                break;
//            }
//            case "May":{
//                month="5";
//                break;
//            }
//            case "June":{
//                month="6";
//                break;
//            }
//            case "July":{
//                month="7";
//                break;
//            }
//            case "August":{
//                month="8";
//                break;
//            }
//            case "September":{
//                month="9";
//                break;
//            }
//            case "October":{
//                month="10";
//                break;
//            }
//            case "November":{
//                month="11";
//                break;
//            }
//            case "December":{
//                month="12";
//                break;
//            }
//            default:{
//                month="";
//                break;
//            }
//        }
//    }
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
