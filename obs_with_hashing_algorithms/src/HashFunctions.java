class HashFunctions {
    private int m; // size of the hash table, set to a prime number
    private int a1, b1, a2, b2; // coefficients for hash functions

    public void setM(int m) {
        this.m = m;
    }

    public HashFunctions(int m) {
        this.m = m;

        // Assigning prime numbers for a1, b1, a2, b2
        a1 = 2; // prime
        b1 = 3; // prime

        a2 = 5; // prime
        b2 = 7; // prime
    }

    public int h1(int x) {
        return (((a1 * x) + b1)/1001)%m;

    }

    public int h2(int x) {
        return (((a2 * x) + b2)/1001)%m;
    }

    public int probe(int x, int i) {
        int hash1 = h1(x);
        int hash2 = h2(x);
        return  (hash1 + (hash2 * i)) % m;
    }
}
