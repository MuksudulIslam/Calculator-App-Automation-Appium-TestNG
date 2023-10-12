import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class Setup {
    AndroidDriver driver;

    @BeforeTest
    public AndroidDriver setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("platformVersion","12");
        caps.setCapability("appPackage","com.google.android.calculator");
        caps.setCapability("appActivity","com.android.calculator2.Calculator");
        caps.setCapability("app","d://Android APK//calculator.apk");
        caps.setCapability("automationName","UiAutomator2");

        URL url = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        return driver;
    }

    @AfterTest
    public void quitApp(){
        driver.quit();
    }
}
