import java.util.List;
import java.util.Random;

    public class Main {
        public static void main(String[] args) {
            // Prepare name lists by reading them
            ReadNames reader = new ReadNames();
            List<String> maleNames = reader.readMaleNames("malename.txt");
            List<String> femaleNames = reader.readFemaleNames("femalename.txt");
            List<String> surnames = reader.readLastNames("lastnames.txt");

            // Create StudentDatabase and StudentGenerator
            StudentDatabase database = new StudentDatabase();
            StudentGenerator studentGenerator = new StudentGenerator(maleNames, femaleNames, surnames, database);
            studentGenerator.generateRandomStudents();

            // Create ChainingHashTable and insert students
            ChainingHashTable hashTable = new ChainingHashTable(4001);
            long startInsertTime = System.currentTimeMillis();
            for (Student student : database.getStudentList()) {
                hashTable.insertStudent(student);
            }
            long endInsertTime = System.currentTimeMillis();
            System.out.println("Time taken to insert students with chaining: " + (endInsertTime - startInsertTime) + " ms.");

            // Search for 100 random students
            Random random = new Random();
            long startSearchTime = System.currentTimeMillis();

            for (int i = 0; i < 100; i++) {
                Student student = null;
                while (student == null) {
                    int yy = random.nextInt(10) + 10; // For years between 2010 and 2019
                    int ff = random.nextInt(9) + 1;   // For faculties from 1 to 9
                    int dd = random.nextInt(9) + 1;   // For departments from 1 to 9
                    int nnn = random.nextInt(100);    // For student numbers from 000 to 999
                    String randomId = String.format("%02d%02d%02d%03d", yy, ff, dd, nnn);
                    student = hashTable.searchStudent(Integer.parseInt(randomId));
                }
                System.out.println((i+1)+".Found student in Chaning Table: " + student.getName() + " " + student.getLastName());

            }



            long endSearchTime = System.currentTimeMillis();
            System.out.println("Time taken to search for 100 students: " + (endSearchTime - startSearchTime) + " ms.");


            ////////////////////////////////////OPEN ADDRESSING/////////////////////////////////////////////
            OpenAddressingHashTable openAddressingHashTable = new OpenAddressingHashTable(401); // Start with 401 spots
            startInsertTime = System.currentTimeMillis();
            for (Student student : database.getStudentList()) {
                openAddressingHashTable.insert(student);


            }
            endInsertTime = System.currentTimeMillis();
            System.out.println("Time taken to insert students into the hash table: " + (endInsertTime - startInsertTime) + " ms.");
            long startSearchTimeOA = System.currentTimeMillis();

            for (int i = 0; i < 100; i++) {
                Student student = null;
                while (student == null) {
                    int yy = random.nextInt(10) + 10;  // 2010 ile 2019 arasındaki yıllar için
                    int ff = random.nextInt(9) + 1;    // 1 ile 9 arasındaki fakülteler için
                    int dd = random.nextInt(9) + 1;    // 1 ile 9 arasındaki departmanlar için
                    int nnn = random.nextInt(100);     // 000 ile 999 arasındaki öğrenci numaraları için
                    String randomId = String.format("%02d%02d%02d%03d", yy, ff, dd, nnn);
                    student = openAddressingHashTable.searchStudent(Integer.parseInt(randomId));
                }

                System.out.println((i+1)+".Found student in Open Addressing Hash Table: " + student.getName() + " " + student.getLastName());
            }
            


            long endSearchTimeOA = System.currentTimeMillis();
            System.out.println("Time taken to search for 100 students in Open Addressing Hash Table: " + (endSearchTimeOA - startSearchTimeOA) + " ms.");
        }
    }

