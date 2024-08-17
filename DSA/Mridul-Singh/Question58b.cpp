//GFG QUESTION -> Flattening a Linked List
//Given a Linked List, where every node represents a sub-linked-list and contains two pointers:
// (i) a next pointer to the next node,
// (ii) a bottom pointer to a linked list where this node is head.
// Each of the sub-linked lists is in sorted order.
// Flatten the Link List so all the nodes appear in a single level while maintaining the sorted order.

#include<bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node* bottom;
    Node(int x) : data(x), next(nullptr), bottom(nullptr) {}
};

class Solution {
  public:
    Node* constructLL(vector<int>& arr) {
        Node* head=new Node(arr[0]);
        Node* it=head;
        for(int i=1;i<arr.size();i++){
            Node* temp= new Node(arr[i]);
            it->bottom=temp;
            it=temp;
        }
        return head;
    }
    
    Node *flatten(Node *root) {
        vector<int> arr;
        Node* ptr = root;
        while (ptr != nullptr) {
            Node* subptr = ptr;
            while (subptr != nullptr) {
                arr.push_back(subptr->data);
                subptr = subptr->bottom;
            }
            ptr = ptr->next;
        }
        sort(arr.begin(), arr.end());
        return constructLL(arr);
    }
};

void printList(Node* root) {
    while (root != nullptr) {
        cout << root->data << " ";
        root = root->bottom;
    }
    cout << endl;
}

int main() {
    Node* head = new Node(5);
    head->bottom = new Node(7);
    head->bottom->bottom = new Node(8);
    head->bottom->bottom->bottom = new Node(30);
    head->next = new Node(10);
    head->next->bottom = new Node(20);
    head->next->next = new Node(19);
    head->next->next->bottom = new Node(22);
    head->next->next->bottom->bottom = new Node(50);
    head->next->next->next = new Node(28);
    head->next->next->next->bottom = new Node(35);
    head->next->next->next->bottom->bottom = new Node(40);
    head->next->next->next->bottom->bottom->bottom = new Node(45);
    Solution sol;
    Node* flatHead = sol.flatten(head);
    printList(flatHead);
    return 0;
}