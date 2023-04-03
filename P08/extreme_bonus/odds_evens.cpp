#include <iostream>
#include <vector>

int main(int args, char* argv[]) {
    std::vector<int> v; int number;
    while (std::cin >> number) v.push_back(number);   
    std::cout << "Number of elements: " << v.size() << std::endl;
    std::cout << "Elements: "; for (int i = 0; i < v.size(); i++) std::cout << v.at(i) << ' '; std::cout << std::endl;
    std::cout << "Even indices: "; for (int i = 0; i < v.size(); i+=2) std::cout << v.at(i) << ' '; std::cout << std::endl;
    std::cout << "Odd indices: "; for (int i = 1; i < v.size(); i+=2) std::cout << v.at(i) << ' '; std::cout << std::endl;
    return 0;
}