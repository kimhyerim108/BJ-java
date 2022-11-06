import java.io.*;
import java.util.*;

public class 구슬찾기 {
	static int N, M;
	static int[][] arr;
	static int[] big,small;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		big = new int[N+1];
		small = new int[N+1];
		int count=0;
		int half = N/2+1;
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1; // b보다 무거운거 (a가 더 무거움)
			arr[b][a] = -1; // a보다 가벼운거 (b가 더 가벼움)
		}
		for(int i=1;i<=N;i++) //거쳐가는구술
		{
			for(int j=1;j<=N;j++)//출발
			{
				for(int k = 1;k<=N;k++)//도착
				{
					if (arr[k][i]!=0 && arr[j][i] == arr[i][k])
						arr[j][k] = arr[j][i];
				}
			}
		}
		for(int i=1;i<=N;i++)
			size(i);
		for(int i=1;i<=N;i++)
		{
			if(big[i]>=half) count++;
			if(small[i]>=half)count++;
		}
		System.out.println(count);
	}
	static void size(int n)
	{
		for(int i=1;i<=N;i++)
		{
			if(arr[n][i] == 1) big[n]++;
			else if(arr[n][i] == -1) small[n]++;
		}
	}
}
