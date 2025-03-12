package demo.wrappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public static void enterText(ChromeDriver driver, By by, String text) {
        try {
            WebElement we = driver.findElement(by);
            we.click();
            we.clear();
            we.sendKeys(text);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void clickOnElement(ChromeDriver driver, By by) {
        try {
            WebElement we = driver.findElement(by);
            we.click();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void navigateToHomePage(ChromeDriver driver) throws InterruptedException {
        driver.get("http://www.flipkart.com/");
        Thread.sleep(2000);
        try {
            WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='JFPqaw']")));
            driver.findElement(By.xpath("//span[@role='button']")).click();
        } catch (Exception e) {
            // TODO: handle exception
            
        }

        
    }

    public static void selectRating(ChromeDriver driver, String ratingValue) {
        try {
            List<WebElement> ratings = driver.findElements(By.xpath("//div[contains(@title, 'above')]//div[contains(text(), 'above')]"));
            for(WebElement rating : ratings) {
                if(rating.getText().contains(ratingValue)) {
                    rating.findElement(By.xpath("./preceding-sibling::div")).click();
                    break;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
