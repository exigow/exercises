#include <stdlib.h>
#include <stdio.h>

#define get getchar_unlocked

inline static bool isNotNumber(int c) {
  return c > '0' - 1 && c < '9' + 1;
}

inline static void buildNumber(int &number, int &character) {
  while (isNotNumber(character)) {
    number = (number << 1) + (number << 3) + character - '0';
    character = get();
  }
}

inline static int read() {
  register int c = get();
  bool negate = false;
  if (c == '-') {
    negate = true;
    c = get();
  }
  register int n = 0;
  buildNumber(n, c);
  if (negate)
    return -n;
  return n;
}

inline static uint readAbsolute() {
  register int n = 0;
  register int c = get();
  buildNumber(n, c);
  return (uint) n;
}

struct Rect {
  uint ax, ay, bx, by;
};

inline static Rect readRect() {
  Rect rect = {
    .ax = readAbsolute(),
    .ay = readAbsolute(),
    .bx = readAbsolute(),
    .by = readAbsolute()
  };
  return rect;
}

static const uint MAX_SIZE = 1000000;
int plusTable[MAX_SIZE];
int minusTable[MAX_SIZE];
int average = 0;
uint abstractionClasses = 0;
uint AbstractionClassCountMax = 0;
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
  uint size = readAbsolute();
  int rectanglesCount = read();
  // fill table
  int tab[size][size];
  tab[0][0] = read();
  for (uint y = 1; y < size; y++)
    tab[0][y] = read() + tab[0][y - 1];
  for (uint x = 1; x < size; x++) {
    for (uint y = 0; y < size; y++) {
      tab[x][y] = read() + tab[x - 1][y];
      if (y > 0)
        tab[x][y] += tab[x][y - 1] - tab[x - 1][y - 1];
    }
  }
  // print table
  for (uint y = 0; y < size; y++) {
    for (uint x = 0; x < size; x++)
      printf("%d ", tab[x][y]);
    printf("\n");
  }
  // compute
  for (uint i = 0; i < rectanglesCount; i++) {
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