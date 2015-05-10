#include <iostream>

using namespace std;

struct Node {
  int letter;
  struct Node *right = NULL, *left = NULL;
};

inline static Node *walkLeft(Node *from) {
  printf("walking left\n");
  if (from->left == NULL)
    from->left = new Node();
  return from->left;
}

inline static Node *walkRight(Node *from) {
  printf("walking right\n");
  if (from->right == NULL)
    from->right = new Node();
  return from->right;
}

inline static Node *readTree() {
  Node *root = new Node();
  while (true) {
    int letter = getchar_unlocked();
    if (feof_unlocked(stdin))
      break;
    int option;
    Node *walker = root;
    do {
      option = getchar_unlocked();
      if (option == 'L')
        walker = walkLeft(walker);
      if (option == 'R')
        walker = walkRight(walker);
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
  Node *root = readTree();
  printNode(root);
  return 0;
}