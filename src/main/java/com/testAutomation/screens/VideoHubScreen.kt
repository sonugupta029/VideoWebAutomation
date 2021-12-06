package com.testAutomation.screens

import com.testAutomation.core.BaseTestPage
import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver

/**
 * Description:
 *    POM for VideoHubScreen POM
 *    @author Sonu Gupta
 */

class VideoHubScreen(val webDriver: RemoteWebDriver) : BaseTestPage(webDriver) {
    private val defaultTimeOutInSeconds = 10
    private val playVideoBtn = By.xpath("//*[@class='fiso-video-start-button__icon fiso-video-start-button__icon--play-bordered']")
    private val adBtn = By.xpath("//*[@id='vjs_video_317']/div[5]/div[3]")
    private val pausePlayVideoParent = By.xpath("//*[@id='vjs_video_317']/div[3]/button[1]")
    private val pausePlayVideoBtn = By.xpath("//*[@id='vjs_video_317']/div[3]/button[1]/div")

    fun hasScreenLoaded(): Boolean {
        swipeTo(0,250)
        return isElementDisplayedAfterTimeout(playVideoBtn, defaultTimeOutInSeconds)
    }


    fun clickPlayVideoButton(): Boolean {
        if (isElementDisplayedAfterTimeout(playVideoBtn, defaultTimeOutInSeconds)) {
            click(playVideoBtn)
            return true
        } else {
            return false
        }
    }

    fun checkAdIsDisplayed(): Boolean {
        swipeTo(0,250)
        Thread.sleep(5000)
        return isElementDisplayedAfterTimeout(adBtn, defaultTimeOutInSeconds)
    }

    fun getAdText(): String? {
        var actualText: String? = null
        if (isElementDisplayedAfterTimeout(adBtn, defaultTimeOutInSeconds)) {
            actualText = getLabelText(adBtn)
        }
        logger.info("label for adText  is $actualText")
        return actualText
    }


    fun checkPlayBtnIsDisplayed(): Boolean {
        return isElementDisplayedAfterTimeout(pausePlayVideoBtn, defaultTimeOutInSeconds)
    }

    fun checkPauseBtnIsDisplayed(): Boolean {
        return isElementDisplayedAfterTimeout(pausePlayVideoBtn, defaultTimeOutInSeconds)
    }

    fun checkPlayPauseParentIsDisplayed(): Boolean {
        return isElementDisplayedAfterTimeout(pausePlayVideoParent, defaultTimeOutInSeconds)
    }

    fun getPlayPauseParentText(): String? {
        var actualText: String? = null
        if (checkPlayPauseParentIsDisplayed()) {
            actualText = getElementAttribute(pausePlayVideoParent, "class")
        }
        logger.info("label for parent  is $actualText")
        return actualText
    }

    fun clickPlayButton(): Boolean {
        if (isElementDisplayedAfterTimeout(pausePlayVideoBtn, defaultTimeOutInSeconds)) {
            click(pausePlayVideoBtn)
            return true
        } else {
            return false
        }
    }

    fun clickPauseButton(): Boolean {
        if (isElementDisplayedAfterTimeout(pausePlayVideoBtn, defaultTimeOutInSeconds)) {
            click(pausePlayVideoBtn)
            return true
        } else {
            return false
        }
    }

}