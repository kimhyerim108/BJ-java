import java.util.*;
import java.io.*;
public class Main
{
    static int N, M,count =0;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++)
		{
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<M;j++){
		        arr[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		int ans=0;
		for(int i=0;isCheck();i++)
		{
		    visited = new boolean[N][M];
		    ans++;
		    count=0;
		    dfs(0,0);
		}
		System.out.print(ans + "\n" +count);
	}
	public static boolean isCheck(){
	    for(int i=0;i<N;i++)
	    {
	        for(int j=0;j<M;j++)
	        {
	            if (arr[i][j] == 9) arr[i][j] =0;
	        }
	    }
	    for(int i=0;i<N;i++)
	    {
	        for(int j=0;j<M;j++)
	        {
	            if (arr[i][j] == 1) return true;
	        }
	    }
	    return false;
	}
	public static void dfs(int x,int y)
	{
	   for(int i=0;i<4;i++)
	   {
	       int px = x + dx[i];
	       int py = y + dy[i];
	       if (px >= N || py >= M || px < 0 || py < 0) continue;
	       if (!visited[px][py]){
	           visited[px][py] = true;
	           if (arr[px][py] == 1) {
	               arr[px][py] = 9;
	               count++;
	           }
	           else dfs(px, py);
	       }
	   }
	}
}
