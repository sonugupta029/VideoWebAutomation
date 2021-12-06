package com.testAutomation.screens

import com.testAutomation.core.BaseTestPage
import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver

/**
 * Description:
 *    POM for LatestFootballNewsScreen POM
 *    @author Sonu Gupta
 */

class LatestFootballNewsScreen(val webDriver: RemoteWebDriver) : BaseTestPage(webDriver) {
    private val defaultTimeOutInSeconds = 10
    private val latestArticleLink = By.xpath("//*[@id='foxsports_row_habitual-1638']/div[1]/div/div[1]/article/header/div[2]/h1/a")

    fun hasScreenLoaded(): Boolean {
        return isElementDisplayedAfterTimeout(latestArticleLink, defaultTimeOutInSeconds)
    }

    fun clickLatestArticleLink(): Boolean {
        if (isElementDisplayedAfterTimeout(latestArticleLink, defaultTimeOutInSeconds)) {
            click(latestArticleLink)
            return true
        } else {
            return false
        }
    }

}