package com.testAutomation.screens

import com.testAutomation.core.BaseTestPage
import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver

/**
 * Description:
 *    POM for Dashboard screen
 *    @author Sonu Gupta
 */

class DashboardScreen(webDriver: RemoteWebDriver) : BaseTestPage(webDriver) {
    private val defaultTimeOutInSeconds = 10
    private val videoLink = By.linkText("Video")
    private val footballLink = By.linkText("Football")

    fun hasScreenLoaded(): Boolean {
        return isElementDisplayedAfterTimeout(videoLink, defaultTimeOutInSeconds)
    }

    fun clickVideoLink(): Boolean {
        if (isElementDisplayedAfterTimeout(videoLink, defaultTimeOutInSeconds)) {
            click(videoLink)
            return true
        } else {
            return false
        }
    }

    fun clickFootballLink(): Boolean {
        if (isElementDisplayedAfterTimeout(footballLink, defaultTimeOutInSeconds)) {
            click(footballLink)
            return true
        } else {
            return false
        }
    }

}