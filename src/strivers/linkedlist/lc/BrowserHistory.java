package strivers.linkedlist.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther : hasan.khan
 * @Created : 06-Jan-25
 * @Description : <a href="https://leetcode.com/problems/design-browser-history/description/?envType=problem-list-v2&envId=linked-list">link</a>
 */
public class BrowserHistory {

    Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    public void visit(String url) {
        Node nwNode = new Node(url);
        current.next = nwNode;
        nwNode.prev = current;
        current = nwNode;
    }

    public String back(int steps) {
       while (steps > 0 && current.prev != null){
           current = current.prev;
           steps--;
       }
        return current.url;
    }

    public String forward(int steps) {
         while (steps > 0 && current.next != null){
             current = current.next;
             steps--;
         }

        return current.url;
    }

    public void print() {
        Node temp = current;
        // Move to the head of the list
        while (temp.prev != null) {
            temp = temp.prev;
        }

        // Print the list
        while (temp != null) {
            System.out.print(temp.url + " -> ");
            temp = temp.next;
        }
        System.out.println("null");

    }


    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println("browserHistory = " + browserHistory.back(1));             // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println("browserHistory = " + browserHistory.back(1));             //                  // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println("browserHistory = " + browserHistory.forward(1));             //                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        System.out.println("browserHistory = " + browserHistory.forward(2));                  // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println("browserHistory = " + browserHistory.back(1));                    // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println("browserHistory = " + browserHistory.forward(7));       // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"

    }
}

class Node {
    public String url;
    public Node next;
    public Node prev;

    public Node(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }


    public String getUrl() {
        return url;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ").append("P: ").append(prev != null ? prev.url : "null,").append(" D: " + url)
                .append(" N: ")
                .append(next != null ? next.url : "null,")
                .append(" ]");

        Node current = next;
        Set<Node> visited = new HashSet<>();

        while (current != null) {
            if (visited.contains(current)) {
                sb.append(" -> [ Cycle Detected ]");
                break;
            }

            visited.add(current);
            sb.append(" -> ");
            // sb.append("[ ").append(current.data).append(", Prev: ").append(current.prev != null ? current.prev.data : "null").append(" ]");
            sb.append("[ ").append("P: ").append(current.prev != null ? current.prev.url : "null, ").append(", D: " + current.url)
                    .append(" N: ").append(current.next != null ? current.next.url : "null ")
                    .append(" ]");

            current = current.next;
        }

        return sb.toString();
    }
}
