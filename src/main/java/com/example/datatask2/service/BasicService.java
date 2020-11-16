package com.example.datatask2.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.datatask2.dao.DriverOffenseInfoMapper;
import com.example.datatask2.dao.OffenseInfoMapper;
import com.example.datatask2.dao.PersonInfoMapper;
import com.example.datatask2.dao.VehicleInfoMapper;
import com.example.datatask2.entity.Offense;
import com.example.datatask2.entity.OffenseInfo;
import com.example.datatask2.entity.Person;
import com.example.datatask2.entity.Vehicle;
import com.example.datatask2.item.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping("/service")
public class BasicService {
    @Autowired
    DriverOffenseInfoMapper driverOffenseInfoMapper;
    @Autowired
    OffenseInfoMapper offenseInfoMapper;
    @Autowired
    PersonInfoMapper personInfoMapper;
    @Autowired
    VehicleInfoMapper vehicleInfoMapper;

    @PostMapping("/dealing")
    public String dealingOffense(@RequestParam("offenseNo") String offenseNo, @RequestParam("driverId") String driverId) {
        Person person = personInfoMapper.findPersonInfoById(driverId);
        if (person == null) {
            return null;
        }
        if (person.getStatus() != 1) {
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        String no = RandomString.getRandomString(8);//ticket_no
        driverOffenseInfoMapper.addTicket(no,date,driverId,offenseNo);
        driverOffenseInfoMapper.claimOffense(offenseNo);
        return no;
    }

    @PostMapping("/detail")
    public boolean addTicketDetail(@RequestParam("driverId") String driverId, @RequestParam("fine") int fine, @RequestParam("point") int point, @RequestParam("detention") int detention, @RequestParam("ticket_no") String ticketNo) {
        String no = RandomString.getRandomString(8);
        driverOffenseInfoMapper.addTicketDetail(no,point,fine,detention,ticketNo);
        Person person = personInfoMapper.findPersonInfoById(driverId);
        if (person == null) {
            return false;
        }
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

    @PostMapping("/addOffense")
    public boolean addOffense(@RequestParam("time") String time, @RequestParam("location") String location, @RequestParam("plate_no") String plateNo) {
        Vehicle vehicle = vehicleInfoMapper.findVehicleInfoByPlateNo(plateNo);
        if (vehicle == null) {
            return false;
        }
        String no = RandomString.getRandomString(8);
        offenseInfoMapper.addOffense(no,time,location,0);
        offenseInfoMapper.addMakeOffense(plateNo,no);
        return true;
    }

    @PostMapping("/findVehicleInfo")
    public Vehicle findVehicleInfo(@RequestParam("plate_no") String plateNo) {
        return vehicleInfoMapper.findVehicleInfoByPlateNo(plateNo);
    }

    @PostMapping("/findOffenseInfo")
    public ArrayList<Offense> findOffenseInfo(@RequestParam("plate_no") String plateNo) {
        return offenseInfoMapper.findOffenseInfoByPlateNo(plateNo);
    }

    @PostMapping("/findPersonById")
    public Person findPersonById(@RequestParam("id") String id) {
        return personInfoMapper.findPersonInfoById(id);
    }

    @PostMapping("/findOffense")
    public ArrayList<OffenseInfo> findOffenseInfoById(@RequestParam("id") String id) {
        return driverOffenseInfoMapper.findDriverOffenseById(id);
    }

    @PostMapping("/findVehicle")
    public ArrayList<Vehicle> findVehicleById(@RequestParam("id") String id) {
        return vehicleInfoMapper.findVehicleById(id);
    }

    @PostMapping("/transaction")
    public boolean transaction(@RequestParam("model") int model, @RequestParam("plate_no") String plateNo, @RequestParam("id1") String id1, @RequestParam("id2") String id2) {
        if (model == 1) { // buy new car
            String no = RandomString.getRandomString(8);
            String plate = RandomString.getRandomString(7);
            personInfoMapper.transaction(no,"1",id2,plate);
            Random df = new Random();
            int num = df.nextInt(6) + 1;
            vehicleInfoMapper.addVehicle(plate,id2,num);
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
            vehicleInfoMapper.deleteVehicle(plateNo);
            vehicleInfoMapper.addVehicle(plateNo,id2,vehicle.getColor().getValue());
            String no = RandomString.getRandomString(8);
            personInfoMapper.transaction(no,id1,id2,plateNo);
        }
        return true;
    }
}
