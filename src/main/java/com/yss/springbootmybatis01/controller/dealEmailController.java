//package com.yss.springbootmybatis01.controller;
//
//import com.yss.springbootmybatis01.pojo.Email;
//import com.yss.springbootmybatis01.service.EmailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.List;
//import java.util.Date;
//import java.util.Properties;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMessage.RecipientType;
//import javax.validation.Valid;
//
///**
// *  简单实现邮件发动功能
// *  涉及知识点：
// *      1、页面跳转，包含请求转发和重定向（forward、redirect）
// *      2、服务端校验数据
// *
// */
//@Controller
//public class dealEmailController {
//
//    @Autowired
//    private EmailService emailService;
//
//    private static final String SMTPSERVER = "smtp.163.com";
//    private static final String SMTPPORT = "465";				//邮箱端口
//    //private static final String ACCOUT = "18346147958@163.com";	//发件人邮箱账号
//    //private static final String PWD = "18346147958z";			//发件人邮箱密码
//
//    /**
//     * 方法名: toIndex
//     * 参数名：@param model  模型
//     * 描述语: 实现页面跳转，跳转位置templates（该文件夹下的数据是安全的，不能被外界直接访问的）
//     */
//    @RequestMapping("/index")
//    public String toIndex(Model model){
//        model.addAttribute("msg","拿下首胜");
//        return "index";
//    }
//    /**
//     * 方法名: toSendEmail
//     * 参数名：@param model  模型
//     * 描述语: 跳转到邮件发送页面
//     * 测试服务端校验时出现异常的解决办法：可以在跳转页面中注入一个users对象，注意由于springmvc会将对象放入到Model中传递，key的名称会使用该对象的驼峰命名规则开作为key
//     * 参数的变量名需要与对象名称相同。讲首字母小写。
//     *
//     * 如果想为传递的对象，更改名称可以使用@ModelAttribute("testEmail")这表示当前传递的对象的key为testEmail，
//     * 那么我们在页面获取的对象key也需要修改为testEmail
//     */
//    @RequestMapping("/toSendEmail")
//    public String toSendEmail(@ModelAttribute("testEmail") Email email){
//        return "sendEmail";
//    }
//    /**
//     * 方法名: toEmailList
//     * 参数名：@param model  模型
//     * 描述语: 跳转到邮件列表页面
//     */
//    @RequestMapping("/toEmailList")
//    public String toEmailList(Model model){
//        List<Email> emailList =  emailService.selectEmailsAll();
//        model.addAttribute("emailList",emailList);
//        return "EmailList";
//    }
//    /**
//     * 方法名: saveAndSendEmail
//     * 参数名：@param email  emailpojo
//     *       @param "BindingResult" ：封装了校验结果,创建一个跟你pojo相同的名称（驼峰命名格式）将错误信息放在里面，对应前面th:errors="${email.sUser}"
//     * 描述语: 保存并发送email
//     */
//    @RequestMapping("/saveAndSendEmail")
//    public String saveAndSendEmail(@ModelAttribute("testEmail") @Valid Email email, BindingResult result){
//        //result.hasErrors() 返回为true时校验不成功，出现不合法数据
//        if(result.hasErrors()){
//            return "sendEmail";
//        }
//        try{
//            sendEmail(email);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//        email.setfTime(sdf.format(new Date()));
//        System.out.println(email.toString());
//        emailService.insertEmail(email);
//        return "redirect:toEmailList";
//    }
//    /**
//     * 方法名: deleteEmailById
//     * 参数名：@param id  email Id
//     * 描述语:根据Id删除email
//     */
//    @RequestMapping("/deleteEmailById")
//    public String deleteEmailById(Integer id,Model model){
//        emailService.deleteEmailById(id);
//        List<Email> emailList =  emailService.selectEmailsAll();
//        model.addAttribute("emailList",emailList);
//        return "EmailList";
//    }
//    /**
//     * 方法名: sendEmail
//     * 参数名：@param email  emailpojo
//     * 描述语: 发送email
//     */
//    public void sendEmail(Email email) throws Exception{
//        // 创建邮件配置
//        Properties props = new Properties();
//        props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
//        props.setProperty("mail.smtp.host", SMTPSERVER); // 发件人的邮箱的 SMTP 服务器地址
//        props.setProperty("mail.smtp.port", SMTPPORT);
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.setProperty("mail.smtp.auth", "true"); // 需要请求认证
//        props.setProperty("mail.smtp.ssl.enable", "true");// 开启ssl
//        // 根据邮件配置创建会话，注意session别导错包
//        Session session = Session.getDefaultInstance(props);
//        // 开启debug模式，可以看到更多详细的输入日志
//        session.setDebug(true);
//        //创建邮件
//        MimeMessage message = createEmail(session,email);
//        //获取传输通道
//        Transport transport = session.getTransport();
//        transport.connect(SMTPSERVER,email.getfUser(), email.getfPwd());
//        //连接，并发送邮件
//        transport.sendMessage(message, message.getAllRecipients());
//        transport.close();
//    }
//    /**
//     * 方法名: createEmail
//     * 参数名：@param session
//     * 描述语: 创建邮件
//     */
//    public MimeMessage createEmail(Session session,Email email) throws Exception {
//        // 根据会话创建邮件
//        MimeMessage msg = new MimeMessage(session);
//        // address邮件地址, personal邮件昵称, charset编码方式
//        InternetAddress fromAddress = new InternetAddress(email.getfUser(), "kimi", "utf-8");
//        // 设置发送邮件方
//        msg.setFrom(fromAddress);
//        InternetAddress receiveAddress = new InternetAddress(email.getsUser(), "test", "utf-8");
//        // 设置邮件接收方
//        msg.setRecipient(RecipientType.TO, receiveAddress);
//        // 设置邮件标题
//        msg.setSubject(email.getEmailTitle(), "utf-8");
//        msg.setText(email.getEmailContent());
//        // 设置显示的发件时间
//        msg.setSentDate(new Date());
//        // 保存设置
//        msg.saveChanges();
//        return msg;
//    }
//
//
//}
