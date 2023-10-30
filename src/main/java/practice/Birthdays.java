package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthdays {
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEE", Locale.US);

    public static void main(String[] args) {

        int day = 13;
        int month = 10;
        int year = 2020;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        StringBuilder dateText = new StringBuilder();

        LocalDate birthDay = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();

        int i = 0;

        while (birthDay.isBefore(today)) {
            String date = FORMATTER.format(birthDay);
            dateText.append(i++).append(" - ").append(date).append(System.lineSeparator());
            birthDay = birthDay.plusYears(1);
        }
       if (birthDay.isEqual(today)) {
            String date = FORMATTER.format(birthDay);
            dateText.append(i++).append(" - ").append(date).append(System.lineSeparator());
        }

        return dateText.toString();

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

    }
}
