//GFG QUESTION -> Sort a linked list of 0s, 1s and 2s
//Given a linked list where nodes can contain values 0s, 1s, and 2s only.
//The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to the head side,
//2s at the end of the linked list, and 1s in the middle of 0s and 2s.

#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node(int val) : data(val), next(nullptr) {}
};

class Solution {
public:
    Node* segregate(Node* head) {
        if (head == nullptr || head->next == nullptr) return head;
    
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        Node* temp = head;
        while (temp != nullptr) {
            if (temp->data == 0) zeroCount++;
            else if (temp->data == 1) oneCount++;
            else twoCount++;
            temp = temp->next;
        }
        temp = head;
        while (zeroCount > 0) {
            temp->data = 0;
            zeroCount--;
            temp = temp->next;
        }
        while (oneCount > 0) {
            temp->data = 1;
            oneCount--;
            temp = temp->next;
        }
        while (twoCount > 0) {
            temp->data = 2;
            twoCount--;
            temp = temp->next;
        }
        return head;
    }
};

void printList(Node* head) {
    while (head != nullptr) {
        cout << head->data << " ";
        head = head->next;
    }
    cout << endl;
}

Node* insertNode(Node* head, int data) {
    Node* newNode = new Node(data);
    if (head == nullptr) {
        return newNode;
    }
    Node* temp = head;
    while (temp->next != nullptr) {
        temp = temp->next;
    }
    temp->next = newNode;
    return head;
}

int main() {
    Node* head = nullptr;
    Solution sol;
    int arr[] = {0, 0, 2, 0, 1};
    for (int i = 0; i < 5; i++) {
        head = insertNode(head, arr[i]);
    }
    cout << "Original List: ";
    printList(head);
    head = sol.segregate(head);
    cout << "Segregated List: ";
    printList(head);
    return 0;
}
