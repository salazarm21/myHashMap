/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhashmap;

import static java.util.Objects.hash;

/**
 *
 * @author timmermank1
 */
public class HashTable<T> {

    final int HASH_TABLE_SIZE = 7;//1009;
    Record<T>[] hashMap;
    int currentSize;
    int collisionsForThisInsert;

    public HashTable() {
        hashMap = new Record[HASH_TABLE_SIZE];
        currentSize = 0;
        for (int i = 0; i < HASH_TABLE_SIZE; i++) {
            Record<T> r = new Record();
            hashMap[i] = r;
        }
    }


    /*Finds an element with a certain key and stores it in the value passed*/
    public boolean find(int key, T value) {
        int hash = findIndex(key);
        if (hash >= 0) {
            value = hashMap[hash].getValue();
            return true;
        } else {
            return false;
        }
    }

    public int findIndex(int key) {
        int hash = hashFunction(key);
        this.collisionsForThisInsert = 0;
        while (true) {
            if (hashMap[hash].isNormal() && hashMap[hash].getKey() == key) {
                return hash;
            } else if (hashMap[hash].isEmpty()) {
                return -1;
            } else {
                this.collisionsForThisInsert++;
                hash = probeFunction(key);
            }
        }
    }

    /*Inserts the key/value into the hashtable*/
    public boolean insert(int key, T value) {

        if (currentSize == HASH_TABLE_SIZE || find(key, value)) {
            return false;
        }

        int hash = hashFunction(key);
        collisionsForThisInsert = 0;
        while (true) {
            if (hashMap[hash].isEmpty()) {
                hashMap[hash] = new Record(key, value);
                currentSize++;
                return true;

            } else {
                collisionsForThisInsert++;
                hash = probeFunction(key);
            }
        }
    }

    /*Kills a table key*/
    public boolean remove(int key) {
        int index = findIndex(key);
        if(index < 0){
            return false;
        }
        hashMap[index].kill();
        currentSize--;
        return true;
    }

    /*Returns the load factor for the hash*/
    public double alpha() {
        double loadFactor = 0.0;
        loadFactor = currentSize / HASH_TABLE_SIZE ;
        return 0;
    }


    /*Hash function for finding the home position*/
    private int hashFunction(int key) {
        int hash = (key % HASH_TABLE_SIZE);
        return hash;
    }

    /*The result of probing is returned with the new slot's position*/
    //quadratic probe
    private int probeFunction(int key) {
        int hash = hashFunction(key);
        //need to add one to the location of the key/give a new index to try to insert at.
        
        //return (hash + this.collisionsForThisInsert) % HASH_TABLE_SIZE;
        return( (int) (Math.pow(2, collisionsForThisInsert))) % HASH_TABLE_SIZE;
    }

    public int getCollisionsForThisInsert() {
        return collisionsForThisInsert;
    }

    //Dan Bernstein Hash modified from http://www.cse.yorku.ca/~oz/hash.html
   /* public static int hashFunction(String str) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = str.charAt(i) + ((hash << 5) - hash);
        }
        return hash;
    }

    //ELF Hash modified from https://www.programcreek.com/java-api-examples/index.php?source_dir=RuinsOfRevenge-master/src/com/bitfire/utils/Hash.java
    public long ELFHash(String str) {
        long hash = 0;
        long x = 0;

        for (int i = 0; i < str.length(); i++) {
            hash = (hash << 4) + str.charAt(i);

            if ((x = hash & 0xF0000000L) != 0) {
                hash ^= (x >> 24);
            }
            hash &= ~x;
        }

        return hash;
    }*/
    
    public String toString(){
        String s = "";
        for (int i = 0; i < this.HASH_TABLE_SIZE; i++) {
            s += i + ". " + hashMap[i] + "\n";
        }
        return s;
    }

}
