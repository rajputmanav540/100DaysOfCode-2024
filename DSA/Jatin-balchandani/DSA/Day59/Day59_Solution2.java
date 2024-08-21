import java.util.*;
public class Day59_Solution2 {

        static Node Reverse(Node head){

            Node curr=head, prev=null, Next;
            if(head==null || head.next==null)
                return head;
            else{
                while(curr!= null){
                    Next=curr.next;
                    curr.next=prev;
                    prev=curr;
                    curr=Next;   }
            }
            return prev;

        }


        static Node addTwoLists(Node num1, Node num2) {

            num1= Reverse(num1);
            num2= Reverse(num2);
            Node temp1=num1;
            Node temp2=num2;

            Node DummyNode =new Node(0);
            Node curr=DummyNode;
            int carry=0;
            int sum=0;
            while(num1 != null || num2!= null || carry!=0 ){

                sum=0;
                if(num1!=null){
                    sum=sum+num1.data;
                    num1=num1.next;
                }
                if(num2!=null){
                    sum=sum+num2.data;
                    num2=num2.next;
                }

                Node newNode = new Node((sum+carry )%10);
                //  System.out.println( "In added data  -> " + (sum+carry )%10);

                carry=(sum+carry )/10;

                if(curr !=null)  {
                    curr.next=newNode;
                    curr=newNode;
                }else
                    curr=newNode;

            }

            DummyNode=Reverse(DummyNode.next);

            while(DummyNode.data==0 )
            {
                if(DummyNode.next==null)
                    break;
                DummyNode=DummyNode.next;

            }
            return DummyNode;

        }
    }
