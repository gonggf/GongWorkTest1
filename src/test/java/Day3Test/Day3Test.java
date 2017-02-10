package Day3Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by GGF on 2016/12/15.
 * 1.alert弹窗三种普通的alert，confim弹窗，prompt弹窗
 * 2.多窗口的处理frame,switchTO
 * 3.处理新打开的窗口getwindowhandle
 * 4.三种等待处理方式固定sleep规定时间再下一步操作 ,元素出现后等待规定时间再下一步操作，规定时间内找到元素再下一步操作
 */
public class Day3Test {
    WebDriver driver;
    String url="E:\\GGF\\培训\\webserver\\selenium_html\\index.html";
    @BeforeMethod
    //启用浏览器
    public  void  beforeMethodTest(){
        System.setProperty("webdriver.firefox.bin","D:\\ruanjian\\FireFox\\firefox.exe");
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    }
    @Test
    //alert弹窗点击确定
    public  void alertTest1() throws InterruptedException {
        driver.get ( url );
        driver.findElement ( By.xpath ("//*[@id=\"alert\"]/input") ).click ();
        Alert alert=driver.switchTo ().alert ();
        Thread.sleep ( 2000 );
        alert.accept ();
    }
    @Test
    //confim提示框，二次弹窗
    public  void alerConfirmTest() throws InterruptedException {
        driver.get ( url );
        driver.findElement ( By.xpath ( "//*[@id=\"confirm\"]/input" ) ).click ();
        Alert alert2=driver.switchTo ().alert ();
        Thread.sleep ( 2000 );
        alert2.dismiss ();
        Thread.sleep ( 2000 );
        alert2.accept ();
    }

    @Test
    //prompt提示框，录入像
    public  void alerPomptTest() throws InterruptedException {
        driver.get ( url );
        driver.findElement ( By.xpath ( "//*[@id=\"prompt\"]/input" ) ).click ();
        Alert alert3=driver.switchTo ().alert ();
        Thread.sleep ( 2000 );
        alert3.sendKeys ( "你好啊" );
        Thread.sleep ( 2000 );
        alert3.accept ();
        alert3.accept ();
    }
    @Test
    //多窗口处理,先定位至frame窗口再操作里面的元素，再将控制权交回原页面
    public void iFrameTest() throws InterruptedException {
        driver.get ( url );
        driver.switchTo ().frame ( "aa" );
        driver.findElement ( By.id ( "user" ) ).sendKeys ( "控制权交给frame窗口元素" );
        driver.switchTo ().defaultContent ();
        driver.findElement ( By.id ( "user" ) ).sendKeys ( "控制权交回原页面" );
        Thread.sleep ( 3000 );
    }
    @Test
    //windows新窗口处理，通过当前窗口循环判定是否相同，不同则将控制权交给新打开的窗口
    public void windowFrameTest() throws InterruptedException {
        driver.get ( url );
        driver.findElement ( By.linkText ( "Open new window" ) ).click ();
        String handle=driver.getWindowHandle ();
        for(String handles:driver.getWindowHandles ()){
            if(handles.equals ( handle )){
                continue;
            }
            driver.switchTo ().window ( handles );
        }
        Thread.sleep ( 5000 );
        driver.findElement ( By.id ( "user" ) ).sendKeys ( "新窗口录入" );
        Thread.sleep ( 5000 );
    }
    @Test
    //wait元素出现后等待规定时间再下一步操作
    public void waitTest1(){
        driver.get ( url );
        driver.findElement ( By.xpath ( "//*[@id=\"wait\"]/input" ) ).click ();
        driver.manage ().timeouts ().implicitlyWait ( 30, TimeUnit.SECONDS );
        String text=driver.findElement ( By.xpath ( "//*[@id=\"display\"]/div[1]" ) ).getText ();
        Assert.assertEquals ( text,"wait for display" );
    }
    @Test
    //wait规定时间内找不到再下一步操作
    public void waitTest2(){
        driver.get ( url );
        driver.findElement ( By.xpath ( "//*[@id=\"wait\"]/input" ) ).click ();
        WebDriverWait wait=new WebDriverWait ( driver,0 );
        wait.until ( ExpectedConditions.presenceOfElementLocated (By.xpath ( "//*[@id=\"display\"]/div[1]" ) ) );
        String text=driver.findElement ( By.xpath ( "//*[@id=\"display\"]/div[1]" ) ).getText ();
        Assert.assertEquals ( text,"wait for display" );
    }
    @AfterMethod
    public void afterMethodTest(){
        driver.close ();
    }
}
