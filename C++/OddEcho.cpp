#include <iostream>
#include <string>

using namespace std;
int main() {
	int N;
	cin >> N;
	while(N-- > 0) {
		string word;
		cin >> word;
		if(N % 2 == 0)
			cout << word << endl;
	}
	return 0;
}
