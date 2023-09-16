import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int x = N/2;
		int y = N/2;
		int val = 1;
		int limit = 1;
		while(true)
		{
		    for(int i=0;i<limit;i++)
		        map[x--][y] = val++;
		        
		    if (val >= N* N) break;
		    
		    for(int i=0;i<limit;i++)
		        map[x][y++] = val++;
		        
		    limit++;
		    for(int i=0;i<limit;i++)
		        map[x++][y] = val++;
		        
		    for(int i=0;i<limit;i++)
		        map[x][y--] = val++;
		    limit++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++)
		{
		    for(int j=0;j<N;j++)
		    {
		        if (map[i][j] == T) {x = i + 1; y = (j + 1);}
		        sb.append(map[i][j] + " ");
		    }
		    sb.append("\n");
		}
		sb.append(x + " " + y);
		System.out.println(sb.toString());      
	}
}
