package Day4Test;

import org.apache.commons.io.FileUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by GGF on 2016/12/27.
 * 1.右键
 * 2.双击
 * 3.移动到某个元素上
 * 4.拖动到具体位置
 * 5.actions类keydow方法操作键盘
 * 6.Robot类keypress方法实现操作键盘
 * 7.上传
 * 8.下载
 */
public class Day4Test {
    WebDriver driver;
    String url="file:///F:/%E5%9F%B9%E8%AE%AD/webserver/selenium_html/index.html";
    @BeforeMethod
    //启用浏览器
    public  void  beforeMethodTest(){
        driver=new FirefoxDriver ();
    }
    @Test
    //通过Actions类contextclick方法来进行右键操作
    public void rightClickTest(){
        driver.get ( url );
       WebElement element= driver.findElement ( By.linkText ("登陆界面") );
        Actions actions=new Actions ( driver );
        actions.contextClick (element).perform ();
    }
    @Test
    //通过Actions类doubleclick方法来进行双击操作
    public void doubleClickTest(){
        driver.get ( url );
        WebElement element1=driver.findElement ( By.xpath ( "//*[@id=\"radio\"]/label[1]" ) );
        Actions actions1=new Actions ( driver );
        actions1.doubleClick (element1).perform ();
    }
    @Test
    //通过Actiongs类moveelement方法移动到某个元素上
    public void moveTest(){
        driver.get ( "https://www.baidu.com" );
        WebElement element2=driver.findElement ( By.linkText ( "更多产品" ) );
        Actions actions2=new Actions ( driver );
        actions2.moveToElement ( element2 ).perform ();
    }
    @Test
    //通过Actions类draganddropby方法拖动元素到具体位置
    public void moveTest1(){
        driver.get ( "file:///F:/%E5%9F%B9%E8%AE%AD/webserver/selenium_html/dragAndDrop.html" );
        WebElement element3=driver.findElement ( By.xpath ( "//*[@id=\"drag\"]" ) );
         Actions actions=new Actions ( driver );
        actions.dragAndDropBy ( element3,400,500 ).perform ();

    }
    @Test
    //通过Actions类的clickandhold方法拖动到某个元素后再释放
    public  void  moveTest2(){
        driver.get ( "file:///F:/%E5%9F%B9%E8%AE%AD/webserver/selenium_html/dragAndDrop.html" );
        WebElement element3=driver.findElement ( By.xpath ( "//*[@id=\"drag\"]" ) );
        WebElement element4=driver.findElement ( By.xpath ( "/html/body/h1" ) );
        Actions actions1=new Actions ( driver );
        actions1.clickAndHold ( element3 ).moveToElement ( element4 ).release (element3);
    }
    @Test
    //通过Actions类keydown操作键盘实现多选
    public void selectTest() throws InterruptedException {
        driver.get ( url );
        WebElement select=driver.findElement(By.id ( "selectWithMultipleEqualsMultiple" ));
        List<WebElement> list=select.findElements ( By.tagName ( "option" ) );
        Actions actions=new Actions ( driver );
        actions.keyDown ( Keys.SHIFT ).click (list.get ( 0 )).click (list.get ( 1 )).click (list.get ( 2 )).build ();
    }
    @Test
    //通过Robot类的keypress方法操作键盘
    public void robotTest() throws AWTException {
        driver.get ( url );
        WebElement element=driver.findElement ( By.id ( "user" ) );
        Robot robot=new Robot (  );
        element.click ();
        robot.keyPress ( KeyEvent.VK_A );
        robot.keyPress ( KeyEvent.VK_0 );
        robot.keyRelease ( KeyEvent.VK_0);
        robot.keyRelease ( KeyEvent.VK_A);
    }
    @Test
    //通过sendkeys上传文件
    public  void upTest() throws InterruptedException {
        driver.get ( url );
        driver.findElement(By.id ( "load" ) ).sendKeys ( "F:\\培训\\webserver\\webdriver基础教程6期.pdf" );
        Thread.sleep ( 6000);
    }
    @Test
    //通过Actions类实现下载
    public void  downTest() throws InterruptedException {
        driver.get ( url );
        WebElement element=driver.findElement ( By.linkText ( "登陆界面" ) );
        Actions actions=new Actions ( driver );
        actions.moveToElement ( element );
        actions.contextClick ( element ).perform ();
        actions.keyDown ( Keys.CONTROL).sendKeys ( Keys.DOWN ).perform ();
        Thread.sleep ( 2000 );
        actions.keyDown ( Keys.CONTROL).sendKeys ( Keys.DOWN ).perform ();
        Thread.sleep ( 2000 );
        actions.keyDown ( Keys.CONTROL).sendKeys ( Keys.DOWN ).perform ();
        Thread.sleep ( 2000 );
        actions.keyDown ( Keys.CONTROL).sendKeys ( Keys.DOWN ).perform ();
        Thread.sleep ( 2000 );
        actions.keyDown ( Keys.CONTROL).sendKeys ( Keys.DOWN ).perform ();
        actions.keyDown ( Keys.CONTROL ).sendKeys ( Keys.ENTER ).perform ();
        Thread.sleep ( 2000 );
        actions.keyDown ( Keys.CONTROL ).sendKeys ( Keys.TAB ).perform ();
        Thread.sleep ( 2000 );
        actions.keyDown ( Keys.CONTROL ).sendKeys ( Keys.TAB ).perform ();
        actions.keyDown ( Keys.CONTROL ).sendKeys ( Keys.TAB ).perform ();
        actions.keyDown ( Keys.CONTROL ).sendKeys ( Keys.ENTER ).perform ();
    }
    @Test
    //通过Robot类实现下载
        public void downTest2() throws AWTException, InterruptedException {
        driver.get ( "http://10.20.105.17:6060/cas/login?service=http://10.20.105.17:7070/cstportal/cas" );
        driver.findElement ( By.xpath ( ".//*[@id='cas']/div[4]/div[2]/div[4]/a/span/span" ) ).click ();
        driver.findElement ( By.id ( "username" ) ).sendKeys ( "admin" );
        driver.findElement ( By.id ( "password" ) ).sendKeys ( "a111111" );
        driver.findElement ( By.className ( "btn-submit" ) ).click ();
        driver.findElement ( By.xpath ( ".//*[@id='one_system']/div[2]/ul[2]/li[4]/a/strong/img" ) ).click ();
        driver.findElement ( By.xpath ( ".//*[@id='production']/a/span[1]" ) ).click ();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript ( "arguments[0].scrollIntoView(true)",driver.findElement ( By.xpath ( ".//*[@id='leftMenu']/div[19]/div[1]/div[2]/a[2]" ) ) );
        driver.findElement ( By.xpath ( ".//*[@id='leftMenu']/div[19]/div[1]/div[2]/a[2]" ) ).click ();
        driver.findElement ( By.linkText ( "上胶需求表" ) ).click ();
        driver.findElement ( By.xpath ( ".//*[@id='reportForm']/ul[2]/li/a[2]/span/span[1]" ) ).click ();
        Robot robot=new Robot (  );
        robot.keyPress ( KeyEvent.VK_DOWN);
        Thread.sleep ( 2000 );
        robot.keyPress ( KeyEvent.VK_TAB);
        Thread.sleep ( 2000 );
        robot.keyPress ( KeyEvent.VK_TAB);
        Thread.sleep ( 2000 );
        robot.keyPress ( KeyEvent.VK_TAB);
        Thread.sleep ( 2000 );
        robot.keyPress ( KeyEvent.VK_ENTER);
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
  /*  @AfterMethod
    public void afterMethodTest() throws InterruptedException {
        Thread.sleep ( 5000 );
        driver.close ();
    }*/
}
