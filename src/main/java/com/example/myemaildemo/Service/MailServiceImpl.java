package com.example.myemaildemo.Service;

import com.example.myemaildemo.POJO.MailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author 孙浩林
 * @date 2022/3/19 17:20 20
 */
@Service
@RequiredArgsConstructor
@Component
public class MailServiceImpl implements MailService{

    private final MailSender mailSender;

    @Override
    public void sendMail(MailDTO mailDTO) {
    //new 一个简单的邮件消息对象
        SimpleMailMessage message =new SimpleMailMessage();
        //和配置文件中的username相同，相当于发送方
        message.setFrom("hlsunneu@qq.com");
       //收件人邮箱
        message.setBcc(mailDTO.getMail());
        //抄送人
        message.setCc("hlsunneu@qq.com");
        message.setSubject(mailDTO.getTitle());
        //正文
        message.setText(mailDTO.getContent());
        //发送
        mailSender.send(message);
    }
}
