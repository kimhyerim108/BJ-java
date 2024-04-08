import java.util.*;
import java.io.*;
public class Main
{
    static List<Integer>[] array;
    static int[] visited;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    int X = Integer.parseInt(st.nextToken()); //출발도시번호
		array = new List[N+1];
		visited = new int[N+1];
		for(int i=1;i<=N;i++) array[i] = new ArrayList<>();
		for(int i=0;i<M;i++)
		{
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    array[a].add(b);
		}
		for(int i=0;i<=N;i++) visited[i] = -1;
		boolean flag = false;
		Queue<Integer> q = new LinkedList<>();
        q.add(X);
        visited[X] = 0;
        while(!q.isEmpty()){
            int a = q.poll();
            for(int i : array[a]){
                if (visited[i] == -1){
                    visited[i] = visited[a] + 1;
                    q.add(i);
                }
            }
        }
        for(int i=1;i<=N;i++)
        {
            if (visited[i] == K) {
                flag = true;
                System.out.println(i);
            }
        }
        if (!flag) System.out.println("-1");
	}
}
