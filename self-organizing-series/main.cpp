#include <iostream>
#include <stdio.h>

using namespace std;

typedef unsigned int uint;

long size = 0;

inline int fetchNext() {
  register int n = 0;
  register int c = getchar_unlocked();
  if (c == EOF)
    return EOF;
  while (c > 47 && c < 58)
    n = (n << 1) + (n << 3) + c - 48,
    c = getchar_unlocked();
  return n;
}

inline void putNext(uint n) {
  if (n == 0) {
    putchar_unlocked(48);
    return;
  }
  char tab[12];
  int p = 0;
  while (n != 0) {
    tab[p++] = (char) ((n % 10) + 48);
    n /= 10;
  }
  while (p--)
    putchar_unlocked(tab[p]);
}

struct Node {
  uint value;
  Node *next;
};

inline void printNode(Node *node) {
  putNext(node->value);
}

inline void printIterative(Node *node) {
  Node *temp = node;
  Node *start = node;
  do {
    printNode(temp);
    temp = temp->next;
    if (temp == start)
      break;
    putchar_unlocked(' ');
  } while (true);
}

inline Node *loadAndGetHead() {
  Node *last = NULL;
  Node *head = NULL;
  bool noBlock = true;
  int readedValue = fetchNext();
  do {
    Node *node = new Node();
    size++;
    node->value = (uint) readedValue;
    if (last != NULL)
      last->next = node;
    last = node;
    readedValue = fetchNext();
    if (noBlock)
      head = node, noBlock = false;
  } while (readedValue != EOF);
  last->next = head;
  return head;
}

inline uint removeNext(Node *node) {
  Node *forward = node->next->next;
  uint val = node->next->value;
  delete node->next;
  size--;
  node->next = forward;
  return val;
}

inline uint addNext(Node *node) {
  Node *temp = node->next;
  Node *created = new Node();
  size++;
  uint value = node->value;
  created->value = value - 1;
  node->next = created;
  created->next = temp;
  return value;
}

inline Node *walk(Node* from, uint steps) {
  Node *temp = from;
  for (uint i = 0; i < steps; i++)
    temp = temp->next;
  return temp;
}

inline bool isEven(Node *node) {
  return node->value % 2 == 0;
}

inline uint performAction(Node *pivot) {
  if (isEven(pivot))
    return removeNext(pivot);
  return addNext(pivot);
}

int main() {
  int count = fetchNext();
  Node *pivot = loadAndGetHead();
  for (uint i = 0; i < count; i++) {
    uint steps = performAction(pivot);
    if (steps >= size)
      steps -= size;
    pivot = walk(pivot, steps);
  }
  printIterative(pivot);
  return 0;
}
