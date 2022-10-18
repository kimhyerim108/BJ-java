
package silver;

import java.io.*;
import java.util.*;

public class 양치기꿍 {
	static int R, C;
	static char[][] arr;
	static boolean[][] visited;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int wolf =0,sheep=0, w=0,s=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new boolean[R][C]; 
		for(int i=0;i<R;i++)
		{
			String str = br.readLine();
			for(int j=0;j<C;j++)
				arr[i][j] = str.charAt(j);
		}
		for(int i=0;i<R;i++)
		{
			for(int j=0;j<C;j++)
			{
				if (arr[i][j] == '.') continue;
				if (!visited[i][j] && arr[i][j] != '#')
				{
					if (arr[i][j] == 'v') {wolf=1;sheep=0;}
					else if(arr[i][j] == 'k') {sheep=1; wolf=0;}
					dfs(i, j);
					if (wolf >= sheep) w+=wolf;
					else if(sheep >= wolf) s+=sheep;
				}
			}
		}
		bw.write(s+" "+w);
		bw.flush();
	}
	static void dfs(int a, int b)
	{
		visited[a][b] = true;
		for(int i=0;i<4;i++)
		{
			int x = a + dx[i];
			int y = b + dy[i];
			if(x <0|| x >=R || y<0 || y>=C) continue;
			if (!visited[x][y] && arr[x][y]!='#')
			{
				if (arr[x][y] == 'v') wolf++;
				else if(arr[x][y] =='k') sheep++;
				dfs(x, y);
			}
		}
	}
}
