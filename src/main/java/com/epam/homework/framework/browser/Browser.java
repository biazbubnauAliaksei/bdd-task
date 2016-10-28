package com.epam.homework.framework.browser;

import com.epam.homework.framework.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static com.epam.homework.framework.util.DriverTimeouts.EXPLICIT_WAIT;

public final class Browser implements WrapsDriver {
    private static Browser instance;
    private WebDriver driver;

    private Browser() {
        EventFiringWebDriver eventFiringDriver = new EventFiringWebDriver(WebDriverFactory.getInstance());
        this.driver = eventFiringDriver;
    }

    @Override
    public WebDriver getWrappedDriver() {
        return driver;
    }

    public Actions getActions() {
        return new Actions(Browser.getBrowser().getWrappedDriver());
    }

    public static synchronized Browser getBrowser() {
        if (instance == null) {
            instance = new Browser();
        }
        return instance;
    }

    public void close() {
        try {
            if (getWrappedDriver() != null) {
                getWrappedDriver().quit();
            }
        } finally {
            instance = null;
        }
    }

    public void open(String url) {
        driver.get(url);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public boolean isElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

    public boolean isElementVisible(By by) {
        if (!isElementPresent(by)) {
            return false;
        }
        return findElement(by).isDisplayed();
    }

    public void waitForElementIsVisible(By by) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(by);
        waitByRequiredCondition(condition);
    }

    public void waitForElementIsClickable(By by) {
        ExpectedCondition<WebElement> conditions = ExpectedConditions.elementToBeClickable(by);
        waitByRequiredCondition(conditions);
    }

    private void waitByRequiredCondition(ExpectedCondition<WebElement> conditions) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT.getValue());
        wait.until(conditions);
    }

    public void mooveToElement(By by) {
        Actions action = getActions();
        action.moveToElement((WebElement) by);
    }
}
