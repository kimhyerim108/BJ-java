import java.util.Scanner;

public class 오타맨고창영_2711 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++)
		{
			int N=sc.nextInt();
			String str=sc.next();
			int count=-1;
			for(int j=0;j<str.length();j++)
			{
				count++;
				if(count==N - 1) continue;
				else System.out.print(str.charAt(j));
			}
			System.out.println();
		}
	}
}
