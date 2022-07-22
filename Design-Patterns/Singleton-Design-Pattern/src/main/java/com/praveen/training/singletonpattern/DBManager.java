package com.praveen.training.singletonpattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static volatile DBManager dbManager;
    private static volatile Connection connection;

    private DBManager(){
        if (dbManager != null){
            throw new RuntimeException("Use getDBManger Method");
        }
    }

    public static DBManager getDbManager(){
        if(dbManager == null){
            //double checking implementation
            synchronized (DBManager.class){
                if(dbManager == null){
                    dbManager = new DBManager();
                }
            }
        }
        return dbManager;
    }

    public Connection getConnection(){

        if(connection == null){
            synchronized (DBManager.class){
                if(connection == null){
                    String url = "jdbc:derby:memory:sample;create=true";
                    try {
                        connection = DriverManager.getConnection(url);
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
}
