package org.testproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Database_Read {
    private Connection con;

    public Database_Read(Connection con) {
        this.con = con;
    }

    protected ArrayList<office> read() {
        ArrayList<office> aloffice = new ArrayList<>();

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
                aloffice.add(new office(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),
                        rs.getString(7),rs.getString(8),
                        rs.getString(9)));
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    return aloffice;
    }

    protected void display(ArrayList<office> aloffice) {

    }


}
