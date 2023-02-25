package com.example.automatizationgradledemo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.automatizationgradledemo.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.stream.Stream;

public class TestBase {

    SiteObjects siteObjects = new SiteObjects();

    static String fifthElementName = "Пятый элемент";
    static String fifthElementSignature = "Bruce Willis, Milla Jovovich";
    static String jackieChan = "Jackie Chan";
    static String jackieChanSignature = "Actor, Who Am I? (1998)";
    static String fifthElementUrl = "/title/tt0119116";
    static String chrisTuckerUrl = "/name/nm0000676";


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.imdb.com";
        Configuration.browser = System.getProperty("browserName","chrome");
        Configuration.browserVersion = System.getProperty("browserVersion","100.0");
        Configuration.browserSize = System.getProperty("screenSize","1366x768");
        Configuration.remote = System.getProperty("remoteBrowserAddress");  // передается из дженкинса "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);    // окошко в окошке
        capabilities.setCapability("enableVideo", true);  // запись видео
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    static Stream<Arguments> genres() {
        return Stream.of(
                Arguments.of(List.of(
                        "Action",
                        "Adventure",
                        "Sci-Fi"))
        );
    }

    static Stream<Arguments> headersItems() {
        return Stream.of(
                Arguments.of(List.of(
                        "Chris Tucker",
                        "Awards Circuit Community Awards",
                        "BET Awards",
                        "Blockbuster Entertainment Awards",
                        "Capri, Hollywood",
                        "Central Ohio Film Critics Association",
                        "Gold Derby Awards",
                        "Gotham Awards",
                        "Image Awards (NAACP)",
                        "Kids' Choice Awards, USA",
                        "MTV Movie + TV Awards",
                        "People's Choice Awards, USA",
                        "Phoenix Film Critics Society Awards",
                        "Razzie Awards",
                        "Satellite Awards",
                        "Screen Actors Guild Awards",
                        "ShoWest Convention, USA",
                        "Teen Choice Awards",
                        "The Stinkers Bad Movie Awards"))
        );
    }

}
