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

struct Rect {
  int ax;
  int ay;
  int bx;
  int by;
};

inline static Rect* readRect() {
  Rect* rect = new Rect();
  writeNumber(rect->ay);
  writeNumber(rect->ax);
  writeNumber(rect->by);
  writeNumber(rect->bx);
  return rect;
}

inline static void printRect(Rect *rect) {
  printf("[%d, %d] [%d, %d]\n", rect->ax, rect->ay, rect->bx, rect->by);
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
  // compute
  int sumOverall = 0;
  for (int row = 0; row < abstractionsCount; row++) {
    Rect *rect = readRect();
    printRect(rect);

    int ayFixed = rect->ay - 1;
    int axFixed = rect->ax - 1;

    // upper
    int upper = 0;
    if (ayFixed >= 0)
      upper = tab[rect->bx][ayFixed];
    // left
    int left = 0;
    if (axFixed >= 0)
      left = tab[axFixed][rect->by];

    int big = tab[rect->bx][rect->by];

    int small = tab[axFixed][ayFixed];
    if (axFixed <= 0 || ayFixed <= 0)
      small = 0;

    int result = big - left - upper + small;
    sumOverall += result;
    printf("big(%d) - left(%d) - upper(%d) + small(%d) = %d\n", big, left, upper, small, result);
  }
  printf("sumOverall = %d\n", sumOverall);
  return 0;
}
