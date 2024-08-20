#include <iostream>
using namespace std;

struct node {
    int data;
    node* next;
    node(int x) : data(x), next(nullptr) {}
};

class Solution {
public:
    node* findKthNode(node* temp, int k) {
        k = k - 1;
        while (temp != nullptr && k > 0) {
            k--;
            temp = temp->next;
        }
        return temp;
    }

    node* reverseList(node* head) {
        node* temp = head;
        node* front = nullptr;
        node* prev = nullptr;
        while (temp != nullptr) {
            front = temp->next;
            temp->next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    struct node *reverseIt(struct node *head, int k) {
        if (head == nullptr || k <= 1) {
            return head;
        }
        node* temp = head;
        node* newHead = nullptr;
        node* prevNode = nullptr;
        while (temp != nullptr) {
            node* kthNode = findKthNode(temp, k);
            if (kthNode == nullptr) {
                node* reversedSegment = reverseList(temp);
                if (prevNode != nullptr) {
                    prevNode->next = reversedSegment;
                }
                break;
            }
            node* nextSegment = kthNode->next;
            kthNode->next = nullptr;
            node* reversedSegment = reverseList(temp);
            if (newHead == nullptr) {
                newHead = reversedSegment;
            } else {
                prevNode->next = reversedSegment;
            }
            prevNode = temp;
            prevNode->next = nextSegment;
            temp = nextSegment;
        }
        return newHead;
    }
};

void printList(node* head) {
    while (head != nullptr) {
        cout << head->data << " ";
        head = head->next;
    }
    cout << endl;
}

int main() {
    node* head = new node(3);
    head->next = new node(5);
    head->next->next = new node(4);
    head->next->next->next = new node(7);
    head->next->next->next->next = new node(7);
    head->next->next->next->next->next = new node(9);
    head->next->next->next->next->next->next = new node(8);
    head->next->next->next->next->next->next->next = new node(3);
    head->next->next->next->next->next->next->next->next = new node(1);
    head->next->next->next->next->next->next->next->next->next = new node(8);
    head->next->next->next->next->next->next->next->next->next->next = new node(6);
    cout << "Original list: ";
    printList(head);
    int k = 3;
    Solution sol;
    head = sol.reverseIt(head, k);
    cout << "Reversed list: ";
    printList(head);
    return 0;
}
