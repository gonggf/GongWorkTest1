package Day5Test.YeWuCeng;

import Day5Test.LuoJiCeng.BaseCase;
import Day5Test.LuoJiCeng.PeiZhiTest;
import Day5Test.PoCeng.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by GGF on 2016/12/29.
 * 1.完成163邮箱的注册
 * 2.完成正确账号的登录
 * 3.完成错误账号的登录
 * 4.完成带附件的发送邮件
 */
public class RegisterTest extends BaseCase {
    String mailInfo;
    String  mainPwdInfo;
    String mainCfmPwdInfo;
    String mobileInfo;
    @BeforeMethod
    public  void beforeMethod(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    //正常注册
    public void RegisterTest() throws InterruptedException {
        Date  date=new Date();
        DateFormat dateFormat=new SimpleDateFormat( "yyyyMMddHHmmss ");
        String time=dateFormat.format(date);
        String name="g"+time;
        Long No=System.currentTimeMillis();
        String mobileNo=String.valueOf(No/100);
        //正常注册流程
        sussceRegister(name,"a111111","a111111",mobileNo,"1234","1234");
    }
    @Test
    //邮箱为空用例
    public void mailIsNullAssert(){
        mailAssertIsNull();
    }
    @Test
    //邮箱无字母用例
    public void mailNoWordAssert() {
        mailAssertPublic("44444444");
        Assert.assertEquals(mailInfo,"邮件地址必需以英文字母开头");
    }
    @Test
    //邮箱长度不足用例
    public void mailLength() {
        mailAssertPublic("a111");
        Assert.assertEquals(mailInfo,"长度应为6~18个字符");
    }
    @Test
    //邮箱已被注册用例
    public void mailAegistedAssert(){
        mailAssertPublic("gonggf0916");
        Assert.assertEquals(mailInfo,"该邮件地址已被注册");
    }
    @Test
    //密码长度用例
    public void pwdLengthAssert() {
        pwdAssertPublic("34343a","11");
        Assert.assertEquals(mainPwdInfo,"密码长度应为6~16个字符");
    }
    @Test
    //密码为空用例
    public void pwdIsNullAssert() {
        pwdAssertIsNull("3323234s");
        Assert.assertEquals(mainPwdInfo,"请填写密码");
    }
    @Test
    //二次密码为空用例
    public void cfmPwdIsNullAssert()  {
        cfmPwdAssertIsNull("s11111","2323232");
        Assert.assertEquals(mainCfmPwdInfo,"请再次填写密码");
    }
    @Test
    //密码一致用例
    public void pwdAndCfmPwdAssert()  {
        cfmPwdAssertPublic("22222","222ssss2","a22");
        Assert.assertEquals(mainCfmPwdInfo,"两次填写的密码不一致");
    }
    @Test
    //手机号格式用例
    public void moblieIsNullAssert()  {
        mobilePhoneAssertPublic("22233a","123456","123456","11","1111","2323");
        Assert.assertEquals(mobileInfo,"请填写正确的手机号");
    }
    //邮箱空部分
    public void mailAssertIsNull(){
        goRegister();
        driver.findElement(Elements.RegisterEmail).click();
        driver.findElement(Elements.RegisterButton).click();
        WebElement mailMessage=driver.findElement(Elements.RmailAssertInfo);
        mailInfo=mailMessage.getText().trim();
        Assert.assertEquals(mailInfo,"请填写邮件地址");
    }
    //邮箱公共部分
    public void mailAssertPublic(String emailUrl){
        goRegister();
        driver.findElement(Elements.RegisterEmail).sendKeys(emailUrl);
        driver.findElement(Elements.RegisterButton).click();
        WebElement mailMessage=driver.findElement(Elements.RmailInfo);
        mailInfo=mailMessage.getAttribute("innerHTML").trim();
    }
    //密码为空校验
    public void pwdAssertIsNull(String email){
        goRegister();
        driver.findElement(Elements.RegisterEmail).sendKeys(email);
        driver.findElement(Elements.RegisterMainPwd).click();
        driver.findElement(Elements.RegisterButton).click();
        WebElement mainPwdMessage=driver.findElement(Elements.RmPwdAssertInfo);
        mainPwdInfo=mainPwdMessage.getText().trim();
    }
   //密码校验公共部分
    public void pwdAssertPublic(String email,String mainPwd){
        goRegister();
        driver.findElement(Elements.RegisterEmail).sendKeys(email);
        driver.findElement(Elements.RegisterMainPwd).sendKeys(mainPwd);
        driver.findElement(Elements.RegisterButton).click();
        WebElement mainPwdMessage=driver.findElement(Elements.RmPwdAssertInfo);
        mainPwdInfo=mainPwdMessage.getText().trim();
    }
    //二次密码为空
    public void cfmPwdAssertIsNull(String email,String mailPwd){
        goRegister();
        driver.findElement(Elements.RegisterEmail).sendKeys(email);
        driver.findElement(Elements.RegisterMainPwd).sendKeys(mailPwd);
        driver.findElement(Elements.RegisterButton).click();
        WebElement  CfmPwdMessage= driver.findElement(Elements.RmCfmPwdAssertInfo);
        mainCfmPwdInfo=CfmPwdMessage.getText().trim();
    }
    //二次密码校验公共部分
    public void cfmPwdAssertPublic(String email,String mailPwd,String mainCfmPwd){
        goRegister();
        driver.findElement(Elements.RegisterEmail).sendKeys(email);
        driver.findElement(Elements.RegisterMainPwd).sendKeys(mailPwd);
        driver.findElement(Elements.RegisterMainCfmPwd).sendKeys(mainCfmPwd);
        WebElement  CfmPwdMessage= driver.findElement(Elements.RmCfmPwdAssertInfo);
        driver.findElement(Elements.RegisterButton).click();
        mainCfmPwdInfo=CfmPwdMessage.getText().trim();
    }
    //手机号校验公共部分
    public  void mobilePhoneAssertPublic(String email,String mailPwd,String mainCfmPwd,String mobilePhone,String vcode,String messageVcode){
        goRegister();
        driver.findElement(Elements.RegisterEmail).sendKeys(email);
        driver.findElement(Elements.RegisterMainPwd).sendKeys(mailPwd);
        driver.findElement(Elements.RegisterMainCfmPwd).sendKeys(mainCfmPwd);
        driver.findElement(Elements.RegisterMainMobile).sendKeys(mobilePhone);
        driver.findElement(Elements.RegisterVcode).sendKeys(vcode);
        driver.findElement(Elements.RegisterMessageVcode).sendKeys(messageVcode);
        WebElement  mobilePhoneMessage= driver.findElement(Elements.RegisterMainMobileAsssertInfo);
        driver.findElement(Elements.RegisterButton).click();
        mobileInfo=mobilePhoneMessage.getText().trim();
    }
    //进入注册页面--公用
    public void goRegister(){
        PeiZhiTest.frame(Elements.LoginFrame);
        driver.findElement(Elements.LoginPageRegisterButton).click();
        PeiZhiTest.moreFrame();
        driver.findElement(Elements.EmailRegisterTab).click();
    }
    //进行注册操作--正常流程
    public void sussceRegister(String mailName,String mainPwd,String mainCfmPwd,String mobileNumber,String vCode,String messageVcode){
        //进入注册页面
        goRegister();
        driver.findElement(Elements.RegisterEmail).sendKeys(mailName);
        driver.findElement(Elements.RegisterMainPwd).sendKeys(mainPwd);
        driver.findElement(Elements.RegisterMainCfmPwd).sendKeys(mainCfmPwd);
        driver.findElement(Elements.RegisterMainMobile).sendKeys(mobileNumber );
        driver.findElement(Elements.RegisterVcode).sendKeys(vCode);
        driver.findElement(Elements.RegisterMessageVcode).sendKeys(messageVcode);
        driver.findElement(Elements.RegisterButton).click();

    }
}
