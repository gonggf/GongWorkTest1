package Day5Test.YeWuCeng;

import Day5Test.LuoJiCeng.BaseCase;
import Day5Test.LuoJiCeng.PeiZhiTest;
import Day5Test.PoCeng.Elements;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Thinkpad on 2017/1/12.
 */
public class LoginTest extends BaseCase {
    //https://github.com/gonggf/GongWorkTest1.git
    //调用配置类
    PeiZhiTest peiZhiTest=new PeiZhiTest();
    /**数据驱动，配置登录用例
     * 1.正确账号，正确密码，登录
     * 2.正确账号，错误密码
     * 3.错误账号，错误密码
     */
    @DataProvider(name="loginData")
    public Object[][] testDataProvider(){
        return new Object[][]{{"gonggf0916","1314520gf"},{"gonggf0916","232"},{"ddf","dd"}};
    }
    @Test(dataProvider = "loginData")
    public void  loginTest1(String username,String passWord) throws InterruptedException {
        LoginTest loginTest3=new LoginTest();
        loginTest3.successLogin(username,passWord);
        Thread.sleep(5000);
    }
    @Test
    //正常登录用例
    public void loginTest(){
        successLogin("dreamingxuanyu","forjone1226");
    }
    @Test
    //邮箱为空用例
    public void emailIsNullTest() {
       emailIsNullAssert("1233");
    }
    @Test
    //密码为空用例
    public void passWordIsNullTest(){
        passWordIsNullAssert("1234");
    }
    @Test
    //账号密码错误用例
    public void emailOrPassWordErrorTest(){
        emailOrPassWordIsErrorAssert("gonggf0916","2222");
    }
    //正常登录流程设置参数
    public void successLogin(String email,String password){
        peiZhiTest.frame(Elements.LoginFrame);
        driver.findElement(Elements.LoginName).sendKeys(email);
        driver.findElement(Elements.LoginPassWord).sendKeys(password);
        driver.findElement(Elements.LoginButton).click();
    }
   //校验邮箱为空是否提示
    public void emailIsNullAssert(String passWord)  {
        peiZhiTest.frame(Elements.LoginFrame);
        driver.findElement(Elements.LoginName).click();
        driver.findElement(Elements.LoginPassWord).click();
        driver.findElement(Elements.LoginPassWord).sendKeys(passWord);
        driver.findElement(Elements.LoginButton).click();
        WebElement massageInfo=driver.findElement(Elements.LoginNameAssertInfo);
        String emailInfo=massageInfo.getText().trim();
        Assert.assertEquals(emailInfo,"请输入帐号");
    }
    //校验密码为空是否提示
    public void passWordIsNullAssert(String email){
        peiZhiTest.frame(Elements.LoginFrame);
        driver.findElement(Elements.LoginName).sendKeys(email);
        driver.findElement(Elements.LoginPassWord).click();
        driver.findElement(Elements.LoginButton).click();
        WebElement massageInfo=driver.findElement(Elements.LoginNameAssertInfo);
        String passWordInfo=massageInfo.getText().trim();
        Assert.assertEquals(passWordInfo,"请输入密码");
    }
    //校验账号密码错误是否提示
    public void emailOrPassWordIsErrorAssert(String email,String passWord){
        peiZhiTest.frame(Elements.LoginFrame);
        driver.findElement(Elements.LoginName).sendKeys(email);
        driver.findElement(Elements.LoginPassWord).sendKeys(passWord);
        driver.findElement(Elements.LoginButton).click();
        WebElement massageInfo=driver.findElement(Elements.LoginNameAssertInfo);
        String errorInfo=massageInfo.getText().trim();
        Assert.assertEquals(errorInfo,"帐号或密码错误");
    }

}
