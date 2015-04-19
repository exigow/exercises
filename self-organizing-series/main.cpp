#include <iostream>
#include <stdio.h>

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
  if (n == NULL)
    printf("null");
  else {
    printf("(%lu)->", n->value);
    printRecursive(n->next);
  }
}

inline static Node *loadAndGetHead() {
  Node *last = NULL;
  Node *head = NULL;
  bool noBlock = true;
  long readedValue = next();
  do {
    Node *node = new Node();
    node->value = readedValue;
    if (last != NULL)
      last->next = node;
    last = node;
    readedValue = next();
    if (noBlock)
      head = node, noBlock = false;
  } while (readedValue != EOF);
  last->next = head;
  return head;
}

inline static long removeNext(Node *node) {
  Node *forward = node->next->next;
  long val = node->next->value;
  delete node->next;
  node->next = forward;
  printf("deleted, steps: %lu", val);
  return val;
}

inline static Node *walk(Node* from, long steps) {
  Node *temp = from;
  for (long i = 0; i < steps; i++)
    temp = temp->next;
  return temp;
  // todo skip jesli jest steps >= list.size
}

int main() {
  long count = next();
  Node *pivot = loadAndGetHead();
  printRecursive(pivot);
  /*long steps = removeNext(pivot);
  pivot = walk(pivot, steps);
  printRecursive(pivot);*/
  return 0;
}