import java.util.*;
import java.io.*;
public class Main
{
    static int a, b, N, M;
    static List<Integer> arr[];
    static boolean[] visited;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    a = Integer.parseInt(st.nextToken());
	    b = Integer.parseInt(st.nextToken());
	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    arr = new List[N+1];
	    visited = new boolean[N+1];
	    for(int i=1;i<=N;i++) arr[i] = new ArrayList<>();
	    
	    for(int i=0;i<M;i++){
	        st = new StringTokenizer(br.readLine());
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	        
	        arr[x].add(y);
	        arr[y].add(x);
	    }
	    System.out.println(bfs());
	}
	public static int bfs(){
	    Queue<int[]> q = new LinkedList<>();
	    visited[a] = true;
	    q.add(new int[]{a,0});
	    
	    while(!q.isEmpty()){
	        int temp[] = q.poll();
	        
	        if (temp[0] == b) return temp[1];
	        
	        for(int i: arr[temp[0]]){
	            if (visited[i]) continue;
	            visited[i] = true;
                q.add(new int[]{i,temp[1]+1});
	        }
	    }
	    return -1;
	}
}
