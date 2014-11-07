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

struct Series {
  int counter,
    sum;
};

struct Side {
  Series temp,
    max;
};

void add_series(Series * s, int val) {
  s->sum += val;
  s->counter++;
}


void start_series(Series * s, int val) {
  s->sum = val;
  s->counter = 0;
}

void print_side(Side s) {
  printf("temp{counter: %d, sum: %d} max{counter: %d, sum: %d}\n", s.temp.sum, s.temp.counter, s.max.sum, s.max.counter);
}

int main() {
  int value = next(),
    prev = value;
  Side decreasing = Side();
  do {
    if (value <= prev) {
      prev = value;
      add_series(&decreasing.temp, value);
      if (decreasing.temp.counter >= decreasing.max.counter)
        decreasing.max = decreasing.temp;
    } else
      start_series(&decreasing.temp, value);
    print_side(decreasing);
    value = next();
  } while (value != -1);
  return 0;
}


