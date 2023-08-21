package testsuites;


import luma.tests.AddNewReviewTest;
import luma.tests.CreateAccountTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses(value = {AddNewReviewTest.class, CreateAccountTest.class})
public class TestSuiteTest {
}
