import java.util.*;
import java.io.*;
public class Main
{
    static int N,M,result = Integer.MAX_VALUE;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static Queue<int[]> water;
    static Queue<int[]> doch;
    static char[][] arr;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    arr = new char[N+1][M+1];
	    water = new LinkedList<>();
	    doch = new LinkedList<>();
	    
	    for(int i=0;i<N;i++)
	    {
	        String str = br.readLine();
	        for(int j=0;j<M;j++)
	        {
	            arr[i][j] = str.charAt(j);
	            if(arr[i][j] == 'S') doch.add(new int[]{i,j,0});
	            if (arr[i][j] == '*') water.add(new int[]{i,j});
	        }
	    }
	    bfs();
	    System.out.println((result !=Integer.MAX_VALUE ? result : "KAKTUS"));
	}
	public static void bfs(){
	    while(!doch.isEmpty()){
	        int size = water.size();
	        for(int p=0;p<size;p++)
	        {
    	        int x[] = water.poll();
    	        int a = x[0];
    	        int b = x[1];
    	        for(int i=0;i<4;i++){
    	            int nx = a + dx[i];
    	            int ny = b + dy[i];
    	            
    	            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
    	            if (arr[nx][ny] == '.'){
    	                arr[nx][ny] = '*';
    	                water.add(new int[]{nx,ny});
    	            }
    	        }
	        }
	        int p = doch.size();
	        for(int k=0;k<p;k++)
	        {
    	        int d[] = doch.poll();
    	        int e= d[0];
    	        int f= d[1];
    	        int time = d[2];
    	        for(int i=0;i<4;i++){
    	            int nx = e + dx[i];
    	            int ny = f + dy[i];
    	            
    	            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
    	            if (arr[nx][ny] == 'D')
    	            {
    	                result = Math.min(result,time + 1);
    	                break;
    	            }
    	            if (arr[nx][ny] == '.'){
        	            arr[nx][ny] = 'S';
    	                doch.add(new int[]{nx,ny,time + 1});
    	            }
    	            
    	        }
	        }
	    }
	}
}
