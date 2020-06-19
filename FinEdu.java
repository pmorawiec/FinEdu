import java.util.Scanner;

class FinEdu {
    
    public static void main(String[] args) {
        //Introduction
        System.out.println("\nWelcome to FinEdu");
        System.out.println("This little applet is for financially curious people who want to get some information about how to store and grow money\n");
        
        
        //Data Collection
        System.out.println("Please enter the amount of Money you would like to save: ");
        FinEduOutput instance = new FinEduOutput();
        Scanner read = new Scanner(System.in);
        instance.SavingsAmount = Integer.parseInt(read.nextLine());
        System.out.println("When will you need this money again? (in months) : ");
        instance.lengthOfTime = Integer.parseInt(read.nextLine());
        System.out.println("If you would like the general summary enter 1. If you would like intrest rate calculators, enter 2.");
        int flag = Integer.parseInt(read.nextLine());

        //RATES: 
        double annualInflation = 0.004; //0,4 %

            //Checking, Savings, High-Yield Savings
        double checkingAPY = .0001;//Based off of the top banks in the US: Chase, BOA, PNC, etc. 
        double savingsAPY = .0009;//Based off of the top banks in the US: Chase, BOA, PNC, etc. 
        double hySavingsAPY = 0.01;//Based off my High Yield savings account at Axos Bank (similar rates evrerywhere though)
        
            //CD
        double CD_3months = .01;
        double CD_6months =.01;
        double CD_12months = 0.013;

            //Bond
        double bond_3months = .0117;
        double bond_6months =.0119;
        double bond_12months = .0120;

            //Stocks
        double avgYearReturn = 0.1;
        //General Summary
        if (flag == 1){
            System.out.println("In the generalized summary we will be using average rates, if you are looking for something more specific, Please use out calculators. ");
            
            instance.Cash(annualInflation);
            instance.CheckingAndSaving(annualInflation, checkingAPY,savingsAPY,hySavingsAPY);
            instance.CD(annualInflation, CD_3months, CD_6months,CD_12months);
            instance.Bond(annualInflation,bond_3months, bond_6months,bond_12months);
            instance.Stock(annualInflation, avgYearReturn);
        }

        //Intrest Rate Calculators
        else{
            System.out.println("Its a 2");
        }
    }

}