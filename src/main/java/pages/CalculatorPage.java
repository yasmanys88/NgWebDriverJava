package pages;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorPage {
    WebDriver driver;
    NgWebDriver ngWebDriver;
    JavascriptExecutor jsDriver;

    ByAngularModel firstinput = ByAngular.model("first");
    ByAngularModel operator = ByAngular.model("operator");
    ByAngularModel secondinput = ByAngular.model("second");
    ByAngularButtonText button = ByAngular.buttonText("Go!");
    By result = By.tagName("h2");


    public CalculatorPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        jsDriver = (JavascriptExecutor) driver;
        ngWebDriver = new NgWebDriver(jsDriver);
        driver.get("http://localhost:3456/");
        ngWebDriver.waitForAngularRequestsToFinish();
    }

    public void doSum(String primerNo, String segundoNo) {
        driver.findElement(firstinput).sendKeys(primerNo);
        driver.findElement(operator).sendKeys("+");
        driver.findElement(secondinput).sendKeys(segundoNo);
        driver.findElement(button).click();
        ngWebDriver.waitForAngularRequestsToFinish();
        System.out.println(driver.findElement(result).getText());
    }

}
