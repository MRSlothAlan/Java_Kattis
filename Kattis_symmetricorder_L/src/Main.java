import java.io.File;
import java.util.*;

/*
 * Gotta catch them all !
 */

class pairs
{
	public String name_one;
	public String name_two;
	public pairs()
	{
		name_one = "";
		name_two = "";
	}
}

/*
// example for reversing a list
public class Reversed<T> implements Iterable<T> {
    private final List<T> original;

    public Reversed(List<T> original) {
        this.original = original;
    }

    public Iterator<T> iterator() {
        final ListIterator<T> i = original.listIterator(original.size());

        return new Iterator<T>() {
            public boolean hasNext() { return i.hasPrevious(); }
            public T next() { return i.previous(); }
            public void remove() { i.remove(); }
        };
    }

    public static <T> Reversed<T> reversed(List<T> original) {
        return new Reversed<T>(original);
    }
}
*/

public class Main {
	
	public static ArrayList<pairs> names = new ArrayList<pairs>();
	public static int n, set_num, in_size, i;
	public static pairs name_pair;
	
	public static void main(String[] args)
	{
		set_num = 0;
		// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_symmetricorder\\src\\sample.in");
		try
		{
			Scanner sc = new Scanner(System.in);
			// Scanner sc = new Scanner(file);
			while (sc.hasNext())
			{
				set_num += 1;
				names = new ArrayList<pairs>(); 
				n = sc.nextInt();
				in_size = n;
				while (n > 0)
				{
					name_pair = new pairs();
					if (n == 1)
					{
						name_pair.name_one = sc.next();
						n--;
					}
					else
					{
						name_pair.name_one = sc.next();
						name_pair.name_two = sc.next();
						n -= 2;
					}
					names.add(name_pair);
				}
				if (names.size() > 0)
					System.out.println("SET " + set_num);
				for (pairs name_pair : names)
				{
					System.out.println(name_pair.name_one);
				}
				for (i = names.size() - 1; i >= 0; i--)
				{
					if (names.get(i).name_two != "")
					{
						System.out.println(names.get(i).name_two);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
