import java.io.*;
import java.util.*;

public class MainPlanina {
	public static int v, i;
	public static int side;
	
	public static void main(String[] args) {
		try
		{
			Scanner sc = new Scanner(System.in);
			v = sc.nextInt();
			side = 2;
			for (i = 0; i < v; i++)
			{
				side += Math.pow(2, i);
			}
			System.out.println(side * side);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}