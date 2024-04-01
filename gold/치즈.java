import java.util.*;
import java.io.*;
public class Main
{
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean visited[][];
    static int N, M, arr[][],count=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++)
		{
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<M;j++)
		    {
		        arr[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		int ans;
		for(ans =0; ischeck();ans++)
		{
		  for (boolean[] arr : visited) {
				Arrays.fill(arr, false);
			}
		    count=0;
		    bfs(0,0);
		}
		System.out.println(ans+"\n"+count);
	}
	public static boolean ischeck(){
	    for(int i=0;i<N;i++)
	    {
	        for(int j=0;j<M;j++){
	            if(arr[i][j] ==9)
	                arr[i][j] =0;
	        }
	    }
	    for(int i=0;i<N;i++)
	    {
	        for(int j=0;j<M;j++){
	            if(arr[i][j] ==1)
	                return true;
	        }
	    }
	    return false;
	}
	public static void bfs(int a, int b){
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[]{a,b});
	    
	    while(!q.isEmpty()){
	        int temp[] = q.poll();
    	    int x = temp[0];
    	    int y = temp[1];
    	    visited[x][y] = true;
    	    for(int i=0;i<4;i++){
    	        int px = x + dx[i];
    	        int py = y + dy[i];
    	        if (px >= N || py >= M || px <0 || py < 0) continue;
    	        if (!visited[px][py]){
    	            visited[px][py] = true;
        	        if (arr[px][py] ==  1)
        	        {
        	            
        	            arr[px][py] = 9;
        	            count++;
        	        }
        	        else
        	            q.add(new int[]{px,py});
    	        }
    	    }
	    }
	}
}
