#include <iostream>
#include <stdio.h>

using namespace std;

struct Node {
  int value;
  struct Node *right, *left;
};

inline void printNode(Node *node) {
  printf("%c %d\n", node->value, node->value);
  /*if (node->left)
    printNode(node->left);*/
  if(node->right)
    printNode(node->right);
}

inline void fix(Node *node) {
  printf("fixing %d\n", node->value);
  if (node->right == NULL && node->left != NULL) {
    printf("moving single to right\n");
    node->right = node->left;
    node->left = NULL;
    fix(node->right);
  }
  if (node->right != NULL && node->left != NULL) {
    printf("compare %d > %d\n", node->left->value, node->right->value);
    if (node->left->value > node->right->value) {
      Node *c = node->left;
      node->left = node->right;
      node->right = c;
      printf("swap %d with %d\n", node->left->value, node->right->value);
    }
    fix(node->right);
  }
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
    while (true) {
      c = getchar_unlocked();
      if (c == EOF | c == 10)
        break;
      if (c == 'L') {
        if (walker->left == NULL)
          walker->left = new Node();
        walker = walker->left;
      } else {
        if (walker->right == NULL)
          walker->right = new Node();
        walker = walker->right;
      }
    }
    walker->value = value;
  } while (c != EOF);
  printNode(root);
  fix(root);
  printf("\n");
  printNode(root);
  return 0;
}