package com.example.xp.Login;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AppRoleDAO {

    @Autowired
    JdbcTemplate template;

    public List<String> getRoleNames(Long userId) {
        String sql = "Select r.Role_Name " //
                + " from XPgrp5000.USER_ROLE ur, XPgrp5000.APP_ROLE r " //
                + " where ur.Role_Id = r.Role_Id and ur.User_Id = ? ";

        Object[] params = new Object[] { userId };

        List<String> roles = this.template.queryForList(sql, params, String.class);

        return roles;
    }

}
