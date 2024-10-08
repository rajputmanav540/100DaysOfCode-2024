class Solution {
  public:
    Node *flatten(Node *root) {
        if(root == NULL) {
            return NULL;
        }
        
        Node* ans = NULL;
        Node* curr = root;
        
        while(curr != NULL) {
            ans = mergeBottomSorted(ans, curr);
            curr = curr->next;
        }
        
        return ans;
    }
    
    Node* mergeBottomSorted(Node* head1, Node* head2) {
        if(head1 == NULL) {
            return head2;
        }
        if(head2 == NULL) {
            return head1;
        }
        
        Node* curr1 = head1;
        Node* curr2 = head2;
        Node* temp = new Node(-1);
        Node* ans = temp;
        int val1=0, val2=0;
        
        while(curr1 != NULL || curr2 != NULL) {
            if(curr1 != NULL) {
                val1 = curr1->data;
            }
            else {
                val1 = INT_MAX;
            }
            
            if(curr2 != NULL) {
                val2 = curr2->data;
            }
            else {
                val2 = INT_MAX;
            }
            
            if(val1 < val2) {
                temp->bottom = curr1;
                curr1 = curr1->bottom;
            }
            else {
                temp->bottom = curr2;
                curr2 = curr2->bottom;
            }
            temp = temp->bottom;
        }
        
        return ans->bottom;
    }
};
