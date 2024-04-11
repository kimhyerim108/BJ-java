import java.util.*;
import java.io.*;
public class Main
{
    static int[][] arr;
    static int N, r1, r2, c1, c2;
    static boolean[][] visited;
    static int dx[] = {-2,-2,0,0,2,2};
    static int dy[] = {-1,1,-2,2,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visited = new boolean[N][N];
		bfs();
		if(arr[r2][c2] != 0) System.out.println(arr[r2][c2]);
		else System.out.println("-1");
	}
	public static void bfs(){
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[]{r1,c1});
	    while(!q.isEmpty()){
	        int temp[] = q.poll();
	        int x = temp[0];
	        int y = temp[1];
	        for(int i=0;i<6;i++){
	            int a = x + dx[i];
	            int b = y + dy[i];
	            if (a >= N || b>=N|| a <0 || b <0) continue;
	            if (arr[a][b] == 0){
	                arr[a][b] = arr[x][y] + 1;
	                q.add(new int[]{a,b});
	            }
	        }
	    }
	}
}
