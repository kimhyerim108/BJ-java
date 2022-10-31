import java.io.*;
import java.util.*;


public class Main {
	public static class Node{
		int x;
		int y;
		int i;
		int j;
		public Node(int x, int y, int i, int j) {
			this.x=x;
			this.y=y;
			this.i=i;
			this.j=j;
		}
	}
	static int min = -1;
	static int N, M, K;
	static int[][] arr;
	static int dx[]= {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M][K+2];
		for(int i=0;i<N;i++)
		{
			String str = br.readLine();
			for(int j=0;j<M;j++)
				arr[i][j] = str.charAt(j)-'0';
		}
		bfs();
		
		bw.write(min+"");
		bw.flush();
	}
	static void bfs()
	{
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0, 1));
		visited[0][0][0] = true;
		while (!q.isEmpty())
		{
			Node temp = q.poll();
			if (temp.x == N-1 && temp.y == M-1)
			{
				min = temp.j;
				return;
			}
			for(int i=0;i<4;i++)
			{
				int x = temp.x + dx[i];
				int y = temp.y + dy[i];
				if (x < 0 || x >= N || y < 0 || y >= M) continue;
				if (!visited[x][y][temp.i] && arr[x][y] == 0)
				{
					visited[x][y][temp.i] = true;
					q.add(new Node(x,y,temp.i,temp.j+1));
				}
				else if(!visited[x][y][temp.i+1]&& arr[x][y] == 1 && temp.i <K)
					{
						visited[x][y][temp.i+1] = true;
						q.add(new Node(x,y,temp.i+1,temp.j+1));
					}
			}
		}
	}
}
