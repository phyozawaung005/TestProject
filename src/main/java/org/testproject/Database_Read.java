package org.testproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database_Read {
    private Connection con;

    public Database_Read(Connection con) {
        this.con = con;
    }

    protected void read() {
        try {
            //Preparedstatement can protect from SQL injection
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM offices WHERE country = ?");
            //1 = ? so in this code only 1 ?
            ps.setString(1, "USA");
            //executequery means output result
            //executupdate means no output result used in insert update delete
            ResultSet rs = ps.executeQuery();
            //next mean pointer, if run 1 time he will output data from first
            //if want to output next roll run 2 time. if you want to go up use previous
            //if data he pull data true/ if final data he told false.
            while(rs.next()){
                System.out.print(rs.getInt(1));
                System.out.print("|");
                System.out.print(rs.getString("city"));
                System.out.println("");
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
