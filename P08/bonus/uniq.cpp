#include <iostream>
#include <string>

int main(int args, char* argv[]) {
    for (int i = 1; i < args; i++)
    {
        std::string previous = argv[i-1];
        if (previous != argv[i])
        {
            std::string uniq = argv[i];
            std::cout << uniq << ' ';
        }      
    }
    return 0;
}