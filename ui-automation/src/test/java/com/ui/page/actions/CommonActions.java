package com.ui.page.actions;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import javax.inject.Singleton;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ui.utilities.ConfigurationReader;

@Singleton
public class CommonActions<WebElement> {
//  @Inject
//  WebDriverProvider driverProvider;

//  @Inject
//  DbOperations dbO;

  private static final Logger LOGGER = LoggerFactory.getLogger(CommonActions.class);
  private static final int DRIVER_WAIT_TIME_IN_SECS_10 = 10;
  private static final int DRIVER_WAIT_TIME_IN_SECS_180 = 180;
  public static final String ERROR_MSG = "Some error has occurred while performing operation::{}";
  public static final int WAIT_3_SECS = 3000;
  public static final int DRIVER_WAIT_TIME_IN_SECS = 60;
  private static final String LOADER_XPATH = null;
  private static final String PROGRESS_LOADER_XPATH =null; 
  private static final String SEARCH_LOADER_XPATH = null;
  private static final String SPINNER_LOADER_LEGACY_XPATH =null; 
  private static final String LOADING_LEGACY_XPATH = null;
  public static final int LOADER_WAIT_TIME_IN_SECS = 60;
  public static final int PROGRESS_LOADER_WAIT_TIME_IN_SECS = 180;
  public static final int LOADER_LESSWAIT_TIME_IN_SECS = 15;
  private static final String BASE_URL = ConfigurationReader.getInstance().getProperty("baseUrl");

  
  public void switchToFrameUsingWebElement(WebElement element) {
	    try {
	      final WebDriverWait wait = new WebDriverWait(driverProvider.getInstance(), CommonActions.DRIVER_WAIT_TIME_IN_SECS_180);
	      wait.until(ExpectedConditions.visibilityOf(element));
	      driverProvider.getInstance().switchTo().frame(element);
	      LOGGER.info("user switched the iframe");
	    } catch (Exception e) {
	      LOGGER.error("some error has encountered while switching iframe", e);
	      fail();
	    }
	  }

	  /**
	   * ---------------------------Maximize Window------------------------------------------
	   */
	  public static void maximizeWindow(final WebDriver driver) {
	    driver.manage().window().maximize();
	  }

	  /**
	   * This method is to switch frame using Name or id
	   *
	   * @param value
	   */
	  public void switchToFrameUsingNameId(String value) {
	    for (int i = 0; i < 3; i++) {
	      try {
	        driverProvider.getInstance().switchTo().frame(value);
	        LOGGER.info("user switched the iframe");
	        break;
	      } catch (NoSuchFrameException e) {
	        if (i == 2) {
	          LOGGER.error("some error has encountered while switching iframe", e);
	          fail();
	        } else {
	          continue;
	        }
	      }
	    }
	  }

	  /**
	   * This method is to switch frame using index
	   *
	   * @param index
	   */
	  public void switchToFrameUsingIndex(int index) {
	    for (int i = 0; i < 3; i++) {
	      try {
	        driverProvider.getInstance().switchTo().frame(index);
	        LOGGER.info("user switched the iframe");
	        break;
	      } catch (NoSuchFrameException e) {
	        if (i == 2) {
	          LOGGER.error("some error has encountered while switching iframe", e);
	          fail();
	        } else {
	          continue;
	        }
	      }
	    }
	  }

	  /**
	   * This method is to switch to immediate parent frame
	   */
	  public void switchToParentFrame() {
	    driverProvider.getInstance().switchTo().parentFrame();
	    LOGGER.info("user switched to the parent frame");
	  }

	  /**
	   * This method is to switch to default parent
	   */
	  public void switchToDefaultFrame() {
	    try {
	      LOGGER.info("user switching to the default frame");
	      JavascriptExecutor executor = (JavascriptExecutor) driverProvider.getInstance();
	      executor.executeScript("window.focus();");
	      driverProvider.getInstance().switchTo().defaultContent();
	      LOGGER.info("user switched to the default frame");
	    } catch (Exception e) {
	      LOGGER.info("Error occurred while switching to default frane, thus switching to parent frame");
	      driverProvider.getInstance().switchTo().parentFrame();
	    }
	  }

	  /**
	   * This method is to select drop down value by visible text
	   *
	   * @param element
	   * @param text
	   */
	  public void selectValueInDropDownByText(WebElement element, String text) {
	    for (int i = 0; i < 3; i++) {
	      try {
	        final WebDriverWait wait = new WebDriverWait(driverProvider.getInstance(), CommonActions.DRIVER_WAIT_TIME_IN_SECS_180);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        Select select = new Select(element);
	        select.selectByVisibleText(text);
	        LOGGER.info("selected dropdown value : " + text);
	        break;
	      } catch (UnexpectedTagNameException | NoSuchElementException | TimeoutException | ElementNotInteractableException
	          | org.openqa.selenium.StaleElementReferenceException ele) {
	        LOGGER.error("some error has encountered while selecting drop down value", ele);
	        pauseExecutionFor(WAIT_3_SECS);
	        if (i == 2) {
	          fail();
	        }
	      }
	    }
	  }

	  /**
	   * This method is to select drop down value by value
	   *
	   * @param element
	   * @param text
	   */
	  public void selectValueInDropDownByValue(WebElement element, String text) {
	    for (int i = 0; i < 3; i++) {
	      try {
	        final WebDriverWait wait = new WebDriverWait(driverProvider.getInstance(), SeleniumUtil.DRIVER_WAIT_TIME_IN_SECS);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        Select select = new Select(element);
	        select.selectByValue(text);
	        LOGGER.info("selected dropdown value : " + text);
	        break;
	      } catch (UnexpectedTagNameException | NoSuchElementException | TimeoutException | ElementNotInteractableException
	          | org.openqa.selenium.StaleElementReferenceException ele) {
	        LOGGER.error("some error has encountered while selecting drop down value", ele);
	        pauseExecutionFor(WAIT_3_SECS);
	        if (i == 2) {
	          fail();
	        }
	      }
	    }
	  }

	  /**
	   * -------------------------------------------------------------------------------------------------------
	   * check visibility by element
	   */
	  public Boolean checkVisibilityByElementAndReturnFlag(final WebDriver driver, final WebElement webElement) {
	    Boolean isVisible = false;
	    final WebDriverWait driverWait = new WebDriverWait(driver, DRIVER_WAIT_TIME_IN_SECS_10);
	    try {
	      if (driverWait.until(ExpectedConditions.visibilityOf(webElement)) != null) {
	        SeleniumUtil.highLighterMethod(driver, webElement);
	        isVisible = true;
	      }
	    } catch (org.openqa.selenium.TimeoutException | NoSuchElementException ele) {
	      isVisible = false;
	    } catch (StaleElementReferenceException stale) {
	      LOGGER.info("Element is stale checking again");
	      WebElement element = reInitializeStaleElement(driver, webElement);
	      try {
	        if (driverWait.until(ExpectedConditions.visibilityOf(element)) != null) {
	          highLighterMethod(driver, webElement);
	          isVisible = true;
	        }
	      } catch (org.openqa.selenium.TimeoutException | NoSuchElementException ele) {
	        isVisible = false;
	      }
	    }
	    return isVisible;
	  }
	  
	  public static void tearDown() throws IOException {
		  Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T" );
	  }
  
}
