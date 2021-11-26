#include <iostream>
#include <cmath>
using namespace std;

int res_cost;
int N, G, k;
// dp approach.
#define ll long long
#define inf 999999999999999999
#define const_n 2005
int staircase[const_n];
ll sum1[const_n], sum2[const_n],
	g[const_n][const_n],
	f[const_n][const_n],
	a[const_n],
	b[const_n];

int cal_min(int low_idx, int up_idx)
{
	int v = 0;
	int mid = up_idx - (up_idx - low_idx) / 2;
	if ((up_idx - low_idx + 1) % 2 == 0) {
		v = (staircase[mid] + staircase[mid - 1]) / 2;
	}
	else {
		v = staircase[mid];
	}
	int sum = 0;
	for (int i = low_idx; i <= up_idx; i++) {
		sum += pow(abs(staircase[i] - v), k);
	}
	return sum;
}

void cal_seg(int total_cost, int up_idx, int low_idx, int g_no) {
	if (g_no >= G - 1) {
		total_cost += cal_min(low_idx, up_idx);
		if (res_cost == -1 || res_cost > total_cost)
			res_cost = total_cost;
		return;
	}
	else {
		int next_g_no = g_no + 1;
		for (int tmp_idx = low_idx; tmp_idx <= up_idx - (G - g_no) + 1; tmp_idx++) {
			total_cost += cal_min(low_idx, tmp_idx);
			int next_low_idx = tmp_idx + 1;
			cal_seg(total_cost, up_idx, next_low_idx, next_g_no);
		}
		return;
	}
}



int main()
{
	/*
	programming = solving problems
	art			= doing nothing
	BOTH fields	= copy from elites --> CREATE your OWN approaches later!
	
	C:\Users\tingk\Desktop\ref.cpp
	I know that if I reach this level (diff. 4.6), I will be very happy
	(my current level: 3.0)
	*/
	cin >> N >> G >> k;
	res_cost = -1;

	for (int i = 1; i <= N; i++) {
		cin >> staircase[i];
	}
	// observation: all these sums ignored v? v = 0 here.
	for (int i = 1; i <= N; i++) {
		sum1[i] = sum1[i - 1] + staircase[i];
	}
	for (int i = 1; i <= N; i++) {
		sum2[i] = sum2[i - 1] + (ll)staircase[i] * staircase[i];
	}
	if (k == 1) {
		// a sequence of length N, divide by j pieces!
		for (int i = 1; i <= N; i++) {		
			for (int j = i; j <= N; j++) {
				if (j - i + 1 == 1) {
					g[i][]
				}
			}
		}
	}
	// recursive solution: TLE
	// cal_seg(0, N, 1, 0);
	cout << res_cost << endl;
	return 0;
}