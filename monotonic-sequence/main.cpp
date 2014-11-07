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

void print_series(Series s) {
  printf("series: counter: %d, sum: %d\n", s.counter, s.sum);
}

int main() {
  int value,
    prev = 0;
  Series actual = Series(),
    maximum = Series();
  while (true) {
    value = next();
    if (value == -1)
      break;
    if (value >= prev) {
      printf("value %d is bigger or equal than %d\n", value, prev);
      prev = value;
      actual.sum += value;
      actual.counter++;
      if (actual.counter >= maximum.counter) {
        maximum = actual;
        printf("updating max\n");
      }
      printf("actual ");
      print_series(actual);
    }
    else {
      actual.counter = 1;
      actual.sum = value;
    }
  }
  printf("maximum ");
  print_series(maximum);
  return 0;
}


