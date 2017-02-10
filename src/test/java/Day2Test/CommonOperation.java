package Day2Test;

import javafx.scene.chart.PieChart;
import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by GGF on 2016/12/13.
 * Webdriver常用方法
 * 1.getAttributeTest
 * 2.isDisplayed
 * 3.isSelected
 * 4.screenShort
 */
public class CommonOperation {
    WebDriver driver;
    String url="file:///F:/%E5%9F%B9%E8%AE%AD/webserver/selenium_html/index.html";
    @BeforeMethod
    //启用浏览器
    public  void  beforeMethodTest(){
        driver=new FirefoxDriver();
    }
    @Test
   //通过getAttributeTest获取元素属性值
    public void getAttributeTest(){
       driver.get ( url );
       WebElement element=driver.findElement ( By.id ( "user" ) );
       System.out.print ( element.getAttribute ( "type" ) );
    }
     @Test
     //通过linkText定位元素来判定isDisplayed是否展示,未选中则选中
    public void isDisplayedTest(){
        driver.get(url);
        boolean isdisplay=driver.findElement(By.linkText("登陆界面")).isDisplayed();
        System.out.println(isdisplay);
            if (isdisplay) {
                System.out.print("已选中，选中值是：" + driver.findElement(By.xpath("//*[@id=\"radio\"]/label[1]")).getText());
            } else {
                driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]")).click();
                System.out.print("选择后的值是：" + driver.findElement(By.xpath("//*[@id=\"radio\"]/label[1]")).getText());
            }
     }
     @Test
     //通过xpath定位元素来判定isSelected是否选中
     public void isSelectedTest(){
        driver.get(url);
        boolean isselected=driver.findElement(By.xpath("//*[@id=\"moreSelect\"]")).isSelected();
        System.out.println(isselected);
         if (isselected){
            System.out.print("已选中，选中值是："+driver.findElement(By.xpath("//*[@id=\"moreSelect\"]")).getText());
        }else{
             driver.findElement(By.xpath("//*[@id=\"moreSelect\"]")).click();
         }
     }
     @Test
     //selected下拉框选择三种方式
     public void selectedTest() throws InterruptedException {
         driver.get(url);
         WebElement element= driver.findElement( By.id ("moreSelect") );
         Select select=new Select(element);
         select.selectByIndex ( 0 );
         Thread.sleep ( 5000 );
         select.selectByValue ( "oppe" );
         Thread.sleep ( 5000 );
         select.selectByVisibleText ( "meizu" );
     }
    @Test
    //下拉选项框循通过selectByIndex环遍历点击一遍
    public void selectedTest1() throws InterruptedException {
        driver.get(url);
        WebElement element= driver.findElement( By.id ("moreSelect") );
        Select select=new Select(element);
        for(int i=0;i<select.getOptions ().size ();i++){
            select.selectByIndex ( i );
            Thread.sleep ( 2000 );
        }
    }
     @Test
     //通过isEnabled判定按钮是否激活，未激活并点击打开百度按钮
     public  void isEnabledTest()  {
         driver.get(url);
         boolean isenable=driver.findElement(By.name("buttonhtml")).isEnabled();
         if(isenable){
             System.out.print("激活按钮");
         }else {
            driver.findElement(By.className("btnSousuo")).click();
         }
     }
     @Test
     //截图并保存在logs-screenshorts文件下
     public void screenShortTest() throws IOException {
         driver.get ( url );
         File screenShotFile=((TakesScreenshot)driver).getScreenshotAs ( OutputType.FILE );
         FileUtils.copyFile ( screenShotFile,new File ( "E:\\GgfDay1\\logs\\screenshorts\\"+"Image"+Math.random ()+".png" ));
     }
    @Test
     //时间戳截图
    public void screenShortTest1()throws IOException {
         driver.get ( url );
        Date date=new Date (  );
        DateFormat dateFormat=new SimpleDateFormat ( "yyyyMMddHHmmss ");
        String time=dateFormat.format ( date );
        File screenShotFile=((TakesScreenshot)driver).getScreenshotAs ( OutputType.FILE );
        FileUtils.copyFile ( screenShotFile,new File ( "E:\\GgfDay1\\logs\\screenshorts\\"+"Image"+time+".png" ));
    }

     @AfterMethod
    public void afterMethodText() throws InterruptedException {
         Thread.sleep(4000);
        driver.close();
     }
}
