package gold;

import java.io.*;

public class 적록색약 {
	static int N;
	static char[][] arr;
	static char[][] green;
	static boolean[][] visited;
	static boolean[][] visited2;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr =new char[N+1][N+1];
		green =new char[N+1][N+1];
		visited = new boolean[N+1][N+1];
		visited2 = new boolean[N+1][N+1];
		int count =0,count2=0;
		for(int i =0;i<N;i++)
		{
			String str = br.readLine();
			for(int j = 0;j<N;j++)
			{
				if (!visited[i][j])
					arr[i][j] = str.charAt(j);
				if (!visited2[i][j])
				{
					if(str.charAt(j)=='G')
						green[i][j] ='R';
					else green[i][j] = str.charAt(j); 
				}
			}
		}
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
			{
				if (!visited[i][j])
				{
					count++;
					dfs(i, j, arr[i][j], arr, visited);
				}
				if (!visited2[i][j])
				{
					count2++;
					dfs(i, j, green[i][j], green, visited2);
				}
			}
		bw.write(count +" " + count2);
		bw.flush();
	}
	static void dfs(int a, int b, char c, char[][] v, boolean[][] check)
	{
		check[a][b] = true; 
		for(int i=0;i<4;i++)
		{
			int x = a + dx[i];
			int y = b + dy[i];
			if (x < 0 || x >= N || y < 0 || y>=N)continue;
			if (!check[x][y] && c ==v[x][y])
				dfs(x, y, v[x][y], v, check);
		}
	}
}
