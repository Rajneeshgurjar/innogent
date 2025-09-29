import java.util.*;
class Performance{
	
}
class CompareTask{
	public static void main(String ar[]){
		int n[]=new int[]{10000,50000,100000};
		for(int i:n){
			List<Integer> arrayList=new ArrayList<>();
			long arrayInsertionTime=measureInsertTime(arrayList,i);
			long arrayDeletionTime=measureDeleteTime(arrayList,i);
			System.out.println("Performance when size of ArrayList is =>"+i+"\t insertion time -> "+arrayInsertionTime+"\t deletion time -> "+arrayDeletionTime);
			System.out.println("--------------------------------------------------");
			
			
			List<Integer> linkedList=new LinkedList<>();
			long listInsertionTime=measureInsertTime(linkedList,i);
			long listDeletionTime=measureDeleteTime(linkedList,i);
			System.out.println("Peformance when size of LinkedList is =>"+i+"\t insertion time -> "+listInsertionTime+"\t deletion time -> "+listDeletionTime);
			System.out.println("--------------------------------------------------");
			System.out.println("--------------------------------------------------");
		}
	}
	public static long measureInsertTime(List<Integer> list,int size){
		long startTime=System.nanoTime();
		for(int i=0;i<size;i++){
			list.add(i);
		}
		long endTime=System.nanoTime();
		return (endTime-startTime)/1000000;//ms
	}
	public static long measureDeleteTime(List<Integer> list,int size){
		long startTime=System.nanoTime();
		for(int i=0;i<size;i++){
			list.remove(0);
		}
		long endTime=System.nanoTime();
		return (endTime-startTime)/1000000;//ms
	}
}