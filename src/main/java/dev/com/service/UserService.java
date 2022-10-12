package dev.com.service;

import dev.com.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    private final JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Map<String, Object>>  getUsers(){
        logger.debug("test--1");
        logger.info("---getUsers--");
        String sql ="SELECT * from `user`";
        List<User> users = jdbcTemplate.query(sql, new User());
        System.out.println(users);
        List<Map<String, Object>> maps = this.jdbcTemplate.queryForList(sql);
        return  maps;
    }
    public void addUser(User user){
        String sql ="insert into `user` (`birthday`,`username`,`password`) values (?,?,?)";
        int update = jdbcTemplate.update(sql, user.getBirthday(), user.getUsername(), user.getPassword());
        System.out.println(update);

    }
}
