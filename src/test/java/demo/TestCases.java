package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    static ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation.
     * Follow `testCase01` `testCase02`... format or what is provided in
     * instructions
     */

    /*
     * Do not change the provided methods unless necessary, they will help in
     * automation and assessment
     */
    @BeforeTest(alwaysRun = true)
    public void startBrowser() {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }

    @Test(enabled = true)
    public static void testCase01() throws InterruptedException {
        // navigate to homepage
        Wrappers.navigateToHomePage(driver);

        // Searching with washing machine
        Wrappers.enterText(driver, By.xpath("//input[@title='Search for Products, Brands and More']"),
                "Washing Machine");
        Wrappers.clickOnElement(driver, By.xpath("//button[@title='Search for Products, Brands and More']"));

        // Clicking on popularity
        Wrappers.clickOnElement(driver, By.xpath("//div[text()='Popularity']"));

        // get a list of ratings
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.xpath("//div[@class='_6NESgJ']/parent::div//div[@class='XQDdHH']"),
                        24));

        int count = 0;
        for (int i = 1; i <= 24; i++) {
            WebElement rating = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(
                            By.xpath("(//div[@class='_6NESgJ']/parent::div//div[@class='XQDdHH'])[" + i +
                                    "]")));
            if (Float.parseFloat(rating.getText().replace("\"", "")) <= 4) {
                count++;
            }
        }
        System.out.println("Number of products with rating less than or equal to 4 is --> " + count);
    }

    @Test(enabled = true)
    public static void testCase02() throws InterruptedException {

        // navigate to homepage
        Wrappers.navigateToHomePage(driver);

        // search for iphone
        Wrappers.enterText(driver, By.xpath("//input[@title='Search for Products, Brands and More']"),
                "iPhone");
        Wrappers.clickOnElement(driver, By.xpath("//button[@title='Search for Products, Brands and More']"));

        // get the ratings
        List<WebElement> iphoneRatingElements = driver
                .findElements(By.xpath("//div[@class='_75nlfW']//div[@class='UkUFwK']/span"));

        System.out.println("Titles and discount % of items with more than 17% discount --> ");
        for (WebElement iphoneRatingElement : iphoneRatingElements) {
            if (Integer.parseInt(iphoneRatingElement.getText().replace("% off", "")) > 17) {
                String title = iphoneRatingElement.findElement(By.xpath(
                        "./parent::div/parent::div/parent::div/parent::div/preceding-sibling::div/div[@class='KzDlHZ']"))
                        .getText();
                int discount = Integer.parseInt(iphoneRatingElement.getText().replace("% off", ""));
                System.out.println("Title --> " + title);
                System.out.println("Discount --> " + discount);
                System.out.println();
            }
        }

    }

    @Test(enabled = true)
    public static void testCase03() throws InterruptedException {
        // navigate to homepage
        Wrappers.navigateToHomePage(driver);

        // search for Coffee Mug
        Wrappers.enterText(driver, By.xpath("//input[@title='Search for Products, Brands and More']"),
                "Coffee Mug");
        Wrappers.clickOnElement(driver, By.xpath("//button[@title='Search for Products, Brands and More']"));

        // select the rating 4 and above
        Wrappers.selectRating(driver, "4");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[text()='Customer Ratings']/parent::div/following-sibling::div//span[text()='Clear all']")));


        // get list of user ratings
        List<WebElement> userRatingElements = driver.findElements(
                By.xpath("//div[@class='DOjaWF gdgoEp']/div[not(contains(@style, ' '))]//span[@class='Wphh3N']"));
        int[] userRatingIntegers = new int[userRatingElements.size()];
        for (int i = 0; i < userRatingElements.size(); i++) {
            userRatingIntegers[i] = Integer
                    .parseInt(userRatingElements.get(i).getText().replace("(", "").replace(")", "").replace(",", ""));
        }

        Arrays.sort(userRatingIntegers);

        for (int j = userRatingIntegers.length - 1; j >= userRatingIntegers.length - 6; j--) {
            int currentRatingIntegerValue = userRatingIntegers[j];
            for (WebElement userRatingElement : userRatingElements) {
                int webRatingIntegerValue = Integer
                        .parseInt(userRatingElement.getText().replace("(", "").replace(")", "").replace(",", ""));
                if (currentRatingIntegerValue == webRatingIntegerValue) {
                    String prodName = userRatingElement
                            .findElement(By.xpath("./parent::div/preceding-sibling::a[@class='wjcEIp']")).getText();
                    String imageUrl = userRatingElement
                            .findElement(By.xpath("./parent::div/preceding-sibling::a[@class='VJA3rP']"))
                            .getAttribute("href");
                    System.out.println("Product name --> " + prodName);
                    System.out.println("Image url --> " + imageUrl);
                    System.out.println();
                    break;
                }
            }
        }

    }

    @AfterTest
    public void endTest() {
        driver.close();
        driver.quit();

    }
}