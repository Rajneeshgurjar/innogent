import java.util.*;
class Employee implements Comparable{
	int id;
	String name;
	String department;
	double salary;
	Employee(int id,String name,String department,double salary){
		this.id=id;
		this.name=name;
		this.department=department;
		this.salary=salary;
	}
	
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getDepartment(){
		return department;
	}
	public double getSalary(){
		return salary;
	}
	
	
	public int compareTo(Object o){
		Employee emp=(Employee)o;
		
		int dept=department.compareTo(emp.getDepartment());
		if(dept != 0 )return dept;
		
		int nam=name.compareTo(emp.getName());
		if(dept != 0 )return nam;
		
		int sal=Double.compare(emp.getSalary(),salary);
		if(sal != 0)return sal;
		
		return 0;
		
	}
	
	public String toString(){
	return "[ id = "+id+", name = "+name+", department = "+department+", salary ="+ salary+" ]";
	}
	
}

class EmployeeSort{
	
	
	//iterator for traversing
	public static void employeeList(List<Employee> employees){
		Iterator<Employee> itr=employees.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}	
	
	public static void main(String ar[])
	{
		List<Employee> employees=new ArrayList<>();
			employees.add(new Employee(101,"Rudra","Qa",30000));
			employees.add(new Employee(102,"Jyoti","javaDev",5500));
			employees.add(new Employee(103,"Sourabh","Devops",25000));
			employees.add(new Employee(104,"Raghav","pythonDev",12000));
			employees.add(new Employee(105,"Rajneesh","JavaDev",45000));
			employees.add(new Employee(106, "Amit", "JavaDev", 40000));
		
			System.out.println("List of Employee before sorting =>>\n");
			employeeList(employees);
			System.out.println("-------------------------------------");
		
			System.out.println("List of Employee after sorting with Comparator =>>\n");
			Collections.sort(employees);
			employeeList(employees);
			
			
			
			
			System.out.println("-------------------------------------");
			System.out.println("List of Employee after sorting with Comparator =>>\n");
			employees.sort(
				Comparator.comparing(Employee::getDepartment)   // department ascending
                      .thenComparing(Employee::getName)    // name ascending
                      .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed()) // salary descending
			);
			employeeList(employees);
			
	}
}