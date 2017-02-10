package demo.day2;



import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by thinkpad on 2016/12/20.
 */
public class AssertTest {
    @Test
    public void assertEquals(){
        String a = "abcd";
        String b = "abcd";
        Assert.assertEquals(a,b);
    }
    @Test
    public void assertNotEquals(){
        String a = "1";
        String b = "1";
       Assert.assertNotEquals(a,b,"a 等于 b!");
    }
    @Test
    public void testNoNull(){
        String a = null;
        Assert.assertNotNull(a,"A 为空");
    }
    @Test
    public void testNull(){
        String a = "1";
        Assert.assertNull(a,"A 不为空");
    }
}
