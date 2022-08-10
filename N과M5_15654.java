package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N과M5_15654 {
	private static int[] arr;
	private static int[] copy;
	private static boolean[] visited;
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		copy = new int[M];
		visited = new boolean[N];
		for(int i=0;i< N;i++)
			arr[i] = sc.nextInt(); 
		Arrays.sort(arr);
		dfs(0);
	}
	private static void dfs(int cnt)
	{
		if (cnt == M)
		{
			for(int i=0;i<M;i++)
				System.out.print(copy[i] + " ");
			System.out.println();
			return ;
		}
		for(int i=0;i<N;i++)
		{
			if (visited[i]) continue;
			visited[i] = true;
			copy[cnt] = arr[i];
			dfs(cnt+1);
			visited[i] = false; 
		}
	}
}