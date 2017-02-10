package demo.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thinkpad on 2016/12/27.
 */
public class PhotoScript {
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
    public void photoScript(){
        Driver.get("https://www.baidu.com");
//        Driver.get("http://172.16.1.172:8082/general/login/index.php");
        String pageTitle = Driver.getTitle();
        System.out.println(pageTitle);
        //获取当前时间
        Date dateTime = new Date();
        System.out.println(dateTime);

        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd-HHmmss");  //设置时间格式，MM代表月份，mm代表分钟，HH代表以24小时制的小时，hh代表12小时制的小时
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd-hhmmss");
        String date24Hour = dateFormat1.format(dateTime);
        String date12Hour = dateFormat2.format(dateTime);
        System.out.println(date24Hour);//以设置的时间格式设定日期（24小时制度）
        System.out.println(date12Hour);//以设置的时间格式设定日期（12小时制度）
        File screenWindows = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenWindows,new File(".//logs/screenshots/test"+ date24Hour +".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @AfterTest
    public void  close() throws InterruptedException {
        Thread.sleep(4000);
        Driver.quit();
        System.out.println("关闭浏览器成功");
    }
}
