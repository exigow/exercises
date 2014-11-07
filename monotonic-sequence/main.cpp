#include <stdio.h>

inline long next() {
  long n = 0;
  int c = getchar_unlocked();
  if (c == -1)
    return -1;
  while (c >= 48 && c <= 57)
    n = n * 10 + c - 48,
    c = getchar_unlocked();
  return n;
}

class Side {
public:
  struct Series {
    long counter;
    long long sum;
  };
  Series temp,
    max;
  inline void add(long value) {
    temp.sum += value;
    temp.counter++;
    if (temp.counter > max.counter)
      max = temp;
  }
  inline void reset(long value) {
    temp.sum = value;
    temp.counter = 1;
  }
  inline static void print(Side side) {
    printf("%lu %llu", side.max.counter, side.max.sum);
  }
};

int main() {
  long value = next(),
    prev = value;
  if (value == -1) {
    printf("0 0");
    return 0;
  }
  Side decreasing = Side(), increasing = Side();
  do {
    if (value <= prev)
      decreasing.add(value);
    else
      decreasing.reset(value);
    if (value >= prev)
      increasing.add(value);
    else
      increasing.reset(value);
    prev = value;
    value = next();
  } while (value != -1);
  if (increasing.max.counter <= decreasing.max.counter)
    Side::print(decreasing);
  else
    Side::print(increasing);
  return 0;
}
