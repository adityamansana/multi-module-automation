package com.api.actions;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.api.utilities.ConfigurationReader;

//@Singleton
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
  private static final String BASE_URL = ConfigurationReader.getInstance().getProperty("baseAPIUrl");

}
  
