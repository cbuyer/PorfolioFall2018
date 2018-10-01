package linkedlistparty;

class Node <T extends Comparable<T>> {

    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

class LinkedListParty<T extends Comparable<T>> {

	Node<T> head;

	public LinkedListParty(T item) {

		head = new Node(item);
	}

   public void add(T item){

        Node currNode = head;
        Node nextNode = head.next;


        if (currNode.data == null) {
            Node<T> tmpNode = head;
            head = new Node(item);
            head.next = tmpNode;

            return;
        }

        if (nextNode != null && nextNode.data.compareTo(item) >= 0) {
            currNode.next = new Node(item);
            currNode.next.next = nextNode;

            return;
        }

        while (nextNode != null && nextNode.data.compareTo(item) <= 0) {
            currNode = nextNode;
            nextNode = nextNode.next;
        }

        currNode.next = new Node(item);
        currNode.next.next = nextNode;
   }

    public void delete(T item){

        Node prevNode = null;
        Node currNode = head;

        if (head.data == item) {
            head = head.next;

            return;
        }

        while (currNode != null && currNode.data != item) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        if (currNode == null) {
            System.out.println("A node with value(" +item +")does not exist.");
        } else {

            prevNode.next = currNode.next;
        }

   }	

	public void showAll() {

            Node tmpNode = head;
            while (tmpNode != null) {
		System.out.print(tmpNode.data + " -> ");
		tmpNode = tmpNode.next;

            }
		System.out.println("null");
	}

public static void main(String[] args) {

	  LinkedListParty<Integer> myList = new LinkedListParty(5);

	  myList.add(7);
	  myList.add(6);
	  myList.add(15);
	  myList.add(2);
	  myList.add(4);
	  myList.add(10);
          myList.add(12);
	  myList.showAll();
	  myList.delete(3);
	  myList.delete(5);
          myList.delete(6);
          
	  myList.showAll();
   }
}