import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static ArrayList<Long> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		if (N > 1022)
		{
		    bw.write("-1");
		    bw.flush();
		    return ;
		}
	    for(int i=0;i<10;i++)
	        dp(i);
	    Collections.sort(list);
	    bw.write(list.get(N) + "");
		bw.flush();
	}
	static void dp(long num)
	{
	    list.add(num);
	    for(int i=0;i<num%10;i++)
	        dp((num*10) + i);
	}
