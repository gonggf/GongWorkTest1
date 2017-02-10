package demo.day2;

import com.google.common.base.Verify;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by thinkpad on 2016/12/28.
 */
public class AlertOption {

    WebDriver Driver;
    @BeforeTest
    public void openFireFox(){
        //指定Firefox安装路径
        System.setProperty("webdriver.firefox.bin","D:\\Software\\FireFox\\firefox.exe");    //setProperty相当于设置为静态变量，存在于内存里面
        //启动Firefox浏览器
        Driver = new FirefoxDriver();
        System.out.println("打开浏览器成功");
        Driver.get("file:///E:/selenium_test/selenium_html/index.html");

    }

    @Test
    public void alertOption() throws InterruptedException {
        WebElement alertElement = Driver.findElement(By.xpath(".//*[@id='alert']/input"));
        alertElement.click();
//      移交Driver控制权给alert弹窗
        Alert alert1 = Driver.switchTo().alert();
//        点击“确定”
        alert1.accept();
    }




//    页面提交，确认与取消
//  常见于“删除”操作产生的弹框
//对弹框进行处理
    @Test
    public void comfirmOption() throws InterruptedException {
        WebElement comfirmElement = Driver.findElement(By.xpath(".//*[@id='confirm']/input"));
        comfirmElement.click();
        Thread.sleep(1000);
        Alert comfirm1 = Driver.switchTo().alert();
//        点击“取消”
        comfirm1.dismiss();
        Thread.sleep(1000);
//        再点击确定
        comfirm1.accept();
    }


    //    页面提交，确认与取消
//  常见于“删除”操作产生的弹框
//对弹框进行处理
    @Test
    public void pormptOption() throws InterruptedException {
        WebElement portptElement = Driver.findElement(By.xpath(".//*[@id='prompt']/input"));
        portptElement.click();
        Thread.sleep(1000);
        Alert prompt1 = Driver.switchTo().alert();
        String textMsg = prompt1.getText();
        Assert.assertEquals(textMsg,"我是提示信息");
// alert输入一段文本
        prompt1.sendKeys("大傻叉");

//        再点击确定
        prompt1.accept();
        Thread.sleep(1000);
        prompt1.accept();


    }




    @AfterTest
    public void  close() throws InterruptedException {
        Thread.sleep(4000);
        Driver.quit();
        System.out.println("关闭浏览器成功");
    }

}
