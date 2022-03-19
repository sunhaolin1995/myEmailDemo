package com.example.myemaildemo.Controller;

import com.example.myemaildemo.POJO.MailDTO;
import com.example.myemaildemo.Seniverse.Per;
import com.example.myemaildemo.Service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author 孙浩林
 * @date 2022/3/19 17:51 51
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value="/api/mail")
public class MailController {
    private final MailService mailService;

    @Scheduled(cron = "0 03 03 ? * *")
    public void  sendMail() throws IOException {
        String[] str ={"2575453225@qq.com","1315687551@qq.com"};
        MailDTO mailDTO =new MailDTO();
        mailDTO.setMail(str);
        mailDTO.setTitle("早上好，今天你也要开心");

        mailDTO.setContent(Per.getWe());
        mailService.sendMail(mailDTO);
    }


}
