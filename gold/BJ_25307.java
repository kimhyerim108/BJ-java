import java.io.*;
import java.util.*;

public class 시루의백화점구경 {
	static int N, M, K;
	static int[][] arr;
	static Queue<int[]> w,s;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		w = new LinkedList<>();
		s = new LinkedList<>();
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 4) s.add(new int[] {i,j,0});
				else if(arr[i][j] == 3) w.add(new int[] {i,j,0});
			}
		}
		wall();
		int result = show();
		if (result == -1) System.out.println(-1);
		else System.out.println(result * -1);
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}
	static int show()
	{
		while(!s.isEmpty())
		{
			int temp[] = s.poll();
			for(int i=0;i<4;i++)
			{
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				int z = temp[2] - 1;
				if (x < 0 || x >= N || y < 0 || y >= M) continue;
				if (arr[x][y] == 2) return z;
				if(arr[x][y] == 0)
				{
					arr[x][y] = z;
					s.add(new int[] {x,y,z});
				}
			}
		}
		return -1;
	}
	static void wall()
	{
		while(!w.isEmpty())
		{
			int temp[] = w.poll();
			if(temp[2] == K) continue;
			for(int i=0;i<4;i++)
			{
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				if (x < 0 || x >= N || y < 0 || y >= M || arr[x][y] == 4) continue;
//				if (temp[2] >= K) break;
				arr[x][y] = 1;
				w.add(new int[] {x,y,temp[2]+1});
			}
		}
	}
}
