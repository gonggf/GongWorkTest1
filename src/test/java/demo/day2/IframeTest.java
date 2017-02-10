package demo.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by thinkpad on 2016/12/28.
 */
public class IframeTest {

    WebDriver Driver;
    @BeforeTest
    public void openFireFox(){
        //指定Firefox安装路径
        System.setProperty("webdriver.firefox.bin","D:\\Software\\FireFox\\firefox.exe");    //setProperty相当于设置为静态变量，存在于内存里面
        //启动Firefox浏览器
        Driver = new FirefoxDriver();
        System.out.println("打开浏览器成功");
        Driver.get("file:///E:/selenium_test/selenium_html/index.html");
    }

    @Test
    public void iframeTest() throws InterruptedException {

//        Driver.switchTo().frame("aa"); //使用name或定位Iframe
//        使用元素的方法定位iframe
        WebElement iframeElement = Driver.findElement(By.xpath("/html/body/div/table/tbody/tr[15]/td[2]/iframe"));
        Driver.switchTo().frame(iframeElement);
        WebElement iframeInsideElement = Driver.findElement(By.linkText("baidu"));
        String text1 = iframeInsideElement.getText();
        System.out.println(text1);
        iframeInsideElement.click();
        Thread.sleep(2000);
        //交回控制权到原来页面
        Driver.switchTo().defaultContent();

        WebElement alertElement = Driver.findElement(By.xpath(".//*[@id='alert']/input"));
        alertElement.click();
//      移交Driver控制权给alert弹窗
        Alert alert1 = Driver.switchTo().alert();
        Thread.sleep(3000);
//        点击“确定”
        alert1.accept();

    }







    @AfterTest
    public void  close() throws InterruptedException {
        Thread.sleep(4000);
        Driver.quit();
        System.out.println("关闭浏览器成功");
    }

}
