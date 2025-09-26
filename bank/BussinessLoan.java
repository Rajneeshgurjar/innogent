class BussinessLoan implements Loan{
	int payableAmount(double loanAmount, int duration, double interestRate){
		int x=(loanAmount*duration*interestRate)/100;
		return x+loanAmount;	
	}
}