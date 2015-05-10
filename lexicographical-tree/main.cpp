#include <iostream>

struct Node {
  int letter;
  struct Node *right = NULL, *left = NULL;
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

struct Result {
  int left = 0;
  int right = 0;
};

inline static int reduce(Node *element) {
  int tempLeft = 0;
  int tempRight = 0;
  if (!element->left && !element->right)
    return element->letter - 70;
  else {
    if (element->left)
      tempLeft = reduce(element->left);
    if (element->right)
      tempRight = reduce(element->right);
  }
  if (tempLeft != 0 && tempLeft < 90) {
    element->left = NULL;
    tempLeft = tempLeft + 70;
  }
  if (tempRight != 0 && tempRight < 90) {
    element->right = NULL;
    tempRight = tempRight + 70;
  }
  if (tempLeft > tempRight) {
    element->right = NULL;
    return tempLeft;
  }
  if (tempLeft < tempRight) {
    element->left = NULL;
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