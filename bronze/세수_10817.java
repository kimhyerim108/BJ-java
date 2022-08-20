package baekjoon;

import java.util.*;

public class 세수_10817 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for(int i=0;i<3;i++)
			arr[i]= sc.nextInt(); 
		Arrays.sort(arr);
		System.out.println(arr[1]);
	}
}
