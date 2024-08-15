package com.zemnitskiy.date.time;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;

public class OracleExercises {
  public static void main(String[] args) {
    LocalDate today = LocalDate.now();
    System.out.printf("The previous Thursday is: %s%n",
        today.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));

    Clock clock = Clock.systemUTC();
    showEachMonthDuration(Year.now());
    showEachMonday(YearMonth.now());
    System.out.println(isFriday13(LocalDate.now()));

  }

  public static void showEachMonthDuration(Year year) {
    for (Month month : Month.values()) {
      YearMonth yearMonth = YearMonth.of(year.getValue(), month);
      yearMonth.atEndOfMonth();
      System.out.printf("Month: %s, Duration: %s%n", month,
          yearMonth.atEndOfMonth().getDayOfMonth());
    }
  }

  public static void showEachMonday(YearMonth month) {
    LocalDate date = month.atDay(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
    while (date.getMonth() == month.getMonth()) {
      System.out.println(date.getDayOfMonth());
      date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    }
  }

  public static boolean isFriday13(LocalDate date) {
    return date.getDayOfMonth() == 13 && date.getDayOfWeek() == DayOfWeek.FRIDAY;
  }
}
