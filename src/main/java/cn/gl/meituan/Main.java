package cn.gl.meituan;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            String line = scanner.nextLine();
//            int i = Integer.parseInt(line);
//            solution(i);
//        }

        solution(6);


    }

    static volatile boolean coupon = true;
    static ReentrantLock lock = new ReentrantLock();

    static class ReviewEncourage{
        volatile int n;
        AtomicInteger count = new AtomicInteger(1);

        public ReviewEncourage(int n) {
            this.n = n;
        }

        // 仅能打印A，表示发放积分
        public void bonus(PrizePool prizePool) {
            prizePool.send("A");
        }

        // 仅能打印B，表示发放优惠券
        public void coupon(PrizePool prizePool) {
            prizePool.send("B");
        }

        // 仅能打印C，表示发放贡献值
        public void contribution(PrizePool prizePool) {
            prizePool.send("C");
        }
    }

    static PrizePool prizePool = new PrizePool();

    static class PrizePool{
        public void send(String input) {
            System.out.print(input);
        }
    }

    static class BonusTask implements Runnable{
        ReviewEncourage reviewEncourage;

        public BonusTask(ReviewEncourage reviewEncourage) {
            this.reviewEncourage = reviewEncourage;
        }

        @Override
        public void run() {
            AtomicInteger count = reviewEncourage.count;
            while (count.get() <= reviewEncourage.n) {
                if (count.get() % 2 == 1 ) {
                    lock.lock();
                    if (count.get() <= reviewEncourage.n){
                        reviewEncourage.bonus(prizePool);
                        count.addAndGet(1);
                    }
                    lock.unlock();
                }
            }
        }
    }

    static class CouponTask implements Runnable {

        ReviewEncourage reviewEncourage;

        public CouponTask(ReviewEncourage reviewEncourage) {
            this.reviewEncourage = reviewEncourage;
        }

        @Override
        public void run() {
            AtomicInteger count = reviewEncourage.count;
            while (count.get() <= reviewEncourage.n) {
                if (count.get() % 2 == 0 && coupon) {
                    lock.lock();
                    if (count.get() <= reviewEncourage.n){
                        reviewEncourage.coupon(prizePool);
                        count.addAndGet(1);
                        coupon = false;
                    }
                    lock.unlock();
                }
            }
        }
    }

    static class ContributionTask implements Runnable {

        ReviewEncourage reviewEncourage;

        public ContributionTask(ReviewEncourage reviewEncourage) {
            this.reviewEncourage = reviewEncourage;
        }

        @Override
        public void run() {
            AtomicInteger count = reviewEncourage.count;
            while (count.get() <= reviewEncourage.n) {
                if (count.get() % 2 == 0 && !coupon) {
                    lock.lock();
                    if (count.get() <= reviewEncourage.n){
                        reviewEncourage.contribution(prizePool);
                        count.addAndGet(1);
                        coupon = true;
                    }
                    lock.unlock();
                }
            }
        }
    }


    public static void solution(Integer num){
        ReviewEncourage reviewEncourage = new ReviewEncourage(num);
        Thread bonusThread = new Thread(new BonusTask(reviewEncourage));
        Thread couponThread = new Thread(new CouponTask(reviewEncourage));
        Thread contributionThread = new Thread(new ContributionTask(reviewEncourage));
        bonusThread.start();
        couponThread.start();
        contributionThread.start();
    }
}
