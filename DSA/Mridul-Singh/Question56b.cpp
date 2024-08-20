//GFG Sort LL using merge sort

#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node(int x) : data(x), next(nullptr) {}
};

class Solution {
public:
    Node* findMiddle(Node* temp) {
        Node* slow = temp;
        Node* fast = temp->next;
        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }
        return slow;
    }

    Node* merge(Node* leftHead, Node* rightHead) {
        Node* dummyNode = new Node(-1);
        Node* temp = dummyNode;
        while (rightHead != nullptr && leftHead != nullptr) {
            if (rightHead->data >= leftHead->data) {
                temp->next = leftHead;
                leftHead = leftHead->next;
            } else {
                temp->next = rightHead;
                rightHead = rightHead->next;
            }
            temp = temp->next;
        }
        if (leftHead != nullptr) {
            temp->next = leftHead;
        }
        if (rightHead != nullptr) {
            temp->next = rightHead;
        }
        return dummyNode->next;
    }

    Node* mergeSort(Node* head) {       //time complexity O(n log n) and space compexity O(log n)
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        Node* middle = findMiddle(head);
        Node* leftHead = head;
        Node* rightHead = middle->next;
        middle->next = nullptr;
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);
        return merge(leftHead, rightHead);
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
    Solution solution;
    Node* head = new Node(4);
    head->next = new Node(2);
    head->next->next = new Node(1);
    head->next->next->next = new Node(3);
    cout << "Original List: ";
    printList(head);
    head = solution.mergeSort(head);
    cout << "Sorted List: ";
    printList(head);
    return 0;
}
