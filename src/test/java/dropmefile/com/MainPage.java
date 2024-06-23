package dropmefile.com;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement languageSelector = $("#language-select");
    SelenideElement centralHeadingSelector = $(".utext");

    public MainPage verifyLanguageElement(String value){
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


}
