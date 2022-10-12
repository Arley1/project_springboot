package dev.com.mapper;

import dev.com.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from `user` where id =#{id}")
    User getUser(@Param("id") String id);


}
