package dropmefile.com;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final
    SelenideElement languageSelector = $("#language-select");
    SelenideElement centralHeadingSelector = $(".utext");
    ElementsCollection optionButtonsSelector = $$("div.input_line label[for^=period]");

    public MainPage verifyLanguageElement(String value) {
        languageSelector.$(byText(value)).shouldBe(visible);
        return this;
    }

    public MainPage setLanguage(String value) {
        languageSelector.$(byText(value)).click();
        return this;
    }


    public MainPage verifyCentralHeading(String value) {
        centralHeadingSelector.shouldHave(text(value));
        return this;
    }

    public MainPage verifyOptionButtons(List<String> expectedButtons) {
        optionButtonsSelector.filter(visible).shouldHave(texts(expectedButtons));
        return this;
    }

}
