package Parameters;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

@RunWith(Parameterized.class)

public class TestParameters {
    private Selenium selenium;
    private String browser;

    public TestParameters(String browser){
        super();
        this.browser = browser;
    }

    @Parameters
    public static Collection browsersStrings(){
        return Arrays.asList(new Object[][] { {"*firefox"}, {"*googlechrome"} });
    }

    @Before
    public void setUp() throws Exception {
        selenium = new DefaultSelenium("localhost", 4444, this.browser, "http://localhost:3000");
        selenium.start();
        selenium.setTimeout("90000");
        selenium.windowMaximize();
    }

    @Test
    public void testSauce() throws Exception {
        this.selenium.open("/");
        assertEquals("Cross browser testing with Selenium - Sauce Labs", this.selenium.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}

