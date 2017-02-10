package Day5Test.PoCeng;

import org.openqa.selenium.By;

/**
 * Created by Thinkpad on 2017/1/17.
 */
public class Elements {
    //控制权转移窗口-登录页面
      public static By LoginFrame=By.id("x-URS-iframe");
      public static  By WriteFrame=By.className("APP-editor-iframe");
    //登录页面
        //登录账号
       public static By LoginName=By.name("email");
       //登录密码
       public static By LoginPassWord=By.name("password");
       //登录按钮
       public static By LoginButton=By.id("dologin");
       //注册按钮
       public static By LoginPageRegisterButton=By.id("changepage");
       //登录账号提示语
       public static By LoginNameAssertInfo=By.xpath(".//*[@id='nerror']/div[2]");
    //注册页面
      //邮箱注册Tab
      public static By EmailRegisterTab=By.xpath(".//*[@id='tabsUl']/li[1]/a");
      //邮箱地址
      public static By RegisterEmail=By.id("nameIpt");
      //邮箱校验提示语
     public static By RmailAssertInfo=By.xpath(".//*[@id='m_name']/span");
     //邮箱提示语
     public static  By RmailInfo=By.xpath(".//*[@id='conflictTitle']");
     //密码
      public static By RegisterMainPwd=By.id("mainPwdIpt");
     //确认密码
      public static By RegisterMainCfmPwd=By.id("mainCfmPwdIpt");
     //手机号码
      public static By RegisterMainMobile=By.id("mainMobileIpt");
      //手机号码校验提示语
      public static By RegisterMainMobileAsssertInfo=By.xpath(".//*[@id='m_mainMobile']/span");
      //二次密码处校验提示语
      public static By RmCfmPwdAssertInfo=By.xpath(".//*[@id='m_mainCfmPwd']/span");
      //一次密码处校验提示语
      public static By RmPwdAssertInfo=By.xpath(".//*[@id='m_mainPwd']/span");
     //验证码
      public  static By RegisterVcode=By.id("vcodeIpt");
     //短信验证码
      public  static By RegisterMessageVcode=By.id("mainAcodeIpt");
     //注册按钮
      public  static By RegisterButton=By.id("mainRegA");
      //登录后的页面
    //写信按钮
     public static  By write=By.xpath(".//*[@id='dvNavContainer']/nav/div/ul/li[2]/span[2]");
    //写信页面
    //收件人
    public static By emailContainer=By.xpath(".//*[@class='bz0']/div[2]/div/input");
    //主题
    public static By emailHide=By.xpath(".//*[@class='tH0']/header/div[2]/div/div/div/input");
    //添加附件
    public static By upload=By.xpath(".//*[@class='ia0']/div[1]/div[2]/input");
    //邮件内容
    public static By contain=By.xpath("html/body");
    //发送按钮
    public static By fBtn=By.xpath(".//*[@class='nui-toolbar-item']/div/span[2]");
    //发送成功页面
    public static By sendSuccessful=By.xpath(".//*[text()='发送成功']");
   // public  static  By se=By.id ("moreSelect");
}
