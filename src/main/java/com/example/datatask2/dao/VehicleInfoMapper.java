package com.example.datatask2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.datatask2.entity.Vehicle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface VehicleInfoMapper extends BaseMapper<Vehicle> {
    Vehicle findVehicleInfoByPlateNo(@Param("no") String plateNo);

    ArrayList<Vehicle> findVehicleById(@Param("id") String id);

    void addVehicle(@Param("plate_no") String plateNo, @Param("owner_id") String id, @Param("color") int color);

    void deleteVehicle(@Param("plate_no") String plateNo);
}
