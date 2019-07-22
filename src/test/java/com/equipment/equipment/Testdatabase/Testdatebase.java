package com.equipment.equipment.Testdatabase;

import com.equipment.equipment.dao.ArmorMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Testdatebase {

    @Autowired
    DataSource dataSource;

    @Autowired
    ArmorMapper usersMapper;


    @Test
    public void TestDatabase() throws SQLException {
        System.err.println(dataSource.getConnection());
    }

//    @Test
//    public void TestDataUsers(){
//        List<Users> list = usersMapper.dataUsers();
//        for (Users users : list){
//            System.out.println(users.getUsername()+users.getState()+"---->>");
//        }
//    }

}
