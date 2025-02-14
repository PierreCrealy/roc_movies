package com.ndroc.rocmovies.services;

import org.springframework.beans.factory.annotation.Value;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieServiceManual {


    public List<String> getAllMovies(){

        List<String> moviesTitle = new ArrayList<>();

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://pierre-dev-app.fr:3306/bibe4387_rocmovies",
                    "bibe4387_spring",
                    "Lekiki951309."
            );
            System.out.println("Connection established");

            String sql = "SELECT * FROM movies";
            Statement statement;

            statement = connection.createStatement();
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
