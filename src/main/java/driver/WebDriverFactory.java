package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static utils.Waiter.WAIT_2_SECONDS;

public class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver getWebDriver() {
        WebDriver driver = null;
        switch (System.getProperty("browser", "chrome")) {
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver();
                driver = new EdgeDriver();
                break;
            }
            default: {
                try {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--incognito");
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(chromeOptions);
                } catch (Exception e) {
                    Log log = null;
                    log.fatal("Driver did not start!");
                }
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_2_SECONDS)); //будет ожидать элемент макс 2 секи
        return driver;
    }

}