#include "vending_machine.h"

void Vending_Machine::add(std::string name, int price){
    items.push_back(Item(name,price));
}

void Vending_Machine::buy(int index){
    std::cout << "#### Buying " << items[index].to_string() << std::endl;
}

std::string Vending_Machine::menu() {
    std::string menuString = "\n";
    menuString += "======================\n";
    menuString += "Welcome to UTA Vending\n";
    menuString += "======================\n";

    for (int i = 0; i < items.size(); i++)
    {
        menuString += std::to_string(i) + ") " + items[i].to_string() + "\n";
    }
    
    menuString += "\n";
    return menuString;
}