package Test;

class Clerk {
    private int productNum = 0;

    public synchronized void xiaofei(){
        if (productNum>0){
            System.out.println(Thread.currentThread().getName()+"：开始消费第"+productNum+"个产品");
            productNum--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void shengchan(){
        if (productNum<20){
            productNum++;
            System.out.println(Thread.currentThread().getName()+"：开始生产第"+productNum+"个产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Producer implements Runnable{

    Clerk clerk = new Clerk();
    public Producer(Clerk clerk1) {
        clerk = clerk1;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.shengchan();
        }
    }
}

class Consumer implements Runnable{
    Clerk clerk = new Clerk();
    public Consumer(Clerk clerk1) {
        clerk = clerk1;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.xiaofei();
        }
    }
}




public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        Thread p = new Thread(producer);
        Thread c = new Thread(consumer);

        p.setName("生产者");
        c.setName("消费者");

        p.start();
        c.start();


    }
}
