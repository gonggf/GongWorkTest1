package demo.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by thinkpad on 2016/12/21.
 */
public class OpenBrowser {
    WebDriver Driver;
    @Test
    public void openFireFox(){
        //指定Firefox安装路径
        System.setProperty("webdriver.firefox.bin","D:\\Software\\FireFox\\firefox.exe");    //setProperty相当于设置为静态变量，存在于内存里面
        //启动Firefox浏览器
        Driver = new FirefoxDriver();
        System.out.println("打开浏览器成功");
        System.out.println(System.getProperty("webdriver.firefox.bin"));
    }
    @AfterMethod
    public  void closeBroswer() throws InterruptedException {
        Thread.sleep(3000);
        Driver.close();
        System.out.println("关闭浏览器成功");

    }


}
