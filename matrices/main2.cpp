#include <stdio.h>
#include <stdlib.h>

#define get getchar_unlocked
inline static int read() {
  register int c = get();
  int x = 0;
  bool negate = false;
  for (; ((c < '0' || c > '9') && c != '-'); c = get());
  if (c == '-') {
    negate = true;
    c = get();
  }
  for (; c > '0' - 1 && c < '9' + 1; c = get())
    x = (x << 1) + (x << 3) + c - 48;
  if (negate)
    x = -x;
  return x;
}

struct Rect {
  int ax, ay, bx, by;
};

inline static Rect readRect() {
  Rect rect = {
    .ax = read(),
    .ay = read(),
    .bx = read(),
    .by = read()
  };
  return rect;
}

static const int MAX_SIZE = 1000000;
int plusTable[MAX_SIZE];
int minusTable[MAX_SIZE];
int average = 0;
int abstractionClasses = 0;
int AbstractionClassCountMax = 0;

int countMax = 0;
inline static void increment(int result, int tab[]) {
  if (countMax < tab[result]) {
    countMax = tab[result];
    AbstractionClassCountMax = 1;
  } else if (countMax == tab[result])
    AbstractionClassCountMax += 1;
}

inline static void pushResult(int result, int tab[]) {
  if (tab[result] == 0) {
    tab[result] = 1;
    abstractionClasses += 1;
    increment(result, tab);
  } else {
    tab[result] += 1;
    increment(result, tab);
  }
}

int main() {
  int size = read();
  int rectanglesCount = read();
  // fill table
  int tab[size][size];
  tab[0][0] = read();
  for (int y = 1; y < size; y++)
    tab[0][y] = read() + tab[0][y - 1];
  for (int x = 1; x < size; x++) {
    for (int y = 0; y < size; y++) {
      tab[x][y] = read() + tab[x - 1][y];
      if (y > 0)
        tab[x][y] += tab[x][y - 1] - tab[x - 1][y - 1];
    }
  }
  // print table
  for (int y = 0; y < size; y++) {
    for (int x = 0; x < size; x++)
      printf("%d ", tab[x][y]);
    printf("\n");
  }
  // compute
  for (int i = 0; i < rectanglesCount; i++) {
    Rect rect = readRect();
    int result = tab[rect.bx][rect.by];
    if (rect.ay > 0)
      result -= tab[rect.bx][rect.ay - 1];
    if (rect.ax > 0)
      result -= tab[rect.ax - 1][rect.by];
    if (rect.ax > 0 && rect.ay > 0)
      result += tab[rect.ax - 1][rect.ay - 1];
    average += result;
    if (result >= 0) {
      pushResult(result, plusTable);
    } else {
      result = -result;
      pushResult(result, minusTable);
    }
  }
  average /= rectanglesCount;
  printf("%d %d %d", abstractionClasses, AbstractionClassCountMax, average);
  return 0;
}