package Day1Test;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by GGF on 2016/12/11.
 *  TestNg校验方式
 * 1.相等
 * 2.不等
 * 3.空
 * 4.不空
 * 5.boolean类型
 */
public class TngVerifcationMode {

    @Test
    public void equalTest(){
        String a="1234";
        String b="1234";
        System.out.println("当前a等于："+a);
        System.out.println("当前b等于："+b);
        //相等
        Assert.assertEquals(a,b,"a和b必须要相等");
    }
    @Test
    public void noEqualTest(){
        String a="今天是周日";
        int b=1234;
        System.out.println("当前a等于："+a);
        System.out.println("当前b等于："+b);
        //不等
        Assert.assertNotEquals(a,b,"a和b必须要不相等");
    }
    @Test
    public void nullTest(){
        String a =null;
        System.out.print("当前a等于"+a);
        //为空
        Assert.assertNull(a,"a必须是个空值");
    }
    @Test
    public void noNullTest(){
        String a="今天是周日";
        System.out.print("当前a等于"+a);
        //不为空
        Assert.assertNotNull(a,"a不能为空值");
    }
    @Test
    public void boolTest(){
        boolean t=true;
        System.out.print("t的值为："+t);
        //boolean类型
        Assert.assertTrue(t,"t是boolean类型值");
    }
}
