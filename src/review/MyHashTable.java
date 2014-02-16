package review;

import java.util.ArrayList;
import java.util.Collection;

public class MyHashTable<K, V> {

    private int SIZE = 50;
    private HashNode[] array = (HashNode[]) new Object[SIZE];
    private int size = 0;

    public void put(K key, V value) {
	int hash = key.hashCode() % SIZE;

	HashNode a = array[hash];

	if (a == null) {
	    array[hash] = new HashNode(key, value, hash);
	} else {
	    do {
		if (a.mKey == key) {
		    a.mValue = value;
		    return;
		}
		a = a.next;
	    } while (a.next != null);
	    a.next = new HashNode(key, value, hash);
	}
       size++;
    }

    public V remove(K key) {
	int hash = key.hashCode();
	V value = null;
	HashNode a = array[hash];
	while (a != null) {
	    if (a.mKey == key) {
		value = (V) a.mValue;
		a = a.next;
		size--;
		return value;
	    }
	}
	//value not found
	return value;
    }

    public boolean contains(V value) {
	return false;
    }

    public Collection<K> getKeys() {
	ArrayList<K> keys = new ArrayList<K>(size);
	HashNode<K,V> tmp;
	for(int i = 0 ; i < SIZE ; i++) {
	    tmp = array[i];
	    while (tmp != null) {
		keys.add(tmp.mKey);
		tmp = tmp.next;
	    }
	}
	return keys;
    }

    public void clear() {
	for(int i = 0 ; i < SIZE ; i++) {
	    array[i] = null;
	}
	size = 0;
    }

    public ArrayList<V> getValues() {
	ArrayList<V> values = new ArrayList<V>(size);
	HashNode<K, V> tmp;
	for(int i = 0 ; i < SIZE ; i++) {
	    tmp = array[i];
	    while (tmp != null) {
		values.add(tmp.mValue);
		tmp = tmp.next;
	    }
	}
	return values;
    }

    public int size() {
	return size;
    }

    private class HashNode<K, V> {
	private K mKey;
	private V mValue;
	private HashNode<K,V> next = null;

	public HashNode(K key, V value, int hash) {
	    mKey = key;
	    mValue = value;
	    next = null;
	}
	
    }

    public static void main(String[] args) {

	MyHashTable<Integer, String> hash = new MyHashTable<Integer, String>();
	for (int i = 0 ; i < 4 * 50 ; i++) {
	    hash.put(i, String.valueOf(System.currentTimeMillis()));
	}
    }

}
