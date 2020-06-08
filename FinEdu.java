import java.util.Scanner;


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
        System.out.println("\n//     Cash     //\n");

        //Short Term Cash (good idea)
        if (lengthOfTime <= 3){
            System.out.println("Since you are going to need the cash in a short peirod of time (0-3 months), this is a good option for you.");
            System.out.println("Due to inflation you currently would lose $" + loss);
            System.out.println("Even though you are losing some money, the benefit is that it is the most liquid form of currency.");
            System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation + "%, you will have $" + afterLoss );
        }

        //Long Term storage. not great. 
        else{
            System.out.println("Since you are going to need the cash in a long peirod of time (0-3 months), this is not a good option for you.");
            System.out.println("Due to inflation you currently would lose $" + loss);
            System.out.println("After "+ lengthOfTime + " months, at an annual inflation rate of "+ annualInflation + "%, you will have $" + afterLoss );
        }
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
        
        //General Summary
        if (flag == 1){
            System.out.println("In the generalized summary we will be using average rates, if you are looking for something more specific, Please use out calculators. ");
            instance.Cash(1.5);
        }

        //Intrest Rate Calculators
        else{
            System.out.println("Its a 2");
        }
    }

}