import java.io.*;
import java.util.*;


public class 항체인식 {
	static int N, M;
	static int[][] map;
	static int[][] vaccine;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		vaccine = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				vaccine[i][j] = Integer.parseInt(st.nextToken());
		}
		start();
		if (check()) bw.write("YES");
		else bw.write("NO");
		bw.flush();
//		System.out.println();
//		for(int i=0;i<N;i++)
//		{
//			for(int j=0;j<M;j++)
//				System.out.print(map[i][j] + " ");
//			System.out.println();
//		}
//		for(int i=0;i<N;i++)
//		{
//			for(int j=0;j<M;j++)
//				System.out.print(vaccine[i][j] + " ");
//			System.out.println();
//		}
	}
	static void start()
	{
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
			{
				if (map[i][j] != vaccine[i][j])
				{
					dfs(i, j, vaccine[i][j]);
					return;
				}
			}
	}
	static boolean check()
	{
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
			{
				if (map[i][j] != vaccine[i][j])
					return false;
			}
		return true;
	}
	static void dfs(int a, int b, int c)
	{
		visited[a][b] = true;
		int last = map[a][b];
		map[a][b] = c;
		for(int i=0;i<4;i++)
		{
			int x = a + dx[i];
			int y = b + dy[i];
			if (x < 0 || x >= N || y < 0 || y >= M) continue;
			if (!visited[x][y] && map[x][y] == last)
				dfs(x, y, c);
		}
	}
}

