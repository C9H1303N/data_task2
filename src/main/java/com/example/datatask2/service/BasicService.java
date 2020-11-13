package com.example.datatask2.service;

import com.example.datatask2.dao.DriverOffenseInfoMapper;
import com.example.datatask2.dao.OffenseInfoMapper;
import com.example.datatask2.dao.PersonInfoMapper;
import com.example.datatask2.dao.VehicleInfoMapper;
import com.example.datatask2.entity.Offense;
import com.example.datatask2.entity.OffenseInfo;
import com.example.datatask2.entity.Person;
import com.example.datatask2.entity.Vehicle;
import com.example.datatask2.item.RandomString;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class BasicService {
    @Autowired
    DriverOffenseInfoMapper driverOffenseInfoMapper;
    @Autowired
    OffenseInfoMapper offenseInfoMapper;
    @Autowired
    PersonInfoMapper personInfoMapper;
    @Autowired
    VehicleInfoMapper vehicleInfoMapper;

    @PostMapping("/service/dealing")
    boolean dealingOffense(@Param("offenseNo") String offenseNo, @Param("driverId") String driverId) {
        Person person = personInfoMapper.findPersonInfoById(driverId);
        if (person.getStatus() != 1) {
            return false;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        String no = RandomString.getRandomString(8);
        driverOffenseInfoMapper.addTicket(no,date,driverId,offenseNo);
        driverOffenseInfoMapper.claimOffense(offenseNo);
        return true;
    }

    @PostMapping("/service/detail")
    boolean addTicketDetail(@Param("driverId") String driverId, @Param("fine") int fine, @Param("point") int point, @Param("detention") int detention, @Param("ticket_no") String ticketNo) {
        String no = RandomString.getRandomString(8);
        driverOffenseInfoMapper.addTicketDetail(no,point,fine,detention,ticketNo);
        Person person = personInfoMapper.findPersonInfoById(driverId);
        if (person.getStatus() != 1) {
            return false;
        }
        int newPoint = person.getPoint() - point;
        if (newPoint < 0) {
            person.setPoint(0);
            person.setStatus(0);
        }
        else {
            person.setPoint(newPoint);
        }
        personInfoMapper.updatePersonInfo(person);
        return true;
    }

    @PostMapping("/service/addOffense")
    boolean addOffense(@Param("time") String time, @Param("location") String location, @Param("plate_no") String plateNo) {
        Vehicle vehicle = vehicleInfoMapper.findVehicleInfoByPlateNo(plateNo);
        if (vehicle == null) {
            return false;
        }
        String no = RandomString.getRandomString(8);
        offenseInfoMapper.addOffense(no,time,location,0);
        return true;
    }

    @PostMapping("/service/findVehicleInfo")
    Vehicle findVehicleInfo(@Param("plate_no") String plateNo) {
        return vehicleInfoMapper.findVehicleInfoByPlateNo(plateNo);
    }

    @PostMapping("/service/findOffenseInfo")
    ArrayList<Offense> findOffenseInfo(@Param("plate_no") String plateNo) {
        return offenseInfoMapper.findOffenseInfoByPlateNo(plateNo);
    }

    @PostMapping("/service/findPersonById")
    Person findPersonById(@Param("id") String id) {
        return personInfoMapper.findPersonInfoById(id);
    }

    @PostMapping("/service/findOffense")
    ArrayList<OffenseInfo> findOffenseInfoById(@Param("id") String id) {
        return driverOffenseInfoMapper.findDriverOffenseById(id);
    }

    @PostMapping("/service/findVehicle")
    ArrayList<Vehicle> findVehicleById(@Param("id") String id) {
        return vehicleInfoMapper.findVehicleById(id);
    }

    @PostMapping("/service/transaction")
    boolean transaction(@Param("model") int model, @Param("plate_no") String plateNo, @Param("id1") String id1, @Param("id2") String id2) {
        if (model == 1) { // buy new car
            String no = RandomString.getRandomString(8);
            String plate = RandomString.getRandomString(7);
            personInfoMapper.transaction(no,"1",id2,plate);
            vehicleInfoMapper.addVehicle(plate,id2,3);
        }
        else if (model == 2) {
            Vehicle vehicle = vehicleInfoMapper.findVehicleInfoByPlateNo(plateNo);
            if (vehicle == null) {
                return false;
            }
            String no = RandomString.getRandomString(8);
            personInfoMapper.transaction(no,id1,"2",plateNo);
            vehicleInfoMapper.deleteVehicle(plateNo);
        }
        else {
            Vehicle vehicle = vehicleInfoMapper.findVehicleInfoByPlateNo(plateNo);
            if (vehicle == null) {
                return false;
            }
            String no = RandomString.getRandomString(8);
            personInfoMapper.transaction(no,id1,id2,plateNo);
        }
        return true;
    }
}
