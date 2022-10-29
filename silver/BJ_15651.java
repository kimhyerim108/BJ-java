import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		backtraking(0);
		System.out.println(sb);
	}
	static void backtraking(int L)
	{
	    if (L==M)
	    {
	        for(int i=0;i<M;i++)
	            sb.append(arr[i]).append(' ');
	        sb.append('\n');
	       return ;
	    }
	    for(int i=1;i<=N;i++)
	    {
	        arr[L] = i;
	        backtraking(L+1);
	    }
	}
}
