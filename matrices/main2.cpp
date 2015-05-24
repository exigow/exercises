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

int main() {
  int size = read();
  int rectanglesCount = read();

  // initialize tab
  int tab[size][size];
  for (int x = 0; x < size; x++) {
    for (int y = 0; y < size; y++) {
      tab[x][y] = read();
      if (x > 0)
        tab[x][y] += tab[x - 1][y];
      if (y > 0)
        tab[x][y] += tab[x][y - 1];
      if (x > 0 && y > 0)
        tab[x][y] -= tab[x - 1][y - 1];
    }
  }

  int sumyElementowPodmacierzyDod[1000000];
  int sumyElementowPodmacierzyUje[1000000];
  int average = 0;
  int abstractionClasses = 0;
  int maxPowtorzen = 0;
  int maxAbstractionClassCount = 0;
  for (int i = 0; i < rectanglesCount; i++) {
    Rect rect = readRect();
    int result = tab[rect.bx][rect.by];
    if (rect.ay > 0)
      result -= tab[rect.bx][rect.ay - 1];
    if (rect.ax > 0)
      result -= tab[rect.ax - 1][rect.by];
    if (rect.ax > 0 && rect.ay > 0)
      result += tab[rect.ax - 1][rect.ay - 1];
    printf("%d\n", result);
    average += result;
    if (result >= 0) {
      if (sumyElementowPodmacierzyDod[result] == 0) {
        sumyElementowPodmacierzyDod[result] = 1;
        abstractionClasses += 1;
        if (maxPowtorzen < sumyElementowPodmacierzyDod[result]) {
          maxPowtorzen = sumyElementowPodmacierzyDod[result];
          maxAbstractionClassCount = 1;
        } else if (maxPowtorzen == sumyElementowPodmacierzyDod[result]) {
          maxAbstractionClassCount += 1;
        }
      } else {
        sumyElementowPodmacierzyDod[result] += 1;
        if (maxPowtorzen < sumyElementowPodmacierzyDod[result]) {
          maxPowtorzen = sumyElementowPodmacierzyDod[result];
          maxAbstractionClassCount = 1;
        } else if (maxPowtorzen == sumyElementowPodmacierzyDod[result]) {
          maxAbstractionClassCount += 1;
        }
      }
    } else {
      int sumaUje = -result;
      if (sumyElementowPodmacierzyUje[sumaUje] == 0) {
        sumyElementowPodmacierzyUje[sumaUje] = 1;
        abstractionClasses += 1;
        if (maxPowtorzen < sumyElementowPodmacierzyUje[sumaUje]) {
          maxPowtorzen = sumyElementowPodmacierzyUje[sumaUje];
          maxAbstractionClassCount = 1;
        } else if (maxPowtorzen == sumyElementowPodmacierzyUje[sumaUje]) {
          maxAbstractionClassCount += 1;
        }
      } else {
        sumyElementowPodmacierzyUje[sumaUje] += 1;
        if (maxPowtorzen < sumyElementowPodmacierzyUje[sumaUje]) {
          maxPowtorzen = sumyElementowPodmacierzyUje[sumaUje];
          maxAbstractionClassCount = 1;
        } else if (maxPowtorzen == sumyElementowPodmacierzyUje[sumaUje]) {
          maxAbstractionClassCount += 1;
        }
      }
    }
  }
  average /= rectanglesCount;
  printf("%d %d %d", abstractionClasses, maxAbstractionClassCount, average);
  return 0;
}