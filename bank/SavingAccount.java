//open closed principle
class SavingAccount extends Account implements InterestPay{
	SavingAccount(double balance){
		super(balance);
	}
SavingtAccount(double balance){
		super(balance);
	}
	double calculateInterest(){
		return (double)balance*0.06;
	}
	void withdraw(double amount){
		if(balance-amount<=0){
			balance-=amount;
			System.out.println("Payment success");
		}
		else{
			System.out.println("insufficiant balance");
		}
		
	}
}

//Liskov Substitution Principle (LSP)
class SavingAccountLoan extends SavingAccount implements Loan{
	
}