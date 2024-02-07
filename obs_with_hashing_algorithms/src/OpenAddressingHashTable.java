class  OpenAddressingHashTable {
    private Student[] table;
    private int tableSize;
    private HashFunctions hashFunctions;
    private int itemCount;

    public OpenAddressingHashTable(int tableSize) {
        this.tableSize = tableSize;
        this.table = new Student[tableSize];
        this.itemCount = 0;
        this.hashFunctions = new HashFunctions(tableSize);  // Initialize after setting tableSize
    }

    public Student[] getTable() {
        return table;
    }

    public void insert(Student student){
        if(itemCount == tableSize){
            resizeTable();
        }
        int i = 0;
        int index = hashFunctions.probe(student.getID(), i);
        while(table[index] != null  ) {  // Check if the slot is already occupied
            i++;  // Increment i to probe next slot
            index = hashFunctions.probe(student.getID(), i);  // Recalculate the index with the new i value

        }

        table[index] = student;  // Insert the student at the calculated index
        itemCount++;

    }

    private void resizeTable() {
        int primedSize = nextPrime(tableSize);
        Student[] newTable = new Student[primedSize];
        System.arraycopy(table, 0, newTable, 0, tableSize);
        tableSize = primedSize;
        table = newTable;
        hashFunctions.setM(primedSize);
    }
    public static int nextPrime(int currentSize) {
        int newSize = 2 * currentSize;  // Double the current size
        while (!isPrime(newSize)) {
            newSize++;
        }
        return newSize;
    }

    // Helper function to check if a number is prime
    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void printTable() {
        for (int i = 0; i < tableSize ; i++) {
            System.out.print("Slot " + i + ": ");
            if (table[i] != null) {
                System.out.println(table[i].getID() + " - " + table[i].getName());
            } else {
                System.out.println("empty");
            }
        }
    }
    public Student searchStudent(int id) {
        int i = 0;
        int index = hashFunctions.probe(id, i);
        while (table[index] != null && i < tableSize) {
            if (table[index].getID() == id) {
                // Found the student
                return table[index];
            }
            i++;
            index = hashFunctions.probe(id, i);
        }
        // Student not found
        return null;
    }
}
