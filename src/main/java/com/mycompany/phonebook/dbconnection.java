/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hsoleimany
 */
public class dbconnection {

    public ArrayList<Phonebook> getContact() {
        Connection c = getconnection();
        ArrayList<Phonebook> plist = null;
        try {
            Statement s = c.createStatement();
            String sql = "SELECT * FROM phonebook.phonebooks ;";
            ResultSet rs = s.executeQuery(sql);
            plist = new ArrayList<Phonebook>();
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("family"));
                System.out.println(rs.getString("address"));
                System.out.println(rs.getString("mobile"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return plist;
    }

    public boolean saveContact(Phonebook p) {
        Connection c = getconnection();
        try {
            Statement s = c.createStatement();
            String sql = "INSERT INTO phonebook.phonebooks ( name, family, address, mobile) VALUES (?,?,?,?);";

            PreparedStatement statement = c.prepareCall(sql);
            statement.setString(1, p.getName());
            statement.setString(2, p.getFamily());
            statement.setString(3, p.getAddress());
            statement.setString(4, p.getMobile());
            statement.executeUpdate();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            System.out.println("in insert method error....");
            return false;
        } finally {

        }
        return true;
    }

    public boolean updateContact(Phonebook p) {
        Connection c = getconnection();
        try {

            Statement s = c.createStatement();
            String sql = "UPDATE phonebook.phonebooks "
                    + "SET name= ? ,"
                    + "SET family= ? ,"
                    + "SET address= ? ,"
                    + "SET mobile= ?  "
                    + "WHERE id= ? ;";

            PreparedStatement statement = c.prepareCall(sql);
            statement.setString(1, p.getName());
            statement.setString(2, p.getFamily());
            statement.setString(3, p.getAddress());
            statement.setString(4, p.getMobile());
            statement.setInt(5, p.getId());
            statement.executeUpdate();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            System.out.println("in insert method error....");
            return false;
        } finally {

        }
        return true;
    }

    public Connection getconnection() {
        Connection c;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "root", "");

        } catch (Exception e) {

            System.out.println(e.fillInStackTrace());
            System.out.println("Connect to database error.....");
            return null;
        }

        return c;
    }
}
