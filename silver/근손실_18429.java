package baekjoon;

import java.util.*;

public class 근손실_18429 {
	static int N,K,result = 0;
	static int[] arr, health;
	static boolean check[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N + 1];
		health = new int[N + 1];
		check = new boolean[N + 1];
		for(int i =0;i<N;i++)
			health[i]= sc.nextInt(); 
		backtracking(500, 0);
		System.out.println(result);
	}
	private static void backtracking(int T, int count)
	{
		if(count == N)
			result++;
		for(int i=0;i<N;i++)
		{
			if(!check[i] && (T - K + health[i]) >= 500)
			{
				check[i] = true;
				arr[count] = i + 1;
				backtracking(T - K + health[i], count + 1);
				check[i] = false;
			}
		}
	}
}
