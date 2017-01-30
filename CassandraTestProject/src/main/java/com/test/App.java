package com.test;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
  




 
        // Connect to the cluster and keyspace 
        final Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1")
                .build();       
        final Session session = cluster.connect("samplekeyspace");
         
      
         
        // Retrieve all Student details from Student table
        System.out.println("\n*********Retrive User Data Example *************");        
        getStudentsAllDetails(session);
    }
        /*
         
        // Insert new User into users table
        System.out.println("\n*********Insert User Data Example *************");        
        session.execute("INSERT INTO users (id, address, name) VALUES (11104, 'USA', 'Stuatr')");
        getUsersAllDetails(session);
         
        // Update user data in users table
        System.out.println("\n*********Update User Data Example *************");        
        session.execute("update users set address = 'USA NEW' where id = 11104");
        getUsersAllDetails(session);
         
        // Delete user from users table
        System.out.println("\n*********Delete User Data Example *************");        
        session.execute("delete FROM users where id = 11104");
        getUsersAllDetails(session);
         
        // Close Cluster and Session objects
        System.out.println("\nIs Cluster Closed :" + cluster.isClosed());
        System.out.println("Is Session Closed :" + session.isClosed());     
        cluster.close();
        session.close();
        System.out.println("Is Cluster Closed :" + cluster.isClosed());
        System.out.println("Is Session Closed :" + session.isClosed());
    }
     */
    private static void getStudentsAllDetails(final Session inSession){        
        // Use select to get the users table data
        ResultSet results = inSession.execute("SELECT * FROM student");
        for (Row row : results) {
            System.out.format("%d %s %s\n", row.getInt("id"), row.getString("firstname"),
                    row.getString("lastname"));
        }
    }
}