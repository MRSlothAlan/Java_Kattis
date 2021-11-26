import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Emag Eht 
 * 		Please do the help me with the game question first.
 * 
 * chessboard
 * K, Q, R, B, N, P
 * 
 * Black --> :
 * white --> .
 * 
 * 8 = first row
 * a = left-most column.
 * etc.
 * 
 * description order: K, Q, R, B, N, pawn (no need to show names)
 * 
 * smaller row number if white, same type
 * larger row number if black, same type
 * 
 * white player --> uppercase letter
 * black player --> lowercase letter.
 * 
 * same type in same row?
 * show one with smaller column letter.
 */
class ChessComparatorBlack implements Comparator<String> {
	@Override
	public int compare(String arg0, String arg1) {
		char[] first_chess = arg0.toCharArray();
		char[] second_chess= arg1.toCharArray();
		// descending order of type.
		if (Character.getNumericValue(first_chess[0]) < Character.getNumericValue(second_chess[0]))
		{
			return 1;
		}
		else if (Character.getNumericValue(first_chess[0]) > Character.getNumericValue(second_chess[0]))
		{
			return -1;
		}
		else
		{	// descending order of row number
			if (Character.getNumericValue(first_chess[2]) < Character.getNumericValue(second_chess[2]))
			{
				return -1;
			}
			else if (Character.getNumericValue(first_chess[2]) > Character.getNumericValue(second_chess[2]))
			{
				return 1;
			}
			else
			{
				// ascending order of column number
				if (Integer.valueOf(first_chess[1]) < Integer.valueOf(second_chess[1]))
				{
					return -1;
				}
				else if (Integer.valueOf(first_chess[1]) > Integer.valueOf(second_chess[1]))
				{
					return 1;
				}
				else
				{
					return 0;
				}
			}
		}
	}
}


class ChessComparatorWhite implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		char[] first_chess = arg0.toCharArray();
		char[] second_chess= arg1.toCharArray();
		// descending order of type.
		// Integer.valueOf returns ASCII values, not the integer value of char
		if (Character.getNumericValue(first_chess[0]) < Character.getNumericValue(second_chess[0]))
		{
			return 1;
		}
		else if (Character.getNumericValue(first_chess[0]) > Character.getNumericValue(second_chess[0]))
		{
			return -1;
		}
		else
		{	// ascending order of row number
			if (Character.getNumericValue(first_chess[2]) < Character.getNumericValue(second_chess[2]))
			{
				return -1;
			}
			else if (Character.getNumericValue(first_chess[2]) > Character.getNumericValue(second_chess[2]))
			{
				return 1;
			}
			else
			{
				// ascending order of column number
				if (Integer.valueOf(first_chess[1]) < Integer.valueOf(second_chess[1]))
				{
					return -1;
				}
				else if (Integer.valueOf(first_chess[1]) > Integer.valueOf(second_chess[1]))
				{
					return 1;
				}
				else
				{
					return 0;
				}
			}
		}
	}
}

public class Main {
	public static String in_str, tmp_chess_info, tmp;
	public static int row_num, col_num, i;
	public static Map<Character, Integer> type_weight;
	public static char chess_piece;
	
	public static void main(String[] arg)
	{		
		File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_helpme\\src\\1.in");
		try {
			type_weight = new HashMap<>();
			// K, Q, R, B, N, pawn
			type_weight.put('K', 60);
			type_weight.put('Q', 50);
			type_weight.put('R', 40);
			type_weight.put('B', 30);
			type_weight.put('N', 20);
			type_weight.put('P', 10);
			
			Scanner sc = new Scanner(file);
			// Scanner sc = new Scanner(System.in);
			row_num = 8;	// between 8 to 1.
			col_num = 0;
			/*
			 * AFTERNOON : DON'T USE PRIORITY QUEUE, IT IS NOT WORKING.
			 */
			PriorityQueue<String> white_pieces = new PriorityQueue<String>(new ChessComparatorWhite());
			PriorityQueue<String> black_pieces = new PriorityQueue<String>(new ChessComparatorBlack());

			while(sc.hasNext())
			{
				sc.next();
				if (sc.hasNext())
				{
					in_str = sc.next();
					in_str = in_str.replace("|", ",");
					in_str = in_str.substring(1, in_str.length() - 1);
					col_num = 0;
					for (String cell : in_str.split(","))
					{
						tmp = cell.replace(":", "").replace(".", "");
						if (tmp.length() > 0)
						{
							chess_piece = tmp.toCharArray()[0];
							
							if (90 < chess_piece)
							{
								tmp_chess_info = String.valueOf(type_weight.get(Character.toUpperCase(chess_piece))) + 
												String.valueOf((char)(97 + col_num)) + 
												String.valueOf(row_num);
								black_pieces.add(tmp_chess_info);
							}
							else
							{
								tmp_chess_info = String.valueOf(type_weight.get(chess_piece)) + 
													String.valueOf((char)(97 + col_num)) + 
													String.valueOf(row_num);
								white_pieces.add(tmp_chess_info);
							}
						}
						col_num++;
					}
					row_num--;
				}
			}
			String out_white_tmp = "";
			String out_black_tmp = "";
			while(!white_pieces.isEmpty())
			{
				out_white_tmp += white_pieces.poll() + ",";
			}
			
			while(!black_pieces.isEmpty())
			{
				out_black_tmp += black_pieces.poll() + ",";
			}
			out_white_tmp = out_white_tmp.substring(0, out_white_tmp.length() - 1)
					.replace("60", "K")
					.replace("50", "Q")
					.replace("40", "R")
					.replace("30", "B")
					.replace("20", "N")
					.replace("10", "");
			out_black_tmp = out_black_tmp.substring(0, out_black_tmp.length() - 1)
					.replace("60", "K")
					.replace("50", "Q")
					.replace("40", "R")
					.replace("30", "B")
					.replace("20", "N")
					.replace("10", "");
			System.out.println(out_white_tmp);
			System.out.println(out_black_tmp);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}


