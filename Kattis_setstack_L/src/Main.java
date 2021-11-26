import java.util.*;
import java.io.*;


public class Main {
	public static Map<Set<Integer>, Integer> IDCache;
	public static ArrayList<Set<Integer>> Setcache;
	
	public static int ID (Set<Integer> in_s) {
		if (IDCache.containsKey(in_s)) {
			return IDCache.get(in_s);
		}
		Setcache.add(in_s);
		IDCache.put(in_s, Setcache.size() - 1);
		return IDCache.get(in_s);
	}
	
	public static void main(String[] args) {
		try {
			Stack<Integer> s;
			int T; // number of test cases
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_setstack_L\\src\\setstack.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			T = sc.nextInt();
			
			while (T > 0) {
				Setcache = new ArrayList<Set<Integer>>();
				IDCache = new HashMap<Set<Integer>, Integer>();
				s = new Stack<Integer>();
				int N = sc.nextInt();
				for (int n = 0; n < N; n++) {
					char[] in_command = sc.next().toCharArray();
					if (in_command[0] == 'P') {
						s.push(ID(new HashSet<Integer>()));
					}
					else if (in_command[0] == 'D') {
						s.push(s.peek());
					}
					else {
						Set<Integer> x1 = Setcache.get(s.peek());	// pick the set according to ID.
						s.pop();
						Set<Integer> x2 = Setcache.get(s.peek());
						s.pop();
						Set<Integer> x = new HashSet<Integer>();
						if (in_command[0] == 'U') {
							x.addAll(x1);
							x.addAll(x2);
						}
						if (in_command[0] == 'I') {
							x.addAll(x1);
							x.retainAll(x2);
						}
						if (in_command[0] == 'A') {
							x.addAll(x2);
							x.add(ID(x1));
						}
						s.add(ID(x));
					}
					System.out.println(Setcache.get(s.peek()).size());
				}
				T--;
				System.out.println("***");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
