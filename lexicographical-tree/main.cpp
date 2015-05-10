#include <iostream>
#include <stdio.h>

struct Node {
  int letter;
  struct Node *right, *left;
};

inline static Node *walkLeft(Node *from) {
  if (from->left == NULL)
    from->left = new Node();
  return from->left;
}

inline static Node *walkRight(Node *from) {
  if (from->right == NULL)
    from->right = new Node();
  return from->right;
}

inline static Node *walk(Node *walker, int option) {
  if (option == 'L')
    return walkLeft(walker);
  if (option == 'R')
    return walkRight(walker);
  return walker;
}

inline static Node *buildTree() {
  Node *root = new Node();
  while (true) {
    int letter = getchar_unlocked();
    if (feof_unlocked(stdin))
      break;
    int option;
    Node *walker = root;
    do {
      option = getchar_unlocked();
      walker = walk(walker, option);
    } while(option != '\n');
    walker->letter = letter;
  };
  return root;
}

inline static void printNode(Node *node) {
  if (node == NULL)
    return;
  printNode(node->left);
  printNode(node->right);
  printf("%c", node->letter);
}

inline static bool isOnlyOneLeaf(Node *node) {
  if (node->left && node->right)
    return false;
  if (node->left)
    return isOnlyOneLeaf(node->left);
  if (node->right)
    return isOnlyOneLeaf(node->right);
  return true;
}

inline static bool isNotHavingSubNodes(Node *node) {
  return !node->left && !node->right;
}

inline static bool isLetter(int val) {
  return val != 0 && val < 90;
}

static const int BORDER = 70;

inline static int reduce(Node *node) {
  int tempLeft = 0;
  int tempRight = 0;
  if (isNotHavingSubNodes(node))
    return node->letter - BORDER;
  else {
    if (node->left)
      tempLeft = reduce(node->left);
    if (node->right)
      tempRight = reduce(node->right);
  }
  if (isLetter(tempLeft)) {
    node->left = NULL;
    tempLeft = tempLeft + BORDER;
  }
  if (isLetter(tempRight)) {
    node->right = NULL;
    tempRight = tempRight + BORDER;
  }
  if (tempLeft > tempRight) {
    node->right = NULL;
    return tempLeft;
  }
  if (tempLeft < tempRight) {
    node->left = NULL;
    return tempRight;
  }
  return tempRight;
}

int main() {
  Node *root = buildTree();
  while (!isOnlyOneLeaf(root))
    printf("%c", reduce(root));
  printNode(root);
  return 0;
}
