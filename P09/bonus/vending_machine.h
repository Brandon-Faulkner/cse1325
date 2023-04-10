#include <iostream>
#include <string.h>
#include <vector>
#include "item.h"

class Vending_Machine {
    private:
        std::vector<Item> items;
    
    public:
        void add(std::string name, int price);
        void buy(int index);
        friend std::ostream& operator<<(std::ostream& os, Vending_Machine& machine);
};