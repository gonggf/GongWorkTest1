package demo.day1;


import org.testng.annotations.*;

/**
 * Created by thinkpad on 2016/12/19.
 */
public class TestCase {
     @Test
    public void btest1(){
         System.out.println("这是一个@Case !!!");
     }

     @BeforeTest
    public void test2() {
        System.out.println("这是一个@BeforeCase !!!");
     }
    @BeforeMethod
    public void test3() {
        System.out.println("这是一个@BeforeMethod !!!");
    }
    @Test
    public void ftest4(){
        System.out.println("这是一个@Case2 !!!");
    }
    @AfterTest
    public void test5(){
        System.out.println("这是一个@AfterTest !!!");
    }
    @AfterMethod
    public void test6(){
        System.out.println("这是一个@AfterMethod !!!");
    }

}

