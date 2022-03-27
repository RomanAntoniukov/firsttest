import org.apache.commons.io.FileUtils;
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
import org.testng.Assert;

import javax.lang.model.element.Element;
import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.Key;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.WebElement.*;




public class Main {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/roman/Desktop/My projects/roman/Applications/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://client.demo.crassu.la/");

        WebElement login = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname=\"username\"]")));
        login.sendKeys("r.antoniukov@crassula.io");

        WebElement password = driver.findElement(By.xpath("//input[@formcontrolname=\"password\"]"));
        password.sendKeys("v5W4msEpFq4V", Keys.ENTER);

        WebElement Payments = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/cl-main-menu/cl-panel/cl-main-menu-links/a[@routerlink='/payments']")));
        Payments.click();

        WebElement Tomyaccount = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/payments/between-my-accounts']")));
        Tomyaccount.click();
        WebElement Selectaccount = driver.findElement(By.cssSelector(".ng-select__wrap.select__with-icon.select--account.select--from-account"));
        Selectaccount.click();

        WebElement Findemacc = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), 'Financial Demo Account')] ")));
        Findemacc.click();

        WebElement Selectaccountto = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ng-select-custom.ng-select.ng-select-single.ng-untouched.ng-pristine.ng-valid")));
        Selectaccountto.click();

        WebElement accountto = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), 'test2')]")));
        accountto.click();

        WebElement amounttosend = driver.findElement(By.xpath("//input [@formcontrolname='amount']"));
        amounttosend.sendKeys("1", Keys.ENTER);

        WebElement Continue = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button [contains(text(), 'Continue')]")));
        Continue.click();

        WebElement Continueconfirm = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button [contains(text(), 'Continue')]")));
        Continueconfirm.click();

        WebElement confirm = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button [contains(text(), 'Confirm')]")));
        confirm.click();

        WebElement todashboard = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a [@class='btn btn--brand']")));
        todashboard.click();

        WebElement gotocheckinfo = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/cl-app/div/cl-main-layout/header/div[2]/div[1]/cl-main-menu/cl-panel/cl-main-menu-links/a[2]")));
        gotocheckinfo.click();

        WebElement clicktransaction = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("mat-row:nth-child(2)")));
        clicktransaction.click();

        WebElement remitteraccount = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(" div.transaction-details__info div:nth-child(7) div.transaction-details__info-value")));

        Assert.assertEquals(remitteraccount.getText(), "19771232931");

        WebElement benificiaryaccount = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(" div.transaction-details__info div:nth-child(9) div.transaction-details__info-value")));
        Assert.assertEquals(benificiaryaccount.getText(), "93149520673");

        WebElement amountsent = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("cl-transaction-details-dialog div mat-dialog-content div.summary div.summary__amount")));
        Assert.assertEquals(amountsent.getText(), "+1.00 EUR");

        WebElement download = driver.findElement(By.xpath("//div [@class='transaction-details']"));
        String s = download.getText();

        File f = new File("Report.csv");
        try{
            FileUtils.writeStringToFile(f, s, Charset.defaultCharset());
        }catch(IOException exc){
            exc.printStackTrace();
        }
        WebElement closewindow = driver.findElement(By.xpath("//button [@class='dialog-close']"));
        closewindow.click();

        WebElement logout = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div [@class='profile__name']")));
        logout.click();
        WebElement signout = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div [@class='label' and contains (text(), 'Sign out')]")));
        signout.click();


    }
}
