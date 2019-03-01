package com.example.xp.Repo;


import com.example.xp.Model.AppUser;
import com.example.xp.utils.EncryptedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImpl implements UserRepo{

    @Autowired
    JdbcTemplate template;

    @Override
    public void addUser(AppUser user) {

        String encPassW = EncryptedPasswordUtils.encryptedPassword(user.getEncrytedPassword());

        String sql = "insert into XPgrp5000.APP_USER values (default, ?, "+ encPassW+", 1)";

        this.template.update(sql, user.getUserName());
    }
}
