import java.io.*;
import java.util.*;
public class Main
{
    static int T;
    static int N, M,K;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    T = Integer.parseInt(br.readLine());
	    
	    for(int z=0;z<T;z++)
	    {
	        int count=0;
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        M = Integer.parseInt(st.nextToken());
    	    N = Integer.parseInt(st.nextToken());
    	    K = Integer.parseInt(st.nextToken());
    	    
    	    arr = new int[M][N];
    	    visited = new boolean[M][N];
    	    for(int i=0;i<K;i++)
    	    {
    	        st = new StringTokenizer(br.readLine());
    	        
	            int a = Integer.parseInt(st.nextToken());
	            int b = Integer.parseInt(st.nextToken());
	            arr[a][b] = 1;
    	    }
    	    for(int i=0;i<M;i++)
    	    {
    	        for(int j = 0;j<N;j++)
    	        {
    	            if (!visited[i][j] &&arr[i][j]==1)
    	            {
    	                count++;
    	                bfs(i,j);
    	            }
    	        }
    	    }
    	    System.out.println(count);
	    }
	}
	static void bfs(int i, int j)
	{
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[] {i,j});
	    visited[i][j] = true;
	    while (!q.isEmpty())
	    {
	        i  = q.peek()[0];
	        j = q.peek()[1];
	        q.poll();
	        for(int a=0;a<4;a++)
	        {
	            int x = i + dx[a];
	            int y = j + dy[a];
	            if (x <0 || x>=M||y<0||y>=N) continue;
	            if (!visited[x][y] && arr[x][y] == 1)
	            {
	                q.add(new int[] {x,y});
	                visited[x][y]= true;
	            }
	        }
	    }
	}
