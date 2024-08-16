import java.util.*;
public class Day56_Solution2 {
    {
        //Function to sort the given linked list using Merge Sort.
        static Node mergeSort(Node head)
        {

            Node  t= head;
            int c=0;
            while(t!=null){
                c+=1;
                t=t.next;
            }
            int arr[]= new int[c];
            t=head;
            c=0;

            while(t!=null){
                arr[c]=t.data;
                t=t.next;
                c++;
            }
            Arrays.sort(arr);
            t=head;

            int i=0;
            while(i<c){

                t.data=arr[i];
                t=t.next;
                i++;

            }

            return head;

        }
    }


