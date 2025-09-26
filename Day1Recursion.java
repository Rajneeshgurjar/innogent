class Day1Recursion{
	static int factorial(int n){
		if(n==0) return 1;
		return n*factorial(n-1);
		
	}
	
	public static void main(String ar[]){
		int n=5;
		System.out.println("factorial of "+n+" is => "+factorial(n));
	}
}