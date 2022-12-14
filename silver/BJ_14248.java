package silver;

import java.io.*;
import java.util.*;

public class 점프점프 {
	static int n, s, count =0;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+2];
		visited = new boolean[n+2];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++)
			arr[i]= Integer.parseInt(st.nextToken());
		s = Integer.parseInt(br.readLine());
		dfs(s);
		System.out.println(count);
	}
	static void dfs(int number)
	{
		if (number > n || number < 1) return ;
		if (arr[number] != 0 && !visited[number])
		{
			count++;
			visited[number]=true;
			dfs(number + arr[number]);
			dfs(number - arr[number]);
		}
	}
}
