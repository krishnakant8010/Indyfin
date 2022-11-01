package Annotatuins;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
  @Test
  public void newtest1() {
	  System.out.println("this is my first test case 1");
  }
  
  @Test
  public void newtest2() {
	  System.out.println("this is my second test case 2");
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("this is my BeforeMethord test case");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("this is my afterMethod test case");
  }
 

  @BeforeClass
  public void beforeClass() {
	  System.out.println("this is my beforeClass test case");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("this is my afterClass test case");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("this is my beforeTest test case");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("this is my afterTest test case");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("this is my beforeSuite test case");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("this is my afterSuite test case");
  }

}
