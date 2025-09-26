//Dependency Inversion Principle (DIP)
class CurrentAccount extends Account{
	void withdraw(double amount){
		balance-=amount;
	}
}