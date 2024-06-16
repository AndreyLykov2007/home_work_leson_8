package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DropMeFileComMainPage {
    private final SelenideElement setLanguage = $("#language-select");

    public DropMeFileComMainPage openPage(){
        open("/");
        return this;
    }

    public DropMeFileComMainPage setLanguage(String value) {
        setLanguage.$(byText(value)).click();
        return this;
    }

}
