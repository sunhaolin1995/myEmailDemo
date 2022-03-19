package com.example.myemaildemo.Service;

import com.example.myemaildemo.POJO.MailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 孙浩林
 * @date 2022/3/19 17:04 04
 */

public interface MailService {


    /**
     * 发送邮件
     * @param mailDTO
     */
    void sendMail(MailDTO mailDTO);


}
