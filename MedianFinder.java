import java.util.PriorityQueue;


public class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {

        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();

    }

    public static void main(String args[]) {


        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

    public void addNum(int num) {

        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if (minHeap.size() < maxHeap.size())
            minHeap.offer(maxHeap.poll());

    }

    public double findMedian() {

        return minHeap.size() > maxHeap.size() ? minHeap.peek() : (double) (minHeap.peek() + maxHeap.peek()) / 2;

    }

}
