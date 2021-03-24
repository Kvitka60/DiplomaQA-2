package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormPage {

    private static String host = System.getProperty("host");

    private SelenideElement heading = $(".heading");
    private static SelenideElement byButton = $$(".button__content").find(exactText("Купить"));
    private SelenideElement byCreditButton = $$(".button__content").find(exactText("Купить в кредит"));

    private static SelenideElement cardPayment = $$(".heading_theme_alfa-on-white").find(exactText("Оплата по карте"));
    private SelenideElement creditAccordingToTheCard = $$(".heading_theme_alfa-on-white")
            .find(exactText("Кредит по данным карты"));

    private static SelenideElement cardNumber = $(byText("Номер карты")).parent().$(".input__control");
    private static SelenideElement cardMonth = $(byText("Месяц")).parent().$(".input__control");
    private static SelenideElement cardYear = $(byText("Год")).parent().$(".input__control");
    private static SelenideElement cardName = $(byText("Владелец")).parent().$(".input__control");
    private static SelenideElement cardCVV = $(byText("CVC/CVV")).parent().$(".input__control");

    private static SelenideElement continueButton = $$(".button__content").find(exactText("Продолжить"));

    private SelenideElement success = $(withText("Успешно"));
    private SelenideElement error = $(withText("Ошибка"));
    private static SelenideElement successSearch = $$(".notification__title").find(exactText("Успешно"));
    private SelenideElement errorSearch = $$(".notification__title").find(exactText("Ошибка"));
    private static SelenideElement inputSub = $(".input__sub");

    public FormPage() {
        heading.shouldBe(visible);
    }

    public static void byButtonCard() {
        open (host);
        byButton.click();
        cardPayment.shouldBe(visible);
    }

    public void byCreditButton() {
        open (host);
        byCreditButton.click();
        creditAccordingToTheCard.shouldBe(visible);
    }

    public static void setValidNumberCard() {
        cardNumber.setValue(DataHelper.getValidCardNumber().getNumber());
    }

//    public void setNotValidNumberCard() {
//        cardNumber.setValue(DataHelper.getNotValidCardNumber().getNumber());
//    }


    public static void setCardMonth(String months) {
        cardMonth.setValue(months);
    }

    public static void setCardYear(String year) {
        cardYear.setValue(year);
    }

    public static void setCardName(String name) {
        cardName.setValue(name);
    }

    public static void setCardCVV(String cvv) {
        cardCVV.setValue(cvv);
    }

    public static void clickContinueButton() {
        continueButton.click();
    }

    public static void checkSuccessSearch() {
        successSearch.waitUntil(visible, 10000);
    }

    public static void compareExpectedAndActualResult(String expected) {
        inputSub.shouldHave(text(expected));
        String actual = inputSub.innerText();
        assertEquals(expected, actual);
    }

}
