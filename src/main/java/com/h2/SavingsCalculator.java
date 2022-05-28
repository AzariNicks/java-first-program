package com.h2;
import java.time.LocalDate;
import java.time.YearMonth;


public class SavingsCalculator {

    private float[] credits;
    private float[] debits;


public SavingsCalculator(float[] credits, float[] debits){
    this.credits = credits;
    this.debits = debits;


}
private float sumOfCredits(){
    float sum = 0.0f;
    for (float credits:credits){
        sum += credits;
    }
    return sum;
}
    private float sumOfDebits(){
        float sum = 0.0f;
        for (float debits:debits){
            sum += debits;
        }
        return sum;
    }

// fix, this for some reason we are returning 3 I
// have a feeling
// its cuz of how we set up the variables lol
// for febuary 1 2020 we are getting (3) instead of 29
// were supposed to get 29 becuz thers 30 more days in the month


private static int remainingDaysInMonth(LocalDate date){



    YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
    // remaining days are broken gotta fix it lol

    int totalDaysInMonth = yearMonth.lengthOfMonth();
    // totalDays is working so its prolly localDateTime
    return totalDaysInMonth - date.getDayOfMonth();


}
public float calculate(){

    return  sumOfCredits() - sumOfDebits();
}
public static void main(String[] args) {
    String[] creditsAsString = args[0].split(",")
   ; String[] debitsAsString = args[1].split(",");
   float[] credits = new float[creditsAsString.length];
    for(int i= 0;i<creditsAsString.length;i++){
       credits[i] = Float.parseFloat(creditsAsString[i]);
    }
    float[] debits = new float[debitsAsString.length];
    for(int i= 0;i<debitsAsString.length;i++){
        debits[i] = Float.parseFloat(debitsAsString[i]);
    }
    SavingsCalculator calculator = new SavingsCalculator(credits, debits);

    float netSavings = calculator.calculate();
    System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(java.time.LocalDate.now()));


}


}
