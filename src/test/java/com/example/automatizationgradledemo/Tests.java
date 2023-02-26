package com.example.automatizationgradledemo;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;


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
        siteObjects.openFilmPage(fifthElementUrl)
                .checkSectionWithGenres(buttons)
        ;
    }


    @DisplayName("Проверить фильтр и результат фильтрации в разделе Credits на странице актера")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void checkFilterAndFilteredResultInCreditsOnActorPage() {
        siteObjects.openFilmPage(fifthElementUrl)
                .clickChrisTuckerUrl()
                .clickActorFilterButton()
                .clickWriterFilterButton()
                .expandProducerSection()
                .checkFirstItemInProducerSection()
        ;
    }


    @Severity(SeverityLevel.NORMAL)
    @MethodSource("headersItems")
    @ParameterizedTest(name="Проверить все заголовки на странице Awards у актера")
    void checkAllHeadersInAwardsPage(List<String> headers) {
        siteObjects.openFilmPage(chrisTuckerUrl)
                .clickAwardsUrl()
                .checkAllAwardsHeadersInActorPage(headers)
        ;
    }


}
