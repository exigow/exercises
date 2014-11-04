inline void put(int n) {
  int N = n, rev, count = 0;
  rev = N;
  if (N == 0) {
    putchar_unlocked('0');
    putchar_unlocked('\n');
    return;
  }
  while ((rev % 10) == 0) {
    count++;
    rev /= 10;
  }
  rev = 0;
  while (N != 0) {
    rev = (rev << 3) + (rev << 1) + N % 10;
    N /= 10;
  }
  while (rev != 0) {
    putchar_unlocked(rev % 10 + '0');
    rev /= 10;
  }
  while (count--)
    putchar_unlocked('0');
}
