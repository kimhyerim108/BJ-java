import java.util.*;
import java.io.*;
public class Main{
    static int N,M;
    static char[][] arr;
    static boolean[][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int blue=1, white=1,b=0,w=0;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    arr = new char[M][N];
	    visited = new boolean[M][N];
	    for(int i=0;i<M;i++)
	    {
	        String str = br.readLine();
	        for(int j=0;j<N;j++)
	            arr[i][j] = str.charAt(j);
	    }
	     for(int i=0;i<M;i++)
	    {
	        for(int j=0;j<N;j++)
	        {
	            if (!visited[i][j])
	            {
	                bfs(i,j,arr[i][j]);
	                if (arr[i][j] == 'B')
	                    b+= Math.pow(blue,2);
	                else if(arr[i][j] == 'W')
	                    w+= Math.pow(white,2);
	            }
	            blue=1;white=1;
	        }
	    }
	    bw.write(w + " " + b);
	    bw.flush();
	}
	static void bfs(int a, int b, char c)
	{
	    visited[a][b] = true;
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[] {a,b});
	    while (!q.isEmpty())
	    {
	        int temp[] = q.poll();
	        int x = temp[0];
	        int y = temp[1];
	        for(int i=0;i<4;i++)
	        {
	            int nx = x + dx[i];
	            int ny = y + dy[i];
	            if (nx<0 || nx >= M ||ny <0 || ny >=N)continue;
	            if (!visited[nx][ny] && arr[nx][ny]==c)
	            {
	                q.add(new int[] {nx,ny});
	                visited[nx][ny] = true;
	                if (c=='W') white++;
	                else if(c == 'B') blue++;
	                
	            }
	        }
	    }
	}
}
