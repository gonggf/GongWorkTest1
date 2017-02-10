package Day5Test.LuoJiCeng;

import Day5Test.LuoJiCeng.BaseCase;
import Day5Test.PoCeng.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Thinkpad on 2017/1/12.
 */
public class PeiZhiTest extends BaseCase {

    //登录页面控制权转移至frame窗口
    public static void frame(By frame){
        WebElement iFrame=driver.findElement(frame);
        driver.switchTo().frame(iFrame);
    }
    //控制权转移至新打开的窗口
    public static void moreFrame(){
        String handle=driver.getWindowHandle();
        for(String handles:driver.getWindowHandles()) {
            if (handle.equals(handles)) {                continue;
            }
            driver.switchTo().window(handles);
        }
    }
}
