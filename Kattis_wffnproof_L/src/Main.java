import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
 * 	https://math.stackexchange.com/questions/2395470/why-will-an-implication-be-true-when-the-hypothesis-is-false
 *  when hypothesis is false --> the implied knowledge is true.
 *  
 *  3 types:
 *  	1. K, A, C, E : Must be in the form (1)(2)(2) or (1)(2)((1)(2)(2)), etc. 
 *  	2. N : can be added to any valid pairs of logic 
 *  	2. p q r s t : boolean variables.
 */


public class Main {
	public static String in_raw_str, out_proposed_str, tmp;
	// public static Stack<Character> N_stack = new Stack<Character>();
	// public static Stack<Character> bool_stack = new Stack<Character>();
	// public static Stack<Character> logic_stack = new Stack<Character>();
	public static int idx;
	public static char tmp_char;
	public static boolean isFirstRound;
	
	
	public static void main(String[] arg)
	{		
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_anotherbrick\\src\\2.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			while(sc.hasNext())
			{
				in_raw_str = sc.next();
				if (in_raw_str == "0")
				{
					return;
				}
				else
				{
					isFirstRound = true;
					Stack<Character> N_stack = new Stack<Character>();
					Stack<Character> bool_stack = new Stack<Character>();
					Stack<Character> logic_stack = new Stack<Character>();
					idx = 0;
					while(idx < in_raw_str.length())
					{
						tmp_char = in_raw_str.charAt(idx);
						switch(tmp_char)
						{
						case('p'):
						case('q'):
						case('r'):
						case('s'):
						case('t'):
							bool_stack.add(tmp_char);
							break;
						case('K'):
						case('A'):
						case('C'):
						case('E'):
							logic_stack.add(tmp_char);
							break;
						case('N'):
							N_stack.add(tmp_char);
							
						}
						idx++;
					}
					if (bool_stack.size() == 0)
					{
						System.out.println("no WFF possible");
						return;
					}
					out_proposed_str = "";
					tmp = "";
					
					// what if there are only one logic variable? You can only negate it
					if (bool_stack.size() == 1)
					{
						tmp = out_proposed_str;
						tmp_char = bool_stack.pop();
						out_proposed_str = tmp_char + tmp;
						
						while (N_stack.size() > 0)
						{
							tmp = out_proposed_str;
							tmp_char = N_stack.pop();
							out_proposed_str = tmp_char + tmp;
						}
						System.out.println(out_proposed_str);
						return;
					}
					else
					{
						while(bool_stack.size() > 0)
						{
							if (logic_stack.size() > 0)
							{
								// a sequential flow to generate the string required.
								tmp = out_proposed_str;
								tmp_char = bool_stack.pop();
								out_proposed_str = tmp_char + tmp;
								// add negation to make the formula longer
								if (N_stack.size() > 0)
								{
									tmp = out_proposed_str;
									tmp_char = N_stack.pop();
									out_proposed_str = tmp_char + tmp;
								}
								// may add another logic variable with negation if possible?
								if (isFirstRound)
								{
									if (bool_stack.size() > 0)
									{
										tmp = out_proposed_str;
										tmp_char = bool_stack.pop();
										out_proposed_str = tmp_char + tmp;
									}
									if (N_stack.size() > 0)
									{
										tmp = out_proposed_str;
										tmp_char = N_stack.pop();
										out_proposed_str = tmp_char + tmp;
									}
									isFirstRound = false;
								}
								// logic symbol
								tmp = out_proposed_str;
								tmp_char = logic_stack.pop();
								out_proposed_str = tmp_char + tmp;
							}
							else
							{
								break;
							}
						}
						while(N_stack.size() > 0)
						{
							tmp = out_proposed_str;
							tmp_char = N_stack.pop();
							out_proposed_str = tmp_char + tmp;
						}
						System.out.println(out_proposed_str);
						return;
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
