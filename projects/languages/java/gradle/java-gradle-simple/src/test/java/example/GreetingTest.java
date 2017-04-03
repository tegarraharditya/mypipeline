package example;

import org.junit.Test;

public class GreetingTest {
  @Test
  public void test() {
    new Greeting().coveredByUnitTest();
  }

  @Test
  public void testlagi(){
   new Greeting().notCoveredByUnitTest();
  }
}
