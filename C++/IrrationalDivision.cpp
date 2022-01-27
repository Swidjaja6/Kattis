#include <iostream>

using namespace std;
int main() {
	int p, q;
	cin >> p >> q;
	if(p % 2 == 1 && q % 2 == 1)
		cout << 1 << endl;
	else if(p % 2 == 0)
		cout << 0 << endl;
	else if(q > p)
		cout << 2 << endl;
	else
		cout << 0 << endl;
	return 0;
}
