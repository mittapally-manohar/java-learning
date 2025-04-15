//package org.consistent.practice.assessment.arrise;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//public class MyHashMap<E,V> {
//    List<LinkedList<Entry>> entries  = new ArrayList<>();
//    public V get(E key) {
//        Entry entry = null;
//        if(entries.get(hash(key)).size()==1) {
//            entry = entries.get(hash(key)).get(0);
//        }else{
//            LinkedList<Entry> list =  entries.get(hash(key));
//            for(Entry entry1 : list) {
//                if(entry1.key.equals(key)){
//                    return (V)entry1.value;
//                }
//            }
//        }
//
//        return (V)entry.value;
//    }
//
//    public V put(E key, V value) {
//        Entry entry = new Entry(key, value);
//        int index  = hash(key);
//        Entry existingEntry = null;
//        if(entries.get(hash(key)).size()==1) {
//            existingEntry = entries.get(hash(key)).get(0);
//        }else{
//            LinkedList<Entry> list =  entries.get(hash(key));
//            for(Entry entry1 : list) {
//                if(entry1.key.equals(key)){
//                    existingEntry = entry1;
//                    break;
//                }
//            }
//        }
//
//        if(existingEntry.key.equals(key) || existingEntry == null){
//            LinkedList<Entry> list = new LinkedList<>();
//            list.add(entry);
//            entries.add(index, list);
//        } else {
//            LinkedList<Entry> list =  entries.get(hash(key));
//            list.add(entry);
//            entries.remove(index);
//            entries.add(index,list);
//        }
//
//        return value;
//    }
//
//    MyHashMap(){
//
//    }
//
//    public int hash(E key) {
//        return Math.abs(key.hashCode() % 16);
//    }
//
//    public static void main(String[] args) {
//        MyHashMap<String,Integer> map = new MyHashMap();
//
//        map.put("Mahonar",100);
//        map.put("Sid",200);
//        map.put("Mahonar",300);
//    }
//
//}
//
//
//
//class Entry1<E, V>{
//    E key;
//    V value;
//    Entry1(E key, V value) {
//        this.key = key;
//        this.value = value;
//    }
//}
//
//
