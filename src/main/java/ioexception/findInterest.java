package ioexception;

public class findInterest {
    static double calculateInterest(double amount , double rate , int years){
        if (amount<0 || rate <0){
            throw new IllegalArgumentException("Invalid input : Rate and Time can't be negative");
        }
        return  (amount*rate*years)/100;
    }

    public static void main(String[] args) {
        try {
            double amount = 100000;
            double rate = 22.4;
            int years = 3;

            double interest = calculateInterest(amount,rate,years);
            System.out.println("Calculate Interest" + interest);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
