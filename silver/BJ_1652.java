import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char arr[][] = new char[N][N];
		for(int i=0;i<N;i++)
		{
		    String str = br.readLine();
		    for(int j=0;j<N;j++)
		    {
		        arr[i][j] = str.charAt(j);
		    }
		}
		int horizontal = 0;
		int vertical = 0;
		for(int i=0;i<N;i++)
		{
		    int check_h = 0, check_v =0;
		    for(int j=0;j<N;j++)
		    {
		        if(arr[i][j] == '.') check_h++;
		        if (arr[i][j] == 'X' || j == (N-1)){
		            if (check_h >= 2) horizontal++;
		            check_h =0;
		        }
		        if (arr[j][i] == '.') check_v++;
		        if (arr[j][i] == 'X' || j == (N-1))
		        {
		            if (check_v >= 2) vertical++;
		            check_v = 0;
		        }
		    }
		}
		System.out.println(horizontal + " " + vertical);
	}
}
