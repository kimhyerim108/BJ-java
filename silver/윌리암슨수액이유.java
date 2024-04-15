import java.util.*;
import java.io.*;
public class Main
{
    static int N, M;
    static int[][] arr;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
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
	            if (arr[i][j] == 2) q.add(new int[]{i,j,0});
	        }
	    }
	    int result = bfs();
	    if (result == 0) System.out.println("NIE");
	    else System.out.println("TAK\n" + result);
    }
	public static int bfs(){
	    while(!q.isEmpty()){
	        int temp[] = q.poll();
	        int x = temp[0];
	        int y = temp[1];
	        int time = temp[2];
	        for(int i=0;i<4;i++){
	            int a = x + dx[i];
	            int b = y + dy[i];
	            if (a <0 || b < 0 || a >= N || b >= M) continue;
	            if (!visited[a][b] && arr[a][b] == 0){
	                visited[a][b] = true;
	                q.add(new int[]{a, b,time+1});
	            }
	            if (!visited[a][b] && (arr[a][b] == 3 || arr[a][b] == 4 || arr[a][b] == 5)){
	                return time+1;
	            }
	        }
	    }
	    return 0;
	}
}
