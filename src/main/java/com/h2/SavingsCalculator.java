package com.h2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.YearMonth;


public class SavingsCalculator {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

private float[] debits;
private float[] credits;

public SavingsCalculator(float[] credits, float[] debits){
    this.credits = credits;
    this.debits = debits;
System.out.println(dtf.format(now));

};
private float sumOfCredits(){
    float sum = 0.0f;
    for (float credits:credits){
        sum += credits;
    }
    return sum;
};
    private float sumOfDebits(){
        float sum = 0.0f;
        for (float debits:debits){
            sum += debits;
        }
        return sum;
    }
    int LocalDate;
private static int remainingDaysInMonth(java.time.LocalDate date){
    int year = LocalDateTime.now().getYear();
    int monthValue = LocalDateTime.now().getMonthValue();


    YearMonth yearMonth = YearMonth.of(year, monthValue);
    int totalDaysInMonth = yearMonth.lengthOfMonth();
    int remainingDays = LocalDateTime.now().getDayOfMonth() - totalDaysInMonth;
    return remainingDays;

};



}
