import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] woolim = new int[10];
		int[] start = new int[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<9;i++)
		    woolim[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<9;i++)
		    start[i] = Integer.parseInt(st.nextToken());
		int sum1=0, sum2=0;
		boolean win=false;
		for(int i=0;i<9;i++)
		{
		    sum1 += woolim[i];
		    if (sum1 > sum2)
		        win = true;
		    sum2 += start[i];
		    if (sum1 > sum2)
		        win = true;
		}
		if (sum1 < sum2 && win)
		    System.out.println("Yes");
		else
		    System.out.println("No");
	}
}
