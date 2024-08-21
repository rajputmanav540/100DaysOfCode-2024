//GFG QUESTION -> Add Number Linked Lists

#include<bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node(int x) : data(x), next(nullptr) {}
};

class Solution {
  public:
        Node* reverseList(Node* head) {
        Node* prev = nullptr;
        Node* curr = head;
        Node* next = nullptr;
        while (curr != nullptr) {
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    Node* addTwoLists(struct Node* num1, struct Node* num2) {
        num1 = reverseList(num1);
        num2 = reverseList(num2);
        Node* temp1 = num1;
        Node* temp2 = num2;
        Node* dummyNode = new Node(-1);
        Node* curr = dummyNode;
        int carry = 0;
        while (temp1 != nullptr || temp2 != nullptr) {
            int sum = carry;
            if (temp1) {
                sum += temp1->data;
                temp1 = temp1->next;
            }
            if (temp2) {
                sum += temp2->data;
                temp2 = temp2->next;
            }
            Node* newNode = new Node(sum % 10);
            carry = sum / 10;
            curr->next = newNode;
            curr = curr->next;
        }
        if (carry) {
            Node* newNode = new Node(carry);
            curr->next = newNode;
        }
        Node* result = reverseList(dummyNode->next);
        delete dummyNode;
        return result;
    }
};

void printList(Node* head) {
    while (head != nullptr) {
        cout << head->data << " ";
        head = head->next;
    }
    cout << endl;
}

Node* createList(int arr[], int n) {
    Node* head = new Node(arr[0]);
    Node* temp = head;
    for (int i = 1; i < n; i++) {
        temp->next = new Node(arr[i]);
        temp = temp->next;
    }
    return head;
}

int main() {
    int arr1[] = {4, 5}; 
    int arr2[] = {3, 4, 5};
    Node* num1 = createList(arr1, 2);
    Node* num2 = createList(arr2, 3);
    Solution s;
    Node* result = s.addTwoLists(num1, num2);
    cout << "Sum: ";
    printList(result);
    return 0;
}