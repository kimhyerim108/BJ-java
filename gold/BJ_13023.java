package gold;

import java.io.*;
import java.util.*;

public class ABCDE {
	static int N, M;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		list = new ArrayList[N];
		for(int i=0;i<N;i++)
			list[i] = new ArrayList<>();
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int i=0;i<N;i++)
			if (count ==0)
				dfs(i,1);
		bw.write(count+"");
		bw.flush();
	}
	static void dfs(int s, int x)
	{
		if (x == 5)
		{
			count =1;
			return ;
		}
		visited[s] = true;
		for(int i : list[s])
		{
			int n = i;
			if(!visited[n])
				dfs(n, x+1);
		}
		visited[s] = false;
	}
}
