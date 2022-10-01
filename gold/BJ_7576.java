import java.io.*;
import java.util.*;

class to_mato
{
	int x;
	int y;
	to_mato(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
public class 토마토_7576 {
	static int M;
	static int N;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int[][] arr;
	static Queue<to_mato> queue;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		queue = new LinkedList<to_mato>();
		arr = new int[N][M];
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					queue.add(new to_mato(i,j));
			}
		}
		bw.write(BFS() +"");
		bw.flush();
	}
	public static int BFS() {
		while (!queue.isEmpty())
		{
			to_mato t = queue.remove();
			int x = t.x;
			int y = t.y;
			for(int i=0;i<4;i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M)
				{
					if (arr[nx][ny] == 0)
					{
						queue.add(new to_mato(nx, ny));
						arr[nx][ny] = arr[x][y] + 1;
					}
				}
			}
		}
		int result =Integer.MIN_VALUE;
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
			{
				if (arr[i][j] == 0)
					return -1;
				result = Math.max(result, arr[i][j]);
			}
		if (result == 1) return 0;
		else return result-1;
	}
}
