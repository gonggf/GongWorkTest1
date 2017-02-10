package Day2Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.jws.WebService;
import java.util.List;

/**
 * @author GGF  on 2016/12/15.
 * 1.如何处理Table
 */
public class TableTest {
    WebDriver driver;
    String url="file:///F:/%E5%9F%B9%E8%AE%AD/webserver/selenium_html/index.html";
    @BeforeMethod
    //启用浏览器
    public  void  beforeMethodTest(){
        driver=new FirefoxDriver ();
    }
    @Test
    public void getTableTable(){
        WebElement table=driver.findElement ( By.xpath ( "/html/body/div/table" ));
        List<WebElement> rows=table.findElements ( By.tagName ( "tr" ) );
        List<WebElement> tds=table.findElements ( By.tagName ( "td" ) );
        for(int i=0;i<=rows.size();i++){
            for(int j=0;j<=tds.size();j++){
            }
        }


    }
}
