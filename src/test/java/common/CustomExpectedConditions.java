package common;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

public class CustomExpectedConditions {
    private CustomExpectedConditions(){

    }
    public static ExpectedCondition<Boolean> selectOptionSizeGreaterThan(final By locator, final int index) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    WebElement element = driver.findElement(locator);
                    return element.findElements(By.tagName("option")).size()>index;
                } catch (StaleElementReferenceException var3) {
                    return null;
                }
            }
            public String toString() {
                return String.format("select found by %s options size greater than %s", locator,index);
            }
        };
    }
    public static ExpectedCondition<Boolean> selectRefreshed(final By locator) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    Select select = new Select(driver.findElement(locator));
                    return select.getOptions().get(0).isSelected();
                } catch (StaleElementReferenceException var3) {
                    return null;
                }
            }
            public String toString() {
                return String.format("select found by %s options cleaned", locator);
            }
        };
    }
}
