package JUnitTestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import selenium.TestSuite1;
import selenium.TestSuite2;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestSuite1.class,
        TestSuite2.class
})

public class TestSuite {

}
