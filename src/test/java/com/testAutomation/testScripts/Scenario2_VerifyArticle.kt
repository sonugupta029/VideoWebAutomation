package com.testAutomation.testScripts

import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.Status
import com.testAutomation.core.BaseTestScript
import com.testAutomation.screens.*
import com.testAutomation.utils.HtmlReporter
import org.testng.Assert
import org.testng.annotations.Test

/**
 * Description:
 *    Scenario 2: Verify Article - Navigate to Latest News by selecting Sports -> Football -> Latest News on the left
 *    hamburger menu on the Homepage - Select any article - Validate Article Title, Description and Hero Image is present
 *    @author Sonu Gupta
 */

class Scenario2_VerifyArticle : BaseTestScript() {
    lateinit var dashboardScreen: DashboardScreen
    lateinit var footballScreen: FootballScreen
    lateinit var latestFootballNewsScreen: LatestFootballNewsScreen
    lateinit var latestFootballArticleScreen: LatestFootballArticleScreen
    lateinit var extentTest: ExtentTest

    @Test()
    fun verifyArticle() {
        extentTest = HtmlReporter.createTest("""Verify Article - Navigate to Latest News by selecting Sports -> 
                    |Football -> Latest News on the left hamburger menu on the Homepage - Select any article - Validate Article Title, 
                    |Description and Hero Image is present""")

        if (webDriver == null) {
            extentTest.log(Status.FAIL, "initialisation Failed ")
            Assert.fail()

        } else {
            extentTest.log(Status.PASS, "initialisation pass ")

        }

        webDriver?.get("https://www.foxsports.com.au/")
        webDriver?.manage()?.window()?.maximize()

        val actualDashboardScreenTitle = webDriver?.title
        val expectedDashboardScreenTitle = "FOX SPORTS | Live Sports Scores | NRL, AFL, Cricket Scores"


        dashboardScreen = DashboardScreen(webDriver!!)
        if (dashboardScreen.hasScreenLoaded() && actualDashboardScreenTitle == expectedDashboardScreenTitle) {
            extentTest.log(Status.PASS, "Dashboard page loaded successfully. Actual: [$actualDashboardScreenTitle], Expected: [$expectedDashboardScreenTitle]")
        } else {
            extentTest.log(Status.FAIL, "Page loaded failed")
            Assert.fail()

        }

        if (dashboardScreen.clickFootballLink()) {
            extentTest.log(Status.PASS, "Tap on Football link")

        } else {
            extentTest.log(Status.FAIL, "Tap on Football link failed")

        }

        val actualFootballScreenTitle = webDriver?.title
        val expectedFootballScreenTitle = "Football | Live Scores & Results | EPL, A-League & More | FOX SPORTS"

        footballScreen = FootballScreen(webDriver!!)
        if (footballScreen.hasScreenLoaded() && actualFootballScreenTitle==expectedFootballScreenTitle) {
            extentTest.log(Status.PASS, "Football page loaded successfully. Actual: [$actualFootballScreenTitle], Expected: [$expectedFootballScreenTitle]")
        } else {
            extentTest.log(Status.FAIL, "Football Page loaded failed")
            Assert.fail()

        }

        if (footballScreen.clickLatestNewsLink()) {
            extentTest.log(Status.PASS, "Click on Latest News link successfully")
        } else {
            extentTest.log(Status.FAIL, "Click on Latest News link failed")

        }

        val actualLatestNewsScreenTitleText = webDriver?.title
        val expectedLatestNewsScreenTitleText = "Football News | EPL News, A League News & More | FOX SPORTS"

        latestFootballNewsScreen = LatestFootballNewsScreen(webDriver!!)
        if (latestFootballNewsScreen.hasScreenLoaded() && actualLatestNewsScreenTitleText==expectedLatestNewsScreenTitleText) {
            extentTest.log(Status.PASS, "Latest football news loaded successfully. Actual: [$actualLatestNewsScreenTitleText], Expected: [$expectedLatestNewsScreenTitleText]")
        } else {
            extentTest.log(Status.FAIL, "Latest football news Page loaded failed")
            Assert.fail()

        }

        if (latestFootballNewsScreen.clickLatestArticleLink()) {
            extentTest.log(Status.PASS, "Latest article link loaded successfully")
        } else {
            extentTest.log(Status.FAIL, "Latest article link loaded failed")

        }

        val actualLatestArticleScreenTitleText = webDriver?.title
        val expectedLatestArticleScreenTitleText = "EPL 2021: news, scores, results, ladder, Liverpool vs Crystal Palace, Manchester City vs Southampton, Everton, Sadio Mane"

        latestFootballArticleScreen = LatestFootballArticleScreen(webDriver!!)

        if (latestFootballArticleScreen.hasScreenLoaded() && actualLatestArticleScreenTitleText==expectedLatestArticleScreenTitleText) {
            extentTest.log(Status.PASS, "Latest football article loaded successfully. Actual: [$actualLatestArticleScreenTitleText], Expected: [$expectedLatestArticleScreenTitleText]")
        } else {
            extentTest.log(Status.FAIL, "Latest football article Page loaded failed")
            Assert.fail()

        }

        if (latestFootballArticleScreen.checkHeroImageIsDisplayed()) {
            extentTest.log(Status.PASS, "Hero image displayed successfully")
        } else {
            extentTest.log(Status.FAIL, "Hero image displayed loaded failed")

        }

        val actualTitleText = latestFootballArticleScreen.getLatestArticleTitle()
        val expectedTitleText = "Reds go top as star’s freak streak goes on; City stutter as Arsenal’s \$57m signing saves day: PL Wrap"

        if (actualTitleText == expectedTitleText) {
            extentTest.log(Status.PASS, "Title verification pass. Actual: [$actualTitleText], Expected: [$expectedTitleText]")
        } else {
            extentTest.log(Status.FAIL, "Title verification pass. Actual: [$actualTitleText], Expected: [$expectedTitleText]")

        }

        val actualDescriptionPart1 = latestFootballArticleScreen.getLatestArticleDescriptionPart1()
        val expectedDescriptionPart1 = "Sadio Mane reached 100 career goals for Liverpool in a 3-0 win against Crystal Palace that sent the Reds top of the Premier League, while Arsenal eased the pressure on Mikel Arteta with a battling 1-0 victory at Burnley on Saturday."

        if (actualDescriptionPart1 == expectedDescriptionPart1) {
            extentTest.log(Status.PASS, "Description Part 1 verification pass. Actual: [$actualDescriptionPart1], Expected: [$expectedDescriptionPart1]")
        } else {
            extentTest.log(Status.FAIL, "Description Part 1 verification pass. Actual: [$actualDescriptionPart1], Expected: [$expectedDescriptionPart1]")

        }

        val actualDescriptionPart2 = latestFootballArticleScreen.getLatestArticleDescriptionPart2()
        val expectedDescriptionPart2 = "Defending champions Manchester City dropped two points at home to Southampton after a 0-0 stalemate while struggling Wolves lost their fourth match in five against 10-man Brentford."

        if (actualDescriptionPart2 == expectedDescriptionPart2) {
            extentTest.log(Status.PASS, "Description Part 2 verification pass. Actual: [$actualDescriptionPart2], Expected: [$expectedDescriptionPart2]")
        } else {
            extentTest.log(Status.FAIL, "Description Part 2 verification pass. Actual: [$actualDescriptionPart2], Expected: [$expectedDescriptionPart2]")

        }

        val actualDescriptionPart3 = latestFootballArticleScreen.getLatestArticleDescriptionPart3()
        val expectedDescriptionPart3 = "Mane continued his eye-catching mastery of Palace, netting in a record ninth league match in a row against the Eagles."

        if (actualDescriptionPart3 == expectedDescriptionPart3) {
            extentTest.log(Status.PASS, "Description Part 3 verification pass. Actual: [$actualDescriptionPart3], Expected: [$expectedDescriptionPart3]")
        } else {
            extentTest.log(Status.FAIL, "Description Part 3 verification pass. Actual: [$actualDescriptionPart3], Expected: [$expectedDescriptionPart3]")

        }
    }
}