package com.xzit.service;

/**
 * Created by huang on 2018/4/12.
 */
public interface SendMailService {
    /**
     *
     * @param subject 邮件主题
     * @param content 内容
     * @param toMail 收件人
     */
    public void sendSimpleMail(String subject,String content,String toMail);
}
