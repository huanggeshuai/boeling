package com.xzit.service.Impl;

import com.xzit.service.SendMailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by huang on 2018/4/12.
 */
@Service
public class SendMailServiceImpl implements SendMailService {
    @Resource
    JavaMailSender mailSender;
    @Resource
    SimpleMailMessage simpleMailMessage;
    public void sendSimpleMail(String subject, String content, String toMail) {
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        simpleMailMessage.setTo(toMail);
        mailSender.send(simpleMailMessage);
    }
}
