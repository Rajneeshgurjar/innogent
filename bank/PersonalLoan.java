//single responsbility principle
class PersonalLoan implements Loan{
	int payableAmount(double loanAmount, int duration, double interestRate){
		int x=(loanAmount*duration*interestRate)/100;
		return x+loanAmount;	
	}
	int emi(double loanAmount,int duration,double interestRate){
		int emiAmount = payableAmount(loanAmount,duration,interestRate)/duration;
	}
}