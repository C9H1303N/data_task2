package com.example.datatask2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.datatask2.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

@Repository
@Mapper
public interface PersonInfoMapper extends BaseMapper<Person> {
    Person findPersonInfoById(@Param("id") String id);

    void updatePersonInfo(@Param("person") Person person);

    void transaction(@Param("trading_no") String no, @Param("seller_id") String id1, @Param("buyer_id") String id2, @Param("plate_no") String plateNo);
}
