import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    HashMap<String, String> map = new HashMap<String, String>();
	    int T = Integer.parseInt(br.readLine());
	    for(int i=0;i<T;i++)
	    {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        String name = st.nextToken();
	        String check = st.nextToken();
	        if (map.containsKey(name))
	            map.remove(name);
	       else
	            map.put(name, check);
	    }
	    ArrayList<String> list = new ArrayList<String>(map.keySet());
	    Collections.sort(list,Collections.reverseOrder());
	    for(var i : list)
	        System.out.println(i);
	}
}
