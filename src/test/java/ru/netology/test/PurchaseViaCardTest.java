package ru.netology.test;


import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.FormPage;


public class PurchaseViaCardTest {


    // тест с валидными данными
    @Test
    void shouldHaveValidData (String expected) {
        //val loginPage = open("http://localhost:8080", FormPage.class);
        FormPage.byButtonCard();
        FormPage.setValidNumberCard();
        FormPage.setCardMonth(DataHelper.getMonth());
        FormPage.setCardYear(DataHelper.getYear());
        FormPage.setCardName(DataHelper.getName());
        FormPage.setCardCVV(DataHelper.getCvv());
        FormPage.clickContinueButton();
        FormPage.checkSuccessSearch();
        FormPage.compareExpectedAndActualResult(expected);
    }

}
