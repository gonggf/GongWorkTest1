package Day1Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.peer.SystemTrayPeer;

/**
 * Created by GGF on 2016/12/11.
 * 1.打开网页
 * 2.浏览器后退
 * 3.浏览器前进
 * 4.浏览器刷新
 * 5.设置浏览器大小
 * 6.获取当前页面title
 * 7.获取当前页面url
 */
public class BrowserCommonOperation
{
    //公共
    WebDriver driver;
    String url="https://www.baidu.com";
    String url1="http://www.51testing.org";
    @BeforeMethod
    public void beforeMethod(){
        driver=new FirefoxDriver();
    }
     @Test
    public void openUrl(){
         driver.get(url);
         System.out.print("当前打开窗口为："+url);
     }
    @Test
    public void backOff(){
        driver.get(url);
        driver.get(url1);
        //回退操作
        driver.navigate().back();
        System.out.print("回退成功啦");
    }
    @Test
    public  void getTitleTest(){
        driver.get(url);
        //获取当前Title
        String i=driver.getTitle();
        System.out.print("当前title："+i);
    }
    @Test
    public  void getUrlTest(){
        driver.get(url);
        //获取当前地址
        String t=driver.getCurrentUrl();
        System.out.print("当前页面url："+t);
    }
    @Test
    public void setBrowserSize(){
        driver.get(url);
        //窗口最大化
        driver.manage().window().maximize();
        System.out.print("最大化成功！");
        //设置窗口大小
        Dimension dimension =new Dimension(500,600);
        driver.manage().window().setSize(dimension);
        System.out.print("窗口成功设定成500*600！");
    }
    @Test
    public void refreshTest(){
        driver.get(url);
        driver.findElement(By.id("kw")).sendKeys("hello");
        //刷新页面
        driver.navigate().refresh();
        System.out.print("刷新成功！");
    }
    @Test
    public void forwordTest(){
        driver.get(url);
        driver.get(url1);
        //后退
        driver.navigate().back();
        //前进
        driver.navigate().forward();
        System.out.print("前进成功！");
    }
    @AfterMethod
    public void afterMethod(){
        //关闭浏览器
        driver.close();
    }

}
