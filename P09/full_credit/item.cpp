#include "item.h"

Item::Item(std::string name, int price) : _name{name}, _price{price} {
    if(price < 0) throw std::runtime_error{"Price cannot be negative"};    
}

std::string Item::to_string() {
    double price = _price / 100.00;
    std::ostringstream stream;
    stream << std::fixed << std::setprecision(2) << price ;
    std::string priceString = stream.str();
    return _name + " ($" + priceString + ")";
}