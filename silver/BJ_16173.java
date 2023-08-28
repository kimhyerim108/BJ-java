import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int dx[] = {0, 1};
    static int dy[] = {1, 0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++)
		{
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int j = 0;j<N;j++)
		        arr[i][j] = Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
		
	    System.out.println("Hing");
	}
	static void dfs(int x, int y)
	{
	    if (arr[x][y] == -1)
	    {
	        System.out.println("HaruHaru");
	        System.exit(0);
	    }
	    visited[x][y] = true;
	    for(int i=0;i<2;i++)
	    {
	       int a = x + arr[x][y] * dx[i];
	       int b = y + arr[x][y] * dy[i];
	       if (a >=N || b >= N) continue;
	       if (!visited[a][b])
	            dfs(a,b);
	    }
	}
}
