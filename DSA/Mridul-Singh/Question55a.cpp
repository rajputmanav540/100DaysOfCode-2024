//LEETCODE PROBLLEM 206
//Given the head of a singly linked list, reverse the list, and return the reversed list.
#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* temp = head;
        ListNode* front = nullptr;
        ListNode* prev = nullptr;
        while (temp != nullptr) {
            front = temp->next;
            temp->next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
};

void printList(ListNode* head) {
    while (head != nullptr) {
        cout << head->val << " -> ";
        head = head->next;
    }
    cout << "nullptr" << endl;
}

ListNode* createLinkedList(int arr[], int size) {   //time complexity O(n) and sapce complexity O(1)
    if (size == 0) return nullptr;
    ListNode* head = new ListNode(arr[0]);
    ListNode* current = head;
    for (int i = 1; i < size; i++) {
        current->next = new ListNode(arr[i]);
        current = current->next;
    }
    return head;
}

int main() {
    int arr[] = {1, 2, 3, 4, 5};
    int size = sizeof(arr) / sizeof(arr[0]);
    ListNode* head = createLinkedList(arr, size);
    cout << "Original Linked List: ";
    printList(head);
    Solution sol;
    ListNode* reversedHead = sol.reverseList(head);
    cout << "Reversed Linked List: ";
    printList(reversedHead);
    return 0;
}