#include <iostream>
#include <stdio.h>

using namespace std;

struct Node {
  int value;
  struct Node *right, *left;
};

inline void printNode(Node *node) {
  printf("%d\n", node->value);
  if (node->left)
    printNode(node->left);
  if(node->right)
    printNode(node->right);
}

int main() {
  int c;
  bool rooting = true;
  Node *root = NULL, *walker;
  do {
    Node *created = new Node();
    int value = getchar_unlocked();
    created->left = NULL;
    created->right = NULL;
    if (rooting)
      rooting = false,
      root = created,
      root->value = value;
    getchar_unlocked(); // skip space
    walker = root;
    cout << "walker starting from " << walker->value << endl;
    while (true) {
      c = getchar_unlocked();
      if (c == EOF | c == 10) {
        cout << endl;
        break;
      }
      if (c == 'L') {
        if (walker->left == NULL)
          walker->left = new Node();
        walker = walker->left;
      } else {
        if (walker->right == NULL)
          walker->right = new Node();
        walker = walker->right;
      }
      cout << (char) c;
    }
    walker->value = value;
  } while (c != EOF);
  printNode(root);
  return 0;
}