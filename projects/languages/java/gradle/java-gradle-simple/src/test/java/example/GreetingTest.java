package example;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import org.testng.annotations.Test;
@Description("This is a Description")
public class GreetingTest {
  
  @Title("Method A")
  @Test
  public void test() {
    new Greeting().coveredByUnitTest();
  }
  
  @Title("Method B")
  @Test
  public void testlagi(){
   new Greeting().notCoveredByUnitTest();
  }
}
