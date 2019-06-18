from __future__ import print_function
import copy


hashTable = {}
tableSize = 0


def insertInHash(key, element):
    hashIndex = key % tableSize

    if (tableSize == len(hashTable)):
        print("Can't perform Insertion..Hash Table is full!!")
        return

    hashIndex = (hashIndex + 1) % tableSize
    if hashIndex in hashTable:
        hashTable[hashIndex].append(element)
    else:
        hashTable[hashIndex] = [element]


def deleteFromHash(key):
    flag = False
    if len(hashTable) == 0:
        print("Hash Table is Empty!!\n")
        return

    for loopKey in hashTable:
        if loopKey == key:
            hashTable.pop(key)
            flag = True
            break

    if flag:
        print("Given data deleted from Hash Table\n")
    else:
        print("Given data is not available in Hash Table\n")
    return


def searchElement(key):
    hashIndex = key % tableSize
    flag = False
    if len(hashTable) == 0:
        print("Hash Table is Empty!!")
        return

    for loopKey in hashTable:
        if loopKey == key:
            print("%d found with value:" % loopKey, hashTable[loopKey])
            flag = True
    if not flag:
        print("Given data is not present in hash table\n")
    return


def display():
    if len(hashTable) == 0:
        print("Hash Table is Empty!!\n")
        return

    print("Key  Element   Index ")
    print("----------------------")
    for loopKey in hashTable:
        for index, loopEle in enumerate(hashTable[loopKey]):
            print("%-10d" % loopKey, end="")
            print("%-7d" % loopEle, end="")
            print("%d" % index)


tableSize = int(input("Enter the no of elements:"))
while True:
    print("1. Insertion 2. Deletion")
    print("3. Searching 4. Display")
    ch = int(input("5. Exit\nEnter your choice:"))
    if ch == 1:
        key = int(input("Enter the key value:"))
        element = int(input("Element:"))
        insertInHash(key, element)

    elif ch == 2:
        key = int(input("Enter the key value:"))
        deleteFromHash(key)
    elif ch == 3:
        key = int(input("Enter the key value:"))
        searchElement(key)
    elif ch == 4:
        display()
    elif ch == 5:
        exit(0)

    else:
        print("You have entered wrong Option!!\n")
