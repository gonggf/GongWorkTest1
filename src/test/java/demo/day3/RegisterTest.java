package demo.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Created by thinkpad on 2017/1/9.
 */
public class RegisterTest extends BrowserOpenClose {
    public void testPageInfoOption(){
//        元素定位及入库
        WebElement phoneNo = Driver.findElement(By.xpath(".//*[@id='mobileIpt']"));
        WebElement checkNo = Driver.findElement(By.xpath(".//*[@id='mVcodeIpt']"));
        WebElement smsCheckNo = Driver.findElement(By.xpath(".//*[@id='acodeIpt']"));
        WebElement userPassword = Driver.findElement(By.xpath(".//*[@id='mobilePwdIpt']"));
        WebElement userCheckPassword = Driver.findElement(By.xpath(".//*[@id='mobileCfmPwdIpt']"));
        WebElement submitButton = Driver.findElement(By.xpath(".//*[@id='mobileRegA']"));



//        元素操作
        phoneNo.sendKeys("18259497096");
        checkNo.sendKeys("1e23");
        smsCheckNo.sendKeys("132112");
        userPassword.sendKeys("123qwe");
        userCheckPassword.sendKeys("123qwe");
        submitButton.click();


    }

    public void checkProint(){
//        元素对象库
        WebElement smsCheckError = Driver.findElement(By.xpath(".//*[@id='m_acode']/span"));

//        对象操作
        String smsInfo = smsCheckError.getText();
        System.out.println(smsInfo);

    }




    @Test
    public  void mailRegister() throws InterruptedException {
        Driver.get("http://mail.163.com/");
        String loginHandle = Driver.getWindowHandle();
        WebElement iframeMailLogin = Driver.findElement(By.id("x-URS-iframe"));
        Driver.switchTo().frame(iframeMailLogin);
        WebElement registerButton = Driver.findElement(By.id("changepage"));
        registerButton.click();
        Thread.sleep(2000);
//        Driver.switchTo().defaultContent();    //主动权归还给原来的页面

//窗口切换，跳转到新打开的窗口
        for (String handles :  Driver.getWindowHandles()) {
            if (handles.equals(loginHandle)){
               continue;
            }
            else {
                Driver.switchTo().window(handles);
            }
        }
//        WebElement elementPhoneNo = Driver.findElement(By.xpath(".//*[@id='mobileIpt']"));
//        elementPhoneNo.sendKeys("18259497096");
        testPageInfoOption();
        Thread.sleep(2000);     //等待错误信息出现
        checkProint();
        Thread.sleep(5000);
//        跳转回原来的窗口
        Driver.switchTo().window(loginHandle);

    }

}
