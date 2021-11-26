import java.util.*;
import java.io.*;

/*
 * https://blog.csdn.net/v123411739/article/details/8040488
 * http://www.cs.ucf.edu/~dmarino/progcontests/mysols/collegeother/
 * https://blog.csdn.net/wcy_1122/article/details/79434142
 * https://blog.csdn.net/weixin_30911809/article/details/97174104
 * https://www.cnblogs.com/GerynOhenz/p/8514291.html
 * https://gcpc.nwerc.eu/wp-content/uploads/2012/outlines_2012.pdf
 * https://github.com/UAPSPC/Code-Archive
 * https://2016.bapc.eu/media/filer_public/2016/09/30/bapc2016-preliminaries-solutions.pdf
 * https://2016.bapc.eu/en/contest/preliminaries/
 * https://math.stackexchange.com/questions/1352726/minimizing-a-function-sum-of-squares/1353029
 */
public class Main {
	public static double g = 9.81;
	
	public static void main(String[] args)
	{
		try {
			// File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_skijumping_L\\src\\sample.in");
			// Scanner sc = new Scanner(file);
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			while(t > 0) {
				t--;
				int j, p, H, L;
				j = sc.nextInt();
				p = sc.nextInt();
				H = sc.nextInt();
				L = sc.nextInt();
				// unit = meter
				/*
				 * 	l : landing position
				 * 	vl : landing speed
				 * 	a : speed-angle_H		*/
				double X1 = -2.0 * (double)H / Math.pow(L, 2);
				double v0 = Math.sqrt(2 * g * j);
				double X2 = (g / (2.0 * Math.pow(v0, 2)));
				// 0 <= l < L / 2
				double l_, h_, h_ori, v_vert, v_final, slope_H, angle_H, slope_F, angle_F;
				
				h_ori = (double) H * ( 1 - 2 * Math.pow((0 / (double) L), 2)) + p;
				
				double l_lower = Math.sqrt(p / (X1 + X2));
				if (Double.isNaN(l_lower) || l_lower > (double)L / 2 || l_lower < 0) {	// in lower part
					if (0.5*g*(L*L / (4 * v0*v0)) <= p + H / 2 && 0.5*g*(L*L / (v0*v0)) > p + H)
					{
						// L / 2 <= l < L, quadratic equation.
						double a = (-1 * X2) + X1;
						double b = 4.0 * (double) H / (double)L;
						double c = p - H;
						double det = Math.pow(b, 2) - 4 * a * c;
						double root_1 = ((-1.0) * b - Math.sqrt(det)) / (2.0 * a);
						double root_2 = ((-1.0) * b + Math.sqrt(det)) / (2.0 * a);
						if ((double)L / 2 <= root_1) {
							l_ = root_1;	// how to check that additional part?
						} else {
							l_ = root_2;
						}
					}
					else {
						double time = Math.sqrt(2 * (p + H) / g);
						l_ = v0 * time;
					}

					// cal. h_
					h_ = 2 * H * Math.pow((l_ / (double) L - 1), 2);
					double f_ = - g / 2 * Math.pow(l_ / v0, 2) + (double) H + (double) p;
					
					
					if (l_ >= (double) L)
						slope_H = 0;
					else
						slope_H = 4 * H * l_ / Math.pow(L, 2) - 4.0 * (double) H / (double) L;
				}
				else {
					// in upper part, use l_lower.
					l_ = l_lower;
					h_ = H * (1 - 2 * Math.pow((l_ / (double) L), 2));
					slope_H = -(4 * (double) H / Math.pow(L, 2)) * l_;
				}
				slope_F = -1 * g * l_ / Math.pow(v0, 2);
				double angle = (1 + slope_H * slope_F) / (Math.sqrt(1 + slope_H * slope_H) * Math.sqrt(1 + slope_F * slope_F));
				angle = Math.acos(angle) * 180 / Math.PI;
				
				if (l_ >= (double) L) {
					h_ = 0;
				}
				v_vert = Math.sqrt(2 * g * (h_ori - h_));
				
				v_final = Math.sqrt(Math.pow(v_vert, 2) + Math.pow(v0, 2));
				
				System.out.printf("%.8f %.8f %.8f\n" ,l_, v_final, angle);
			}
		} catch (Exception e) {
			
		}
	}
}
