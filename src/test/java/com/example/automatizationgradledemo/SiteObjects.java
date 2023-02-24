package com.example.automatizationgradledemo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SiteObjects {

    private SelenideElement
        searchInputField = $(".imdb-header-search__input.searchTypeahead__input.react-autosuggest__input"),
        firstSearchResult = $("li[id=react-autowhatever-1--item-0]"),
        filmHeaderInFilmPage = $("h1[data-testid=hero-title-block__title]"),
        actorHeaderInActorPage = $("h1[data-testid=hero__pageTitle]")
    ;

    private ElementsCollection elements
    ;


    public SiteObjects openPage() {
        open("/");
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

//    public SiteObjects method() {
//
//        return this;
//    }
//
//    public SiteObjects method() {
//
//        return this;
//    }
//
//    public SiteObjects method() {
//
//        return this;
//    }
//
//    public SiteObjects method() {
//
//        return this;
//    }
//
//    public SiteObjects method() {
//
//        return this;
//    }
//
//    public SiteObjects method() {
//
//        return this;
//    }
//
//    public SiteObjects method() {
//
//        return this;
//    }
//
//    public SiteObjects method() {
//
//        return this;
//    }


}
