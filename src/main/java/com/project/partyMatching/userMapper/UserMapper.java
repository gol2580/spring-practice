package com.project.partyMatching.userMapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//DAO
@Mapper
@Repository
public interface UserMapper {

    void testInsert();
}
