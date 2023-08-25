import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int start = Integer.parseInt(br.readLine());
        bw.write((start % 2 == 1)? "SK" : "CY");
        bw.flush();
	}
}
