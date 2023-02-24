package com.example.automatizationgradledemo;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

@Tag("vacancy_tests")
public class Tests extends TestBase {


    @DisplayName("Найти в поиске фильм и перейти на страницу фильма из результата поиска")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void findFilmInSearchFieldAndGoToFilmPageFromSearchResults() {
        siteObjects.openPage()
                .putNameInSearchInputField(fifthElementName)
                .validateSearchResultByEntitySignature(fifthElementSignature)
                .clickOnFirstItemInSearchResult()
                .checkCorrectnesOfFilmNameInFilmPage(fifthElementName)
        ;
    }


    @DisplayName("Найти в поиске актера и перейти на страницу актера из результата поиска")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void findActorInSearchFieldAndGoToActorPageFromSearchResults() {
        siteObjects.openPage()
                .putNameInSearchInputField(jackieChan)
                .validateSearchResultByEntitySignature(jackieChanSignature)
                .clickOnFirstItemInSearchResult()
                .checkCorrectnesOfActorNameInActorPage(jackieChan)
        ;
    }


    @Severity(SeverityLevel.NORMAL)
    @MethodSource("genres")
    @ParameterizedTest(name="Проверить все жанры {0} фильма")
    void checkAllGenresInFilmPage(List<String> buttons) {
        open("/title/tt0119116");
        $("div[class=ipc-chip-list__scroller]")
                .$$("span[class=ipc-chip__text]")
                .shouldHave(texts(buttons));
    }


    @DisplayName("Проверить фильтр и результат фильтрации в разделе Credits на странице актера")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void checkFilterAndFilteredResultInCreditsOnActorPage() {
        open("/title/tt0119116");
        $(withTagAndText("a", "Chris Tucker")).click();
        $("#name-filmography-filter-actor").click();
        sleep(1000);
        $("#name-filmography-filter-writer").click();
        sleep(1000);
        $("label[data-testid=accordion-item-producer-previous-projects]").click();
        $("li[data-testid=nm_flmg_credit_producer_0]").shouldBe(visible);
    }


    @Severity(SeverityLevel.NORMAL)
    @MethodSource("headersItems")
    @ParameterizedTest(name="Проверить все заголовки на странице Awards")
    void checkAllHeadersInAwardsPage(List<String> headers) {
        open("/name/nm0000676");
        $(withTagAndText("a", "Awards")).click();
        $(".article.listo").$$("h3").shouldHave(texts(headers));
    }


}
