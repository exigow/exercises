#include <iostream>

using namespace std;

inline long next() {
  register long n = 0;
  register int c = getchar_unlocked();
  if (c == -1)
    return -1;
  while (c > 47 && c < 58)
    n = (n << 1) + (n << 3) + c - 48,
      c = getchar_unlocked();
  return n;
}

struct Node {
  long value;
  Node *next;
};

static void printRecursive(Node *n) {
  if (n == nullptr)
    printf("null");
  else {
    printf("(%lu)->", n->value);
    printRecursive(n->next);
  }
}

inline static Node *loadAndGetHead() {
  Node *prev = nullptr;
  Node *head = nullptr;
  bool noBlock = true;
  long readedValue = next();
  do {
    Node *node = new Node();
    node->value = readedValue;
    if (prev != nullptr)
      prev->next = node;
    prev = node;
    readedValue = next();
    if (noBlock)
      head = node, noBlock = false;
  } while (readedValue != EOF);
  return head;
}

inline static void removeNext(Node *node) {
  Node *forward = node->next->next;
  delete node->next;
  node->next = forward;
}

int main() {
  long count = next();
  Node *pivot = loadAndGetHead();
  removeNext(pivot);
  printRecursive(pivot);
  return 0;
}