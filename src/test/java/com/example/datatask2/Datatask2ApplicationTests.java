package com.example.datatask2;

import com.example.datatask2.dao.DriverOffenseInfoMapper;
import com.example.datatask2.dao.OffenseInfoMapper;
import com.example.datatask2.dao.PersonInfoMapper;
import com.example.datatask2.dao.VehicleInfoMapper;
import com.example.datatask2.entity.Offense;
import com.example.datatask2.entity.OffenseInfo;
import com.example.datatask2.entity.Person;
import com.example.datatask2.entity.Vehicle;
import com.example.datatask2.item.RandomString;
import com.example.datatask2.service.BasicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
class Datatask2ApplicationTests {

    @Autowired
    private VehicleInfoMapper vehicleInfoMapper;
    @Autowired
    private OffenseInfoMapper offenseInfoMapper;
    @Autowired
    private PersonInfoMapper personInfoMapper;
    @Autowired
    private DriverOffenseInfoMapper driverOffenseInfoMapper;


    @Test
    void contextLoads() {
    }

    @Test
    void testve() {
        Vehicle vehicle;
        vehicle = vehicleInfoMapper.findVehicleInfoByPlateNo("qwe");
        System.out.println(vehicle.getOwnerId());
    }

    @Test
    void testof() {
        ArrayList<Offense> offense;
        offense = offenseInfoMapper.findOffenseInfoByPlateNo("9999");
        System.out.println(offense);
    }

    @Test
    void testper() {
        Person person;
        person = personInfoMapper.findPersonInfoById("sb");
        System.out.println(person.getName());
    }

    @Test
    void testDOI() {
        ArrayList<OffenseInfo> offenseInfo;
        offenseInfo = driverOffenseInfoMapper.findDriverOffenseById("sb");
        System.out.println(offenseInfo);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        driverOffenseInfoMapper.addTicket("1",date,"3","4");
    }

    @Test
    void testadd() {
        Vehicle vehicle = vehicleInfoMapper.findVehicleInfoByPlateNo("222");
        if (vehicle == null) {
            System.out.println("false");
        }
        String no = RandomString.getRandomString(8);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        offenseInfoMapper.addOffense(no,date,"location",0);
        System.out.println("true");
    }
}
