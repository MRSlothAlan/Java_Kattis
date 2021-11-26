import java.util.*;
import java.io.*;


public class Main {
	
	public static String in_str = "";
	public static int i;
	public static float
				count_whitespace,
				count_lowercase,
				count_uppercase,
				count_symbol;
	public static char tmp_char;
	/*
	 * the ratios of whitespace characters, 
	 * lowercase letters, 
	 * uppercase letters, and 
	 * symbols (in that order)
	 */
	public static void ratio_calculation() {
		count_whitespace = 0;
		count_lowercase = 0;
		count_uppercase = 0;
		count_symbol = 0;
		// 65 ~ 90, 97 ~ 122
		for (i = 0; i < in_str.length(); i++)
		{
			tmp_char = in_str.charAt(i);
			if (tmp_char == '_')
			{
				count_whitespace++;
			}
			else if(65 <= (int)tmp_char && (int)tmp_char <= 90)
			{
				count_uppercase++;
			}
			else if(97 <= (int)tmp_char && (int)tmp_char <= 122)
			{
				count_lowercase++;
			}
			else
			{
				count_symbol++;
			}
		}
		
		System.out.printf("%f\n", count_whitespace / (float)in_str.length());
		System.out.printf("%f\n", count_lowercase / (float)in_str.length());
		System.out.printf("%f\n", count_uppercase / (float)in_str.length());
		System.out.printf("%f\n", count_symbol / (float)in_str.length());
	}
	
	public static void main(String[] arg)
	{
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_alphabetspam\\src\\1.in");
		try {
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			in_str = sc.next();
			ratio_calculation();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
