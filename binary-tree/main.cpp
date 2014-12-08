#include <iostream>
#include <stdio.h>

struct node {
  char value;
  struct node *right, *left;
};

void printout(node *tree) {
  if (tree->left)
    printout(tree->left);
  printf("%d\n", tree->value);
  if(tree->right)
    printout(tree->right);
}

void insert(node ** tree, node * item) {
  if(!(*tree)) {
    *tree = item;
    return;
  }
  if (item->value < (*tree)->value)
    insert(&(*tree)->left, item);
  else if (item->value>(*tree)->value)
    insert(&(*tree)->right, item);
}

int main() {
  node *curr, *root = NULL;

  int c;
  do {
    int letter = getchar_unlocked();
    std::cout << letter << " --> ";
    getchar_unlocked(); // skip space
    while (true) {
      c = getchar_unlocked();
      if (c == EOF | c == 10) {
        std::cout << std::endl;
        break;
      }
      std::cout << c << ", ";
    }
  } while (c != EOF);
  return 0;
}