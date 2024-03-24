import java.util.*;
import java.io.*;
public class Main
{
    static int[] answer;
    static List<Integer>[] list;
    static boolean visited[];
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    StringTokenizer st;
	    list = new ArrayList[N+1];
	    visited = new boolean[N+1];
	    answer = new int[N+1];
	    for(int i=0;i<N+1;i++)
	        list[i] = new ArrayList<>();
	    for(int i=1;i<N;i++){
	       st = new StringTokenizer(br.readLine());
	       int a = Integer.parseInt(st.nextToken());
	       int b = Integer.parseInt(st.nextToken());
	       list[a].add(b);
	       list[b].add(a);
	   }
	   dfs(1);
	   for(int i=2;i<N+1;i++)
	        System.out.println(answer[i]);
	}
	static void dfs(int index){
	    visited[index] = true;
	    for(int i: list[index])
	    {
	        if (!visited[i])
	        {
	            answer[i] = index;
	            dfs(i);
	        }
	    }
	}
}
