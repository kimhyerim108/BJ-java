package silver;

import java.io.*;
import java.util.StringTokenizer;

public class 도영이음식 {
	static int N;
	static int[] S, B;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		StringTokenizer st;
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		backtracking(0, 0, 1, 0);
		System.out.println(min);
	}
	static void backtracking(int check, int idx, int s, int b)
	{
		if(idx == N)
		{
			if(check != 0)
			min = Math.min(min, Math.abs(s - b));
			return ;
		}
		backtracking(check, idx + 1, s, b);
		backtracking(check +1 , idx + 1, s * S[idx], b + B[idx]);
	}
}
