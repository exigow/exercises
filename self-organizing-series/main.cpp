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

inline void printNode(Node *node) {
  printf("%lu ", node->value);
}

inline void printIterative(Node *node) {
  Node *temp = node;
  Node *start = node;
  do {
    printNode(temp);
    temp = temp->next;
  } while (temp != start);
}

inline Node *loadAndGetHead() {
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

inline long removeNext(Node *node) {
  Node *forward = node->next->next;
  long val = node->next->value;
  delete node->next;
  node->next = forward;
  return val;
}

inline long addNext(Node *node) {
  Node *temp = node->next;
  Node *created = new Node();
  created->value = node->value - 1;
  node->next = created;
  created->next = temp;
  return node->value;
}

inline Node *walk(Node* from, long steps) {
  Node *temp = from;
  for (long i = 0; i < steps; i++)
    temp = temp->next;
  return temp;
  // todo skip jesli jest steps >= list.size
}

inline bool isEven(Node *node) {
  return node->value % 2 == 0;
}

inline long hehe(Node *pivot) {
  if (isEven(pivot))
    return removeNext(pivot);
  return addNext(pivot);
}

int main() {
  long count = next();
  Node *pivot = loadAndGetHead();
  for (int i = 0; i < count; i++) {
    long steps = hehe(pivot);
    pivot = walk(pivot, steps);
  }
  printIterative(pivot);
  return 0;
}
