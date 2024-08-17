//GFG QUESTION -> Palindrome Linked List
//Given a singly linked list of integers. The task is to check if the given linked list is palindrome or not.

#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node(int val) : data(val), next(nullptr) {}
};

class Solution {
  public:
    Node* reverse(Node* head){
        Node* temp=head;
        Node* prev=nullptr;
        Node* front=nullptr;
        while(temp!=nullptr){
            front=temp->next;
            temp->next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
    bool isPalindrome(Node *head) {     //time complexity O(n) and space compelxity O(1)
        Node* reversed=reverse(head);
        while(head!=nullptr){
            if(head->data!=reversed->data){
                return false;
            }
            head=head->next;
            reversed=reversed->next;
        }
        return true;
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
    int arr[] = {1, 5, 2, 5, 1};
    for (int i = 0; i < 5; i++) {
        head = insertNode(head, arr[i]);
    }
    cout << sol.isPalindrome(head);
    return 0;
}