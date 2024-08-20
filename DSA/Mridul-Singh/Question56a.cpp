//LEETCODE PROBLEM 146
// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
// Implement the LRUCache class:
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise,
// add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity.

#include<bits/stdc++.h>
using namespace std;

class Node{
    public:
    int key;
    int val;
    Node*next;
    Node*prev;
    Node(int key,int val){
        this->key=key;
        this->val=val;
        next=NULL;
        prev=NULL;
    }
};
class LRUCache {
public:
    unordered_map<int,Node*>m;
    Node*head=new Node(-1,-1);
    Node*tail=new Node(-1,-1);
    int size;
    LRUCache(int capacity) {
           size=capacity;
            head->next=tail;
             tail->prev=head;
    }
    void deleteNode(Node*p){
       Node*pre=p->prev;
       Node*nex=p->next;
       pre->next=nex;
       nex->prev=pre;
    }
    void addNode(Node*newnode){
        Node*temp=head->next;
        head->next=newnode;
        newnode->prev=head;
        newnode->next=temp;
        temp->prev=newnode;
    }
    int get(int key) {
        if(m.find(key)==m.end())
        return -1;
        Node*p=m[key];
        deleteNode(p);
        addNode(p);
        m[key]=head->next;
        return head->next->val;
    }
    
    void put(int key, int value) {
       if(m.find(key)!=m.end()){
            Node*c=m[key];
            deleteNode(c);
            c->val=value;
            addNode(c);
            m[key]=head->next;
        }
        else{
            if(m.size()==size){
                Node* prev=tail->prev;
                deleteNode(prev);
                Node*l=new Node(key,value);
                addNode(l);
                m.erase(prev->key);
                m[key]=head->next;
            }
            else{
                 Node*l=new Node(key,value);
                addNode(l);
                m[key]=head->next; 
            }
        }
    }
};

int main()
{   LRUCache lru(2);
    lru.put(1, 1);
    lru.put(2, 2);
    cout << lru.get(1) << endl;
    lru.put(3, 3);
    cout << lru.get(2) << endl;
    lru.put(4, 4);
    cout << lru.get(1) << endl;
    cout << lru.get(3) << endl;
    cout << lru.get(4) << endl;
    return 0;
}