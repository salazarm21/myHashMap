/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myhashmap;

/**
 *
 * @author Katie Timmerman
 * CS 180 - 02
 * Prof: Dr Timmerman
 * Assignment:
 */
public class MyHashMap {

    public static void main(String[] args) {
    HashTable <Integer> newHash = new HashTable();
    
    int i = 0;
    while(i < newHash.HASH_TABLE_SIZE){
        int key = (int) (Math.random() * 999999);
        boolean inserted = newHash.insert(key, key);
        if(inserted){
            i++;
            System.out.println(newHash);
            System.out.println(newHash.getCollisionsForThisInsert() + "\n\n");
        }
        if(i == 101){
            //do average
        }
    }

    }

}
