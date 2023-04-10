#include "vending_machine.h"

Vending_Machine::Vending_Machine(){};

Vending_Machine::Vending_Machine(std::istream& is) {
    Item item;
    while (is >> item) {
        items.push_back(item);
    } 
}

void Vending_Machine::add(std::string name, int price) {
    items.push_back(Item(name,price));
}

void Vending_Machine::buy(int index) {
    std::cout << "#### Buying " << items[index] << std::endl;
}

std::ostream& operator<<(std::ostream& os, Vending_Machine& machine) {
    os << "\n======================\nWelcome to UTA Vending\n======================\n";

    for (int i = 0; i < machine.items.size(); i++)
    {
        os << i << ") " << machine.items[i] << std::endl;
    }
    
    os << std::endl;
    return os;
}