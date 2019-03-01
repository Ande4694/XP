package com.example.xp.Login;

import com.example.xp.Model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class AppUserDAO  {

    @Autowired
    JdbcTemplate template;

    public AppUser findUserAccount(String userName) {
        // Select .. from App_User u Where u.User_Name = ?
        String sql = AppUserMapper.BASE_SQL + " where u.User_Name = ? ";

        Object[] params = new Object[] { userName };
        AppUserMapper mapper = new AppUserMapper();
        try {
            AppUser userInfo = this.template.queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
