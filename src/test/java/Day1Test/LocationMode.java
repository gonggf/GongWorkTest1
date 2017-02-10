package Day1Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.bind.Element;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by GGF on 2016/12/11.
 * 1.findElement()
 * 2.findElements()
 * 3.By.id
 * 4.By.name
 * 5.By.className
 * 6.By.partialLinkText
 * 7.By.cssSelector
 * 8.By.tagName
 * 9.By.xpath
 * 10.click
 * 11.sendkeys
 * 12.clear
 * 13.getText
 * 14.getTitle
 */
public class LocationMode {
    WebDriver driver;
    String url="https://www.baidu.com";
    @BeforeMethod
    public  void beforMethod(){
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public  void findElementTest() throws InterruptedException {
        driver.get(url);
        //通过ID定位赋值sendKeys
        driver.findElement(By.id("kw")).sendKeys("今天是周日");
        Thread.sleep(5000);
        //通过Name定位并做清除clear操作
        driver.findElement(By.name("wd")).clear();
        //通过partialLinkText定位
        driver.findElement(By.partialLinkText("新"));
        System.out.println("通过partialLinkText定位元素值有："+ driver.findElement(By.partialLinkText("新")).getText());
        //通过cssSelector定位
        String csstest=driver.findElement(By.cssSelector(".t>a")).getText();
        System.out.println("通过cssSelector定位获取TEXT:"+csstest);
        //通过xpath定位
        String xpathTest=driver.findElement(By.xpath(".//*[@id='1']/h3/a")).getText();
        System.out.print("通过Xpath定位的值："+xpathTest);
    }
    @Test
    public void findElementsTest(){
        driver.get(url);
        //通过classname获取定位
     List<WebElement> list= driver.findElements(By.className("mnav"));
     for (int i=0;i<list.size();i++){
         //通过循环分别打印出相同classname的数据并展示getText
         System.out.println("通过classname列表值有分别是："+list.get(i).getText());
     }
       //做click操作
       list.get(0).click();
        //获取Title
        String title=driver.getTitle();
        System.out.print("getTite的内容是：："+title);
    }
    @Test
    public void findElementsTest2(){
        driver.get(url);
        //通过tagName定位
        List<WebElement> webElements= driver.findElements(By.tagName("a"));
        System.out.println("通过TagName定位的个数有："+webElements.size());
        for (int i=0;i<webElements.size();i++){
            //通过循环分别打印出相同classname的数据并展示getText
            System.out.println("通过TagName定位的值分别是："+webElements.get(i).getText());
        }
    }
}
