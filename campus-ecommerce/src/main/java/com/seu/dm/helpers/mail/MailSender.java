package com.seu.dm.helpers.mail;

import com.seu.dm.helpers.mail.MailEntity;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Properties;

/**
 * Created by 张老师 on 2017/3/13.
 */
public class MailSender {
//        mail.setMailServerPort("587");
//        mail.setValidate(true);
//        mail.setUserName("964753691@qq.com");
//        mail.setPassword("zuggjuilwtvqbbea");
//        mail.setFromAddress("964753691@qq.com");
//        mail.setToAddress("zhangyin_hfut@126.com");
//        mail.setSubject("dsad");
//        mail.setContent("are you ok?");
    private static final String MAILSERVERHOST="smtp.qq.com";
    private static final String MAILSERVERPORT="587";
    private static final String USERNAME="964753691@qq.com";
    private static final String FROMADDRESS="964753691@qq.com";
    private static final String PASSWORD="saraxxxlokntbaii";
    private static final String SUBJECT="激活邮件";


    public static void send(Integer id,String email){

        String validateCode = MD5Util.encode2hex(id.toString());
        System.out.println(validateCode);
        System.out.println(email);
        ///邮件的内容
        StringBuffer sb=new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！如果无法访问，请手动复制链接到地址栏。</br>");
        sb.append("<a href=\"http://localhost:8080/user/register?action=activate&id=");
        sb.append(id);
        sb.append("&validateCode=");
        sb.append(validateCode);
        sb.append("\">http://localhost:8080/user/register?action=activate&id=");
        sb.append(id);
        sb.append("&validateCode=");
        sb.append(validateCode);
        sb.append("</a>");
        System.out.println(sb.toString());
        //Mail实体
        MailEntity mail = new MailEntity();
        mail.setMailServerHost(MAILSERVERHOST);
        mail.setMailServerPort(MAILSERVERPORT);
        mail.setValidate(true);
        mail.setUserName(USERNAME);
        mail.setPassword(PASSWORD);
        mail.setFromAddress(FROMADDRESS);
        mail.setToAddress(email);
        mail.setSubject(SUBJECT);
        mail.setContent(sb.toString());

        sendHtmlMail(mail);
    }

    public static boolean sendHtmlMail(MailEntity mailInfo){
        // 判断是否需要身份认证
        Authentication authenticator = null;
        Properties pro = mailInfo.getProperties();
        if (mailInfo.isValidate()) {
            authenticator = new Authentication(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro,authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            Address from = new InternetAddress(mailInfo.getFromAddress());
            mailMessage.setFrom(from);
            Address to = new InternetAddress(mailInfo.getToAddress());
            // Message.RecipientType.TO属性表示接收者的类型为TO
            mailMessage.setRecipient(Message.RecipientType.TO,to);
            mailMessage.setSubject(mailInfo.getSubject());
            mailMessage.setSentDate(new Date());
            Multipart mainPart = new MimeMultipart();
            BodyPart html = new MimeBodyPart();
            html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            mailMessage.setContent(mainPart);
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }


}

