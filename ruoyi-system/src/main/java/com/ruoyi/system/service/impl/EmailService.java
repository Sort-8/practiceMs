package com.ruoyi.system.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
public class EmailService {
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Value("${spring.mail.username}")
//    private String sender;
//
//    /**
//     * 发送简单邮件
//     * */
//    public void sendSimpleMail(String recevier,String subject,String context){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(sender);
//        message.setTo(recevier);
//        message.setText(context);
//        message.setSubject(subject);
//        try {
//            mailSender.send(message);
//            logger.info("简单邮件已经发送");
//        }catch (Exception e)
//        {
//            logger.error("发送简单邮件出错"+e);
//        }
//    }
}
