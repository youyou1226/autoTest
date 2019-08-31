package maven2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * TestNG注解
 * @author 61795
 *执行顺序：
 beforeSuite beforeTest beforeClass、 beforeMethod、test afterMethod  afterClass afterTest afterSuite
 */

public class TestNGZhuJie {
	//@BeforeSuite注解的方法，将会在testng定义的xml根元素里面的所有执行之前运行。
	@BeforeSuite
    public void beforeSuite() {
        System.out.println(this.getClass().getName() + " beforeSuite");
    }
	//@AfterSuite注解的方法，将会在testng定义的xml根元素里面的所有执行之后运行。
    @AfterSuite
    public void afterSuite() {
        System.out.println(this.getClass().getName() + " afterSuite");
    }
    //@BeforeTest注解的方法，将会在一个元素定义的所有里面所有测试方法执行之前运行。
    @BeforeTest
    public void beforeTest() {
        System.out.println(this.getClass().getName() + " beforeTest");
    }
    //@AfterTest注解的方法，将会在一个元素定义的所有里面所有的测试方法执行之后运行。
    @AfterTest
    public void afterTest() {
        System.out.println(this.getClass().getName() + " afterTest");
    }
 //@BeforeClass注解的方法，将会在当前测试类的第一个测试方法执行之前运行。
    @BeforeClass
    public void beforeClass() {
        System.out.println(this.getClass().getName() + " beforeClass");
    }
    //@AfterClass注解的方法，将会在当前测试类的最后一个测试方法执行之后运行。
    @AfterClass
    public void afterClass() {
        System.out.println(this.getClass().getName() + " afterClass");
    }
    //@BeforeMethod注解的方法，将会在当前测试类的每一个测试方法执行之前运行。
    @BeforeMethod 
    public void beofreMethod() {
        System.out.println(this.getClass().getName() + " beforeMethod");
    }
    //@AfterMethod注解的方法，将会在当前测试类的每一个测试方法执行之后运行。
    @AfterMethod
    public void afterMethod() {
        System.out.println(this.getClass().getName() + " afterMethod");
    }
 /**
  * 有两个测试方法test1(),test2();
  */
    @Test
    public void test2() {
        System.out.println(this.getClass().getName() + " test2");
    }
    @Test
    public void test1() {
        System.out.println(this.getClass().getName() + " test1");
    }
 
}
