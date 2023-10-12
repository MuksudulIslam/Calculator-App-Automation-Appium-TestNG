import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorScreen {
    @FindBy(id = "com.google.android.calculator:id/op_add")
    WebElement op_Plus;
    @FindBy(id = "com.google.android.calculator:id/op_sub")
    WebElement op_Minus;
    @FindBy(id = "com.google.android.calculator:id/op_mul")
    WebElement op_multi;
    @FindBy(id = "com.google.android.calculator:id/op_div")
    WebElement op_div;
    @FindBy(id = "com.google.android.calculator:id/eq")
    WebElement btn_equal;
    @FindBy(id = "com.google.android.calculator:id/clr")
    WebElement btn_clear;
    @FindBy(id = "com.google.android.calculator:id/result_final")
    WebElement final_Result;

    AndroidDriver driver;

    public CalculatorScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String calculateSeries(String series) {

        char[] ch = series.toCharArray();
        for (char d : ch) {
            if (Character.isDigit(d)) {
                driver.findElement(By.id("com.google.android.calculator:id/digit_" + d)).click();
            } else if (d == '+') {
                op_Plus.click();
            } else if (d == '-') {
                op_Minus.click();
            } else if (d == '*') {
                op_multi.click();
            } else if (d == '/') {
                op_div.click();
            }
        }

        btn_equal.click();
        return final_Result.getText();

    }
}
