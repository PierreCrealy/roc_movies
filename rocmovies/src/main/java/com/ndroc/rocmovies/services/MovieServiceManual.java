package com.ndroc.rocmovies.services;

import org.springframework.beans.factory.annotation.Value;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieServiceManual {

    private final String url  = "jdbc:mysql://pierre-dev-app.fr:3306/bibe4387_rocmovies";
    private final String user = "bibe4387_spring";
    private final String pass = "Nh)}D(OV33R,";

    private Connection conn;

    public MovieServiceManual() {
        this.connectionToBDD();
    }

    private void connectionToBDD()
    {
        try{
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("Connection established");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<String> getAllMovies(){

        List<String> moviesTitle = new ArrayList<>();

        try{
            String sql = "SELECT * FROM movies";
            Statement statement;

            statement = this.conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next())
            {
                moviesTitle.add(rs.getString("title"));
                System.out.println(rs.getString("title"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return moviesTitle;
    }
}
