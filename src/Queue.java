public class Queue
{
    Node head;

    //returns true if the Queue has no nodes
    public boolean isEmpty()
    {
        return (head == null);
    }

    //adds a new node to the end of the queue
    public void enqueue(int row, int col, String path)
    {
        if (head == null)
        {
            head = new Node(row, col, path);
        }
        else
        {
            Node iterNode = head;
            while(iterNode.nextNode != null)
                iterNode = iterNode.nextNode;
            iterNode.nextNode = new Node(row, col, path);
        }
    }

    //returns the node as an array where the 0th index has the row and the 1st index has the column
    public Node dequeue()
    {
        if(head == null)
        {
            Node result = new Node(-1,-1, "");
            return (result);
        }
        else
        {
            Node result = head;
            head = head.nextNode;
            return result;
        }
    }

//	public static void main(String[] args)
//	{
//		Queue testQ = new Queue();
//		testQ.enqueue(1, 2);
//		testQ.enqueue(2, 3);
//		testQ.enqueue(3, 4);
//
//		int[] arr;
//		arr = testQ.dequeue();
//		System.out.println("" + arr[0] + arr[1]);
//		arr = testQ.dequeue();
//		System.out.println("" + arr[0] + arr[1]);
//		arr = testQ.dequeue();
//		System.out.println("" + arr[0] + arr[1]);
//
//	}
}//end of Queue class

class Node
{
    public int row;
    public int col;
    public String path;
    public Node nextNode;

    public Node(int r, int c, String p)
    {
        row = r;
        col = c;
        path = p;
        nextNode = null;
    }
}//end of Node class
