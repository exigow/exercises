#include <stdio.h>

/*
  - wyjątek: w systemie unarnym (jedynkowy system liczbowy) liczbę 0 reprezentujemy jako słowo puste
  - długość n ciągu wejściowego zawarta w przedziale od 0 do 10^7 (10000000)
  - elementy ciągu C nie większe niż 10^9 (1000000000)
  - podstawa systemu pozycyjnego d ograniczona odpowiednio przez 1 i 10^9 (1000000000)
 */

inline unsigned char get() {
  return (unsigned char) getchar_unlocked();
}

inline long next() {
  long n = 0;
  char c = get();
  while (c >= 48 && c <= 57)
    n = n * 10 + c - 48,
    c = get();
  return n;
}

inline unsigned char len(long val, long base) {
  unsigned char i = 255;
  unsigned char a = 0;
  for (; val && i; --i, val /= base)
    a++;
  return a;
}

int main() {
  long count = next(), mode = next();
  long i;
  long long result = 0;
  for (i = 0; i < count; i++)
    result += next();
  if (mode == 1)
    printf("%llu", result);
  else
    printf("%d", len(result, mode));
  return 0;
}
