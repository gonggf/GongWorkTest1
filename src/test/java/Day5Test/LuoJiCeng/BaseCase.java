package Day5Test.LuoJiCeng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

/**
 * Created by Thinkpad on 2017/1/6.
 */
public class BaseCase {
    public static WebDriver driver;
    public  static  String url = "http://mail.163.com/";

    @BeforeMethod
    //打开浏览器并进入网址
    public   void Open() {
        System.setProperty("webdriver.chrome.driver","E:\\项目信息\\GgfDay1\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);
    }
    //定义触发键盘
    public static void PressAction()  throws AWTException{
        Robot robot=new Robot (  );
        robot.keyPress(KeyEvent.VK_SPACE);
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        driver.quit();
    }
}
