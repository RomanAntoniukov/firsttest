import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import javax.print.DocFlavor;
import java.security.Key;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.WebElement.*;

public class Main {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/roman/Desktop/My projects/roman/Applications/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://client.demo.crassu.la/");

        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname=\"username\"]")));
        element.sendKeys("r.antoniukov@crassula.io");
        element = driver.findElement(By.xpath("//input[@formcontrolname=\"password\"]"));
        element.sendKeys("v5W4msEpFq4V", Keys.ENTER);
        WebElement payments = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/cl-app/div/cl-main-layout/header/div[2]/div[1]/cl-main-menu/cl-panel/cl-main-menu-links/a[2]")));
        payments.click();
        WebElement transfer = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/cl-app/div/cl-main-layout/cl-payments-layout/div/cl-secondary-menu/cl-panel/cl-tab-nav-bar/a[3]")));
                transfer.click();
        WebElement selectcurrency = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/cl-app/div/cl-main-layout/cl-payments-layout/cl-self-transfer/cl-panel/cl-panel-body/div/div/div[2]/form/div[2]/ng-select/div/span")));
        selectcurrency.click();
        WebElement selectaccount = driver.findElement(By.xpath("/html/body/cl-app/div/cl-main-layout/cl-payments-layout/cl-self-transfer/cl-panel/cl-panel-body/div/div/div[2]/form/div[2]/ng-select/div/div"));
        selectaccount.click();
        selectaccount.click();
        WebElement accountfrom = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/cl-app/div/cl-main-layout/cl-payments-layout/cl-self-transfer/cl-panel/cl-panel-body/div/div/div[2]/form/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div[5]/div/div[2]/div[1]")));
        accountfrom.click();
        WebElement ammountsend = driver.findElement(By.xpath("//input[@formcontrolname=\"amount\"]"));
        ammountsend.sendKeys("1");
        WebElement continuebutton = driver.findElement(By.xpath("//button[text()=\"Continue\"]"));
        continuebutton.click();
        WebElement continuebutton1 = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=\"Continue\"]")));
                continuebutton1.click();
        WebElement continuebutton3 = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=\"Continue\"]")));
        continuebutton3.click();
        WebElement confirmbutton = driver.findElement(By.xpath("//button[text()=\"Confirm\"]"));
        confirmbutton.click();
        WebElement todashboard = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mat-dialog-0\"]/cl-transfer-completed-dialog/mat-dialog-content/a[1]")));
        todashboard.click();
        WebElement payment1 = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/cl-app/div/cl-main-layout/header/div[2]/div[1]/cl-main-menu/cl-panel/cl-main-menu-links/a[2]")));
        payment1.click();
        WebElement check = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/cl-app/div/cl-main-layout/cl-payments-layout/cl-payment-history/cl-panel/cl-panel-body/div/mat-table/mat-row[1]/mat-cell[7]/button")));
        check.click();
        String accountRemitter = driver.findElement(By.xpath("//div[@class=\"transaction-details__info-value\" and contains(text(), '1977')]")).getText();
        String accountBenificiary = driver.findElement(By.xpath("//div[@class=\"transaction-details__info-value\" and contains(text(), '633')]")).getText();
        String sentamount = driver.findElement(By.xpath("//div[@class=\"summary__amount\" and contains(text(), 'EUR')]")).getText();
        try {
            if(accountRemitter.equalsIgnoreCase("19771232931"))
            {
                System.out.println("true");
            }
            if(accountBenificiary.equalsIgnoreCase("63329315731"))
            {
                System.out.println("true");
            }
            if(sentamount.equalsIgnoreCase("+1.00 EUR"))
            {
                System.out.println("true");
            }
        }
        catch(Exception e) {
            System.out.println("false");
        }
        WebElement closewindow = driver.findElement(By.xpath("//button [@class=\"dialog-close\"]"));
        closewindow.click();
        WebElement download = driver.findElement(By.xpath("/html/body/cl-app/div/cl-main-layout/cl-payments-layout/cl-payment-history/cl-panel/div/div[2]/div[4]/button/span[1]/mat-icon"));
        download.click();
        WebElement xls = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span [@class=\"select-option--title\" and contains (text(), 'Save as XLS')]")));
        xls.click();
        WebElement logout = driver.findElement(By.xpath("//div [@class=\"profile__name\"]"));
        logout.click();
        WebElement signout = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div [@class=\"label\" and contains (text(), 'Sign out')]")));
        signout.click();
    }
}