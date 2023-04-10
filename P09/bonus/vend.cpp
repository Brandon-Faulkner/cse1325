#include "vending_machine.h"

int main() {
    Vending_Machine machine;
    machine.add("Peanut butter crackers", 169);
    machine.add("Oreos", 189);
    std::cout << machine;
    machine.buy(1);
    return 0;
}