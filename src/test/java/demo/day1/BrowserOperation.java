package demo.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

/**
 * Created by thinkpad on 2016/12/22.
 */
public class BrowserOperation {
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
    public  void openPage() throws InterruptedException {
        Driver.get("https://www.baidu.com");
        //Driver.navigate().to("http://www.baidu.com");
        System.out.println("打开百度页面成功");

        //Driver.navigate().to("http://172.16.1.172:8082/general/login/index.php");
//        Driver.get("http://172.16.1.172:8082/general/login/index.php");
//        System.out.println("打开OA页面成功");
//        Driver.navigate().back();
//        System.out.println("后退成功");
//        Thread.sleep(5000);
//        Driver.navigate().forward();
//        System.out.println("前进成功");
//        Thread.sleep(5000);
        Driver.navigate().refresh();
        System.out.println("刷新成功");

       //设置浏览器大小
        Dimension abc = new Dimension(1024,768);
        Driver.manage().window().setSize(abc);
        System.out.println("设置窗口大小成功");
        Thread.sleep(5000);

//      窗口最大化
        Driver.manage().window().maximize();
        System.out.println("窗口最大化成功");
        Thread.sleep(5000);
        String CuUrl = Driver.getCurrentUrl();
        System.out.println(CuUrl);
        Assert.assertEquals(CuUrl,"https://www.baidu.com/");
    }

    @Test
    public void getTitle(){
        Driver.get("https://www.baidu.com");
        String Cutitle = Driver.getTitle();
        System.out.println("网页标题是："+ Cutitle);
        Assert.assertEquals(Cutitle,"百度一下，你就知道");

    }


    @AfterTest
    public void  close() throws InterruptedException {
        Thread.sleep(4000);
        Driver.quit();
        System.out.println("关闭浏览器成功");
    }
}
