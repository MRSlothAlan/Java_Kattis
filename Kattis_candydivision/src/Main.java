import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long in_num = sc.nextLong();
        TreeSet<Long> ans = new TreeSet<>();	// a balanced tree already
        // find all possible root till sqrt(in_num)
        for (Long i = 2l; i <= Math.ceil(Math.sqrt((double)in_num)); i++) {
            if (in_num % i == 0) {
                ans.add(i);
                if (i != in_num / i) {	// also a factor.
                    ans.add((in_num/i));
                }
            }
        }

        System.out.print(0);

        Iterator<Long> it = ans.iterator();
        while (it.hasNext()) {
            System.out.print(" " + (it.next() - 1));
        }

        System.out.print(" " + (in_num - 1));
    }
}
