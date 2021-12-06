package com.testAutomation.screens

import com.testAutomation.core.BaseTestPage
import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver

/**
 * Description:
 *    POM for Football screen
 *    @author Sonu Gupta
 */

class FootballScreen(val webDriver: RemoteWebDriver) : BaseTestPage(webDriver) {
    private val defaultTimeOutInSeconds = 10
    private val latestNewsLink = By.linkText("Latest News")

    fun hasScreenLoaded(): Boolean {
        return isElementDisplayedAfterTimeout(latestNewsLink, defaultTimeOutInSeconds)
    }


    fun clickLatestNewsLink(): Boolean {
        if (isElementDisplayedAfterTimeout(latestNewsLink, defaultTimeOutInSeconds)) {
            click(latestNewsLink)
            return true
        } else {
            return false
        }
    }

}