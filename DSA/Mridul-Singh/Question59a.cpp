//GFG QUESTION -> Delete nodes having greater value on right
//Given a singly linked list, remove all the nodes with any node on their right whose value is greater and return the head of the modified linked list.
//(Not just the immediate Right, but the entire List on the Right)

#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;

    Node(int x) {
        data = x;
        next = nullptr;
    }
};

class Solution {
public:
    Node* reverse(Node* head) {
        Node* front = nullptr;
        Node* prev = nullptr;
        while (head != nullptr) {
            front = head->next;
            head->next = prev;
            prev = head;
            head = front;
        }
        return prev;
    }

    Node* compute(Node* head) {     //time complexity O(n) and space complexity O(1)
        Node* revHead = reverse(head);  
        Node* maxNode = revHead;
        Node* curr = revHead;
        while (curr != nullptr && curr->next != nullptr) {
            if (curr->next->data < maxNode->data) {
                Node* temp = curr->next;
                curr->next = temp->next;
                delete temp;
            } else {
                curr = curr->next;
                maxNode = curr;
            }
        }
        return reverse(revHead);
    }
};

void printList(Node* head) {
    while (head != nullptr) {
        cout << head->data << " ";
        head = head->next;
    }
    cout << endl;
}

int main() {
    Node* head = new Node(12);
    head->next = new Node(15);
    head->next->next = new Node(10);
    head->next->next->next = new Node(11);
    head->next->next->next->next = new Node(5);
    head->next->next->next->next->next = new Node(6);
    head->next->next->next->next->next->next = new Node(2);
    head->next->next->next->next->next->next->next = new Node(3);
    cout << "Original List: ";
    printList(head);
    Solution solution;
    Node* modifiedHead = solution.compute(head);
    cout << "Modified List: ";
    printList(modifiedHead);
    while (modifiedHead != nullptr) {
        Node* temp = modifiedHead;
        modifiedHead = modifiedHead->next;
        delete temp;
    }
    return 0;
}