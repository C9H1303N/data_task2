package com.example.datatask2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.datatask2.entity.Offense;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface OffenseInfoMapper extends BaseMapper<Offense> {
    ArrayList<Offense> findOffenseInfoByPlateNo(@Param("no") String plateNo);

    void addOffense(@Param("no") String no, @Param("time") String time, @Param("location") String location, @Param("is_claimed") int isClaimed);

    void addMakeOffense(@Param("plate_no") String plateNo,@Param("offense_no") String offenseNo);
}
