package demo.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by thinkpad on 2016/12/28.
 */
public class WindowTest {

    WebDriver Driver;
    @BeforeTest
    public void openFireFox(){
        //指定Firefox安装路径
        System.setProperty("webdriver.firefox.bin","D:\\Software\\FireFox\\firefox.exe");    //setProperty相当于设置为静态变量，存在于内存里面
        //启动Firefox浏览器
        Driver = new FirefoxDriver();
        System.out.println("打开浏览器成功");
        //////全局等待，设置最长等待多久，一找到就执行
//        Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void winTest() throws InterruptedException {
        Driver.get("file:///E:/selenium_test/selenium_html/index.html");
        WebElement linkNewWindow = Driver.findElement(By.linkText ("Open new window"));
        linkNewWindow.click();
        String currentWindowHandle = Driver.getWindowHandle();
        System.out.println(currentWindowHandle);
//获取所有的窗口句柄，并逐个与currentWindowHandle匹配
        for (String handls :Driver.getWindowHandles()){
            if (handls.equals(currentWindowHandle)) {
                continue;
            }
            else {
                Driver.switchTo().window(handls);
            }
        }
        Thread.sleep(5000);

        WebElement newWindowInputBox = Driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr[1]/td[2]/div/input"));
        newWindowInputBox.sendKeys("新窗口输入测试文本");


    }

//元素等待测试

    @Test
    public void waitTest() throws InterruptedException {
        Driver.get("file:///E:/selenium_test/selenium_html/index.html");
        WebElement waitButton = Driver.findElement(By.xpath (".//*[@id='wait']/input"));
        waitButton.click();
//显示等待,等待元素一定时间
        WebDriverWait webDriverWait = new WebDriverWait(Driver, 30);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("red")));
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By))
//        Thread.sleep(5000);
        WebElement waitDisplayElement = Driver.findElement(By.className("red"));
        String textElement = waitDisplayElement.getText();
        System.out.println(textElement);

    }

    @AfterTest
    public void  close() throws InterruptedException {
        Thread.sleep(4000);
        Driver.quit();
        System.out.println("关闭浏览器成功");
    }

}
