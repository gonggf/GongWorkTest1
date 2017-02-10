package demo.day2;

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
public class SelectTest {
    WebDriver Driver;

    @BeforeTest
    public void openFireFox(){
        //指定Firefox安装路径
        System.setProperty("webdriver.firefox.bin","D:\\Software\\FireFox\\firefox.exe");    //setProperty相当于设置为静态变量，存在于内存里面
        //启动Firefox浏览器
        Driver = new FirefoxDriver();
        System.out.println("打开浏览器成功");

    }



    @Test
    public void selectOption() throws InterruptedException {
        Driver.get("file:///E:/selenium_test/selenium_html/index.html");
        WebElement selectElement = Driver.findElement(By.xpath(".//*[@id='moreSelect']"));
//        实例化一个select类
        Select select1 = new Select(selectElement);

        for (int i = 0; i <6 ; i++) {
            Thread.sleep(2000);
//        通过索引选取一个下拉框
            select1.selectByIndex(i);
        }
        Thread.sleep(1000);
//        使用属性值选择下拉框
        select1.selectByValue("vivo");
        Thread.sleep(1000);
//        使用标签值选择下拉框
        select1.selectByVisibleText("xiaomi");

    }









    @AfterTest
    public void  close() throws InterruptedException {
        Thread.sleep(4000);
        Driver.quit();
        System.out.println("关闭浏览器成功");
    }



}
