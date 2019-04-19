package cn.et;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class sendMailTest {
    //自动装配发送邮件的类
    @Autowired
    private JavaMailSender jms;

    @PostMapping("test1")
    public String test1(@RequestBody Map map){
		SimpleMailMessage mailMessage =new SimpleMailMessage();
		//发送方的邮箱名
		mailMessage.setFrom("YHL2574405253@163.com");
		//接收方的邮箱名
		mailMessage.setTo(map.get("receiveName").toString());
		//邮箱标题
		mailMessage.setSubject(map.get("title").toString());
		//邮箱内容
		mailMessage.setText(map.get("content").toString());
		jms.send(mailMessage);
        return "SUCCESS 8091";
    }

    @GetMapping("test2/{name}")
    public String test2(@PathVariable("name") String name){
        return name;
    }

    @RequestMapping("test3")
    public String test3(@RequestBody String name){
        return name;
    }


//    @RequestMapping("send")
//    public String send(){
//        SimpleMailMessage mailMessage =new SimpleMailMessage();
//        //发送方的邮箱名
//        mailMessage.setFrom("YHL2574405253@163.com");
//        //接收方的邮箱名
//        mailMessage.setTo("2574405253@qq.com");
//        //邮箱标题
//        mailMessage.setSubject("发送邮件");
//        //邮箱内容
//        mailMessage.setText("测试发送邮件");
//        jms.send(mailMessage);
//        return "SUCCESS 8091";
//    }
}
