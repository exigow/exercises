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
  int sumyElementowPodmacierzyDod[1000000];
  int sumyElementowPodmacierzyUje[1000000];
  int ileRoznychSum = 0;
  int maxPowtorzen = 0;
  int ileMaxPowtorzen = 0;
  int sumOverall = 0;
  int size = read();
  int tab[size][size];
  int abstractionsCount = read();
  for (int i = 0; i < size; i++) {
    for (int j = 0; j < size; j++) {
      tab[i][j] = read();
      if (i > 0)
        tab[i][j] += tab[i - 1][j];
      if (j > 0)
        tab[i][j] += tab[i][j - 1];
      if (i > 0 && j > 0)
        tab[i][j] -= tab[i - 1][j - 1];
    }
  }
  for (int i = 0; i < abstractionsCount; i++) {
    Rect rect = readRect();
    int result = tab[rect.bx][rect.by];
    if (rect.ay > 0)
      result -= tab[rect.bx][rect.ay - 1];
    if (rect.ax > 0)
      result -= tab[rect.ax - 1][rect.by];
    if (rect.ax > 0 && rect.ay > 0)
      result += tab[rect.ax - 1][rect.ay - 1];
    sumOverall += result;
    if (result >= 0) {
      if (sumyElementowPodmacierzyDod[result] == 0) {
        sumyElementowPodmacierzyDod[result] = 1;
        ileRoznychSum += 1;
        if (maxPowtorzen < sumyElementowPodmacierzyDod[result]) {
          maxPowtorzen = sumyElementowPodmacierzyDod[result];
          ileMaxPowtorzen = 1;
        } else if (maxPowtorzen == sumyElementowPodmacierzyDod[result]) {
          ileMaxPowtorzen += 1;
        }
      } else {
        sumyElementowPodmacierzyDod[result] += 1;
        if (maxPowtorzen < sumyElementowPodmacierzyDod[result]) {
          maxPowtorzen = sumyElementowPodmacierzyDod[result];
          ileMaxPowtorzen = 1;
        } else if (maxPowtorzen == sumyElementowPodmacierzyDod[result]) {
          ileMaxPowtorzen += 1;
        }
      }
    } else {
      int sumaUje = -result;
      if (sumyElementowPodmacierzyUje[sumaUje] == 0) {
        sumyElementowPodmacierzyUje[sumaUje] = 1;
        ileRoznychSum += 1;
        if (maxPowtorzen < sumyElementowPodmacierzyUje[sumaUje]) {
          maxPowtorzen = sumyElementowPodmacierzyUje[sumaUje];
          ileMaxPowtorzen = 1;
        } else if (maxPowtorzen == sumyElementowPodmacierzyUje[sumaUje]) {
          ileMaxPowtorzen += 1;
        }
      } else {
        sumyElementowPodmacierzyUje[sumaUje] += 1;
        if (maxPowtorzen < sumyElementowPodmacierzyUje[sumaUje]) {
          maxPowtorzen = sumyElementowPodmacierzyUje[sumaUje];
          ileMaxPowtorzen = 1;
        } else if (maxPowtorzen == sumyElementowPodmacierzyUje[sumaUje]) {
          ileMaxPowtorzen += 1;
        }
      }
    }
  }
  sumOverall /= abstractionsCount;
  printf("%d %d %d", ileRoznychSum, ileMaxPowtorzen, sumOverall);
  return 0;
}