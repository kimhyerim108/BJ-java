import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    arr = new int[N][M];
	    visited = new boolean[N][M];
	    for (int i=0;i<N;i++)
	    {
	        String str = br.readLine();
	        for(int j = 0;j<M;j++)
	            arr[i][j] = str.charAt(j) - '0';
	    }
	    bfs(0, 0);
	    bw.write(arr[N-1][M-1] + "");
	    bw.flush();
	}
	private static void bfs(int x, int y)
	{
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[]{x, y});
	    while (!q.isEmpty())
	    {
	        int temp[] = q.poll();
	        int sx = temp[0];
	        int sy = temp[1];
	        for(int i=0;i<4;i++)
	        {
	            int numx = sx + dx[i];
	            int numy = sy + dy[i];
	            if (numx <0 || numx >= N || numy < 0 || numy >= M) continue;
	            if (arr[numx][numy] == 1 && !visited[numx][numy])
	            {
	                q.add(new int[] {numx, numy});
	                arr[numx][numy] = arr[sx][sy] + 1;
	                visited[numx][numy] = true;
	            }
	        }
	    }
	}
}
