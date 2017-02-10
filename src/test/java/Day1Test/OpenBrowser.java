package Day1Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by GGF on 2016/12/11.
 */
public class OpenBrowser {
    //公共
    WebDriver driver;
    //打开火狐浏览器
    @Test
    public void openFireFox(){
        System.setProperty("webdriver.firefox.bin","D:\\ruanjian\\FireFox\\firefox.exe");
        driver=new FirefoxDriver();
    }
    //打开谷歌浏览器
    @Test
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\项目信息\\GgfDay1\\drivers\\chromedriver.exe");
         driver=new ChromeDriver();
    }
    //打开IE浏览器
    @Test
    public void openIeBrowser(){
        System.setProperty("webdriver.ie.driver","E:\\项目信息\\GgfDay1\\drivers\\IEDriverServer.exe");
        driver=new InternetExplorerDriver();
    }
}
