import java.util.*;

public class 괄호의값_2504 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		String str = sc.nextLine();
		int value = 1;
		int result =0;
		for(int i=0;i<str.length();i++)
		{
			if (str.charAt(i) == '(')
			{
				value *= 2;
				stack.push(str.charAt(i));
			}
			else if(str.charAt(i) == '[')
			{
				value *= 3;
				stack.push(str.charAt(i));
			}
			else if(str.charAt(i) == ')')
			{
				if (stack.isEmpty() || stack.peek() != '(')
				{
					result = 0;
					break ;
				}
				else if(str.charAt(i - 1) == '(')
					result += value;
				stack.pop();
				value /= 2;
			}
			else if(str.charAt(i) == ']')
			{
				if (stack.isEmpty() || stack.peek() != '[')
				{
					result = 0;
					break ;
				}
				else if(str.charAt(i - 1) == '[')
					result += value;
				stack.pop();
				value /= 3;
			}
		}
		if(!stack.empty()) System.out.println(0);
		else
			System.out.println(result);
	}
}
