import java.io.*;
import java.util.*;


public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[] visited;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int result=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[M*N];
		for(int i=0;i<N;i++)
		{
			String str = br.readLine();
			for(int j =0;j<M;j++)
				arr[i][j] = str.charAt(j) - 'A';
		}
		dfs(0,0, 0);
		bw.write(result + "");
		bw.flush();
	}
	static void dfs(int a,int b,int count)
	{
		if (visited[arr[a][b]])
		{
			result = Math.max(result, count);
			return;
		}
		else
		{
			visited[arr[a][b]] = true;
			for(int i=0;i<4;i++)
			{
				int x = a + dx[i];
				int y = b + dy[i];
				if (x < 0|| x >= N|| y < 0 || y >= M) continue;
				dfs(x, y,count+1);
			}
			visited[arr[a][b]] = false;
		}
	}
}
