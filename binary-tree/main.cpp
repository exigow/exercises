#include <iostream>
#include <stdio.h>

int main() {
  int c;
  do {
    c = getchar_unlocked();
    std::cout << c << " --> ";
    getchar_unlocked(); // skip space
    while (true) {
      c = getchar_unlocked();
      if (c == EOF | c == 10) {
        std::cout << std::endl;
        break;
      }
      std::cout << c << ", ";
    }
  } while (c != EOF);
  return 0;
}