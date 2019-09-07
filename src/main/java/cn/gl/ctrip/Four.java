package cn.gl.ctrip;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Four {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head,int m) {
        // delete,  last-> head
        if (head == null)
            return null;
        ListNode fackHead2 = new ListNode(0);
        ListNode tale2 = fackHead2;
        ListNode fackHead = new ListNode(0);
        fackHead.next = head;
        ListNode prv = fackHead;
        ListNode temp = fackHead.next;
        while (temp != null) {
            if (temp.val <= m) {
                tale2.next = temp;
                tale2 = tale2.next;
                prv.next = temp.next;
                temp.next = null;
                temp = prv;
            }
            temp = temp.next;
            prv = prv.next;
        }
        tale2.next = fackHead.next;
        return fackHead2.next;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}
