import java.io.*;
import java.util.*;


public class DFSBFS {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[] visited;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		arr = new int[N+1][N+1];
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1; 
		}
		dfs(V, 0);
		bw.write("\n");
		bw.flush();
		visited = new boolean[N+1];
		bfs(V);
	}
	private static void dfs(int V,int count) throws IOException{
		visited[V] = true; 
		bw.write(V+" ");
		bw.flush();
		if(count == M)
			return ;
		for(int j=1;j<arr.length;j++)
		{
			if (arr[V][j] == 1 && !visited[j])
				dfs(j, count+1);
		}
	}
	private static void bfs(int V) throws IOException{
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(V);
		visited[V] = true;
		bw.write(V + " ");
		bw.flush();
		while (!queue.isEmpty())
		{
			int temp = queue.poll();
			for(int i=1;i<arr.length;i++)
			{
				if(arr[temp][i] == 1 && !visited[i])
				{
					queue.add(i);
					visited[i] = true;
					bw.write(i + " ");
					bw.flush();
				}
			}
		}
	}
}
