import java.util.*;
import java.io.*;

public class Main
{
    static int maxInt = 100;
    static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		arr = new int[maxInt][maxInt];
		for(int i=0;i<4;i++)
		{
		    StringTokenizer st = new StringTokenizer(br.readLine());
	        int x1 = Integer.parseInt(st.nextToken());
	        int y1 = Integer.parseInt(st.nextToken());
	        int x2 = Integer.parseInt(st.nextToken());
	        int y2 = Integer.parseInt(st.nextToken());
	        square(x1,x2,y1,y2);
		}
		System.out.println(sum());
	}
	static void square(int x, int x2, int y, int y2)
	{
	    for(int i=x;i<x2;i++)
	    {
	        for(int j=y;j<y2;j++)
	           arr[i][j] = 1;
	    }
	}
	static int sum()
	{
	    int sum = 0;
	    for(int i=0;i<maxInt;i++)
	        for(int j =0;j<maxInt;j++)
	            sum += arr[i][j];
	    return sum;
	}
}
