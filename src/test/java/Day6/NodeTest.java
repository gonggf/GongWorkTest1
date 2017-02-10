package Day6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Thinkpad on 2017/1/9.
 */
public class NodeTest {
    @Test
    public void gridNodeTest() throws MalformedURLException {
        DesiredCapabilities firefox=DesiredCapabilities.firefox();
        WebDriver driver=new RemoteWebDriver(new URL("http://172.16.0.90:5555"),firefox);
        driver.get("E:\\GGF\\培训\\webserver\\selenium_html\\index.html");
    }
}

