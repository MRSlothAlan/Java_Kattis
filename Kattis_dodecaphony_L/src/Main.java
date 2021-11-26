import java.io.*;
import java.util.*;

/*
 * Do this tomorrow morning.
 */
public class Main {
    public static String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#","G", "G#", "A", "A#", "B"},
            melo_ori, melo_cur;
    public static int range;
    
    public static int Idx(String cur) {
        int ori_idx = 0;
        for (int i = 0; i < range; i++) {
            if (notes[i].equals(cur)) {
                ori_idx = i;
                break;
            }
        }
        return ori_idx;
    }
    
    public static int shiftMag(int ori_idx, int cur_idx) {
        int shift_mag = 0;
        if (ori_idx <= cur_idx) {
            shift_mag = cur_idx - ori_idx;
        }
        else if (ori_idx > cur_idx) {
            // for cur --> end then start to cur, why wrong?
            /*
             c, cs, d, ds, e, f, fs, g, gs, a, as, b, c, cs, d, ds, e, f, fs, g, gs, a, as, b
                                               10 11  0  1   2                                        
             */
            // shift_mag = range - ori_idx + cur_idx;
            shift_mag = range - ori_idx + cur_idx;  
        }
        return shift_mag;
    }
    
    // 
    public static void main(String[] args) {
        try {
            // File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_dodecaphony\\src\\dodecaphony-01.in");
            // Scanner sc = new Scanner(file);
            Scanner sc = new Scanner(System.in);
            // c, cs, d, ds, e, f, fs, g, gs, a, as, b, c, ... loop
            int n = sc.nextInt();   // number of notes.
            range = notes.length;   // length of note
            sc.nextLine();
            
            melo_ori = sc.nextLine().split("\\s+");
            melo_cur = sc.nextLine().split("\\s+");
            // transposition, retrograde, inversion.
            int idx = 0;
            // init for transposition : find first shift, only consider UP.
            int shift_mag = 0;
            int ori_idx = Idx(melo_ori[idx]);
            int cur_idx = Idx(melo_cur[idx]);
            shift_mag = shiftMag(ori_idx, cur_idx);
            idx++;
            for (; idx < n; idx++) {
                // ori, check cur's next, 
                ori_idx = Idx(melo_ori[idx]);
                // cur_idx = Idx(melo_cur[idx]);
                cur_idx = (ori_idx + shift_mag) % range;
                // int next_idx = (ori_idx + 1) % range;    // ah shift by N ar
                if (!melo_cur[idx].equals(notes[cur_idx])) {
                    break;
                }   // two ways to calculate .
                /*
                if (shiftMag(ori_idx, cur_idx) != shift_mag) {
                    break;
                }
                */
            }
            if (idx >= n) {
                System.out.println("Transposition");
                return;
            }
            idx = 0;
            // 01
            boolean retroValid = true;
            for (idx = n - 1; idx >= n/2; idx--) {  // retrograde
                if (!melo_ori[idx].equals(melo_cur[n - 1 - idx])) { // can't be wrong.
                    retroValid = false;
                    break;
                }
            }
            if (retroValid) {
                System.out.println("Retrograde");   // diu.
                return;
            }
            idx = 0;
            for (; idx < n; idx++) {    // inversion????
            /*
             * Wait:    12 notes.
               cddeffggaab c cddeffggaab 
             */
                ori_idx = Idx(melo_ori[idx]);
                int inver_idx = 0;
                if (ori_idx != 0) {
                    inver_idx = range - ori_idx; 
                }
                if (!notes[inver_idx].equals(melo_cur[idx])) {  
                    break;
                }
            }
            if (idx >= n) {
                System.out.println("Inversion");
                return;
            }
            // WHY wrong ans?
            System.out.println("Nonsense");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}