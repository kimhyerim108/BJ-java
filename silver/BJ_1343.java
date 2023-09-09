import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.replaceAll("XXXX","AAAA");
		str = str.replaceAll("XX","BB");
		if (str.contains("X"))
		{
		    System.out.println("-1");
		    System.exit(0);
		}
		System.out.println(str);
	}
}
