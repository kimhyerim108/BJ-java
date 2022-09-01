import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 1;
		String arr = sc.next();
		for(int i=0;i< N;i++)
		{
			char a = arr.charAt(i);
			if(a == 'S')
				count++;
			else if(a == 'L')
			{
				count++;
				i++;
			}
		}
		if(count > N)
			System.out.println(N);
		else
			System.out.println(count);
	}
}
