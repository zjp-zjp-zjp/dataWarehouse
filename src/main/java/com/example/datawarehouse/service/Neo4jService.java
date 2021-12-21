//package com.example.datawarehouse.service;
//import org.neo4j.driver.AuthTokens;
//import org.neo4j.driver.Driver;
//import org.neo4j.driver.GraphDatabase;
//import org.neo4j.driver.Result;
//import org.neo4j.driver.Session;
//
//import static org.neo4j.driver.Values.parameters;
//public class Neo4jService implements AutoCloseable{
//    private final Driver driver;
//    public Neo4jService( String uri, String user, String password )
//    {
//        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
//    }
//    @Override
//    public void close() throws Exception
//    {
//        driver.close();
//    }
//    public void testquery()
//    {
//        try ( Session session = driver.session() )
//        {
//            Result result = session.run( "MATCH (n:Actor) RETURN n LIMIT 1");
//            System.out.println(result.single().get("n").get("name").asString());
//        }
//    }
//    public static void main( String... args ) throws Exception
//    {
//        try ( Neo4jService greeter = new Neo4jService( "bolt://192.168.1.104:7687", "neo4j", "zjp5683zjp" ) )
//        {
//            greeter.testquery();
//        }
//    }
//}
