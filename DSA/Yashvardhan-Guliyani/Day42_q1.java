int kthSmallest(int arr[], int l, int r, int k) {
        priority_queue<int> pq;
        for(int i =0;i<(r-l+1);i++)
        {
            pq.push(arr[i]);
        }
        while(pq.size()>k)
        {
            pq.pop();
        }
        return pq.top();
