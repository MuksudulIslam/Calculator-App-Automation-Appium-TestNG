import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTestRunner extends Setup {

    CalculatorScreen calculator;

    @Test(priority = 1, description = "Do Calculate The Series")
    public void doSeries(){
        calculator = new CalculatorScreen(driver);
        String actualResult = calculator.calculateSeries("100/10*5-10+60");
        Assert.assertEquals(actualResult,"100");

//        String actualresult = calculator.calculateSeries("50+10-20*2+10/2");
//        Assert.assertEquals(actualresult,"25");


    }

}
