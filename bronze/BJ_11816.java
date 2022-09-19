import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 팔십십육 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int jin = 10;
		if (str.startsWith("0x"))
		{
			str = str.substring(2);
			jin = 16;
		}
		else if(str.startsWith("0"))
		{
			str = str.substring(1);
			jin = 8;
		}
		int a=Integer.parseInt(str, jin);
		bw.write(a + " ");
		bw.flush();
		bw.close();
	}
}
