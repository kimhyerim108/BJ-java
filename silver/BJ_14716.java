package silver;

import java.io.*;
import java.util.*;

public class 현수막 {
	static int M, N;
	static int[][] arr;
	static boolean[][] visited;
	static int dx[] = {-1,1, 0, 0, -1, 1, -1, 1};
	static int dy[] = {0, 0, -1, 1, -1, -1, 1,1};
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 M = Integer.parseInt(st.nextToken());
		 N = Integer.parseInt(st.nextToken());
		 int count = 0;
		 arr = new int[M][N];
		 visited = new boolean[M][N];
		 for (int i=0;i<M;i++)
		 {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0;j<N;j++)
				 arr[i][j] = Integer.parseInt(st.nextToken());
		 }
		 for (int i=0;i<M;i++)
			 for(int j=0;j<N;j++)
				 if (!visited[i][j] && arr[i][j] == 1)
				 {
					 dfs(i, j);
					 count++;
				 }
		 bw.write(count +"");
		 bw.flush();
	}
	static void dfs(int a, int b)
	{
		visited[a][b] = true;
		for(int i=0;i<8;i++)
		{
			int x = a + dx[i];
			int y = b + dy[i];
			if (x < 0 || x >= M || y < 0 || y >= N) continue;
			if (!visited[x][y] && arr[x][y] == 1)
				dfs(x, y);
		}
	}
}
