#include <stdio.h>
#include <stdlib.h>

inline static void writeNumber(int &x) {
#define get getchar_unlocked
  register int c = get();
  x = 0;
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
}

int main() {
  int abstractionsCount;
  int sumyElementowPodmacierzyDod[1000000];
  int sumyElementowPodmacierzyUje[1000000];
  int ileRoznychSum = 0;
  int maxPowtorzen = 0;
  int ileMaxPowtorzen = 0;
  int sumaSumEle = 0;
  int size;
  writeNumber(size);
  int tab[size][size];
  writeNumber(abstractionsCount);
  for (int i = 0; i < size; i++) {
    for (int j = 0; j < size; j++) {
      writeNumber(tab[i][j]);
      if (i > 0)
        tab[i][j] += tab[i - 1][j];
      if (j > 0)
        tab[i][j] += tab[i][j - 1];
      if (i > 0 && j > 0)
        tab[i][j] -= tab[i - 1][j - 1];
    }
  }
  for (int i = 0; i < abstractionsCount; i++) {
    int k, l, m, n;
    writeNumber(k);
    writeNumber(l);
    writeNumber(m);
    writeNumber(n);
    int suma = tab[m][n];
    if (l > 0)
      suma -= tab[m][l - 1];
    if (k > 0)
      suma -= tab[k - 1][n];
    if (k > 0 && l > 0)
      suma += tab[k - 1][l - 1];
    sumaSumEle += suma;
    if (suma >= 0) {
      if (sumyElementowPodmacierzyDod[suma] == 0) {
        sumyElementowPodmacierzyDod[suma] = 1;
        ileRoznychSum += 1;
        if (maxPowtorzen < sumyElementowPodmacierzyDod[suma]) {
          maxPowtorzen = sumyElementowPodmacierzyDod[suma];
          ileMaxPowtorzen = 1;
        } else if (maxPowtorzen == sumyElementowPodmacierzyDod[suma]) {
          ileMaxPowtorzen += 1;
        }
      } else {
        sumyElementowPodmacierzyDod[suma] += 1;
        if (maxPowtorzen < sumyElementowPodmacierzyDod[suma]) {
          maxPowtorzen = sumyElementowPodmacierzyDod[suma];
          ileMaxPowtorzen = 1;
        } else if (maxPowtorzen == sumyElementowPodmacierzyDod[suma]) {
          ileMaxPowtorzen += 1;
        }
      }
    } else {
      int sumaUje = -suma;
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
  sumaSumEle /= abstractionsCount;
  printf("%d %d %d", ileRoznychSum, ileMaxPowtorzen, sumaSumEle);
  return 0;
}