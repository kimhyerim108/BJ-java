import java.util.*;
import java.io.*;
public class Main
{
    static int[] board;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new int[101];
		for(int i=0;i<101;i++)
		    board[i] = i;
		//사다리  숫자
		for(int i=0;i<N;i++)
		{
		    st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    
		    board[x] = y;
		}
		//뱀 숫자
		for(int i=0;i<M;i++)
		{
		    st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    
		    board[x] = y;
		}
		System.out.println(bfs(1));
	}
	public static int bfs(int start){
	    Queue<Integer> q = new LinkedList<>();
	    q.add(start);
	    int check[] = new int[101];
	    while(true){
	       int num = q.poll();
	       for(int i=1;i<7;i++){
	           int newNum = num + i;
	           
	           if (newNum > 100) continue;
	           if (check[board[newNum]]==0){
	               q.add(board[newNum]);
	               check[board[newNum]] = check[num] + 1;
	           }
	           if (board[newNum] == 100)
	                return check[100];
	       }
	    }
	}
}
