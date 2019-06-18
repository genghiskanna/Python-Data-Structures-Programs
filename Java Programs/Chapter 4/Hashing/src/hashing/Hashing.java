package hashing;

import java.util.Scanner;

class HashTable {
    
    private int data[];
    private int free;
    
    private static int ModuloDivision(int key, int size) {
        int HashValue = key % size;
        return HashValue;
    }
    
    public int SearchHashTable(int key, int size, int element) {
        int HashValue = ModuloDivision(key, size);
        int probe = HashValue;
        while (true) {
            if (data[probe] == element) {
                return probe;
            } else if (data[probe] == Integer.MAX_VALUE) {
                System.out.println("Element Not Found");
                return Integer.MAX_VALUE;
            } else {
                probe = probe % size + 1;
            }
        }
    }
    
    public void InsertLinearProbing(int key, int size) {
        
        int HashValue;
        if (free == 0) {
            System.out.println("No Space in the Hashtable");
            return;
        } else {
            HashValue = ModuloDivision(key, size);
            int probe = HashValue;
            while (true) {
                if (data[probe] == Integer.MAX_VALUE
                        || data[probe] == Integer.MIN_VALUE) {
                    data[probe] = key;
                    break;
                } else {
                    probe = probe % size + 1;
                }
            }
        }
        
        free--;
    }
    
    HashTable(int size) {
        data = new int[size];
        free = size;
        for (int i = 0; i < size; i++) {
            data[i] = Integer.MAX_VALUE;
        }
    }
    
    HashTable() {
    }
    
    public void display(int size) {
        System.out.println();
        System.out.print("Position\t");
        for (int i = 0; i < size; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.print("Key\t\t");
        for (int i = 0; i < size; i++) {
            if (data[i] == Integer.MAX_VALUE) {
                System.out.print("*\t");
            } else {
                System.out.print(data[i] + "\t");
            }
        }
        System.out.println();
    }
}

public class Hashing {
    
    public static void main(String args[]) {
        int size, elt;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the hashtable:");
        size = sc.nextInt();
        HashTable table = new HashTable(size);
        int choice;
        do {
            System.out.println("1.Insert an element\n2.Search for an element\n3.Display has table\n Enter your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the value:");
                    elt = sc.nextInt();
                    table.InsertLinearProbing(elt, size);
                    break;
                case 2:
                    System.out.print("Enter the value:");
                    elt = sc.nextInt();
                    System.out.println("Found at position :"+table.SearchHashTable(elt, size, elt));
                    break;
                
                case 3:
                    table.display(size);
                    break;
            }
        }while(choice<4);  
    }
}
