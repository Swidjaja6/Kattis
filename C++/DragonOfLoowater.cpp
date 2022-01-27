#include <iostream>
#include <algorithm>
#include <string>

using namespace std;
int main() {
	int n, m;
	string doom = "Loowater is doomed!";
	cin >> n >> m;
	while(n != 0 && m != 0) {
		int diam[n], heights[m];
		for(int i = 0; i < n; i++)
			cin >> diam[i];
	        for(int i = 0; i < m; i++)
			cin >> heights[i];
		if(n > m) {
			cout << doom  << endl;
			cin >> n >> m;
			continue;
		}	
		sort(diam, diam + n);
		sort(heights, heights + m);
		int cost = 0, dI = 0;
		for(int hI = 0; hI < m; hI++) {
			if(dI == n)
				break;
			if(heights[hI] >= diam[dI]) {
				dI++;
				cost += heights[hI];
			}
		}
		if(dI == n) 
			cout << cost << endl;
		else 
			cout << "Loowater is doomed!" << endl;
		cin >> n >> m;
	}
	return 0;
}
