package com.example.xp.Login;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.example.xp.Model.AppUser;
import org.springframework.jdbc.core.RowMapper;



public class AppUserMapper implements RowMapper<AppUser>{

    public static final String BASE_SQL //
            = "Select u.User_Id, u.User_Name, u.Encryted_Password From XPgrp5000.APP_USER u ";

    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long userId = rs.getLong("User_Id");
        String userName = rs.getString("User_Name");
        String encrytedPassword = rs.getString("Encryted_Password");


        return new AppUser(userId, userName, encrytedPassword);
    }

}
