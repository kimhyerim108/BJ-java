import java.util.*;

public class 단어뒤집기2_17413 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer buffer = new StringBuffer();
		String str = sc.nextLine() + "\n";
		Stack stack = new Stack<>();
		for(int i=0;i<str.length();i++)
		{
			if (str.charAt(i) == ' ' || str.charAt(i) == '\n')
			{
				if (str.charAt(i) == '<')
				{
					while (true) {
						if (str.charAt(i) != '>')
							i++;
					}
					buffer.append(str.charAt(i));
				}
				else
				{
					while(!stack.empty())
						buffer.append(stack.pop());
					buffer.append(str.charAt(i));
				}
			}
			else
				stack.add(str.charAt(i));
		}
		System.out.println(buffer.toString());
	}
}
