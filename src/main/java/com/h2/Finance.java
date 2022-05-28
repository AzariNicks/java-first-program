package com.h2;

import java.sql.Array;
import java.util.Map;
import com.h2.BestLoanRates;
import  com.h2.MortgageCalculator;
import com.h2.SavingsCalculator;

import static java.util.Arrays.copyOfRange;

public class Finance {

    public final static String BEST_LOAN_RATES = "bestLoanRates";
    public final static String SAVINGS_CALCULATOR = "savingsCalculator";
    public final static String MORTGAGE_CALCULATOR = "mortgageCalculator";

    public final static Map<String, String> commandsToUsage =
            Map.of( BEST_LOAN_RATES      ,    "usage: bestLoanRates",
                    SAVINGS_CALCULATOR   ,    "usage: savingsCalculator",
                    MORTGAGE_CALCULATOR  ,    "usage: mortgageCalculator" );


    private static boolean validateCommandArguments(String[] args) {
        switch (args[0]){
            case BEST_LOAN_RATES: args[0] = "bestLoanRates";
            return args.length == 1;
            case SAVINGS_CALCULATOR : args[0] = "savingsCalculator";
            return args.length == 3;
            case MORTGAGE_CALCULATOR: args[0] = "mortgageCalculator";
            return args.length == 4;
        }
        return false;
    }

private static void executeCommand(String command, String[] arguments){
    switch (command) {
        case BEST_LOAN_RATES:
            System.out.println("Finding best loan rates...");
            BestLoanRates.main(arguments);
            return;
        case SAVINGS_CALCULATOR:
            System.out.println("Finding your net Savings...");
            SavingsCalculator.main(arguments);
           return;
        case MORTGAGE_CALCULATOR:
            System.out.println("Finding Your Monthly payment...");
            MortgageCalculator.main(arguments);
            return;
    }}
public static void main(String[] args){
        String  command = args[0];
        if(!commandsToUsage.containsKey(command)){
            System.out.println(command + ": command not found");
            return;
        }
        else{
            boolean isValidCommand = validateCommandArguments(args);
            if(!isValidCommand){System.out.println(commandsToUsage.get(args[0]));
            return;}
            else{executeCommand(command, copyOfRange(args, 1 ,args.length));}
        }

}

}
