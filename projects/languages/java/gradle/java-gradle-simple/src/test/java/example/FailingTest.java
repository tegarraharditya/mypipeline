package example;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static org.testng.Assert.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
@Description("This is an example Failed Test")
public class FailingTest {
	
        @Title("Failing Test")
	@Test
	public void testAuthenticator() throws Exception {
	    assertEquals(1, 2);
	}
}
