package org.testproject;

import jdk.internal.foreign.StringSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private Connection get_DB_Connection() {
        Connection con =  null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
            System.out.println("Connected to database successfully");

        }
        catch (ClassNotFoundException ce) {
            System.out.println(ce.getMessage());
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        return con;
    }


    public static void main(String[] args) {
        Main m = new Main();
        Connection con = m.get_DB_Connection();

        Database_Read dr = new Database_Read(con);
        dr.read();
        try {
            con.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}