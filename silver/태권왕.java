import java.util.*;
import java.io.*;
public class Main
{
    static int S,T;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int C = Integer.parseInt(br.readLine());
		
		for(int i=0;i<C;i++){
		    st = new StringTokenizer(br.readLine());
    		S = Integer.parseInt(st.nextToken());
    		T = Integer.parseInt(st.nextToken());
    		System.out.println(bfs());
		}
	}
	static int bfs(){
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[]{S, T,0});
	   
	    while(!q.isEmpty()){
	        int temp[] = q.poll();
	        int x = temp[0];
	        int y = temp[1];
	        int time = temp[2];
	        if (x == y){
	            return time;
	        }
	        if (x > y) continue;
            q.add(new int[]{x+1,y,time+1});
            q.add(new int[]{x*2, y + 3,time+1});
	    }
	    return -1;
	}
}
