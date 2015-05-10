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

inline char toChar(Node *node) {
  if (node == NULL)
    return '_';
  return (char) node->letter;
}

inline void printNode(Node *node) {
  if (node == NULL)
    return;
  printf("node %c with left: %c, right %c\n", toChar(node), toChar(node->left), toChar(node->right));
  printNode(node->left);
  printNode(node->right);
}

int main() {
  Node *root = buildTree();
  printNode(root);
  return 0;
}