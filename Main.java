
package ATMAssingment;

import java.util.Scanner;
 
public class Main {

         static double currentBalance;
        static int withdrawCount ;
        static int depositCount ; 
        static  Scanner sc ;

    public static void main(String[] args) {
        
       sc = new Scanner(System.in);
      double intialBalance = 2500.75;
      currentBalance = intialBalance;
      withdrawCount = 0 ; 
      depositCount = 0 ; 
       System.out.println("Please Enter your pin : ");

                if(login(sc.nextInt()) == true){

      int i = 0 ; 
      while(i!= 5 ){
           
          System.out.println("please follow these options for garanting "
                  + "the best experence:\n "
                  + "press 1 for checking the current balance of your account\n"
                  + "press 2 to deposit\n "
                  + "press 3 to withdraw\n "
                  + "press 4 for showing The Account States\n "
                  + "and finally press 5 for Exit");
          i = i=sc.nextInt();
          
          if(i<1 || i >5 ){
              System.out.println("Invalid option");
          }
          switch (i) {
              case 1:
                  checkBalance(currentBalance);
                  break;
              case 2:
                  System.out.println("Please enter the amount of money that you want to "
                          + "deposit: " );
                  double deposit = sc.nextDouble();
                  currentBalance+= deposit(deposit);
                  
                  break;
              case 3:
                  System.out.println("Please enter the amount of money that you want to "
                          + "withdraw: ");
                  double withdraw = sc.nextDouble();
                  currentBalance-= withdraw(withdraw);
                 
                  break;
              case 4:
                  showAccountStates(currentBalance);
                  break;
              case 5:
                  if(withdrawCount == 0 ){
                      System.out.println("Transaction cancelled");
                  }
                  if(depositCount == 0 ){
                      System.out.println("Deposits cancelled");
                  }
                  System.out.println(" Successful deposits: "+depositCount);
                  System.out.println(" Successful Withdraws: "+withdrawCount);
                  
                  System.out.println("Thank you for using our ATM ");
                  
                  break;
              default:
                  break;
          }
      }
          }  
                }
    
        
    
  
      
      
    
        
    
    public static boolean login(int pin){
        
          int correctPin = 1234 ;
          int i = 0 ; 
          do{
          
           if(pin != correctPin){
                   if(i == 2 ){
              System.out.println("Sorry your account is locked try again later");
              return false ;
                   }
            System.out.println("Wrong pin you please enter the correct one.");
                      pin = sc.nextInt();
         
        }else{
                System.out.println("Login Successful");
                return true; 
        }
        
          i++ ; 
          }
          while(i<3);
  
                 return false ;

        }
    
   public static void checkBalance(double currentBalance){
       System.out.println("The Current Balance: " + currentBalance);  
      
   }
   
   public static double deposit(double deposit){
       if(deposit <=0 ){
           System.out.println("Invalid amount");
           return 0;
       }       
         if(deposit !=0){
                  System.out.println("Current Balance: "+ (currentBalance+deposit));
                                    depositCount++;

                  }
        return deposit ; 
   }
   public static double withdraw(double withdraw){
      if(withdraw <=0 || withdraw>currentBalance){
          System.out.println("Insufficient balance");
          return 0 ; 
      }
       if(withdraw !=0){
        
            if(currentBalance == 0){
           System.out.println("Warning: Your account is empty");
       }
               System.out.println("Current Balance: "+ (currentBalance-withdraw));
                  withdrawCount++;
                  }
       
   return withdraw;
   }
   public static void showAccountStates(double currentBalance){
   if(currentBalance>= 5000){
       System.out.println("VIP Customer");
   }else if(currentBalance >=1000 && currentBalance <= 4999.99){
       System.out.println("Regular Customer");
   }else{
       System.out.println("Low Balance");
   }
    if(currentBalance == 0){
           System.out.println("Warning: Your account is empty");
       }
   }
}

    
    
