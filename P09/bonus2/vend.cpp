#include "vending_machine.h"

int main() {
    std::ifstream file{"products.txt"};
    Vending_Machine machine{file};    
    std::cout << machine;
    return 0;
}