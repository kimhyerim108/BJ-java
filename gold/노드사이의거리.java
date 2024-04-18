import java.util.*;
import java.io.*;
public class Main
{
    static int tree[][];
    static boolean visited[];
    static int N, M;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    tree = new int[N+1][N+1];
	    
	    for(int i=0;i<N-1;i++){
	        st = new StringTokenizer(br.readLine());
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	        int z = Integer.parseInt(st.nextToken());
	        
	        tree[x][y] = z;
	        tree[y][x] = z;
	    }
	    for(int i=0;i<M;i++){
	        st = new StringTokenizer(br.readLine());
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	        
	        bfs(x, y);
	    }
	}
	static void bfs(int x, int y){
	    Queue<Integer> q = new LinkedList<>();
	    visited = new boolean[N+1];
	    
	    q.add(x);
	    visited[x] = true;
	    
	    int answer[] = new int[N+1];
	    while(!q.isEmpty()){
	        int a = q.poll();
	        
	        for(int i=1;i<N+1;i++){
	            
	            if(tree[a][i] != 0 && !visited[i]){
	                answer[i] = tree[a][i] + answer[a];
	                
	                if (i == y) {
	                    System.out.println(answer[y]);
	                    return;
	                }
	                q.add(i);
	                visited[i] = true;
	            }
	        }
	    }
	}
}
