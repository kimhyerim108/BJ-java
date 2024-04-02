import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<M;j++){
		        arr[i][j] = Integer.parseInt(st.nextToken());
		        if (arr[i][j] == 2)
		        {
		            q.add(new int[]{i, j});
		            visited[i][j] = true;
		            arr[i][j] = 0;
		        }
		    }
		}
		bfs();
		for(int i=0;i<N;i++){
		    for(int j=0;j<M;j++){
		        if (!visited[i][j] && arr[i][j] == 1) arr[i][j] = -1;
		        System.out.print(arr[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	public static void bfs(){
	    while(!q.isEmpty()){
	        int temp[] = q.poll();
	        int x = temp[0];
	        int y = temp[1];
	        for(int i=0;i<4;i++){
	            int px = x + dx[i];
	            int py = y + dy[i];
	            if (px >= N || py >= M || px < 0 || py < 0) continue;
	            if (!visited[px][py] && arr[px][py] == 1)
	            {
	                q.add(new int[]{px, py});
	                arr[px][py] = arr[x][y] + 1;
	                visited[px][py] = true;
	            }
	        }
	    }
	}
}
