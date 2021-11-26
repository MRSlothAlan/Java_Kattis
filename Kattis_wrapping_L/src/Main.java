import java.util.*;
import java.io.*;

/*
 * Packaging boards for drying
 * find the fraction between the space occupied by the boards / total space occupied
 * 
 * Consult the C++ version of this code plz.
 */

class point
{
	public double x, y;
	public point(double in_x, double in_y){
		x = in_x;
		y = in_y;
	}
	public void add(point in_pt) {
		this.x += in_pt.x;
		this.y += in_pt.y;
	}
	public point addNew(point in_pt) {
		point tmp_new_pt = new point(this.x, this.y);
		tmp_new_pt.x += in_pt.x;
		tmp_new_pt.y += in_pt.y;
		return tmp_new_pt;
	}
}

class vector
{
	public double i_vec, j_vec;
	public vector(point in_ptA, point in_ptB){
		// vector AB = OB - OA, O is the origin.
		i_vec = in_ptA.x - in_ptB.x;
		j_vec = in_ptA.y - in_ptB.y;
	}
}


class PointComparator implements Comparator<point> {
    @Override
    public int compare(point p1, point p2) {
        if (p1.x < p2.x)
        	return -1;
        else if (p1.x == p2.x && p1.y > p2.y)
        	return -1;
        else
        	return 1;
    }
}

// https://open.kattis.com/problems/wrapping

public class Main {
	public static double recArea; 
	public static point[] vertices;
	public static int v_ptr, m;
	public static Set<String> uniqueSet;
	
	public static double findConvexHullArea() {
		Arrays.sort(vertices, new PointComparator());	// sort by x, left most x point as the origin.
		m = 0;
		point[] vertices_unique = new point[vertices.length];
		v_ptr = 0;
		// if the cross product is 0: points on the same line, because no magnitude.
		// cross product is negative? the lines probably overlapped.
		// why all the hate?? I am doing well as a student :-)
		// UNDERSTAND the method --> create your own. Haters? Why? Jealous? Well I don't even WANT $$???
		// create unique id~ = can remove duplicate.
		uniqueSet = new HashSet<String>();
		for (int i = 0; i < vertices.length; i++) {
			String uniqueId = String.valueOf(vertices[i].x) + String.valueOf(vertices[i].y);
			if (!uniqueSet.contains(uniqueId)) {
				vertices_unique[v_ptr++] = vertices[i];
				uniqueSet.add(uniqueId);
			}
		}
		int length = v_ptr;
		point[] selected = new point[vertices.length];
		for (int i = 0; i < length; i++) {
			// confirm that at least two points are in the array right now, and excluding overlapping / coplanar points
			while (m > 1 && Determinant(new vector(selected[m - 1], selected[m - 2]), 
										new vector(vertices_unique[i], selected[m - 2])) <= 0)
				m--;
			selected[m++] = vertices_unique[i];
		}
		int k = m;
		for (int i = length - 2; i >= 0; i--) {
			while (m > k && Determinant(new vector(selected[m - 1], selected[m - 2]), 
										new vector(vertices_unique[i], selected[m - 2])) <= 0)
				m--;
			selected[m++] = vertices_unique[i];
		}
		// polygon area? Decompose the polygon into triangles and sum them up
		double area = 0.0;
		if (vertices.length > 1) m--;
		for (int i = 1; i < m; i++)
		{
			// origin to two points, sequencially.
			area += Determinant(new vector(selected[i], selected[0]), 
								new vector(selected[i + 1], selected[0]));
		}
		area /= 2;		// triangle;
		return area;
	}
	public static double Determinant(vector in_vecA, vector in_vecB) 
	{
		// the determinant for two vectors!!
		return in_vecA.i_vec * in_vecB.j_vec - in_vecB.i_vec * in_vecA.j_vec;
	}
	
	public static point RotatePoint(point in_pt, double angle)
	{
		return new point(Math.cos(angle) * in_pt.x - Math.sin(angle) * in_pt.y,	// x 
							Math.cos(angle) * in_pt.y + Math.sin(angle) * in_pt.x); // y
	}
	
	public static void main(String[] args)
	{
		try
		{
			// File file = new File("C:\\Users\\fxhk\\eclipse-workspace\\Kattis_wrapping\\src\\wrapping.in");
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_wrapping_L\\src\\wrapping.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();	// number of test cases
			for (int i = 0; i < N; i++) {
				recArea = 0;
				int n = sc.nextInt();	// number of boards in the moulds
				vertices = new point[n * 4];
				v_ptr = 0;
				// convex hull problem, better off getting all the vertices enclosing the area.
				for (int j = 0; j < n; j++) {
					double x, y, w, h, v;	// -90 < v <= 90
					x = sc.nextDouble();	// x coordinate of center
					y = sc.nextDouble();	// y coor. of center
					w = sc.nextDouble();
					h = sc.nextDouble();
					v = sc.nextDouble();
					v = Math.toRadians(v);	// to radians.
					recArea += w * h;
					point tmp_pt = new point(x, y);
					vertices[v_ptr++] = tmp_pt.addNew(RotatePoint(new point(w / 2, h / 2), v));
					vertices[v_ptr++] = tmp_pt.addNew(RotatePoint(new point(-w / 2, h / 2), v));
					vertices[v_ptr++] = tmp_pt.addNew(RotatePoint(new point(w / 2, -h / 2), v));
					vertices[v_ptr++] = tmp_pt.addNew(RotatePoint(new point(-w / 2, -h / 2), v));
				}
				// find the convex hull
				double area = findConvexHullArea();
				System.out.printf("%.1f %%\n", recArea / area * 100);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}