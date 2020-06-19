public class FinEduOutput {
    int SavingsAmount;
    int lengthOfTime = 0;
    
    
    public void Cash (Double annualInflation){
        double monthlyInflation = annualInflation/12;

        // In the future you can add an api to get the intrest rates of the moment. 
        double percentLoss = monthlyInflation*lengthOfTime;
        double loss = percentLoss * SavingsAmount;
        double afterLoss = SavingsAmount - loss;

        //Short Term Cash (good idea)
        if (lengthOfTime <= 3){
            System.out.println("\n//     Cash     //\n");
            System.out.println("Since you are going to need the cash in a short peirod of time (0-3 months), this is a decent option for you.");
            System.out.println("Due to inflation you currently would lose $" + loss);
            System.out.println("Even though you are losing some money, the benefit is that it is the most liquid form of currency.");
            System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation*100 + "%, you will have $" + afterLoss );
        }
    }

    public void CheckingAndSaving (Double annualInflation, double checkingAPY, double savingsAPY, double hySavingsAPY ){
        double monthlyInflation = annualInflation/12;

        //Regular Checking : Calculate loss of using it 
        double monthlyCheckingAPY = checkingAPY/12;
        // In the future you can add an api to get the intrest rates of the moment. 
        monthlyCheckingAPY = monthlyInflation - monthlyCheckingAPY;
        double percentCheckingLoss = monthlyCheckingAPY*lengthOfTime;
        double checkingLoss = percentCheckingLoss*SavingsAmount;
        double afterCheckingLoss = SavingsAmount - checkingLoss;

        //Regular Savings: Caluclate loss of using it
        double monthlySavingsAPY = savingsAPY/12;
        monthlySavingsAPY = monthlyInflation-monthlySavingsAPY;
        double percentageSavingsLoss = monthlySavingsAPY*lengthOfTime;
        double savingsLoss = percentageSavingsLoss*SavingsAmount;
        double afterSavingsLoss = SavingsAmount- savingsLoss;

        //High Yield Savings : Calulate loss/gain of using it
        double monthlyHYSavingsAPY = hySavingsAPY/12;
        monthlyHYSavingsAPY = monthlyInflation - monthlyHYSavingsAPY;
        double percentageHYSavingsChange = monthlyHYSavingsAPY* lengthOfTime;
        double hySavingsChange = percentageHYSavingsChange*SavingsAmount;
        double afterHYSavingsChange = SavingsAmount - hySavingsChange;
        
        System.out.println("\n//     Checking & Savings     //\n");
        
        if (lengthOfTime <=6){
            System.out.println("\n--Checking--");
            System.out.println("Since you will be needing cash within a short period of time, Checking is a good option for you. ");
            System.out.println("Due to inflation, you would currently lose $"+ checkingLoss);
            System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation*100 + "%, you will have $" + afterCheckingLoss );
        }
        if (lengthOfTime >2){
            System.out.println("\n--Savings--");
            System.out.println("A standard savings account can be good for you. ");
            System.out.println("Due to inflation, you would currently lose $"+savingsLoss);
            System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation*100 + "%, you will have $" + afterSavingsLoss );

            
            System.out.println("\n--High - Yield Savings Account--");
            System.out.println("If you plan to save for a Emergency fund (VERY highly recommended), this is a good option to store your money");
            if (monthlyHYSavingsAPY<0){
                hySavingsChange = Math.abs(hySavingsChange);
                afterHYSavingsChange = Math.abs(afterHYSavingsChange);
                System.out.println("Despite inflation, you would gain $"+ hySavingsChange);
                System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation*100 + "%, you will have $" + afterHYSavingsChange );
            }
            else{
                System.out.println("Due to inflation, you would currently lose $"+ hySavingsChange);
                System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation + "%, you will have $" + afterHYSavingsChange );
            }
        }    
        
        
    }

    public void CD (Double annualInflation, double for3months, double for6months, double for12months){
        // Inflation rates. 
        double monthlyInflation = annualInflation/12;

        // Calculations:
            //3 Month CD
        double moRate3months = for3months/12;
        moRate3months = monthlyInflation - moRate3months;
        double percentageChange3 = moRate3months * lengthOfTime;
        double change3 = percentageChange3*SavingsAmount;
        double total3 = SavingsAmount + change3;

            //6 Month CD 
        double moRate6months = for6months/12;
        moRate6months = monthlyInflation- moRate6months;
        double percentageChange6 = moRate6months * lengthOfTime;
        double change6 = percentageChange6 * SavingsAmount;
        double total6 = SavingsAmount + change6;

            //12 Month CD
        double moRate12months = for12months/12;
        moRate12months = monthlyInflation- moRate12months;
        double percentChange12 = moRate12months * lengthOfTime;
        double change12 = percentChange12*SavingsAmount;
        double total12 = SavingsAmount + change12;

        if (lengthOfTime>=3){
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
                    System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation*100 + "%, you will have $" + total3 );
                }
                else{
                    System.out.println("Due to inflation, you would currently lose $"+ change3);
                    System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation*100 + "%, you will have $" + total3 );
                }
            }
            //6 month CD
            if (lengthOfTime>=6 || lengthOfTime==12){
                System.out.println("\n--6 month CD");
                if (moRate6months<0){
                    change6 = Math.abs(change6);
                    total6 = Math.abs(total6);
                    System.out.println("Despite inflation, you would gain $"+ change6);
                    System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation*100 + "%, you will have $" + total6 );
                }
                else{
                    System.out.println("Due to inflation, you would currently lose $"+ change3);
                    System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation*100 + "%, you will have $" + total6 );
                }
            }
            //12 month CD
            if (lengthOfTime>=12){
                if (moRate12months<0){
                    change12 = Math.abs(change12);
                    total12 = Math.abs(total12);
                    System.out.println("Despite inflation, you would gain $"+ change12);
                    System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation*100 + "%, you will have $" + total12);
                }
                else{
                    System.out.println("Due to inflation, you would currently lose $"+ change12);
                    System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation*100 + "%, you will have $" + total12);
                }
            }
        }
    }

    public void Bond (double annualInflation, double for3months, double for6months, double for12months){
        double monthlyInflation = annualInflation/12;
        // Calculations:

        //3 Month Bond
        double moRate3months = for3months/12;
        moRate3months = monthlyInflation - moRate3months;
        double percentChange3 = moRate3months * lengthOfTime;
        double change3 = percentChange3*SavingsAmount;
        double total3 = SavingsAmount - change3;

        //6 Month Bond 
        double moRate6months = for6months/12;
        moRate6months = monthlyInflation- moRate6months;
        double percentChange6 = moRate6months * lengthOfTime;
        double change6 = percentChange6*SavingsAmount;
        double total6 = SavingsAmount + change6;

        //12 Month Bond
        double moRate12months = for12months/12;
        moRate12months = monthlyInflation- moRate12months;
        double percentChange12 = moRate12months * lengthOfTime;
        double change12 = percentChange12*SavingsAmount;
        double total12 = SavingsAmount + change12;

        ///if (change3>0 || change6>0 || change12>0) return;
        if (lengthOfTime > 3){
            
            System.out.println("\n//     Government Bonds     //");
            System.out.println("Gov. Bonds are safe, however typically provide less return than other options. ");
            System.out.println("Warning: Not liquid. Must commit to time frame or must pay penalty.");
            //3 month Bond
            if (lengthOfTime>=3 || lengthOfTime<=6){
                System.out.println("\n--3 month Bond --");
                if (moRate3months<0){
                    change3 = Math.abs(change3);
                    total3 = Math.abs(total3);
                    System.out.println("Despite inflation, you would gain $"+ change3);
                    System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation*100 + "%, you will have $" + total3 );
                }
                
            }
            //6 month Bond
            if (lengthOfTime>=6 || lengthOfTime==12){
                System.out.println("\n--6 month Bond");
                if (moRate6months<0){
                    change6 = Math.abs(change6);
                    total6 = Math.abs(total6);
                    System.out.println("Despite inflation, you would gain $"+ change6);
                    System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation*100 + "%, you will have $" + total6 );
                }
                
            }
            //12 month Bond
            if (lengthOfTime>=12){
                if (moRate12months<0){
                    change12 = Math.abs(change12);
                    total12 = Math.abs(total12);
                    System.out.println("\n--12 Month Bond");
                    System.out.println("Despite inflation, you would gain $"+ change12);
                    System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation*100 + "%, you will have $" + total12);
                }
                
            }
        }
    }
    
    public void Stock (double annualInflation, double avgYearReturn){
        if (lengthOfTime>60){
            double monthlyInflation = annualInflation/12;
            
            double avgMonthReturn = avgYearReturn/12;
            System.out.println("inflation "+ monthlyInflation + " || returns: "+ avgMonthReturn);
            avgMonthReturn = monthlyInflation- avgMonthReturn;
            avgMonthReturn = Math.abs(avgMonthReturn);
            double percentChangeStock = avgMonthReturn * lengthOfTime;
            double changeStock = percentChangeStock*SavingsAmount;
            double totalStock = SavingsAmount + changeStock;

            System.out.println("\n//     Stock     //");
            System.out.println("Despite inflation, you would gain $"+ changeStock);
            System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation*100 + "%, you will have $" + totalStock);

        }
    }
}