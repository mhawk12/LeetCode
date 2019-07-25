import java.util.HashMap;
import java.util.Map;

public class RandomPointer {

    public static void main(String[] args) {

    }

    public Node CopyRandomLit(Node head) {

        if (head == null)
            return null;

        Map<Node, Node> nodeMap = new HashMap<>();
        Node resultHead = new Node(0, null, null);
        Node result = null;

        while (head != null) {

            resultHead.next = new Node(head.val, head.next, head.random);

            if (result == null)
                result = resultHead.next;

            nodeMap.put(head, resultHead.next);
            resultHead = resultHead.next;
            head = head.next;

        }


        resultHead = result;

        while (resultHead != null) {
            resultHead.random = nodeMap.get(resultHead.random);
            resultHead = resultHead.next;
        }

        return result;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
