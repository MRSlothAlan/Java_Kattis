import java.util.*;
import java.io.*;

public class Main {

	// Maybe my code uses stacks that's why.
	static char[][] world;
	static int[][] found_groups;
	int rows, columns;
	final char BINARY = '0', DECIMAL = '1';

	public Main(int rows, int columns) {
		world = new char[rows][columns];
		found_groups = new int[rows][columns];
		this.rows = rows-1;
		this.columns = columns-1;
	}

	public class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			Point other = (Point) obj;
			return ((x == other.x) && (y == other.y));
		}
	}

	public void search(int x_start, int y_start, int x_fin, int y_fin, int pool) {

		// The frontier is a queue of points to be explored
		ArrayList<Point> frontier = new ArrayList<Point>(); 

		// Find type of start coordinate
		char type;
		if (world[x_start][y_start] == BINARY) {
			type = BINARY;
		} else {
			type = DECIMAL;
		}
		
		// if this group hasn't been explored before
		if (found_groups[x_start][y_start] == 0) {

			// Initialize the frontier with the start point
			frontier.add(new Point(x_start, y_start));

			while (!frontier.isEmpty()) {

				Point sp = frontier.remove(0);

				//Add node to investigate to found_group
				found_groups[sp.x][sp.y] = pool;
				
				// FOUR WAY SEARCH
				if((sp.y > 0) && (world[sp.x][sp.y-1] == type) && (found_groups[sp.x][sp.y-1] == 0)){
					
					//Add to found group and frontier if legal direction and unexplored
					found_groups[sp.x][sp.y-1] = pool;
					frontier.add(new Point(sp.x, sp.y-1));
				}

				if((sp.y < columns) && (world[sp.x][sp.y+1] == type) && (found_groups[sp.x][sp.y+1] == 0)) {

					found_groups[sp.x][sp.y+1] = pool;
					frontier.add(new Point(sp.x, sp.y+1));
				}

				if((sp.x > 0) && (world[sp.x-1][sp.y] == type) && (found_groups[sp.x-1][sp.y] == 0)) {

					found_groups[sp.x-1][sp.y] = pool;
					frontier.add(new Point(sp.x-1, sp.y));
				}

				if((sp.x < rows) && (world[sp.x+1][sp.y] == type) && (found_groups[sp.x+1][sp.y] == 0)){

					found_groups[sp.x+1][sp.y] = pool;
					frontier.add(new Point(sp.x+1, sp.y));
				} 
			}
		}
		
		// Check if start and end coordinates belong to the same group
		if (found_groups[x_start][y_start] == found_groups[x_fin][y_fin]) {
			if(type == DECIMAL) {
				System.out.println("decimal");
			} else {
				System.out.println("binary");
			}
		} else {
			System.out.println("neither");
		}
	}

	public static void main(String args[]) {

		Scanner io = new Scanner(System.in);
		int rows = io.nextInt();
		int columns = io.nextInt();
		Main elf = new Main(rows, columns);
		
		//Create two-dimensional character array of the world
		for (int i = 0; i < rows; i++) {
			world[i] = io.next().toCharArray();
		}

		//Search for each query
		int queries = io.nextInt();
		for(int i = 1; i <= queries; i++) {
			elf.search(io.nextInt()-1, io.nextInt()-1, io.nextInt()-1, io.nextInt()-1, i); 
		}

		io.close();
	}
}









