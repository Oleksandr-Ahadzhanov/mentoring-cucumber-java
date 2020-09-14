import base_tests.BaseTestChrome;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resource/login"}
)

public class CheckLoginTest extends BaseTestChrome {

}
