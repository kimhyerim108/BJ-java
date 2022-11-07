import java.io.*;
import java.util.*;

public class 케빈 {
	static int N, M;
	static int[][] arr;
	static boolean[] visited;
	static int min = 100000000;
	static int result=1000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		for(int i=1;i<=N;i++)
		{
			visited = new boolean[N+1];
			bfs(i);
		}
		System.out.println(result);
	}
	static void bfs(int n)
	{
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {n,0});
		visited[n] = true;
		int count = 0;
		while(!q.isEmpty())
		{
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			count += y;
			for(int i=1;i<=N;i++)
			{
				int num = arr[x][i];
				if (num == 1 && !visited[i])
				{
					visited[i] = true;
					q.add(new int[] {i, y+1});
				}
			}
		}
		if (count < min)
		{
			min = Math.min(min, count);
			result = n;
		}
	}
}
