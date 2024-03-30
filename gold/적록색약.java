import java.util.*;
import java.io.*;
public class Main
{
    static char[][] arr;
    static char[][] colorb;
    static boolean[][] visited;
    static boolean[][] colorVisite;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N+1][N+1];
		colorb = new char[N+1][N+1];
		visited = new boolean[N+1][N+1];
		colorVisite = new boolean[N+1][N+1];
		int a=0,b=0;
		for(int i=0;i<N;i++){
		    String str = br.readLine();
		    for(int j=0;j<N;j++){
		        arr[i][j] = str.charAt(j);
		        if (str.charAt(j) == 'G')
		            colorb[i][j] = 'R';
		        else colorb[i][j] = str.charAt(j);
		    }
		}
		for(int i=0;i<N;i++){
		    for(int j=0;j<N;j++){
		        if(!visited[i][j])
		        {
		            a++;
		            bfs(i,j,visited,arr[i][j],arr);
		        }
		        if (!colorVisite[i][j])
		        {
		            b++;
		            bfs(i,j,colorVisite,colorb[i][j],colorb);
		        }
		    }
		}
		System.out.println(a + " " + b);
	}
	public static void bfs(int x, int y,boolean[][] visited,char str,char[][] array){
	    Queue<int[]> queue = new LinkedList<>();
	    queue.add(new int[]{x,y});
	    while(!queue.isEmpty()){
	        int[] temp = queue.poll();
	        int a = temp[0];
	        int b = temp[1];
	        for(int i=0;i<4;i++){
	            int px = a + dx[i];
	            int py = b + dy[i];
	            if(px >= N || py >= N || px < 0 || py < 0) continue;
	            if (!visited[px][py] && array[px][py] == str)
	            {
	                visited[px][py] = true;
	                queue.add(new int[]{px,py});
	            }
	        }
	    }
	}
}
