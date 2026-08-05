class palindrome{
     public boolean isPalindrome(ListNode head) {

        // ListNode temp = head;
        // int count = 0;
        // while(temp!=null){
        //     count++;
        //     temp = temp.next;
        // }
        // int[] arr = new int[count];
        // ListNode p = head;
        // for(int i=0;i<arr.length;i++){
        //     arr[i] = p.val;
        //     p = p.next;
        // }
        // int i=0,j=arr.length-1;
        // while(i<=j){
        //     if(arr[i]!=arr[j]){
        //         return false;
        //     }
        //     i++;
        //     j--;
        // }
        // return true;


        // ListNode temp = head;
        // int count = 0;
        // while(temp!=null){
        //     count++;
        //     temp = temp.next;
        // }
        // ListNode head1 = head;
        // ListNode main = null;
        // for(int i=0;i<count/2;i++){
        //     main = head1;
        //     head1 = head1.next;
        // }
        // ListNode p = null;
        // ListNode c = head1;
        // ListNode f = head1.next;
        // c.next = null;
        // while(c!=null){
        //     ListNode tem = null;
        //     if(f!=null){
        //         tem = f.next;
        //         f.next = c;
        //     }
        //     p = c;
        //     c = f;
        //     if(f!=null)
        //         f = tem;
        // }
        // main = p;
        // ListNode temp1 = head;
        // ListNode temp2 = p;
        // while(temp2!=null){
        //     if(temp1.val!=temp2.val){
        //         return false;
        //     }
        //     temp1 = temp1.next;
        //     temp2 = temp2.next;
        // }
        // return true;






public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp!=null){  //counting
            temp = temp.next;
            count++;
        }
        int size = 0;
        if(count%2!=0){
            size = count/2+1;
        }
        else{
            size = count/2;
        }
        ListNode curr = head;
        ListNode q = null; //vi
        
        for(int i=0;i<size;i++){
            q = curr;
            curr = curr.next;
        }

        ListNode prev = null;   //revising
        while(curr!=null){
            ListNode f = curr.next;
            curr.next = prev;
            prev = curr;
            curr = f;
        }

        if(q!=null && q.next!=null)
            q.next = prev;

        ListNode low = head;
        ListNode high = head;
        for(int i=0;i<size;i++){
            high = high.next;
        }
        while(high!=null){
            if(low.val!=high.val){
                return false;
            }
            low = low.next;
            high = high.next;
        }
        return true;
    }
}
}