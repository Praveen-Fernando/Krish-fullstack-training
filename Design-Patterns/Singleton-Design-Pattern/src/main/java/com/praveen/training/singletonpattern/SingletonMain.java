package com.praveen.training.singletonpattern;

import java.sql.Connection;

public class SingletonMain {
    public static void main(String args[]){

        long start;
        long end;

        //DBManager 1
        DBManager dbManager1 = DBManager.getDbManager();
        System.out.println(dbManager1);

        start = System.currentTimeMillis();
        Connection connection1 = dbManager1.getConnection();
        end = System.currentTimeMillis();
        System.out.println(end-start);

        //DBManager 2
        DBManager dbManager2 = DBManager.getDbManager();
        System.out.println(dbManager1);

        start = System.currentTimeMillis();
        Connection connection2 = dbManager2.getConnection();
        end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
