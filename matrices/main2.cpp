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
  int c;
  int liczba = 0;
  int ilePodmacierzy;
  int **summedAreaTable;
  int sumyElementowPodmacierzyDod[1000000];
  int sumyElementowPodmacierzyUje[1000000];
  int ileRoznychSum = 0;
  int maxPowtorzen = 0;
  int ileMaxPowtorzen = 0;
  int sumaSumEle = 0;
  int rozmiarMacierzy;
  int czyUjemna = -1;
  int k, l, m, n;
  int i = 0;
  int suma;
  int j = 0;
  writeNumber(rozmiarMacierzy);
  summedAreaTable = (int **) malloc(rozmiarMacierzy * sizeof(int *));
  for (i = 0; i < rozmiarMacierzy; i++) {
    summedAreaTable[i] = (int *) malloc(rozmiarMacierzy * sizeof(int));
  }
  c = getchar();
  liczba = 0;
  while (c >= 48 && c <= 57) {
    liczba *= 10;
    liczba += (c - 48);
    c = getchar();
  }
  ilePodmacierzy = liczba;
  c = getchar();
  for (i = 0; i < rozmiarMacierzy; i++) {
    for (j = 0; j < rozmiarMacierzy; j++) {
      liczba = 0;
      while (c >= 48 && c <= 57 || c == 45) {
        if (c == 45) {
          czyUjemna = 1;
          c = getchar();
        }
        liczba *= 10;
        liczba += (c - 48);
        c = getchar();
      }
      if (czyUjemna == 1) {
        czyUjemna = -1;
        liczba = -liczba;
      }
      summedAreaTable[i][j] = liczba;
      if (i > 0)
        summedAreaTable[i][j] += summedAreaTable[i - 1][j];
      if (j > 0)
        summedAreaTable[i][j] += summedAreaTable[i][j - 1];
      if (i > 0 && j > 0)
        summedAreaTable[i][j] -= summedAreaTable[i - 1][j - 1];
      c = getchar();
    }
  }
  for (i = 0; i < ilePodmacierzy; i++) {
    liczba = 0;
    while (c >= 48 && c <= 57) {
      liczba *= 10;
      liczba += (c - 48);
      c = getchar();
    }
    k = liczba;
    c = getchar();
    liczba = 0;
    while (c >= 48 && c <= 57) {
      liczba *= 10;
      liczba += (c - 48);
      c = getchar();
    }
    l = liczba;
    c = getchar();
    liczba = 0;
    while (c >= 48 && c <= 57) {
      liczba *= 10;
      liczba += (c - 48);
      c = getchar();
    }
    m = liczba;
    c = getchar();
    liczba = 0;
    while (c >= 48 && c <= 57) {
      liczba *= 10;
      liczba += (c - 48);
      c = getchar();
    }
    n = liczba;
    if (i < ilePodmacierzy - 1)
      c = getchar();
    suma = summedAreaTable[m][n];
    if (l > 0) suma -= summedAreaTable[m][l - 1];
    if (k > 0) suma -= summedAreaTable[k - 1][n];
    if (k > 0 && l > 0) suma += summedAreaTable[k - 1][l - 1];
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
  sumaSumEle /= ilePodmacierzy;
  printf("%d %d %d", ileRoznychSum, ileMaxPowtorzen, sumaSumEle);
  return 0;
}