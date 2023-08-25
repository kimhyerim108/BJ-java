package baekjoon;

import java.util.Scanner;

public class 섬의개수4963 {
	static int[] dx = {-1,1,0,0,-1,1,-1,1};
	static int[] dy = {0,0,-1,1,1,1,-1,-1};
	static int[][] island;
	static boolean[][] visited;
	static int w, h, count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			island = new int[h][w];
			visited = new boolean[h][w];
			for(int i=0;i<h;i++)
			{
				for(int j=0;j<w;j++)
					island[i][j] = sc.nextInt();
			}
			count = 0;
			for(int i=0;i<h;i++)
			{
				for(int j=0;j<w;j++)
				{
					if (island[i][j] == 1 && !visited[i][j])
					{
						count++;
						dfs(i, j);
					}
				}
			}
			System.out.println(count);
		}
	}
	static void dfs(int a, int b) {
		visited[a][b] = true;

        for (int i = 0; i < 8; i++) {
            int na = a + dx[i];
            int nb = b + dy[i];

            if (na < 0 || na >= h || nb < 0 || nb >= w) 
                continue;
            if (island[na][nb] == 1 && !visited[na][nb]) {
            	visited[na][nb] = true; 
                dfs(na, nb);
            }
        }
	}
}
