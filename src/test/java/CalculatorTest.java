import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import java.text.DecimalFormat;

public class CalculatorTest
{


    private CalculatorPage calc;
    private AndroidDriver<MobileElement> driver;

    @BeforeSuite()
    private void initDriver() throws MalformedURLException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "nexus");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("appPackage", "com.vbanthia.androidsampleapp");
        capabilities.setCapability("appActivity", "com.vbanthia.androidsampleapp.MainActivity");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        calc = new CalculatorPage(driver);
    }


    @Test(priority = 1, description = "testing addition with random small positive numbers", invocationCount = 3)
    private void test1_1()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(10) + 1;
        int secondNumber = random.nextInt(10) + 1;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));
        calc.clickAddButton();

        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 + " + secondNumber + ".00 = " + (firstNumber + secondNumber) + ".00");
    }

    @Test(priority = 1, description = "testing addition with random small negative numbers", invocationCount = 3)
    private void test1_2()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(10) - 10;
        int secondNumber = random.nextInt(10) - 10;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));
        calc.clickAddButton();

        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 + " + secondNumber + ".00 = " + (firstNumber + secondNumber) + ".00");
    }

    @Test(priority = 2, description = "testing subtract with random small positive numbers", invocationCount = 3)
    private void test2_1()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(10) + 1;
        int secondNumber = random.nextInt(10) + 1;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));
        calc.clickSubButton();

        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 - " + secondNumber + ".00 = " + (firstNumber - secondNumber) + ".00");
    }

    @Test(priority = 2, description = "testing subtract with random small negative numbers", invocationCount = 3)
    private void test2_2()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(10) - 10;
        int secondNumber = random.nextInt(10) - 10;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));
        calc.clickSubButton();

        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 - " + secondNumber + ".00 = " + (firstNumber - secondNumber) + ".00");
    }

    @Test(priority = 3, description = "testing multiplication with random small positive numbers", invocationCount = 3)
    private void test3_1()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(10) + 1;
        int secondNumber = random.nextInt(10) + 1;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));
        calc.clickMulButton();

        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 * " + secondNumber + ".00 = " + (firstNumber * secondNumber) + ".00");
    }

    @Test(priority = 3, description = "testing multiplication with random small negative numbers", invocationCount = 3)
    private void test3_2()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(10) - 10;
        int secondNumber = random.nextInt(10) - 10;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));
        calc.clickMulButton();

        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 * " + secondNumber + ".00 = " + (firstNumber * secondNumber) + ".00");
    }

    @Test(priority = 4, description = "testing division with random small positive numbers", invocationCount = 3)
    private void test4_1()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(10) + 1;
        int secondNumber = random.nextInt(10) + 1;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));
        calc.clickDivButton();

        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 / " + secondNumber + ".00 = " + new DecimalFormat("#0.00").format((double)firstNumber / secondNumber).replace(',', '.'));
    }

    @Test(priority = 4, description = "testing division with random small negative numbers", invocationCount = 3)
    private void test4_2()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(10) - 10;
        int secondNumber = random.nextInt(10) - 10;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));
        calc.clickDivButton();

        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 / " + secondNumber + ".00 = " + new DecimalFormat("#0.00").format((double)firstNumber / secondNumber).replace(',', '.'));
    }

    @Test(priority = 5, description = "testing reset button", invocationCount = 3)
    private void test5_1()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(201) - 100;
        int secondNumber = random.nextInt(201) - 100;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));
        calc.clickResetButton();

        Assert.assertEquals(calc.getInputFieldLeft(), "");
        Assert.assertEquals(calc.getInputFieldRight(), "");
    }

    @Test(priority = 5, description = "testing large numbers")
    private void test5_21()
    {
        double firstNumber = 1000000000000000000L;
        double secondNumber = 1;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));
        calc.clickAddButton();

        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 + " + secondNumber + ".00 = " + (firstNumber + secondNumber) + ".00");
    }

    @Test(priority = 5, description = "testing large numbers")
    private void test5_22()
    {
        double firstNumber = 1;
        double secondNumber = 1000000000000000000L;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));
        calc.clickAddButton();

        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 + " + secondNumber + ".00 = " + (firstNumber + secondNumber) + ".00");
    }

    @Test(priority = 6, description = "division by zero")
    private void test6()
    {
        int firstNumber, secondNumber;
        firstNumber = secondNumber = 0;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));
        calc.clickDivButton();

        Assert.assertEquals(calc.getResultTextView(), "0.00 / 0.00 = NaN");
    }

    @Test(priority = 7, description = "testing addition on random medium positive numbers", invocationCount = 3)
    private void test7_11()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(990) + 10;
        int secondNumber = random.nextInt(990) + 10;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickAddButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 + " + secondNumber + ".00 = " + (firstNumber + secondNumber) + ".00");
    }

    @Test(priority = 7, description = "testing subtract on random medium positive numbers", invocationCount = 3)
    private void test7_12()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(990) + 10;
        int secondNumber = random.nextInt(990) + 10;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickSubButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 - " + secondNumber + ".00 = " + (firstNumber - secondNumber) + ".00");
    }

    @Test(priority = 7, description = "testing multiplication on random medium positive numbers", invocationCount = 3)
    private void test7_13()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(990) + 10;
        int secondNumber = random.nextInt(990) + 10;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickMulButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 * " + secondNumber + ".00 = " + (firstNumber * secondNumber) + ".00");
    }

    @Test(priority = 7, description = "testing division on random medium positive numbers", invocationCount = 3)
    private void test7_14()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(990) + 10;
        int secondNumber = random.nextInt(990) + 10;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickDivButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 / " + secondNumber + ".00 = " + new DecimalFormat("#0.00").format((double)firstNumber / secondNumber).replace(',', '.'));
    }

    @Test(priority = 7, description = "testing addition on random medium negative numbers", invocationCount = 3)
    private void test7_21()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(990) - 1000;
        int secondNumber = random.nextInt(990) - 1000;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickAddButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 + " + secondNumber + ".00 = " + (firstNumber + secondNumber) + ".00");
    }

    @Test(priority = 7, description = "testing subtract on random medium negative numbers", invocationCount = 3)
    private void test7_22()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(990) - 1000;
        int secondNumber = random.nextInt(990) - 1000;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickSubButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 - " + secondNumber + ".00 = " + (firstNumber - secondNumber) + ".00");
    }

    @Test(priority = 7, description = "testing multiplication on random medium negative numbers", invocationCount = 3)
    private void test7_23()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(990) - 1000;
        int secondNumber = random.nextInt(990) - 1000;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        
        calc.clickMulButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 * " + secondNumber + ".00 = " + (firstNumber * secondNumber) + ".00");
    }

    @Test(priority = 7, description = "testing division on random medium negative numbers", invocationCount = 3)
    private void test7_24()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(990) - 1000;
        int secondNumber = random.nextInt(990) - 1000;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickDivButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 / " + secondNumber + ".00 = " + new DecimalFormat("#0.00").format((double)firstNumber / secondNumber).replace(',', '.'));
    }

    @Test(priority = 8, description = "testing addition on random large positive numbers")
    private void test8_11()
    {
        double firstNumber = 10000000000000L;
        double secondNumber = 10000000000000L;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickAddButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 + " + secondNumber + ".00 = " + (firstNumber + secondNumber) + ".00");
    }

    @Test(priority = 8, description = "testing subtract on random large positive numbers")
    private void test8_12()
    {
        double firstNumber = 10000000000000L;
        double secondNumber = 10000000000000L;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickSubButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 - " + secondNumber + ".00 = " + (firstNumber - secondNumber) + ".00");
    }

    @Test(priority = 8, description = "testing multiplication on random large positive numbers")
    private void test8_13()
    {
        double firstNumber = 10000000000000L;
        double secondNumber = 10000000000000L;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickMulButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 * " + secondNumber + ".00 = " + (firstNumber * secondNumber) + ".00");
    }

    @Test(priority = 8, description = "testing division on random large positive numbers")
    private void test8_14()
    {
        double firstNumber = 10000000000000L;
        double secondNumber = 10000000000000L;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickDivButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 / " + secondNumber + ".00 = " + new DecimalFormat("#0.00").format((double)firstNumber / secondNumber).replace(',', '.'));
    }

    @Test(priority = 8, description = "testing addition on random large negative numbers")
    private void test8_21()
    {
        double firstNumber = -10000000000000L;
        double secondNumber = -10000000000000L;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickAddButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 + " + secondNumber + ".00 = " + (firstNumber + secondNumber) + ".00");
    }

    @Test(priority = 8, description = "testing subtract on random large negative numbers")
    private void test8_22()
    {
        double firstNumber = -10000000000000L;
        double secondNumber = -10000000000000L;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickSubButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 - " + secondNumber + ".00 = " + (firstNumber - secondNumber) + ".00");
    }

    @Test(priority = 8, description = "testing multiplication on random large negative numbers")
    private void test8_23()
    {
        double firstNumber = -10000000000000L;
        double secondNumber = -10000000000000L;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickMulButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 * " + secondNumber + ".00 = " + (firstNumber * secondNumber) + ".00");
    }

    @Test(priority = 8, description = "testing division on random large negative numbers")
    private void test8_24()
    {
        double firstNumber = -10000000000000L;
        double secondNumber = -10000000000000L;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickDivButton();
        Assert.assertEquals(calc.getResultTextView(), firstNumber + ".00 / " + secondNumber + ".00 = " + new DecimalFormat("#0.00").format((double)firstNumber / secondNumber).replace(',', '.'));
    }

    @Test(priority = 9, description = "testing zero values")
    private void test9_1()
    {
        int firstNumber = 0;
        int secondNumber = 0;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickAddButton();
        Assert.assertEquals(calc.getResultTextView(), "0.00 + 0.00 = 0.00");
    }

    @Test(priority = 9, description = "testing zero values")
    private void test9_2()
    {
        int firstNumber = 0;
        int secondNumber = 0;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickSubButton();
        Assert.assertEquals(calc.getResultTextView(), "0.00 - 0.00 = 0.00");
    }

    @Test(priority = 9, description = "testing zero values")
    private void test9_3()
    {
        int firstNumber = 0;
        int secondNumber = 0;

        calc.setInputFieldLeft(String.valueOf(firstNumber));
        calc.setInputFieldRight(String.valueOf(secondNumber));

        calc.clickMulButton();
        Assert.assertEquals(calc.getResultTextView(), "0.00 * 0.00 = 0.00");
    }

    @Test(priority = 10, description = "empty fields")
    private void test10_1()
    {
        calc.clickResetButton();
        calc.clickAddButton();
        Assert.assertEquals(calc.getResultTextView(), "Please, fill the input fields correctly");
    }

    @Test(priority = 10, description = "empty fields")
    private void test10_2()
    {
        calc.clickResetButton();
        calc.clickSubButton();
        Assert.assertEquals(calc.getResultTextView(), "Please, fill the input fields correctly");
    }

    @Test(priority = 10, description = "empty fields")
    private void test10_3()
    {
        calc.clickResetButton();
        calc.clickMulButton();
        Assert.assertEquals(calc.getResultTextView(), "Please, fill the input fields correctly");
    }

    @Test(priority = 10, description = "empty fields")
    private void test10_4()
    {
        calc.clickResetButton();
        calc.clickDivButton();
        Assert.assertEquals(calc.getResultTextView(), "Please, fill the input fields correctly");
    }

    @Test(priority = 11, description = "invalid fields")
    private void test11_1()
    {
        String firstNumber = "A";
        String secondNumber = "1";

        calc.setInputFieldLeft(firstNumber);
        calc.setInputFieldRight(secondNumber);

        calc.clickAddButton();
        Assert.assertEquals(calc.getResultTextView(), "Please, fill the input fields correctly");
    }

    @Test(priority = 11, description = "invalid fields")
    private void test11_2()
    {
        String firstNumber = "1";
        String secondNumber = "A";

        calc.setInputFieldLeft(firstNumber);
        calc.setInputFieldRight(secondNumber);

        calc.clickAddButton();
        Assert.assertEquals(calc.getResultTextView(), "Please, fill the input fields correctly");
    }

    @Test(priority = 12, description = "real numbers")
    private void test12_1()
    {
        String firstNumber = "5.12";
        String secondNumber = "7.95";

        calc.setInputFieldLeft(firstNumber);
        calc.setInputFieldRight(secondNumber);

        calc.clickAddButton();
        Assert.assertEquals(calc.getResultTextView(), "5.12 + 7.95 = 13.07");
    }

    @Test(priority = 12, description = "real numbers")
    private void test12_2()
    {
        String firstNumber = "5.12";
        String secondNumber = "7.95";

        calc.setInputFieldLeft(firstNumber);
        calc.setInputFieldRight(secondNumber);

        calc.clickSubButton();
        Assert.assertEquals(calc.getResultTextView(), "5.12 - 7.95 = -2.83");
    }

    @Test(priority = 12, description = "real numbers")
    private void test12_3()
    {
        String firstNumber = "5.12";
        String secondNumber = "7.95";

        calc.setInputFieldLeft(firstNumber);
        calc.setInputFieldRight(secondNumber);

        calc.clickMulButton();
        Assert.assertEquals(calc.getResultTextView(), "5.12 * 7.95 = 40.70");
    }

    @Test(priority = 12, description = "real numbers")
    private void test12_4()
    {
        String firstNumber = "5.12";
        String secondNumber = "7.95";

        calc.setInputFieldLeft(firstNumber);
        calc.setInputFieldRight(secondNumber);

        calc.clickDivButton();
        Assert.assertEquals(calc.getResultTextView(), "5.12 / 7.95 = 0.64");
    }

    @Test(priority = 13, description = "real negative numbers")
    private void test13_1()
    {
        String firstNumber = "-5.12";
        String secondNumber = "-7.95";

        calc.setInputFieldLeft(firstNumber);
        calc.setInputFieldRight(secondNumber);

        calc.clickAddButton();
        Assert.assertEquals(calc.getResultTextView(), "-5.12 + -7.95 = -13.07");
    }

    @Test(priority = 13, description = "real negative numbers")
    private void test13_2()
    {
        String firstNumber = "-5.12";
        String secondNumber = "-7.95";

        calc.setInputFieldLeft(firstNumber);
        calc.setInputFieldRight(secondNumber);

        calc.clickSubButton();
        Assert.assertEquals(calc.getResultTextView(), "-5.12 - -7.95 = 2.83");
    }

    @Test(priority = 13, description = "real negative numbers")
    private void test13_3()
    {
        String firstNumber = "-5.12";
        String secondNumber = "-7.95";

        calc.setInputFieldLeft(firstNumber);
        calc.setInputFieldRight(secondNumber);

        calc.clickMulButton();
        Assert.assertEquals(calc.getResultTextView(), "-5.12 * -7.95 = 40.70");
    }

    @Test(priority = 13, description = "real negative numbers")
    private void test13_4()
    {
        String firstNumber = "-5.12";
        String secondNumber = "-7.95";

        calc.setInputFieldLeft(firstNumber);
        calc.setInputFieldRight(secondNumber);

        calc.clickDivButton();
        Assert.assertEquals(calc.getResultTextView(), "-5.12 / -7.95 = 0.64");
    }

    @AfterMethod()
    private void resetting()
    {
        calc.clickResetButton();
    }

    @AfterSuite()
    private void close() throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(1);
        driver.quit();
    }
}