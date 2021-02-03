package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CalculatorPage;

public class CalculatorTest {
CalculatorPage calculator;
    @BeforeTest
    public void setup(){
        calculator= new CalculatorPage();
    }
    @Test
    public void suma(){
        calculator.doSum("2", "3");
    }

}
