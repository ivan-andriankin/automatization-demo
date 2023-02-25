package com.example.automatizationgradledemo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SiteObjects {

    private SelenideElement
            searchInputField = $(".imdb-header-search__input.searchTypeahead__input.react-autosuggest__input"),
            firstSearchResult = $("li[id=react-autowhatever-1--item-0]"),
            filmHeaderInFilmPage = $("h1[data-testid=hero-title-block__title]"),
            actorHeaderInActorPage = $("h1[data-testid=hero__pageTitle]"),
            chrisTuckerUrl = $(withTagAndText("a", "Chris Tucker")),
            ActorFilterButton = $("#name-filmography-filter-actor"),
            writerFilterButton = $("#name-filmography-filter-writer"),
            producerSection = $("label[data-testid=accordion-item-producer-previous-projects]"),
            firstItemInProducerSection = $("li[data-testid=nm_flmg_credit_producer_0]"),
            awardsUrl = $(withTagAndText("a", "Awards"))

    ;

    private ElementsCollection
            allGenresOfTheMovie = $("div[class=ipc-chip-list__scroller]").$$("span[class=ipc-chip__text]"),
            allAwardsHeadersInActorPage = $(".article.listo").$$("h3")
    ;


    public SiteObjects openPage() {
        open("/");
        return this;
    }

    public SiteObjects openFilmPage(String value) {
        open(value);
        return this;
    }

    public SiteObjects putNameInSearchInputField(String value) {
        searchInputField.setValue(value);
        return this;
    }

    public SiteObjects validateSearchResultByEntitySignature(String value) {
        firstSearchResult.shouldHave(text(value));
        return this;
    }

    public SiteObjects clickOnFirstItemInSearchResult() {
        firstSearchResult.click();
        return this;
    }

    public SiteObjects checkCorrectnesOfFilmNameInFilmPage(String value) {
        filmHeaderInFilmPage.shouldHave(text(value));
        return this;
    }

    public SiteObjects checkCorrectnesOfActorNameInActorPage(String value) {
        actorHeaderInActorPage.shouldHave(text(value));
        return this;
    }

    public SiteObjects checkSectionWithGenres(List<String> value) {
        allGenresOfTheMovie.shouldHave(texts(value));
        return this;
    }

    public SiteObjects clickChrisTuckerUrl() {
        chrisTuckerUrl.click();
        return this;
    }

    public SiteObjects clickActorFilterButton() {
        ActorFilterButton.click();
        return this;
    }

    public SiteObjects clickWriterFilterButton() {
        writerFilterButton.click();
        return this;
    }

    public SiteObjects expandProducerSection() {
        producerSection.click();
        return this;
    }

    public SiteObjects checkFirstItemInProducerSection() {
        firstItemInProducerSection.shouldBe(visible);
        return this;
    }

    public SiteObjects clickAwardsUrl() {
        awardsUrl.click();
        return this;
    }

    public SiteObjects checkAllAwardsHeadersInActorPage(List<String> values) {
        allAwardsHeadersInActorPage.shouldHave(texts(values));
        return this;
    }


}
