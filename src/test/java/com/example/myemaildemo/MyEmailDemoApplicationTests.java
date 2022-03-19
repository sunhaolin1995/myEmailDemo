package com.example.myemaildemo;

import com.example.myemaildemo.Controller.MailController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class MyEmailDemoApplicationTests {
    @Autowired
    private MailController mailController;

    @Test
    void contextLoads() throws IOException {
       mailController.sendMail();
    }

}
