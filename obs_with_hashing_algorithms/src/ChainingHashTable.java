class ChainingHashTable {
    private StudentLinkedList[] table;
    private HashFunctions hashFunctions;
    private int tableSize;

    public ChainingHashTable(int tableSize) {
        this.tableSize = tableSize;
        this.hashFunctions = new HashFunctions(tableSize);
        this.table = new StudentLinkedList[tableSize];

        // Initialize each spot with a new StudentLinkedList
        for (int i = 0; i < tableSize; i++) {
            table[i] = new StudentLinkedList();
        }
    }


    public void insertStudent(Student student) {
        int id = student.getID();
        int index=  hashFunctions.h2(id);
        table[index].addStudent(student);
    }

    public Student searchStudent(int id) {
        int hash = hashFunctions.h2(id);
        int index = hash;
        return table[index].findStudentById(id);  // Directly finding student in the linked list at the hashed index
    }



    // Search for a student using double hashing
    public void printTable() {
        for (int i = 0; i < tableSize; i++) {
            StudentLinkedList list = table[i];
            System.out.print("Index " + i + ": ");
            Node current = list.getHead();  // Assuming head is accessible; if it's private, use a method to access it
            while (current != null) {
                Student student = current.getStudent();
                System.out.print(student.getID() + " -> ");
                current = current.getNext();
            }
            System.out.println("NULL");  // End of the list at this index
        }
        System.out.println();  // Extra newline for separation after the entire table is printed
    }

}
