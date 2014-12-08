#include <iostream>
#include <stdio.h>

using namespace std;

struct Node {
  int value;
  struct Node *right, *left;
};

inline void printNode(Node *node) {
  if (node->left)
    printNode(node->left);
  printf("%d\n",node->value);
  if(node->right)
    printNode(node->right);
}

int main() {
  int c;
  bool rooting = true;
  Node *root = NULL;
  do {
    Node *created = new Node(), *walker = NULL;
    created->value = getchar_unlocked();
    if (rooting)
      rooting = false,
      root = created;
    getchar_unlocked(); // skip space
    while (true) {
      c = getchar_unlocked();
      if (c == EOF | c == 10) {
        cout << endl;
        break;
      }
      cout << (char) c;
    }
  } while (c != EOF);
  printNode(root);
  return 0;
}