package gold;

import java.io.*;
import java.util.*;

public class 토마토 {
	public static class TOMATO{
		int h;
		int x;
		int y;
		public TOMATO(int h,int x, int y)
		{
			this.h = h;
			this.x = x;
			this.y = y;
		}
	}
	static int M, N, H;
	static int[][][] arr;
	static int dx[]= {-1,1,0,0,0,0};
	static int dy[]= {0, 0, -1, 1, 0, 0};
	static int dz[] = {0, 0, 0, 0,-1,1};
	static Queue<TOMATO> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H+1][N+1][M+1];
		for(int i=0;i<H;i++)
		{
			for(int j=0;j<N;j++)
			{
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<M;k++)
				{
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if(arr[i][j][k]==1)
						q.add(new TOMATO(i, j, k));
				}
			}
		}
		System.out.println(bfs());
	}
	static int bfs()
	{
		
		while(!q.isEmpty())
		{
			TOMATO t = q.poll();
			for(int i=0;i<6;i++)
			{
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				int nz = t.h + dz[i];
				if (nx < 0 || nx>=N||ny<0||ny>=M||nz<0||nz>=H) continue;
				if(arr[nz][nx][ny]==0)
				{
					q.add(new TOMATO(nz, nx, ny));
					arr[nz][nx][ny] =arr[t.h][t.x][t.y]+1;
				}
			}
		}
		int result = Integer.MIN_VALUE;
		for(int i=0;i<H;i++)
		{
			for(int j=0;j<N;j++)
			{
				for(int k=0;k<M;k++)
				{
					if(arr[i][j][k]==0)
						return -1;
					result = Math.max(result, arr[i][j][k]);
				}
			}
		}
		if (result == 1) return 0;
		else return result-1;
	}
}
