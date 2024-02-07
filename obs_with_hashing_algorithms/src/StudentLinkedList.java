class StudentLinkedList {
    private Node head;

    public Node getHead() {
        return head;
    }

    public StudentLinkedList() {
        this.head = null;
    }

    public void addStudent(Student student) {
        Node newNode = new Node(student);

        if (head == null) {
            // If the list is empty, the new node becomes the head node.
            head = newNode;
        } else {
            // If the list is not empty, go to the end of the list.
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            // Set the 'next' value of the node at the end of the list to the new node.
            current.setNext(newNode);
        }
    }

    public Student findStudentById(int id) {
        Node current = head;
        while (current != null) {
            if (current.getStudent().getID() == id) {
                return current.getStudent();
            }
            current = current.getNext();
        }
        return null;
    }

    public void printAllStudents() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getStudent().toString());
            current = current.getNext();
        }
    }
}
