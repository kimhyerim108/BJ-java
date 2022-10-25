import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static List<Integer>[] list;
	static boolean[] visited;
	static int[] arr;
	static Queue<Integer> queue;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		arr = new int[N+1];
		int max=0;
		queue = new LinkedList<>();
		for(int i=1;i<=N;i++)
			list[i] = new ArrayList<>();
		for(int i=1;i<=M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
		}
		for(int i=1;i<=N;i++)
		{
			visited = new boolean[N+1];
			visited[i] = true;
			bfs(i);
		}
		for(int i=1;i<=N;i++)
			max = Math.max(max, arr[i]);
		for(int i=1;i<=N;i++)
		{
			if(max==arr[i])
				System.out.print(i+" ");
		}
	}
	static void bfs(int node)
	{
		queue.add(node);
		while(!queue.isEmpty())
		{
			node = queue.remove();
			for(int i:list[node])
			{
				if(!visited[i])
				{
					arr[i]++;
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
