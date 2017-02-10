package demo.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by thinkpad on 2016/12/30.
 */
public class BrowserOpenClose {
    WebDriver Driver;
    WebDriver DriverChrome;
    @BeforeTest
    public void openFireFox(){
        //指定Firefox安装路径
        System.setProperty("webdriver.firefox.bin","D:\\ruanjian\\firefox\\firefox.exe");    //setProperty相当于设置为静态变量，存在于内存里面
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        //启动Firefox浏览器
        Driver = new FirefoxDriver();
        System.out.println("打开firefox浏览器成功");
//        DriverChrome = new ChromeDriver();
//        DriverChrome.manage().window().maximize();
//        全屏有问题
//        DriverChrome.manage().window().fullscreen();
        System.out.println("打开Chrome浏览器成功");

    }


    @AfterTest
    public void  close() throws InterruptedException {
        Thread.sleep(4000);
        Driver.quit();
        System.out.println("关闭firefox浏览器成功");
//        DriverChrome.quit();
//        System.out.println("关闭Chrome浏览器成功");
    }

}
