package dev.com.mapper;

import dev.com.pojo.JwtUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface JwtUserMapper {
    @Select("select * from `user` where name =#{name}")
    JwtUser selectByUserName(@Param("name") String name);
}
