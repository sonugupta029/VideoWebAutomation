package com.testAutomation.screens

import com.testAutomation.core.BaseTestPage
import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver

/**
 * Description:
 *    POM for LatestFootballArticleScreen POM
 *    @author Sonu Gupta
 */

class LatestFootballArticleScreen(val webDriver: RemoteWebDriver) : BaseTestPage(webDriver) {
    private val defaultTimeOutInSeconds = 10
    private val heroImage = By.xpath("/html/body/div[1]/div")
    private val latestArticleNewsTitle = By.xpath("/html/body/div[2]/article/h1")
    private val latestArticleNewsDescriptionPart1 = By.xpath("/html/body/div[2]/article/div[4]/p[1]")
    private val latestArticleNewsDescriptionPart2 = By.xpath("/html/body/div[2]/article/div[4]/p[2]")
    private val latestArticleNewsDescriptionPart3 = By.xpath("/html/body/div[2]/article/div[4]/p[3]")


    fun hasScreenLoaded(): Boolean {
        return isElementDisplayedAfterTimeout(latestArticleNewsTitle, defaultTimeOutInSeconds)
    }

    fun checkHeroImageIsDisplayed(): Boolean {
        return isElementDisplayedAfterTimeout(heroImage, defaultTimeOutInSeconds)
    }

    fun getLatestArticleTitle(): String? {
        var actualText: String? = null
        if (isElementDisplayedAfterTimeout(latestArticleNewsTitle, defaultTimeOutInSeconds)) {
            actualText = getLabelText(latestArticleNewsTitle)
        }
        logger.info("label for actual text  is $actualText")
        return actualText
    }

    fun getLatestArticleDescriptionPart1(): String? {
        swipeTo(0,500)
        var actualText: String? = null
        if (isElementDisplayedAfterTimeout(latestArticleNewsDescriptionPart1, defaultTimeOutInSeconds)) {
            actualText = getLabelText(latestArticleNewsDescriptionPart1)
        }
        logger.info("label for actual text  is $actualText")
        return actualText
    }

    fun getLatestArticleDescriptionPart2(): String? {
        var actualText: String? = null
        if (isElementDisplayedAfterTimeout(latestArticleNewsDescriptionPart2, defaultTimeOutInSeconds)) {
            actualText = getLabelText(latestArticleNewsDescriptionPart2)
        }
        logger.info("label for actual text  is $actualText")
        return actualText
    }

    fun getLatestArticleDescriptionPart3(): String? {
        var actualText: String? = null
        if (isElementDisplayedAfterTimeout(latestArticleNewsDescriptionPart3, defaultTimeOutInSeconds)) {
            actualText = getLabelText(latestArticleNewsDescriptionPart3)
        }
        logger.info("label for actual text  is $actualText")
        return actualText
    }

}