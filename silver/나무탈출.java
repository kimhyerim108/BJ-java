import java.util.*;
import java.io.*;
public class Main
{
    static List<Integer> list[];
    static int cnt = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		    list[i] = new ArrayList<>();
		for(int i=0;i<N-1;i++)
		{
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    list[a].add(b);
		    list[b].add(a);
		}
		recur(1,-1,0);
		System.out.println((cnt % 2 !=0)? "Yes" : "No");
	}
    static void recur(int i, int compare, int depth)
    {
        for(int x : list[i])
        {
            if(x != compare)
                recur(x,i,depth+1);
        }
        if (compare != -1 && list[i].size() == 1)
            cnt+=depth;
    }
}
