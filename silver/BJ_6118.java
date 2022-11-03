package silver;

import java.io.*;
import java.util.*;
public class 숨바꼭질 {
	static int N, M;
	static List<Integer>[] list;
	static boolean[] visited;
	static int hide=0, dist=0, count=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++)
			list[i] = new ArrayList<>();
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		bfs(1);
		System.out.println(hide + " " + dist + " " + count);
	}
	static void bfs(int a)
	{
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a,0});
		visited[a] = true;
		while(!q.isEmpty())
		{
			int tem[] = q.poll();
			int start = tem[0];
			int len = tem[1];
			if(len > dist)
			{
				dist = len;
				hide = start;
				count = 1;
			}
			else if(len == dist)
			{
				if(hide>start) hide = start;
				count++;
			}
			for(int i=0;i<list[start].size();i++)
			{
				int n = list[start].get(i);
				if(!visited[n])
				{
					visited[n] = true;
					q.add(new int[] {n,len+1});
				}
			}
		}
	}
}
