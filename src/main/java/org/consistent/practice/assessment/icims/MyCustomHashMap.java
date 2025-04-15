package org.consistent.practice.assessment.icims;

import java.util.HashMap;

public class MyCustomHashMap <K,V>{
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Entry<K,V>[] table;
    private int size;

    static class Entry<K,V> {
        K key;
        V value;
        Entry<K,V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    MyCustomHashMap() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    private int hash(K key) {
        return key == null ? 0: key.hashCode() % table.length;
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K,V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
        } else{
            Entry<K,V> current = table[index];
            while (true) {
                if(current.key.equals(key)) {
                    current.value = value;
                    return value;
                }
                if (current == null) {
                    current.next = new Entry<>(key,value);
                    return value;
                }
                current = current.next;
            }
        }
        size++;
        if (size * 0.1 / table.length >= LOAD_FACTOR) {
            resize();
        }
        return value;
    }

    private void resize() {
        Entry<K,V>[] oldTable = table;
        table = new Entry[table.length * 2];
        //rehash everything
        for (Entry<K,V> entry : oldTable) {
            while (entry != null) {
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    public static void main(String[] args) {
        MyCustomHashMap<String, Integer> map = new MyCustomHashMap<>();
        HashMap<String,Integer> mapp = new HashMap<>();
        map.put("manohar",29);
        map.put("manohar", 30);
        map.put("manohar1",29);
        map.put("manohar2", 30);
        System.out.println(map.get("manohar2"));
        map.put("manohar3",29);
        map.put("manohar4", 220);
        map.put("manohar5",29);
        map.put("manohar6", 30);

        System.out.println(map.get("manohar4"));


    }
}
