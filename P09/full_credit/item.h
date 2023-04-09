#include <iostream>
#include <string.h>
#include <sstream>
#include <exception>
#include <sstream>
#include <iomanip>

class Item {
    private:
       std::string _name; 
       int _price;
       
    public:
        Item(std::string name, int price);
        std::string to_string();
}; 