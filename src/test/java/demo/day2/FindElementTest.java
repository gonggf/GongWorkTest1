package demo.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by thinkpad on 2016/12/26.
 */
public class FindElementTest {
    WebDriver Driver;
    WebDriver DriverChrome;

    @BeforeTest
    public void openFireFox(){
        //指定Firefox安装路径
        System.setProperty("webdriver.firefox.bin","D:\\Software\\FireFox\\firefox.exe");    //setProperty相当于设置为静态变量，存在于内存里面
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        //启动Firefox浏览器
        Driver = new FirefoxDriver();
        System.out.println("打开Firefox浏览器成功");
        DriverChrome = new ChromeDriver();
        System.out.println("打开Chrome浏览器成功");

    }

    @Test
    public  void testChromeOperation(){
        DriverChrome.get("http://www.baidu.com");

    }




    @Test
    public void testById(){
        Driver.get("https://www.baidu.com");
        //通过ID 定位
//        WebElement firstElement = Driver.findElement(By.id("kw"));
//        System.out.println(firstElement);
        //通过name定位
//        WebElement firstElement = Driver.findElement(By.name("wd"));
//        System.out.println(firstElement);
        //通过CLASSNAME定位
//        WebElement firstElement = Driver.findElement(By.className("s_ipt"));
//        System.out.println(firstElement);
        //通过linktest定位
//        WebElement firstElement = Driver.findElement(By.linkText("新闻"));
//        System.out.println(firstElement);
        //通过部分文本定位
        WebElement firstElement = Driver.findElement(By.partialLinkText("新"));
        System.out.println(firstElement);

    }
    @Test
    public void testByCss(){
        Driver.get("https://www.baidu.com");
//      通过CSS定位
        WebElement firstElement = Driver.findElement(By.cssSelector("#kw"));
        System.out.println(firstElement);

    }
    @Test
    public void testByTagName(){
        Driver.get("https://www.baidu.com");
//      通过tagName定位
        WebElement firstElement = Driver.findElement(By.tagName("input"));
        System.out.println(firstElement);

    }

    @Test
    public void testByXpath(){
        Driver.get("https://www.baidu.com");
//      通过tagName定位
        String MyInput = "forever";
        Driver.findElement(By.xpath("  //*[@id=\"kw\"]")).sendKeys(MyInput);
        System.out.println(MyInput);

    }

    @Test
    public void testByFindElements() throws InterruptedException {
        Driver.get("https://www.baidu.com");

        String MyInput = "forever";
        List<WebElement> myElements = Driver.findElements(By.className("mnav"));
        for (int i = 0; i <myElements.size() ; i++) {
            System.out.println(myElements.get(i));
            myElements.get(i).click();
//            Thread.sleep(10000);
            Driver.navigate().back();

        }


        Thread.sleep(5000);
//        System.out.println(MyInput);

    }

    @Test
    public void getTagName(){
        Driver.get("https://www.baidu.com");
        WebElement textBox = Driver.findElement(By.id("kw"));
        //获取Tagname值
        String textTagName = textBox.getTagName();
        System.out.println(textTagName);
        Assert.assertEquals(textTagName,"input");

    }

    @Test
    public void getA(){
        Driver.get("https://www.baidu.com");
        WebElement textBox = Driver.findElement(By.id("su"));
        //Attribute里面的参数是对象的某个参数值，下面的例子是查询value的值
        String textTagName = textBox.getAttribute("value");
        System.out.println(textTagName);
        boolean elementDisplay = textBox.isDisplayed();
        System.out.println(elementDisplay);

        Assert.assertEquals(textTagName,"百度一下");
        Assert.assertTrue(elementDisplay);

    }


    @Test
//    判断单选框是否选中
    public void testIsSelect() throws InterruptedException {
        Driver.get("file:///E:/selenium_test/selenium_html/index.html");
        WebElement audio = Driver.findElement(By.xpath(".//*[@id='radio']/input[1]"));
        audio.click();
        Thread.sleep(5000);
        boolean audioSelected = audio.isSelected();
//        System.out.println(audioSelected);
//        加入IF语句为了更好的判断执行结果，可以很好的分析结果
        if (audioSelected) {
            System.out.println("单选框已选中");
        }
        else{
            System.out.println("单选框未选中");
        }
        Assert.assertTrue(audioSelected,"单选框未选中");
    }

    @Test
//    判断元素是否激活显示（是否灰显）
    public void testIsEnable() throws InterruptedException {
        Driver.get("file:///E:/selenium_test/selenium_html/index.html");
        WebElement buttonSubmit = Driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr[6]/td[2]/div/input[1]"));
        String elementType = buttonSubmit.getAttribute("type");  //判断元素的类型，用于之后输出元素类型日志
        String elementValue = buttonSubmit.getAttribute("value");
        boolean audioEnable = buttonSubmit.isEnabled();
//        加入IF语句为了更好的判断执行结果，可以很好的分析结果
        if (audioEnable) {
            System.out.println("元素"+ elementValue +"是"+ elementType +"类型，" +"元素正常显示，激活状态");
        }
        else{
            System.out.println("元素"+ elementValue +"是"+ elementType +"类型，" +"元素灰显，未激活");
        }
    }

    @AfterTest
    public void  close() throws InterruptedException {
        Thread.sleep(4000);
        DriverChrome.quit();
        System.out.println("关闭Chrome浏览器成功");
        Driver.quit();
        System.out.println("关闭Firefox浏览器成功");
    }
}
