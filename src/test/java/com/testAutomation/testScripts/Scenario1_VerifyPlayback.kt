package com.testAutomation.testScripts

import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.Status
import com.testAutomation.core.BaseTestScript
import com.testAutomation.screens.DashboardScreen
import com.testAutomation.screens.VideoHubScreen
import com.testAutomation.utils.HtmlReporter
import org.apache.log4j.Logger
import org.testng.Assert
import org.testng.annotations.Test

/**
 * Description:
 *    Scenario 1: Verify Playback - Navigate to the Videos page by clicking on Video link from top Menu on Homepage -
 *    Choose any video - Validate ads are played before the video starts [most of the cases] - Validate play and pause
 *    events for the player
 *    @author Sonu Gupta
 */

class Scenario1_VerifyPlayback : BaseTestScript() {
    lateinit var dashboardScreen: DashboardScreen
    lateinit var extentTest: ExtentTest
    lateinit var videoHubScreen: VideoHubScreen
    private val logger: Logger = Logger.getLogger("Scenario1_VerifyPlayback")

    @Test(priority = 0)
    fun verifyPlayback() {
        extentTest = HtmlReporter.createTest("""Verify Playback - Navigate to the Videos page by clicking on 
                    |Video link from top Menu on Homepage Choose any video - Validate ads are played before the video starts [most of the cases] 
                    |- Validate play and pause events for the player""")

        if (webDriver == null) {
            extentTest.log(Status.FAIL, "initialisation Failed ")
            Assert.fail()

        } else {
            extentTest.log(Status.PASS, "initialisation pass ")

        }

        webDriver?.get("https://www.foxsports.com.au/")
        webDriver?.manage()?.window()?.maximize()
        dashboardScreen = DashboardScreen(webDriver!!)

        val actualDashboardScreenTitle = webDriver?.title
        val expectedDashboardScreenTitle = "FOX SPORTS | Live Sports Scores | NRL, AFL, Cricket Scores"

        if (dashboardScreen.hasScreenLoaded() && (actualDashboardScreenTitle==expectedDashboardScreenTitle)) {
            extentTest.log(Status.PASS, "Dashboard page loaded successfully. Actual: [$actualDashboardScreenTitle], Expected: [$expectedDashboardScreenTitle]")
        } else {
            extentTest.log(Status.FAIL, "Page loaded failed")
            Assert.fail()

        }

        if (dashboardScreen.clickVideoLink()) {
            extentTest.log(Status.PASS, "Tap on Video tab")

        } else {
            extentTest.log(Status.FAIL, "Tap on Video tab failed")

        }

        val actualVideoScreenTitle = webDriver?.title
        val expectedVideoScreenTitle = "Fox Sports Videos"

        videoHubScreen = VideoHubScreen(webDriver!!)
        if (videoHubScreen.hasScreenLoaded() && actualVideoScreenTitle==expectedVideoScreenTitle) {
            extentTest.log(Status.PASS, "Video hub page loaded successfully. Actual: [$actualVideoScreenTitle], Expected: [$expectedVideoScreenTitle]")
        } else {
            extentTest.log(Status.FAIL, "Video hub Page loaded failed")
            Assert.fail()

        }

        if (videoHubScreen.clickPlayVideoButton()) {
            extentTest.log(Status.PASS, "Tap on Play Video btn on Video Hub screen")

        } else {
            extentTest.log(Status.FAIL, "Tap on Play Video btn Video Hub screen failed")

        }



        if (videoHubScreen.checkAdIsDisplayed()) {
            extentTest.log(Status.PASS, "Ad is playing")
        } else {
            extentTest.log(Status.FAIL, "Ad is displayed failed")

        }

        while (videoHubScreen.getAdText()?.contains("Ad")!!) {
            logger.info("Ad is still playing")
        }
        val adText = videoHubScreen.getAdText()

        if (adText == "") {
            if (videoHubScreen.clickPauseButton()) {
                extentTest.log(Status.PASS, "Tap on Pause btn")
            }
        } else {
            extentTest.log(Status.FAIL, "Tap on Pause btn failed")

        }

        var playPauseParentText = videoHubScreen.getPlayPauseParentText()
        if (playPauseParentText?.contains("paused")!!) {
            extentTest.log(Status.PASS, "Video is paused. Class attribute is [$playPauseParentText]")

        } else {
            extentTest.log(Status.FAIL, "Video is pause failed")

        }


        if (videoHubScreen.clickPlayButton()) {
            extentTest.log(Status.PASS, "Click on Play btn")

        } else {
            extentTest.log(Status.FAIL, "Click on Play btn failed")

        }

        playPauseParentText = videoHubScreen.getPlayPauseParentText()

        if (playPauseParentText?.contains("playing")!!) {
            extentTest.log(Status.PASS, "Video is playing. Class attribute is [$playPauseParentText]")

        } else {
            extentTest.log(Status.FAIL, "Video is playing failed")

        }
    }

}