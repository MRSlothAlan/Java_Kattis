#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
	/*
	TLE

	You know the reason
	*/
	int N, H;
	cin >> N >> H;
	// ** interesting, C++ dynamic array is not really a fixed array structure.
	vector<int> count = vector<int>();		// count for the levels.
	for (int i = 0; i < H; i++) {
		count.push_back(0);
	}
	// memset(count, 0, H);
	// down up down up obstacles, alternate.
	for (int i = 1; i <= N; i++) {
		int obs;
		cin >> obs;
		if (i % 2 > 0) {
			for (int j = 0; j < obs; j++) {
				count[j]++;
			}
		}
		else {
			for (int j = H - 1; j >= H - obs; j--) {
				count[j]++;
			}
		}
	}
	std::sort(count.begin(), count.end());
	int min_cnt = count[0];
	int res_lvl_cnt = 0;
	for (int i = 0; i < H && count[i] == min_cnt; i++) {
		res_lvl_cnt++;
	}
	cout << min_cnt << " " << res_lvl_cnt << endl;
	return 0;
}