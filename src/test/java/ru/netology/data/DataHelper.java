package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataHelper {

    private DataHelper() {}


    @Value
    public static class CardNumber {
        String number;
    }

    public static CardNumber getValidCardNumber() {
        return new CardNumber("4444 4444 4444 4441");
    }

    public static CardNumber getNotValidCardNumber() {
        return new CardNumber("4444 4444 4444 4442");
    }

    @Value
    @Data
    public static class CardInfo {
        String month;

        String name;
        String cvv;
    }
    private static String year = "23";

    public static String getMonth() {
        String[] monthList = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        int month = (int) Math.floor(Math.random() * monthList.length);
        return monthList[month];
    }

//    public static int getYear(int year){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
//        LocalDateTime date = LocalDateTime.now();
//        String Year = date.plusYears(year).format(formatter);
//        return Integer.parseInt(Year);
//    }

    public static String getYear() {
        return year;
    }

    public static String getName() {
        Faker faker = new Faker(new Locale("EN_EN"));
        return (faker.name().lastName()+(" ")+faker.name().firstName());
    }

    public static String getCvv() {
        Faker faker = null;
        return (faker.numerify("###"));
    }

}
