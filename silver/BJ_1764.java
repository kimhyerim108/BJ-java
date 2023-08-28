import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<N;i++)
		    map.put(br.readLine(), 1);
		for(int i=0;i<M;i++)
		{
		    String name = br.readLine();
		    if (map.containsKey(name)) {list.add(name);}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(var i : list)
		    System.out.println(i);
	}
}
