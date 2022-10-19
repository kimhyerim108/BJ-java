import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean check;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0,-1,1,-1,1};
	static int[] dy = {0,0,-1,1,1,1,-1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[101][71];
		visited = new boolean[101][71];
		int count = 0;
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
			{
				if(!visited[i][j])
				{
					check = true;
					dfs(i, j);
					if (check) count++;
				}
			}
		bw.write(count +"");
		bw.flush();
	}
	static void dfs(int a, int b)
	{
		visited[a][b] = true;
		for (int i=0;i<8;i++)
		{
			int x = a + dx[i];
			int y = b + dy[i];
			if (x < 0 || x >= N || y < 0|| y>=M) continue;
			if(arr[x][y] > arr[a][b]) check = false;
			if (!visited[x][y] && arr[x][y] == arr[a][b] && arr[a][b]>-1)
				dfs(x, y);
		}
	}
}
