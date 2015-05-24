#include <stdio.h>

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
  int abstractionsCount, size;
  writeNumber(size);
  writeNumber(abstractionsCount);
  int tab[size][size];
  // corner value
  writeNumber(tab[0][0]);
  // first row
  for (int x = 1; x < size; x++) {
    writeNumber(tab[x][0]);
    tab[x][0] += tab[x - 1][0];
  }
  // rest
  for (int y = 1; y < size; y++) {
    writeNumber(tab[0][y]);
    tab[0][y] += tab[0][y - 1];
    for (int x = 1; x < size; x++) {
      int val;
      writeNumber(val);
      val += tab[x - 1][y];
      val += tab[x][y - 1];
      val -= tab[x - 1][y - 1];
      tab[x][y] = val;
    }
  }
  // print table
  for (int y = 0; y < size; y++) {
    for (int x = 0; x < size; x++)
      printf("%d ", tab[x][y]);
    printf("\n");
  }
  // print abstract rectangles
  printf("rectangles:\n");
  for (int row = 0; row < abstractionsCount; row++) {
    int startX, startY, endX, endY;
    writeNumber(startX);
    writeNumber(startY);
    writeNumber(endX);
    writeNumber(endY);
    printf("%d %d %d %d \n", startX, startY, endX, endY);
  }
  return 0;
}
