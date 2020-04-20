class SList<T>
{
    Node<T> head;
    SList()
    {
        head = null;
    }
    public SListIterator iterator()
    {
        return new SListIterator<T>(head);
    }
}
class SListIterator<T>
{
    Node<T> head;
    Node<T> tail;

    SListIterator(Node<T> node)
    {
        head = node;
    }
    public void insertNode(T data)    {
        if(head==null)
        {
            head = new Node<T>(data);
            tail = head;
        }
        else
        {
            tail.next = new Node<T>(data);
            tail = tail.next;
        }
    }

    public void deleteNode(T data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (String.valueOf(head.data).equals(String.valueOf(data))) {
            head = head.next;
            return;
        }

        Node<T> temp = head;
        while (temp != tail && !String.valueOf(temp.next.data).equals(String.valueOf(data))) {
            temp = temp.next;
        }

        if (temp == tail) {
            System.out.println("List doesn't contain " + data);
            return;
        }

        if (temp.next == tail) {
            tail = temp;
            tail.next = null;
        } else {
            temp.next = temp.next.next;

        }
    }

    public void display()
    {
        if(head==null)
        {
            System.out.println("List is empty ");
            return;
        }
        Node<T> temp = head;
        System.out.println("Data Elements of list are ");
        System.out.print(temp.data+"  ->  ");
        while(temp.next!=null)
        {
            System.out.print(temp.data+"  ->  ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
class Generics
{
    public static void main(String args[])
    {
        SList<String> myList = new SList<String>();
        SListIterator iterator = myList.iterator();
        iterator.insertNode(10);
        iterator.insertNode(20);
        iterator.insertNode("Generic");
        iterator.insertNode("List");
        iterator.insertNode(30);
        iterator.display();
        iterator.deleteNode("List");
        iterator.display();
    }
}