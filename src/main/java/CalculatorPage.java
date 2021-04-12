import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

class CalculatorPage
{
    private final MobileElement inputFieldLeft;
    private final MobileElement inputFieldRight;
    private final MobileElement additionButton;
    private final MobileElement subtractButton;
    private final MobileElement multiplicationButton;
    private final MobileElement divisionButton;
    private final MobileElement resetButton;
    private final MobileElement resultTextView;

    public CalculatorPage(AndroidDriver<MobileElement> driver)
    {
        inputFieldLeft = driver.findElementsById("com.vbanthia.androidsampleapp:id/inputFieldLeft").get(0);
        inputFieldRight = driver.findElementsById("com.vbanthia.androidsampleapp:id/inputFieldRight").get(0);
        additionButton = driver.findElementsById("com.vbanthia.androidsampleapp:id/additionButton").get(0);
        subtractButton = driver.findElementsById("com.vbanthia.androidsampleapp:id/subtractButton").get(0);
        multiplicationButton = driver.findElementsById("com.vbanthia.androidsampleapp:id/multiplicationButton").get(0);
        divisionButton = driver.findElementsById("com.vbanthia.androidsampleapp:id/divisionButton").get(0);
        resetButton = driver.findElementsById("com.vbanthia.androidsampleapp:id/resetButton").get(0);
        resultTextView = driver.findElementsById("com.vbanthia.androidsampleapp:id/resultTextView").get(0);
    }

    public String getResultTextView()
    {
        return resultTextView.getText();
    }
    public String getInputFieldLeft()
    {
        return inputFieldLeft.getText();
    }
    public String getInputFieldRight()
    {
        return inputFieldRight.getText();
    }

    public void setInputFieldLeft(String value)
    {
        this.inputFieldLeft.setValue(value);
    }
    public void setInputFieldRight(String value)
    {
        this.inputFieldRight.setValue(value);
    }

    public void clickAddButton()
    {
        additionButton.click();
    }
    public void clickSubButton()
    {
        subtractButton.click();
    }
    public void clickDivButton()
    {
        divisionButton.click();
    }
    public void clickMulButton()
    {
        multiplicationButton.click();
    }
    public void clickResetButton()
    {
        resetButton.click();
    }

}