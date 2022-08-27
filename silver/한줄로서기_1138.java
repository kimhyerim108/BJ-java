import java.util.*;

public class 한줄로서기_1138 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		int[] arr = new int[x + 1];
		for(int i=1;i<=x;i++)
			arr[i]= sc.nextInt();
		for(int i=x;i>0;i--)
			list.add(arr[i], i);
		for(int i = 0;i<x;i++)
			System.out.print(list.get(i) + " ");
	}
}
