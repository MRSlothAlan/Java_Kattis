import java.io.File;
import java.util.*;


public class Main {

    public static int m, n;
    
    // 0 = +, 1 = -; 2 = *, 3 = /
    
    public static void BruteForceSolver()
    {
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) { // for the sake of testing the first case.
                    /*
                     * Looks like a bunch of code
                     * but actually there are 4 4s and 3 operators only.
                     */
                    int[] operators = new int[3];
                    
                    Stack<Integer> tmp_values = new Stack<Integer> ();
                    int ptr_opt = -1;
                    int[] opt = new int[3];
                    
                    Stack<Integer> tmp_opt = new Stack<Integer> () ;
                    int tmp_val  = 0;
                    
                    operators[0] = i;
                    operators[1] = j;
                    operators[2] = k;
                    // if * or /, calculate the value then push into a stack.
                    // if + or -, push that thing into another stack???
                    
                    for (int l = 0; l < 3; l++)
                    {
                        // for the first term (l = 0), push 2 number 4s.
                        // for the others, push one terms only
                        if (operators[l] > 1)
                        {
                            tmp_val = 0;
                            if (tmp_values.size() > 0) {
                                tmp_val = tmp_values.pop();
                            } 
                            else {
                                tmp_val = 4;
                            }
                            switch(operators[l])
                            {
                            case 2: 
                                tmp_val *= 4;                             
                                tmp_values.push(tmp_val);
                                break;
                            case 3:
                                tmp_val = (int) Math.floor(tmp_val / 4);
                                tmp_values.push(tmp_val);
                                break;
                            }
                        }
                        else 
                        {
                            if (l == 0) {
                                tmp_values.push(4);
                                tmp_values.push(4);
                            }
                            else {
                                tmp_values.push(4);
                            }
                            ptr_opt++;
                            opt[ptr_opt] = operators[l];
                            // tmp_opt.push(operators[l]);
                        }
                    }
                    // now add / minus values in stack.
                    int[] values = new int[tmp_values.size()];
                    int ptr_values = tmp_values.size() - 1;
                    while(tmp_values.size() > 0)
                    {
                    	values[ptr_values] = tmp_values.pop();
                    	ptr_values--;
                    }
                    
                    int sum = values[0];
                    ptr_values = 1;
                    for (int q = 0; q <= ptr_opt; q++)
                    {
                        switch(opt[q])
                        {
                        case(0):
                            sum += values[ptr_values];
                            break;
                        case(1):
                            sum -= values[ptr_values];
                            break;
                        }
                        ptr_values++;
                    }
                    
                    if (sum == n)
                    {
                        flag = true;
                        String out_str = "4 ";
                        for (int p = 0; p < 3; p++)
                        {
                            switch(operators[p])
                            {
                            case 0:
                                out_str += "+ ";
                                break;
                            case 1:
                                out_str += "- ";
                                break;
                            case 2:
                                out_str += "* ";
                                break;
                            case 3:
                                out_str += "/ ";
                                break;
                            }
                            out_str += "4 ";
                        }
                        out_str += "= ";
                        out_str += String.valueOf(n);
                        System.out.println(out_str);
                        // only need to print one value
                        i = 5;
                        j = 5;
                        k = 5;
                        break;
                    }
                }
            }
        }
        if (!flag)
            System.out.println("no solution");
    }
    
    public static void main(String args[])
    {
        // File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\30042021_home_practice\\src\\4thought.in");
        Scanner sc = new Scanner(System.in);
        try
        {
            // Scanner sc = new Scanner(file);
            m = sc.nextInt();
            for (int i = 0; i < m; i++)
            {
                n = sc.nextInt();
                // target or no solution.
                BruteForceSolver();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}