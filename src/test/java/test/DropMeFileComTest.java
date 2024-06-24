package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import dropmefile.com.MainPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class DropMeFileComTest extends TestBase {

    MainPage MainPage = new MainPage();

    @DisplayName("Наличие кнопок выбора языка")
    @ParameterizedTest(name = "Наличие кнопки выбора языка - {0}")
    @ValueSource(strings = {"Eng", "Рус"})
    void dropMeFilesComLanguageButtonsVisibleTest(String languageName) {
        MainPage.verifyLanguageElement(languageName);
    }

    @DisplayName("Соответствие центрального заголовку выбранному языку")
    @ParameterizedTest(name = "При выборе языка - {0}, центральный заголовок - {1} {2}")
    @CsvFileSource(resources = "/test_data/centralHeadingShouldHasTextDependingOnLanguageSelected.csv",
            numLinesToSkip = 1)
    void dropMeFileComCentralHeadingTest(String languageName, String firstHeadingLine, String secondHeadingLine) {
        MainPage.setLanguage(languageName)
                .verifyCentralHeading(firstHeadingLine)
                .verifyCentralHeading(secondHeadingLine);
    }

    static Stream<Arguments> dropMeFileComOptionButtonsTest() {
        return Stream.of(
                Arguments.of(
                        "Eng", List.of("1 DOWNLOAD", "7 DAYS", "14 DAYS")
                ),
                Arguments.of(
                        "Рус", List.of("1 СКАЧИВАНИЕ", "7 ДНЕЙ", "14 ДНЕЙ")
                )
        );
    }

    @DisplayName("Соответствие переключателей параметров хранения выбранному языку")
    @ParameterizedTest(name = "При выборе языка - {0}, отображаются переключатели - {1}")
    @MethodSource()
    void dropMeFileComOptionButtonsTest(String languageName, List<String> expectedButtons) {
        MainPage.setLanguage(languageName)
        .verifyOptionButtons(expectedButtons);
    }
}
