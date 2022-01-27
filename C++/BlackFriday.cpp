#include <iostream>
#include <map>
#include <string>
#include <vector>

using namespace std;
int main() {
	int p;
	cin >> p;
	vector<int> v(6, 0), in(p, 0);
	for(int i = 0; i < p; i++) {
		cin >> in[i];
		++v[in[i]-1];
	}
	for(int i = 5; i >= 0; i--) {
		if(v[i] == 1) {
			for(int j = 0; j < p; j++)
				if(in[j] == i + 1)
					cout << j + 1;
			return 0;
		}
	}
	cout << "none" << endl;
	return 0;
}
