#include <stdio.h>

inline int next() {
  int n = 0;
  int c = getchar_unlocked();
  if (c == -1)
    return -1;
  while (c >= 48 && c <= 57)
    n = n * 10 + c - 48,
      c = getchar_unlocked();
  return n;
}

int main() {
  int x = next();
  while (x != -1) {
    printf("%d ", x);
    x = next();
  }
  return 0;
}
