package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://dropmefiles.com";
        open("/");

    }

    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }
}
