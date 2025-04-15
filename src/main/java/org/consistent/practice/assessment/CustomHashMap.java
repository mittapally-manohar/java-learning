package org.consistent.practice.assessment;

public class CustomHashMap <K, V>{
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] table;

    private int size;

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public CustomHashMap() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode()%table.length);
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> current = table[index];

        while(current!=null) {
            if (current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public V put(K key, V value) {
        int index = hash(key);
        Entry<K,V> newEntry = new Entry<>(key, value);

        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K,V> current = table[index];
            while (true) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return value;
                }
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = newEntry;
        }
        size++;

        if ((size * 1.0) / table.length >= LOAD_FACTOR) {
            resize();
        }
        return value;
    }

    private void resize(){
        Entry<K,V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;

        for (Entry<K, V> entry : oldTable) {
            while(entry!=null) {
                put(entry.key,entry.value);
                entry = entry.next;
            }
        }
    }

}
