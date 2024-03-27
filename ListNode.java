public class ListNode {
    int val;

    ListNode next;

    ListNode(int x){
        this.val = x;
    }

    ListNode(){}
}

class Test{
    public static void main(String[] args) {
//        ListNode a = new ListNode(2);
//        ListNode b = new ListNode(3); a.next = b;
//        ListNode c = new ListNode(4); b.next = c;
//        ListNode d = new ListNode(9); c.next = d;
//
//        //print 2-3-4
//        Print(a);
//        System.out.println();
//        System.out.println("Reversed version : ");
//        ReversePrint(a);
//        System.out.println();
        System.out.println("Stack test : ");
        ImplementationStack s = new ImplementationStack();
        System.out.println(s.isEmpty());
        s.push(2);s.push(87);
        System.out.println(s.peek());
        s.pop();s.push(45);s.push(235);s.push(23);
        System.out.println(s.size());
        while (!s.isEmpty()){
            System.out.println(s.pop());
        }
        System.out.println(s.isEmpty());
        System.out.println(s.size());

        System.out.println("Stack implemented by linked list test: ");
        ImplementationStack2 s2 = new ImplementationStack2();

        System.out.println(s2.isEmpty());
        s2.push(23);s2.push(45);s2.push(67);
        System.out.println("The peek :"+s2.peek());
        s2.pop();
        System.out.println("The peek is "+s2.peek());
        System.out.println("The size is : " +s2.size());
        System.out.println(s2.isEmpty());







    }

    static void Print(ListNode head){
        if(head == null){
            return ;
        }
        System.out.print(head.val + " ");
        Print(head.next);
    }

    static void ReversePrint(ListNode head){
        if(head == null){
            return ;
        }
        ReversePrint(head.next);
        System.out.print(head.val + " ");
    }

    public static ListNode reverseList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        reverseList(head.next);
        ListNode p = head;
        head.next.next = head;
        head.next = null;
        return p;

    }


}
