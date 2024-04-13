import java.util.*;
import java.io.*;
public class Main
{
    static int A, B, N, M;
    static boolean[] visited;
    static int[] answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		answer = new int[100001];
		visited = new boolean[100001];
		bfs();
		System.out.println(answer[M]);
	}
	public static void bfs(){
	    Queue<Integer> q = new LinkedList<>();
	    q.add(N);
	    visited[N] = true;
	    
	    while(!q.isEmpty()){
	        int x = q.poll();
	        int arr[] = {x*A,x*B,x+A,x-A,x+B,x-B,x+1,x-1};
	        for(int i=0;i<8;i++){
	            if (arr[i]>=0&& arr[i] <= 100000 && !visited[arr[i]]){
	                visited[arr[i]] = true;
	                answer[arr[i]] = answer[x]+1;
	                q.add(arr[i]);
	            }
	        }
	        if (answer[M] > 0) break;
	    }
	}
}
