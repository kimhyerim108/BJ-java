package silver;

import java.io.*;
import java.util.*;

public class n과m2 {
	static int N,M;
	static boolean[] visited;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		arr = new int[N+1];
		backtraking(1,0);
	}
	static void backtraking(int a,int L)
	{
		if(L==M)
		{
			for(int i=0;i<M;i++)
				System.out.print(arr[i]+ " ");
			System.out.println();
			return ;
		}
		for(int i=a;i<=N;i++)
		{
			arr[L] = i;
			backtraking(i+1,L+1);
		}
	}
}
