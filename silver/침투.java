import java.util.*;
import java.io.*;
public class Main
{
    static int[][] arr;
    static int N, M;
    static int[] dx = {-1,1, 0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static boolean flag = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++){
		    String str = br.readLine();
		    for(int j=0;j<M;j++){
		        arr[i][j] = str.charAt(j) - '0';
		    }
		}
	    for(int j=0;j<M;j++){
	        if(!visited[0][j] && arr[0][j] == 0)
	            dfs(0,j);
	    }
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
	public static void dfs(int x, int y){
	    if(x == (N  - 1)) flag = true;
	    for(int i=0;i<4;i++){
	        int px = x + dx[i];
	        int py = y + dy[i];
	        if(px < 0 || py < 0 || px >= N || py >= M) continue;
	        if (arr[px][py] ==0 && !visited[px][py]){
	            visited[px][py] = true;
	            arr[px][py] += 2;
	            dfs(px, py);
	        }
	    }
	}
}
