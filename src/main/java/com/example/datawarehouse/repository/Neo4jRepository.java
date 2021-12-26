package com.example.datawarehouse.repository;

import com.example.datawarehouse.entity.Cooperate;
import com.example.datawarehouse.entity.Movie;
import lombok.extern.apachecommons.CommonsLog;
import org.neo4j.driver.*;
import org.neo4j.driver.Record;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static org.neo4j.driver.Values.parameters;
@Repository
public class Neo4jRepository implements AutoCloseable {
    private final Driver driver;
    public Neo4jRepository()
    {
        driver = GraphDatabase.driver( "bolt://192.168.1.105:7687", AuthTokens.basic( "neo4j", "zjp5683zjp" ) );
    }
    @Override
    public void close() throws Exception
    {
        driver.close();
    }
    public ArrayList<Movie> findMovieByDirector(String director){
        Session session=driver.session();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Result result=session.run("MATCH (m:Movie) WHERE m.Director = $director RETURN m",parameters("director",director));
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            movies.add(new Movie(record.get("m").get("MediaFormat").asString(),record.get("m").get("Producers").asString(),record.get("m").get("Writers").asString(),record.get("m").get("ASIN").asString(),record.get("m").get("imdbRating").asString(),record.get("m").get("Numberofdiscs").asString(),record.get("m").get("type").asString(),record.get("m").get("title").asString(),record.get("m").get("Studio").asString(),record.get("m").get("MPAArating").asString(),record.get("m").get("Runtime").asString(),record.get("m").get("customer_rating").asString(),record.get("m").get("pages").asString(),record.get("m").get("Language").asString(),record.get("m").get("PackageDimensions").asString(),record.get("m").get("Subtitles").asString(),record.get("m").get("IsDiscontinuedByManufacturer").asString(),record.get("m").get("Director").asString(),record.get("m").get("Actors").asString(),record.get("m").get("AspectRatio").asString(),record.get("m").get("ProductDimensions").asString(),record.get("m").get("Itemmodelnumber").asString(),record.get("m").get("Dubbed").asString(),record.get("m").get("Releasedate").asString()));
        }
        return movies;
    }
    public ArrayList<Movie> findMovieByActor(String actor){
        Session session=driver.session();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Result result=session.run("MATCH (m:Movie)-[r:has_actor]->(a:Actor) WHERE a.name=$actor RETURN m",parameters("actor",actor));
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            movies.add(new Movie(record.get("m").get("MediaFormat").asString(),record.get("m").get("Producers").asString(),record.get("m").get("Writers").asString(),record.get("m").get("ASIN").asString(),record.get("m").get("imdbRating").asString(),record.get("m").get("Numberofdiscs").asString(),record.get("m").get("type").asString(),record.get("m").get("title").asString(),record.get("m").get("Studio").asString(),record.get("m").get("MPAArating").asString(),record.get("m").get("Runtime").asString(),record.get("m").get("customer_rating").asString(),record.get("m").get("pages").asString(),record.get("m").get("Language").asString(),record.get("m").get("PackageDimensions").asString(),record.get("m").get("Subtitles").asString(),record.get("m").get("IsDiscontinuedByManufacturer").asString(),record.get("m").get("Director").asString(),record.get("m").get("Actors").asString(),record.get("m").get("AspectRatio").asString(),record.get("m").get("ProductDimensions").asString(),record.get("m").get("Itemmodelnumber").asString(),record.get("m").get("Dubbed").asString(),record.get("m").get("Releasedate").asString()));
        }
        return movies;
    }
    public ArrayList<Movie> findMovieByTitle(String title){
        Session session=driver.session();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Result result=session.run("MATCH (m:Movie) WHERE m.title CONTAINS $title RETURN m",parameters("title",title));
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            movies.add(new Movie(record.get("m").get("MediaFormat").asString(),record.get("m").get("Producers").asString(),record.get("m").get("Writers").asString(),record.get("m").get("ASIN").asString(),record.get("m").get("imdbRating").asString(),record.get("m").get("Numberofdiscs").asString(),record.get("m").get("type").asString(),record.get("m").get("title").asString(),record.get("m").get("Studio").asString(),record.get("m").get("MPAArating").asString(),record.get("m").get("Runtime").asString(),record.get("m").get("customer_rating").asString(),record.get("m").get("pages").asString(),record.get("m").get("Language").asString(),record.get("m").get("PackageDimensions").asString(),record.get("m").get("Subtitles").asString(),record.get("m").get("IsDiscontinuedByManufacturer").asString(),record.get("m").get("Director").asString(),record.get("m").get("Actors").asString(),record.get("m").get("AspectRatio").asString(),record.get("m").get("ProductDimensions").asString(),record.get("m").get("Itemmodelnumber").asString(),record.get("m").get("Dubbed").asString(),record.get("m").get("Releasedate").asString()));
        }
        return movies;
    }
    public ArrayList<Movie> findMovieByType(String type){
        Session session=driver.session();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Result result=session.run("MATCH (m:Movie) WHERE m.type CONTAINS $type RETURN m",parameters("type",type));
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            movies.add(new Movie(record.get("m").get("MediaFormat").asString(),record.get("m").get("Producers").asString(),record.get("m").get("Writers").asString(),record.get("m").get("ASIN").asString(),record.get("m").get("imdbRating").asString(),record.get("m").get("Numberofdiscs").asString(),record.get("m").get("type").asString(),record.get("m").get("title").asString(),record.get("m").get("Studio").asString(),record.get("m").get("MPAArating").asString(),record.get("m").get("Runtime").asString(),record.get("m").get("customer_rating").asString(),record.get("m").get("pages").asString(),record.get("m").get("Language").asString(),record.get("m").get("PackageDimensions").asString(),record.get("m").get("Subtitles").asString(),record.get("m").get("IsDiscontinuedByManufacturer").asString(),record.get("m").get("Director").asString(),record.get("m").get("Actors").asString(),record.get("m").get("AspectRatio").asString(),record.get("m").get("ProductDimensions").asString(),record.get("m").get("Itemmodelnumber").asString(),record.get("m").get("Dubbed").asString(),record.get("m").get("Releasedate").asString()));
        }
        return movies;
    }
    public ArrayList<Movie> findMovieByCustomer_rating(float customer_rating){
        Session session=driver.session();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Result result=session.run("MATCH (m:Movie) WHERE toFloat(m.customer_rating) >= $customer_rating RETURN m",parameters("customer_rating",customer_rating));
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            movies.add(new Movie(record.get("m").get("MediaFormat").asString(),record.get("m").get("Producers").asString(),record.get("m").get("Writers").asString(),record.get("m").get("ASIN").asString(),record.get("m").get("imdbRating").asString(),record.get("m").get("Numberofdiscs").asString(),record.get("m").get("type").asString(),record.get("m").get("title").asString(),record.get("m").get("Studio").asString(),record.get("m").get("MPAArating").asString(),record.get("m").get("Runtime").asString(),record.get("m").get("customer_rating").asString(),record.get("m").get("pages").asString(),record.get("m").get("Language").asString(),record.get("m").get("PackageDimensions").asString(),record.get("m").get("Subtitles").asString(),record.get("m").get("IsDiscontinuedByManufacturer").asString(),record.get("m").get("Director").asString(),record.get("m").get("Actors").asString(),record.get("m").get("AspectRatio").asString(),record.get("m").get("ProductDimensions").asString(),record.get("m").get("Itemmodelnumber").asString(),record.get("m").get("Dubbed").asString(),record.get("m").get("Releasedate").asString()));
        }
        return movies;
    }
    public ArrayList<Movie> findMovieByImdbRating(float imdbRating){
        Session session=driver.session();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Result result=session.run("MATCH (m:Movie) WHERE toFloat(m.imdbRating) >= $imdbRating RETURN m",parameters("imdbRating",imdbRating));
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            movies.add(new Movie(record.get("m").get("MediaFormat").asString(),record.get("m").get("Producers").asString(),record.get("m").get("Writers").asString(),record.get("m").get("ASIN").asString(),record.get("m").get("imdbRating").asString(),record.get("m").get("Numberofdiscs").asString(),record.get("m").get("type").asString(),record.get("m").get("title").asString(),record.get("m").get("Studio").asString(),record.get("m").get("MPAArating").asString(),record.get("m").get("Runtime").asString(),record.get("m").get("customer_rating").asString(),record.get("m").get("pages").asString(),record.get("m").get("Language").asString(),record.get("m").get("PackageDimensions").asString(),record.get("m").get("Subtitles").asString(),record.get("m").get("IsDiscontinuedByManufacturer").asString(),record.get("m").get("Director").asString(),record.get("m").get("Actors").asString(),record.get("m").get("AspectRatio").asString(),record.get("m").get("ProductDimensions").asString(),record.get("m").get("Itemmodelnumber").asString(),record.get("m").get("Dubbed").asString(),record.get("m").get("Releasedate").asString()));
        }
        return movies;
    }
    public ArrayList<Cooperate> findActorToActor(int count){
        Session session=driver.session();
        ArrayList<Cooperate> relations = new ArrayList<Cooperate>();
        Result result=session.run("MATCH p=(a1:Actor)-[r:actor_cooperate_with_actor]->(a2:Actor) WHERE toInteger(r.count)>$count RETURN a1,a2,r",parameters("count",count));
        for (Result it = result; it.hasNext(); ) {
            Record record = it.next();
            relations.add(new Cooperate(record.get("a1").get("name").asString(), record.get("a2").get("name").asString(), Integer.parseInt(record.get("r").get("count").asString())));
        }
        return relations;
    }
}
