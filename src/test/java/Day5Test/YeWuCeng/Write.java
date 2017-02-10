package Day5Test.YeWuCeng;
import Day5Test.LuoJiCeng.BaseCase;
import Day5Test.LuoJiCeng.PeiZhiTest;
import Day5Test.PoCeng.Elements;
import Day5Test.YeWuCeng.LoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Thinkpad on 2017/1/12.
 */
public class Write extends BaseCase {
    LoginTest loginTest=new LoginTest();
    @Test
    public void WriteTest() {
        //发送邮件
      // write();
       write("842012173@qq.com","自动化测试163邮件发送","C:\\Users\\thinkpad\\Pictures\\5.jpg","自动化测试163邮件添加附件发送");
    }
    //正常流程发送邮件
    public  void write()  {
        //登录
        loginTest.loginTest();
        driver.findElement(Elements.write).click();
        //转移新窗口
        PeiZhiTest.moreFrame();
        //填写收件人、主题、上传附件、发送
        driver.findElement(Elements.emailContainer).sendKeys("842012173@qq.com");
        driver.findElement(Elements.emailHide).sendKeys("自动化测试");
        driver.findElement(Elements.upload).sendKeys("C:\\Users\\thinkpad\\Pictures\\5.jpg");
        PeiZhiTest.frame(Elements.WriteFrame);
        driver.findElement(Elements.contain).sendKeys("webdriver基础教程");
        driver.switchTo().defaultContent();
        driver.findElement(Elements.fBtn).click();
        PeiZhiTest.moreFrame();
        String sendSuccessfulInfo=driver.findElement(Elements.sendSuccessful).getText().trim();
        Assert.assertEquals(sendSuccessfulInfo,"发送成功可用手机接收回复");
    }
    public  void write(String emailContainerManage,String emailTopic,String uploadmanage,String containManage)  {
        //登录
        loginTest.loginTest();
        driver.findElement(Elements.write).click();
        //转移新窗口
        PeiZhiTest.moreFrame();
        //填写收件人、主题、上传附件、发送
        driver.findElement(Elements.emailContainer).sendKeys(emailContainerManage);
        driver.findElement(Elements.emailHide).sendKeys(emailTopic);
        driver.findElement(Elements.upload).sendKeys(uploadmanage);
        PeiZhiTest.frame(Elements.WriteFrame);
        driver.findElement(Elements.contain).sendKeys(containManage);
        driver.switchTo().defaultContent();
        driver.findElement(Elements.fBtn).click();
        PeiZhiTest.moreFrame();
        String sendSuccessfulInfo=driver.findElement(Elements.sendSuccessful).getText().trim();
        Assert.assertEquals(sendSuccessfulInfo,"发送成功可用手机接收回复免费短信通知");
    }
}
