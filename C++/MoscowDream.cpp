#include <iostream>
#include <string>

using namespace std;
int main() {
	int a, b, c, n;
	cin >> a >> b >> c >> n;
	if(a == 0 || b == 0 || c == 0)
		cout << "NO" << endl;
	else 
		if(a + b + c >= n && n >= 3)
			cout << "YES" << endl;
		else
			cout << "NO" << endl;
	return 0;
}
