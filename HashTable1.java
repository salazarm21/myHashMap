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

    final int HASH_TABLE_SIZE = 1009;
    Record<T>[] hashMap;
    int currentSize;
    int collisionsForThisInsert;

    public HashTable() {
        hashMap = new Record[HASH_TABLE_SIZE];
        currentSize = 0;
        for (int i = 0; i < HASH_TABLE_SIZE; i++) {
            Record<T> r = new Record<T>();
            hashMap[i] = r;
        }
    }

    /*Finds an element with a certain key and stores it in the value passed*/
    public boolean find(int key, T value) {
        return false;
    }

    /*Inserts the key/value into the hashtable*/
    public boolean insert(int key, T value) {

        return false;
    }
    /*Kills a table key*/
    public boolean remove(int key) {

        return false;
    }
    
    /*Returns the load factor for the hash*/
    public double alpha() {
        return 0;
    }

    /*Hash function for finding the home position*/
    private int hashFunction(int key) {
        return key % HASH_TABLE_SIZE;
    }

    /*The result of probing is returned with the new slot's position*/
    private int probeFunction(int key) {
        //need to add one to the location of the key/give a new index to try to insert at.
        
        return 0;
    }
    public int getCollisionsForThisInsert(){
        return collisionsForThisInsert;
    }
    //Dan Bernstein Hash modified from http://www.cse.yorku.ca/~oz/hash.html
    public static int bernHash(String str) {
        int hash = 0;
            for (int i = 0; i < str.length(); i++) {
            hash = str.charAt(i) + ((hash << 5) - hash);
		}
	return hash;
	}
    
    //ELF Hash modified from https://www.programcreek.com/java-api-examples/index.php?source_dir=RuinsOfRevenge-master/src/com/bitfire/utils/Hash.java
    public long ELFHash(String str)
   {
      long hash = 0;
      long x    = 0;

      for(int i = 0; i < str.length(); i++)
      {
         hash = (hash << 4) + str.charAt(i);

         if((x = hash & 0xF0000000L) != 0)
         {
            hash ^= (x >> 24);
         }
         hash &= ~x;
      }

      return hash;
   }
    
}
