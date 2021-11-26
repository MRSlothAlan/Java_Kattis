import java.util.*;
import java.io.*;

/*
// proposed way #1
for (int i = 0; i < size; i++) {
    for (int j = i + 1; j < size; j++) {
        for (int k = j + 1; k < size; k++) {
            if (digits[i] != 0) {
                tmp_number = digits[i] * 100 + digits[j] * 10 + digits[k];
                System.out.print(tmp_number + " ");
                checker(tmp_number);
            }
        }
    }
}
for (int i = size - 1; i >= 0; i--) {
    for (int j = i - 1; j >= 0; j--) {
        for (int k = j - 1; k >= 0; k--) {
            if (digits[i] != 0) {
                tmp_number = digits[i] * 100 + digits[j] * 10 + digits[k];
                System.out.print(tmp_number + " ");
                checker(tmp_number);
            }
        }
    }
}
*/

public class Main {
    public static boolean[] isNotPrime = new boolean[10000000];
    public static boolean[] checked = new boolean[10000000];
    public static int[] digits = new int[7];
    public static int[] dup = new int[7];
    public static int size, out_count, tmp_number;
    public static ArrayList<Integer> Ts = new ArrayList<Integer>();
    public static boolean flag = true;
    // test the time to find all the primes;
    public static void findAllPrimes()
    {
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        isNotPrime[2] = false;
        for (long i = 2; i < 10000000; i++)
        {
            if (!isNotPrime[(int)i])
            {
                for (long j = i * i; j < 10000000; j += i)
                {
                    isNotPrime[(int)j] = true;
                }
            }
        }
    }
    
    public static void checker(int in_num)
    {
        if (!isNotPrime[in_num] && !checked[in_num])
        {
            out_count++;
            checked[in_num] = true;
        }
    }
    
    public static void PermutationIndex(String in_idx_str, 
    									int mask,
    									String out)
    {
    	int n = in_idx_str.length();
    	// perform the checking in here.
    	if (out.length() > 0) {
    		char[] tmp_idx = out.toCharArray();
    		if (digits[Integer.valueOf(tmp_idx[0] - 48)] != 0)
    		{
    			int tmp_val = 0;
    			for(int j = 0; j < tmp_idx.length; j++) {
    				tmp_val += digits[Integer.valueOf(tmp_idx[j] - 48)] * Math.pow(10, tmp_idx.length - j - 1);
    			}
    			checker(tmp_val);
    		}
    	}
    	for (int i = 0; i < n; ++i)
    	{
    		int bit = 1 << i;
    		if ((mask & bit) > 0) 
    			continue;
    		PermutationIndex(in_idx_str, mask | bit, out + in_idx_str.toCharArray()[i]);
    	}
    }
    
    public static void main(String[] args)
    {
        try
        {
            // File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\"
            //          + "Kattis_industrialspy\\src\\sample.in");
            // Scanner sc = new Scanner(file);
        	// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\"
        	//  		+ "eclipse_workspace_coding\\Kattis_industrialspy\\src\\sample.txt");
            Scanner sc = new Scanner(System.in);
            // Scanner sc = new Scanner(file);
            findAllPrimes();
            int T = sc.nextInt();
            for (int i = 0 ; i < T ; i++)
            {
                out_count = 0;
                String in_digit_str = sc.next();
                size = in_digit_str.length();
                digits = new int[7];
                checked = new boolean[10000000];
                int tmp_idx = 0;
                String tmp_idx_str = "";
                for (char c : in_digit_str.toCharArray())
                {
                    digits[tmp_idx] = Integer.valueOf(c - 48);
                    tmp_idx_str += (char) (tmp_idx + 48);
                    tmp_idx++;
                }
                PermutationIndex(tmp_idx_str, 0, "");
                System.out.println(out_count);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
