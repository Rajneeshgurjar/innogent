abstract class Account{
	double balance;
	Account(double balance){
		this.balance=balance;
	}
	int checkBalance(){ 
		return balance;
	}
	void deposite(double amount){
		balance+=amount;
	}
	void withdraw(double amount);
}