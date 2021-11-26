import java.util.*;
import java.io.*;

/* 
 *	100 letters, 50 -> -10, 175 -> 10, 20 -> 25
 *	50 to -10, then 100 to 10, then 75 to 10 + 20 to 25.
 *	total travel time = 2x10 + 2x10 + 2x25
 */
// index 0 = postal office.

/*
 * how about one more location, -20 -> 175?
 * -10 -> 50, K = 100
 * 1. -20 => 75, -10 => 0, -20 = 0
 * 2. -10, -20 => 0, 125, -20 => 25, -20 => 0
 * 
 * for both directions, largest values come first?
 * case : -30,30 - -20,120, -10,40, K = 100
 * if sort by mag: -20, 120, -10, 40, -30, 30
 * Optimal??
 * 2 * 20 + 2 * (30), done !
 * how about -30,100 now?
 * -20, 120, -30, 100, -10, 40
 * 2 * 20 + 2 * 30 + 2 * 30...
 * 
 * what if in other orders, let's say
 * -30, 100, -20, 120, -10, 40 (sort by abs(K - ti), any dist, with ti = K first?)
 * 2 * 30 + 2 * 20 + 2 * 20.
 * 
 * what if -30, 101?
 * -20, 120, -30, 101, -10, 40
 * 2 * 20 + 2 * 30 + 2 * 30
 * -30, 101, -20, 120, -10, 40
 * 2 * 30 + 2 * 30 + 2 * 20, same !?
 * 
 * how about pos, neg locations ? (I think just place them in two separate arrays.)
 * e.g. -10 50, 10 175, 25 20
 * if by abs() sort, same order.
 * 
 * -50 170, -10 50, 10 175, 25 20
 * by abs()
 * -10 50, -50, 170, 10 175, 25 20
 * 
 * 
 * neg to pos don't exist, since round trip dist is calculated.
 * My name is MRSlothAlan in github btw. 
 */

class location {
	int letters_count, locations, abs_val;
	public location(int in_loc, int in_l, int in_K) {
		this.letters_count = in_l;
		this.locations = in_loc;
		this.abs_val = Math.abs(in_K - in_l);
	}
}

class CompareAbsDist implements Comparator<location> {
	@Override
	public int compare(location o1, location o2) {
		if (o1.abs_val < o2.abs_val) {
		// if (o1.letters_count < o2.letters_count) {
		// if (o1.locations < o2.locations) {
			return 1;
		}
		else {
			return -1;
		}
	}
}

public class Main {
	
	public static void main(String[] args) {
		
		try {
			File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\"
					+ "Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_delivery_L\\src\\1.in");
			Scanner sc = new Scanner(file);
			int N, K;
			N = sc.nextInt();
			K = sc.nextInt();	// capacity of the truck
			
			ArrayList<location> neg_loc = new ArrayList<location>();
			ArrayList<location> pos_loc = new ArrayList<location>();
			
			for (int i = 0; i < N; i++) {
				int xi = sc.nextInt();		// [-1500, 1500]
				int ti = sc.nextInt();		// [1, 800]
				location loc = new location(xi, ti, K);
				if (xi < 0) neg_loc.add(loc);
				else if (xi > 0) pos_loc.add(loc);
			}
			location[] pos = new location[pos_loc.size()], 
					neg = new location[neg_loc.size()];
			for (int i = 0; i < pos.length; i++) {
				pos[i] = pos_loc.get(i);
			}
			for (int i = 0; i < neg.length; i++) {
				neg[i] = neg_loc.get(i);
			}
			Arrays.sort(pos, new CompareAbsDist());
			Arrays.sort(neg, new CompareAbsDist());
			Deque<location> queue = new ArrayDeque<location>(); 
			for (location l_pos : pos) { queue.addLast(l_pos); }
			
			int tot_dist = 0, amt = 0, dist = 0;
			
			while (!queue.isEmpty()) {
				amt = K;
				dist = 0;
				// e.g. 80, next 50.
				// 20, then 50
				// -30
				location tmp = queue.getFirst();
				while (amt > 0 && !queue.isEmpty()) {
					tmp = queue.pollFirst();
					amt -= tmp.letters_count;
					dist = Math.max(dist, tmp.locations);
				}
				if (amt < 0) {
					tmp.letters_count += amt;
					queue.addFirst(tmp);
				}
				tot_dist += 2 * dist;
			}
			for (location l_neg : neg) { queue.addLast(l_neg); }
			while (!queue.isEmpty()) {
				amt = K;
				dist = 0;
				// e.g. 80, next 50.
				// 20, then 50
				// -30
				location tmp = queue.getFirst();
				while (amt > 0 && !queue.isEmpty()) {
					tmp = queue.pollFirst();
					amt -= tmp.letters_count;
					dist = Math.max(dist, -1 * tmp.locations);
				}
				if (amt < 0) {
					tmp.letters_count = tmp.letters_count - (amt + tmp.letters_count);
					queue.addFirst(tmp);
				}
				tot_dist += 2 * dist;
			}
			System.out.println(tot_dist);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
