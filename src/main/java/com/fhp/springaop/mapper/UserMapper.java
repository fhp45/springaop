package com.fhp.springaop.mapper;

import com.fhp.springaop.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface  UserMapper {

    User findById(int id);

    void insert(User user);

}
