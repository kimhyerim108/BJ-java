import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for(int i=0;i<N;i++)
		    arr[i] = br.readLine();
		 HashSet<String> set = new HashSet<>();
		 int len = arr[0].length();
		 for(int i = 1;i<=len;i++)
		 {
		     for(int j=0;j<N;j++)
		          set.add(arr[j].substring(len-i));
		      if (set.size() == N)
		      {
		          System.out.println(i);
		          return;
		      }
		      set.clear();
		 }
	}
}
