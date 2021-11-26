import java.util.*;
import java.io.*;


class PatientData {
	public int T, S;
	public String name;
	public int severity_value;
	public PatientData(int in_T, int in_S, String in_name)
	{
		this.S = in_S;
		this.T = in_T;
		this.name = in_name;
		this.severity_value = 0;
	}
	public void computePriority(int in_K, int in_cur_T)
	{
		this.severity_value = this.S + in_K * (in_cur_T - T);
	}
}

class ComparePatient implements Comparator<PatientData>{

	@Override
	public int compare(PatientData pat_1, PatientData pat_2) {
		// TODO Auto-generated method stub
		if (pat_1.severity_value < pat_2.severity_value)
			return 1;
		else if (pat_1.severity_value > pat_2.severity_value)
			return -1;
		else if (pat_1.name.compareTo(pat_2.name) > 0)
			return 1;
		else
			return -1;
	}
}


public class Main {
	public static Map<String, PatientData> clinic;
	
	public static void main(String[] args) {
		try
		{
			File file = new File("C:\\Users\\tingk\\Desktop\\kattis\\Kattis_practices_repo\\eclipse_workspace_coding\\Kattis_clinic_L\\src\\sample1.in");
			Scanner sc = new Scanner(file);
			// Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();	// number of queries to be processed 
			int K = sc.nextInt();	// the constant of the clinic
			clinic = new HashMap<String, PatientData>();
			
			for (int i = 0; i < N; i++)
			{
				int Q = sc.nextInt();
				switch(Q) 
				{
				case 1:
					int T = sc.nextInt();	// the arrival time
					String M = sc.next();	// patient's name
					int S = sc.nextInt();	// the severity
					clinic.put(M, new PatientData(T, S, M));
					break;
				case 2:
					int T_doc = sc.nextInt();	// time that a doctor is ready to treat a patient
					PatientData[] tmp_data = new PatientData[clinic.size()];
					int idx = 0;
					if (clinic.size() == 0)
					{
						System.out.println("doctor takes a break");
					}
					else
					{
						for (String name : clinic.keySet())
						{
							tmp_data[idx] = clinic.get(name);
							tmp_data[idx].computePriority(K, T_doc);
							idx++;
						}
						Arrays.sort(tmp_data, new ComparePatient());
						System.out.println(tmp_data[0].name);
						clinic.remove(tmp_data[0].name);
					}
					break;
				case 3:
					int T_noti = sc.nextInt();	// time, notified that patient M left the queue permanently
					String M_left = sc.next();
					if (clinic.containsKey(M_left)) {
						clinic.remove(M_left);
					}
					break;
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
