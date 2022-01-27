#include <iostream>

using namespace std;
int main() {
	int N;
	cin >> N;
	double qaly = 0.0;
	while(N-- > 0) {
		double q, y;
		cin >> q >> y;
		qaly += (q * y);
	}
	cout << qaly;
}
