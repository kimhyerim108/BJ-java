package silver;

import java.io.*;
import java.util.*;

public class 양bfs {
	static int R, C;
	static char[][]arr;
	static boolean[][] visited;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0, 0,-1, 1};
	static int wolf=0,sheep=0,rew=0,resh=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R+1][C+1];
		visited = new boolean[R+1][C+1];
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
				if (!visited[i][j] && arr[i][j] != '#')
				{
					if (arr[i][j] == 'v') wolf++;
					else if(arr[i][j] == 'o') sheep++;
					bfs(i,j);
				}
				if (wolf>=sheep) {rew+=wolf;}
				else resh+=sheep;
				wolf=0;sheep=0;
			}
		}
		System.out.println(resh+ " " + rew);
	}
	static void bfs(int i, int j)
	{
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		visited[i][j]= true;
		while(!q.isEmpty())
		{
			int temp[] = q.poll();
			for(int a=0;a<4;a++)
			{
				int x = temp[0] + dx[a];
				int y = temp[1] + dy[a];
				if (x <0|| x >= R || y < 0|| y >= C) continue;
				if (!visited[x][y] && arr[x][y] != '#')
				{
					visited[x][y] = true;
					q.add(new int[] {x,y});
					if (arr[x][y] == 'v') wolf++;
					else if(arr[x][y] == 'o') sheep++;
				}
			}
		}
	}
}
