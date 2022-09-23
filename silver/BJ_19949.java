import java.io.*;
import java.util.*;
public class Main
{
    static int[] answer = new int[11];
    static int[] arr = new int[11];
    static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<10;i++)
		    answer[i] = Integer.parseInt(st.nextToken());
		tracking(0);
		bw.write(count + "");
		bw.flush();
	}
	static void tracking(int num)
	{
	    if (num == 10)
	    {
	        int cnt = 0;
	        for (int i=0;i< 10;i++)
	       {
	           if (arr[i] == answer[i])
	                cnt++;
	       }
	        if (cnt >= 5)
	            count++;
	        return ;
	    }
	    for(int i=1;i<=5;i++)
	    {
	        if (num >= 2)
	            if (arr[num - 1] == i && arr[num - 2] == i) continue;
	        arr[num] = i;
	        tracking(num + 1);
	    }
	}
}
