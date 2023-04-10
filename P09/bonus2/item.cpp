#include "item.h"

Item::Item(): Item("Default", 0){};

Item::Item(std::string name, int price) : _name{name}, _price{price} {
    if(price < 0) throw std::runtime_error{"Price cannot be negative"};    
}

std::ostream& operator<<(std::ostream& os, const Item& item) {
    os << item._name << " ($" << std::fixed << std::setprecision(2) << item._price/100.00 << ")";
    return os;
}

std::istream& operator>>(std::istream& is, Item& item) {
    is >> item._name;
    is >> item._price;
    return is;
}