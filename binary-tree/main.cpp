#include <iostream>
#include <stdio.h>

using namespace std;

struct Node {
  int value;
  struct Node *right, *left;
};


inline void printMe(Node *node) {
  if (node == NULL) {
    printf("null");
    return;
  }
  printf("%c <%d>", node->value, node->value);
}

inline void printNode(Node *node) {
  // recur
  if (node->left)
    printNode(node->left);
  if (node->right)
    printNode(node->right);
  // printme
  printMe(node);
  printf("( ");
  printMe(node->left);
  printf(" : ");
  printMe(node->right);
  printf(" )\n");
}

inline void fix(Node *node) {
  printf("\nfixing %d (with ", node->value);
  if (node->left != NULL)
    printf("%d ", node->left->value);
  if (node->right != NULL)
    printf("%d", node->right->value);
  printf(")\n");
  if (node->right != NULL && node->left != NULL) {
    printf("compare %d > %d\n", node->left->value, node->right->value);
    if (node->left->value > node->right->value) {
      Node *c = node->left;
      node->left = node->right;
      node->right = c;
      printf("swap %d with %d\n", node->left->value, node->right->value);
    }
    printf("run on %d\n", node->right->value);
  }
  if (node->right == NULL && node->left != NULL) {
    node->right = node->left;
    node->left = NULL;
  }
  if (node->right != NULL)
    fix(node->right);
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
    if (rooting) {
      rooting = false;
      root = created;
      root->value = value;
    }
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
  printf("\n");
  fix(root);
  printf("\n");
  printNode(root);
  printf("\n");
  return 0;
}