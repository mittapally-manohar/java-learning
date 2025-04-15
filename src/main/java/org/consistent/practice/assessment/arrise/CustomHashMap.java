package org.consistent.practice.assessment.arrise;

import org.consistent.practice.streams.MostAsked;

import java.util.HashMap;

public class CustomHashMap <K,V>{
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Entry<K,V>[] table;
    private int size;

    static class Entry<K,V> {
        final K key;
        V value;
        Entry<K,V> next; //in case of collision
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode()%table.length);
    }

    public CustomHashMap () {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
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
        Entry<K,V> newEntry = new Entry<>(key, value);
        int index = hash(key);
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K,V> current = table[index];
            while (true) {
                if (current.key.equals(key)){
                    current.value = value;
                    return value;
                }
                if(current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = newEntry;
        }
        size ++;
        if ((size * 1.0) / table.length >= LOAD_FACTOR) {
            resize();
        }
        return value;
    }

    private void resize() {
        Entry<K,V>[] oldtable = table;
        table = new Entry[oldtable.length * 2];
        size = 0;

        for (Entry<K,V> entry : oldtable) {
            while(entry!=null) {
                put(entry.key,entry.value);
                entry = entry.next;
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap<MostAsked.Person, String> map1 = new CustomHashMap<>();
        HashMap<MostAsked.Person, String> map2 = new HashMap<>();
        MostAsked.Person p = new MostAsked.Person("Ram",20);
        MostAsked.Person p2 = new MostAsked.Person("Ram",20);
        System.out.println(p.hashCode());
        System.out.println(p2.hashCode());
       map2.put(p,"queen");
        map1.put(p,"king");
        p.setName("king");

        System.out.println(map2.get(p2));
    }
}
