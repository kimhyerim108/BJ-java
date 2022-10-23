package silver;

import java.io.*;
import java.util.*;

public class 영상처리 {
	static int N, M;
	static long[][] arr;
	static boolean[][] visited;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[N+1][M];
		visited = new boolean[N+1][M+1];
		int count=0;
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				int r = Integer.parseInt(st.nextToken());
				int g = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[i][j] = (r+g+b)/3;
			}
		}
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
			{
				if (arr[i][j] >= T)
					arr[i][j] = 255;
				else arr[i][j] = 0; 
			}
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
			{
				if(!visited[i][j] && arr[i][j] ==255)
				{
					count++;
					dfs(i, j);
				}
			}
		bw.write(count+"");
		bw.flush();
	}
	static void dfs(int a, int b)
	{
		visited[a][b] =true;
		for(int i=0;i<4;i++)
		{
			int x = a + dx[i];
			int y = b + dy[i];
			if (x < 0 || x >=N || y < 0 || y >= M) continue;
			if (!visited[x][y] && arr[x][y] == 255)
				dfs(x, y);
		}
	}
}
