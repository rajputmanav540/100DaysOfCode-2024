//GFG QUESTION -> Quick Sort on Linked List
//You are given a Linked List. Sort the given Linked List using quicksort.

#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node(int val) : data(val), next(nullptr) {}
};

class Solution {
public:
    void swap(int* d1, int* d2) {
        int temp = *d1;
        *d1 = *d2;
        *d2 = temp;
    }
    Node* findTail(Node* head) {
        while (head != nullptr && head->next != nullptr) {
            head = head->next;
        }
        return head;
    }
    Node* partition(Node* head, Node* tail) {
        Node* pivot = head;
        Node* curr = head->next;
        Node* prev = head;
        while (curr != tail->next) {
            if (curr->data < pivot->data) {
                prev = prev->next;
                swap(&curr->data, &prev->data);
            }
            curr = curr->next;
        }
        swap(&prev->data, &pivot->data);
        return prev;
    }
    void qs(Node* head, Node* tail) {
        if (head == nullptr || head == tail || tail == nullptr) {
            return;
        }
        Node* pivot = partition(head, tail);
        qs(head, pivot);
        qs(pivot->next, tail);
    }
    Node* quickSort(Node* head) {      //time complexity O(n log n) and space compelxity O(1)
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        Node* tail = findTail(head);
        qs(head, tail);
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
    int arr[] = {3, 5, 2, 4, 1};
    for (int i = 0; i < 5; i++) {
        head = insertNode(head, arr[i]);
    }
    cout << "Original List: ";
    printList(head);
    head = sol.quickSort(head);
    cout << "Sorted List: ";
    printList(head);
    return 0;
}