#include <stdio.h>

inline int next() {
  int n = 0;
  int c = getchar_unlocked();
  if (c == -1)
    return -1;
  while (c >= 48 && c <= 57)
    n = n * 10 + c - 48,
      c = getchar_unlocked();
  printf("value: %d\n", n);
  return n;
}

class Side {
public:

  struct Series {
    int counter,
      sum;
  };

  Series temp,
    max;

  void add(int value) {
    temp.sum += value;
    temp.counter++;
    if (temp.counter >= max.counter)
      max = temp;
  }

  void reset(int value) {
    temp.sum = value;
    temp.counter = 0;
  }

  void print() {
    printf("temp{counter: %d, sum: %d} max{counter: %d, sum: %d}\n", temp.sum, temp.counter, max.sum, max.counter);
  }

};

int main() {
  int value = next(),
    prev = value;
  Side decreasing = Side();
  do {
    if (value <= prev)
      decreasing.add(value), prev = value;
    else
      decreasing.reset(value);
    decreasing.print();
    value = next();
  } while (value != -1);
  return 0;
}
