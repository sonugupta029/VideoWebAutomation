package com.testAutomation.core

import com.testAutomation.utils.HtmlReporter
import com.testAutomation.utils.ProjectConstants
import org.apache.log4j.Logger
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.RemoteWebDriver
import org.testng.ITestContext
import org.testng.annotations.*
import java.lang.Exception

/**
 * Description:
 *    Driver class
 *    @author Sonu Gupta
 */

open class BaseTestScript {
    private val logger: Logger = Logger.getLogger("BaseTestScript")
    var webDriver: RemoteWebDriver? =null

    @BeforeSuite
    fun beforeSuite(){
        logger.info("In before suite")

    }

    @BeforeClass
    fun beforeClass(iTestContext: ITestContext) {
        logger.info("beforeClass")
        val browserType: String = iTestContext.currentXmlTest.getParameter("device")
        when (browserType.toUpperCase()) {
            "CHROME" -> getChromeDriver()
        }
    }

    private fun getChromeDriver() {
        print("inside chrome driver initialisation")
        try{
            val chromeOptions = ChromeOptions()
            System.setProperty("webdriver.chrome.driver", ProjectConstants.CHROMEDRIVER_PATH)
            webDriver = ChromeDriver(chromeOptions)
        }
        catch (exception: Exception){
            logger.info("unable to start webdriver")
        }
    }


    @AfterMethod
    fun afterMethod() {
        logger.info("afterMethod")
        HtmlReporter.extentReports.flush()
    }

    @AfterClass
    fun afterClass() {
        logger.info("afterClass")
        webDriver?.close()
    }

}