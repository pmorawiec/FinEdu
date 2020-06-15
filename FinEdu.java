import java.util.Scanner;

///HERE IS A NEW IDEA I HAVE: 
/// Instead of just giving all of the information, once the user inputs the amount they 
// want to save and how liong they have, This program gives them a few options and guides them
// I can make a seperate one with loans, that combines all of the loans and %'s  of them and it says which ones 
// to pay off first based off of two theories. 
class FinEdu {
    int SavingsAmount;
    int lengthOfTime = 0;
    
    
    public void Cash (Double annualInflation){
        // the inflation rate is obviously variable, but usually balances out to about 2%, if you look at a 25 year average.
        // The input is the annual inflation rate, we must subdivide it into monthly inflation rate. 
        double monthlyInflation = annualInflation/12;

        // In the future you can add an api to get the intrest rates of the moment. 
        double loss = monthlyInflation*lengthOfTime;
        double afterLoss = SavingsAmount - loss;
        

        //Short Term Cash (good idea)
        if (lengthOfTime <= 3){
            System.out.println("\n//     Cash     //\n");
            System.out.println("Since you are going to need the cash in a short peirod of time (0-3 months), this is a decent option for you.");
            System.out.println("Due to inflation you currently would lose $" + loss);
            System.out.println("Even though you are losing some money, the benefit is that it is the most liquid form of currency.");
            System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation + "%, you will have $" + afterLoss );
        }
    }

    public void CheckingAndSaving (Double annualInflation){

        //Converting APY to monthly percentage
        double monthlyInflation = annualInflation/12;

        //Based off of the top banks in the US: Chase, BOA, PNC, etc. 
        double checkingAPY = 0.01;
        double savingsAPY = 0.09;

        //Based off my High Yield savings account at Axos Bank (similar rates evrerywhere though)
        double hySavingsAPY = 1.00;

        //Regular Checking : Calculate loss of using it 
        double monthlyCheckingAPY = checkingAPY/12;
        // In the future you can add an api to get the intrest rates of the moment. 
        monthlyCheckingAPY = monthlyInflation - monthlyCheckingAPY;
        double checkingLoss = monthlyCheckingAPY*lengthOfTime;
        double afterCheckingLoss = SavingsAmount - checkingLoss;

        //Regular Savings: Caluclate loss of using it
        double monthlySavingsAPY = savingsAPY/12;
        monthlySavingsAPY = monthlyInflation-monthlySavingsAPY;
        double savingsLoss = monthlySavingsAPY*lengthOfTime;
        double afterSavingsLoss = SavingsAmount- savingsLoss;

        //High Yield Savings : Calulate loss/gain of using it
        double monthlyHYSavingsAPY = hySavingsAPY/12;
        monthlyHYSavingsAPY = monthlyInflation - monthlyHYSavingsAPY;
        double hySavingsChange = monthlyHYSavingsAPY* lengthOfTime;
        double afterHYSavingsChange = SavingsAmount - hySavingsChange;
        
        System.out.println("\n//     Checking & Savings     //\n");
        
        if (lengthOfTime <=6){
            System.out.println("\n--Checking--");
            System.out.println("Since you will be needing cash within a short period of time, Checking is a good option for you. ");
            System.out.println("Due to inflation, you would currently lose $"+ checkingLoss);
            System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation + "%, you will have $" + afterCheckingLoss );
        }
        if (lengthOfTime >2){
            System.out.println("\n--Savings--");
            System.out.println("A standard savings account can be good for you. ");
            System.out.println("Due to inflation, you would currently lose $"+savingsLoss);
            System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation + "%, you will have $" + afterSavingsLoss );

            
            System.out.println("\n--High - Yield Savings Account--");
            System.out.println("If you plan to save for a Emergency fund (VERY highly recommended), this is a good option to store your money");
            if (monthlyHYSavingsAPY<0){
                hySavingsChange = Math.abs(hySavingsChange);
                afterHYSavingsChange = Math.abs(afterHYSavingsChange);
                System.out.println("Despite inflation, you would gain $"+ hySavingsChange);
                System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation + "%, you will have $" + afterHYSavingsChange );
            }
            else{
                System.out.println("Due to inflation, you would currently lose $"+ hySavingsChange);
                System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation + "%, you will have $" + afterHYSavingsChange );
            }
        }    
        
        
    }

    public void CD (Double annualInflation){
        // Inflation rates. 
        double monthlyInflation = annualInflation/12;
        // Intrest Rates 
        double for3months = 1.00;
        double for6months =1.00;
        double for12months = 1.30;
        
        // Calculations:

        //3 Month CD
        double moRate3months = for3months/12;
        moRate3months = monthlyInflation - moRate3months;
        double change3 = moRate3months * lengthOfTime;
        double total3 = SavingsAmount - change3;

        //6 Month CD 
        double moRate6months = for6months/12;
        moRate6months = monthlyInflation- moRate6months;
        double change6 = moRate6months * lengthOfTime;
        double total6 = SavingsAmount - change6;

        //12 Month CD
        double moRate12months = for12months/12;
        moRate12months = monthlyInflation- moRate12months;
        double change12 = moRate12months * lengthOfTime;
        double total12 = SavingsAmount - change12;

        if (lengthOfTime>3){
            System.out.println("\n//     CD     //");
            System.out.println("For people who can put money away and not touch it. They typically get a slightly better rate than High yield savings accounts."); // In the future implement an API to get hte current rates. 
            System.out.println("Warning: Not liquid. Must commit to time frame or must pay penalty.");

            //3 month CD
            if (lengthOfTime>=3 || lengthOfTime<=6){
                System.out.println("\n--3 month CD --");
                if (moRate3months<0){
                    change3 = Math.abs(change3);
                    total3 = Math.abs(total3);
                    System.out.println("Despite inflation, you would gain $"+ change3);
                    System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation + "%, you will have $" + total3 );
                }
                else{
                    System.out.println("Due to inflation, you would currently lose $"+ change3);
                    System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation + "%, you will have $" + total3 );
                }
            }
            //6 month CD
            if (lengthOfTime>=6 || lengthOfTime==12){
                System.out.println("\n--6 month CD");
                if (moRate6months<0){
                    change6 = Math.abs(change6);
                    total6 = Math.abs(total6);
                    System.out.println("Despite inflation, you would gain $"+ change6);
                    System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation + "%, you will have $" + total6 );
                }
                else{
                    System.out.println("Due to inflation, you would currently lose $"+ change3);
                    System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation + "%, you will have $" + total6 );
                }
            }
            //12 month CD
            if (lengthOfTime>=12){
                if (moRate12months<0){
                    change12 = Math.abs(change12);
                    total12 = Math.abs(total12);
                    System.out.println("Despite inflation, you would gain $"+ change12);
                    System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation + "%, you will have $" + total12);
                }
                else{
                    System.out.println("Due to inflation, you would currently lose $"+ change12);
                    System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation + "%, you will have $" + total12);
                }
            }
        }
    }

    public void Bond (double annualInflation){
        
    }
    public static void main(String[] args) {
        //Introduction
        System.out.println("\nWelcome to FinEdu");
        System.out.println("This little applet is for financially curious people who want to get some information about how to store and grow money\n");
        
        
        //Data Collection
        System.out.println("Please enter the amount of Money you would like to save: ");
        FinEdu instance = new FinEdu();
        Scanner read = new Scanner(System.in);
        instance.SavingsAmount = Integer.parseInt(read.nextLine());
        System.out.println("When will you need this money again? (in months) : ");
        instance.lengthOfTime = Integer.parseInt(read.nextLine());
        System.out.println("If you would like the general summary enter 1. If you would like intrest rate calculators, enter 2.");
        int flag = Integer.parseInt(read.nextLine());
        double annualInflation = 0.4;
        //General Summary
        if (flag == 1){
            System.out.println("In the generalized summary we will be using average rates, if you are looking for something more specific, Please use out calculators. ");
            
            instance.Cash(annualInflation);
            instance.CheckingAndSaving(annualInflation);
            instance.CD(annualInflation);
        }

        //Intrest Rate Calculators
        else{
            System.out.println("Its a 2");
        }
    }

}