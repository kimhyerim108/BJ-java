import java.io.*;
import java.util.*;

public class 연구소 {
	static int N, M;
	static int[][] arr;
	static int[][] copy;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int result =0;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		copy = new int[N][M];
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				arr[i][j] =Integer.parseInt(st.nextToken());
		}
		// 벽 세우기
		copy = arr;
		wall(0);
		System.out.println(result);
	}
	static void wall(int count)
	{
		if (count==3)
		{
			bfs();
			return;
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if (copy[i][j] == 0)
				{
					copy[i][j] = 1;
					wall(count+1);
					copy[i][j] =0;
				}
			}
		}
	}
	static void bfs()
	{
		int[][] map =new int[N][M];
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				map[i][j] = copy[i][j];
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(map[i][j]==2)
					q.add(new int[] {i,j});
		while(!q.isEmpty())
		{
			int temp[] = q.poll();
			for(int i=0;i<4;i++)
			{
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if (nx<0|| nx>=N||ny<0|| ny>=M) continue;
				if (map[nx][ny] == 0)
				{
					map[nx][ny] = 2;
					q.add(new int[] {nx, ny});
				}
			}
		}
		max_size(map);
	}
	static void max_size(int[][] map)
	{
		int count=0;
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(map[i][j] == 0) count++;
		result = Math.max(count, result);
	}
	
}
