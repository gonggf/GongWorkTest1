package Day5Test.YeWuCeng;
import Day5Test.LuoJiCeng.BaseCase;
import Day5Test.PoCeng.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by thinkpad on 2017/1/12.
 */
public class SendEmail extends BaseCase {
    @Test
    public void sendEmailFile() throws InterruptedException {
        LoginTest loginTest=new LoginTest();
        loginTest.loginTest();
//        Thread.sleep(10000);
//        显式等待
        WebDriverWait elementWait = new WebDriverWait(driver, 10);
        elementWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")));
        WebElement sendEmailElement = driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]"));

        sendEmailElement.click();
        WebElement receivePerson = driver.findElement(By.xpath(".//*[@class='bz0']/div[2]/div/input"));
        WebElement emailTitle = driver.findElement(By.xpath(".//*[@class='tH0']/header/div[2]/div/div/div/input"));
        WebElement addFile = driver.findElement(By.xpath(".//*[@class='ia0']/div/div[2]/input"));
        receivePerson.sendKeys("dreamingxuanyu@163.com");
        emailTitle.sendKeys("测试附件邮件");
        addFile.sendKeys("C:\\Users\\thinkpad\\Pictures\\5.jpg");

        //        编写邮件正文
        driver.switchTo().frame(driver.findElement(By.className("APP-editor-iframe")));
        WebElement emailBody = driver.findElement(By.xpath("html/body"));
        emailBody.sendKeys("这是一封测试的邮件");

//        页面控制回到主页面
        driver.switchTo().defaultContent();

//点击“发送”按钮
        driver.findElement(By.xpath(".//*[@id='dvContainer']/div/header/div/div[1]/div/span[2]")).click();
        elementWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='发送成功']")));
//        结果判断，但是不成功，无法获取H1中的文本内容
        WebElement checkStatus = driver.findElement(By.xpath(".//*[text()='发送成功']"));
        String checkStatusText = checkStatus.getAttribute("innerText");
        System.out.println("执行结果 ： " + checkStatusText);
        boolean resultStatus = checkStatus.isDisplayed();
        Assert.assertTrue(resultStatus,"发送失败");

    }
   /* @Test
    //selected下拉框选择三种方式
    public void slecTest() throws InterruptedException {
        selectedTest(Elements.se,0);
    }
    public void selectedTest(By selectl,int a) throws InterruptedException {
        driver.get("file:///E:/GGF/%E5%9F%B9%E8%AE%AD/webserver/selenium_html/index.html");
        WebElement element= driver.findElement( selectl);
        Select select=new Select(element);
        select.selectByIndex ( a );
        Thread.sleep ( 5000 );
        select.selectByValue ( "oppe" );
        Thread.sleep ( 5000 );
        select.selectByVisibleText ( "meizu" );
    }*/
}
