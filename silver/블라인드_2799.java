import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int M = sc.nextInt();
	    int N = sc.nextInt();
	    int index=0;
	    sc.nextLine();
	    String[] array = new String[N+1];
	    int[] answer = new int[5];
	    for(int i=0;i<array.length;i++)
	        array[i] = "";
	    for(int i=0;i<M*5+1;i++)
	    {
	        String str = sc.nextLine();
	        if(str.contains("*") || str.contains("."))
	        {
	            for(int j = 1;j<N*5 +1;j+=5)
	            {
	                array[index]+=str.charAt(j);
	                index++;
	            }
	            index-=N;
	        }
	        else
	        {
	            for(int j=0;j<array.length;j++)
	            {
	                if(array[j].equals("...."))
	                    answer[0]++;
	                else if(array[j].equals("*..."))
	                    answer[1]++;
	                else if(array[j].equals("**.."))
	                    answer[2]++;
	                else if(array[j].equals("***."))
	                    answer[3]++;
	                else if(array[j].equals("****"))
	                    answer[4]++;
	               array[j] ="";
	            }
	            index=0;
	        }
	    }
	    for(int i:answer)
	        System.out.print(i + " ");
	}
}
