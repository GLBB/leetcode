package cn.gl.wangyi;

import java.util.Scanner;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

public class Two {

    public static void main(String[] args) {
//        10
//        1 2 2 2 3 3 4 5 5 5
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(2);
//        ListNode n4 = new ListNode(2);
//        ListNode n5 = new ListNode(3);
//        ListNode n6 = new ListNode(3);
//        ListNode n7 = new ListNode(4);
//        ListNode n8 = new ListNode(5);
//        ListNode n9 = new ListNode(5);
//        ListNode n10 = new ListNode(5);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n1.next = n2;
//        n1.next = n2;
//        n1.next = n2;
//        n1.next = n2;
//        n1.next = n2;
//        n1.next = n2;
//        n1.next = n2;
//        n1.next = n2;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String fLine = scanner.nextLine();
            int num = Integer.valueOf(fLine);
            String secondLine = scanner.nextLine();
            String[] sArr = secondLine.split(" ");
            ListNode head = null;
            if (sArr.length > 1) {
                int val = Integer.valueOf(sArr[0]);
                head = new ListNode(val);
                ListNode tail = head;
                for (int i = 1; i < sArr.length; i++) {
                    val = Integer.valueOf(sArr[i]);
                    ListNode node = new ListNode(val);
                    tail.next = node;
                    tail = node;
                }
//                Solution solution = new Solution();
//                solution.removeDuplicates(head);
            }else {
                return;
            }

        }

    }

    public static void removeDuplicates(ListNode head) {
        // 在这里编写代码
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            if (next == null) {
                break;
            }
            if (temp.val == next.val) {
                // 删除 next 后面值相同的元素， temp 指向以一个数
                ListNode nextTemp = next.next;
                while (nextTemp != null && nextTemp.val == next.val) {
                    nextTemp = nextTemp.next;
                }
                next.next = nextTemp;
                temp = nextTemp;
            }else {
                temp = temp.next;
            }
        }
        // print
        temp = head;
        while (temp != null && temp.next != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println(temp.val);

    }
}
