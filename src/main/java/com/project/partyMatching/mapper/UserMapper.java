package com.project.partyMatching.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//DAO
@Mapper
@Repository
public interface UserMapper {

    public void testInsert();
}
