#include <stdio.h>

inline int next() {
  int n = 0;
  int c = getchar_unlocked();
  if (c == -1)
    return -1;
  while (c >= 48 && c <= 57)
    n = n * 10 + c - 48,
      c = getchar_unlocked();
  printf("next is %d\n", n);
  return n;
}

struct Series {
  int counter,
    sum;
};

struct Side {
  Series actual,
    maximum;
};

void print_series(Series s) {
  printf("series: counter: %d, sum: %d\n", s.counter, s.sum);
}

int main() {
  int value,
    prev = 16;
  Side decreasing = Side();
  while (true) {
    printf("---\n");
    value = next();
    if (value == -1)
      break;
    if (value <= prev) {
      prev = value;
      decreasing.actual.sum += value;
      decreasing.actual.counter++;
      if (decreasing.actual.counter >= decreasing.maximum.counter)
        decreasing.maximum = decreasing.actual;
    } else {
      decreasing.actual.sum = value;
      decreasing.actual.counter = 1;
    }
    print_series(decreasing.actual);
  }
  printf("maximum ");
  print_series(decreasing.maximum);
  return 0;
}


