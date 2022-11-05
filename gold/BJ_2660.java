import java.io.*;
import java.util.*;


public class 회장뽑기 {
	static int N;
	static List<Integer>[] arr = new ArrayList[51];
	static boolean[] visited;
	static int[] save = new int[100];
	static int v=1000000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=N;i++)
			arr[i] = new ArrayList<>();
		
		while (true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a= Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a==-1 && b== -1) break;
			
			arr[a].add(b);
			arr[b].add(a);
		}
		for(int i=1;i<=N;i++)
			bfs(i);
		
		int cnt =0;
		
		for(int i=1;i<=N;i++)
		{
			if (save[i] == v)
			{
				cnt++;
				sb.append(i + " ");
			}
		}
		
		System.out.println(v+ " "+ cnt);
		System.out.print(sb);
	}
	static void bfs(int start)
	{
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[N+1];
		
		visited[start] = true;
		int result =-1;
		q.add(new int[] {start,0});
		while (!q.isEmpty())
		{
			int temp[] = q.poll();
			int x = temp[0];
			int y = temp[1];
			result = Math.max(y, result);
			for(int n:arr[x])
			{
				if(!visited[n])
				{
					visited[n] = true;
					q.add(new int[] {n,y+1});
				}
			}
		}
		v = Math.min(v, result);
		save[start] = result;
	}
}
