package com.example.datatask2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.datatask2.entity.OffenseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
@Mapper
public interface DriverOffenseInfoMapper extends BaseMapper<OffenseInfo> {
    ArrayList<OffenseInfo> findDriverOffenseById(@Param("id") String id);

    void addTicket(@Param("ticket_no") String no, @Param("time") String time, @Param("id") String id, @Param("offense_no") String offenseNo);

    void claimOffense(@Param("no") String no);

    void addTicketDetail(@Param("detail_no") String detailNo, @Param("point") int point, @Param("fine") int fine, @Param("detention") int detention, @Param("ticket_no") String ticketNo);
}
