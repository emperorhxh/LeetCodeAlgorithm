package com.xhx.common.algorithm.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> {

    public static void main(String[] args) {
        LRUCache<String> cache = new LRUCache<>(3);
        cache.put("123","abc");
        cache.put("234","bcd");
        cache.put("345","cde");
        cache.put("456","rer");
        cache.get("234");
        cache.get("345");
        cache.get("456");
        cache.get("234");
        cache.get("234");
        cache.put("123","abc");
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public Map<String, Entry<T>> getDatas() {
        return datas;
    }

    public void setDatas(Map<String, Entry<T>> datas) {
        this.datas = datas;
    }

    private int maxCapacity;
    private int currentCapacity;

    private Entry<T> head;
    private Entry<T> tail;

    private Map<String,Entry<T>> datas=new HashMap<>();

    public LRUCache(int capacity){
        this.maxCapacity=capacity;
        currentCapacity = 0;
    }

    public T get(String key) {
        Entry<T> entry = datas.get(key);
        if(null == entry){
            return null;
        }
        afterAccess(entry);
        return entry.t;
    }

    public void put(String key,T t) {
        if(!datas.containsKey(key)){
            if(currentCapacity +1>maxCapacity){
                removeHead();
            }
            Entry entry = new Entry(t,key);
            datas.put(key,entry);
            insertTail(entry);
            currentCapacity++;
        }else {
            Entry entry = datas.get(key);
            entry.t=t;
            afterAccess(entry);
        }
    }

    private void removeHead(){
        Entry<T> e=head;
        if(null != e){
            head = e.next;
            head.pre = null;
            datas.remove(e.key);
            currentCapacity--;
        }
    }
    private void insertTail(Entry entry){

        Entry<T> e=tail;
        if(null != e){
            entry.pre=e;
            e.next = entry;
        }else {
            head =entry;
        }
        tail = entry;
    }

    private void afterAccess(Entry<T> entry){
        if(tail == entry) return;
        Entry<T> p = entry;
        Entry<T> pre = p.pre;
        Entry<T> next = p.next;
        Entry<T> last = tail;
        if(null == pre){
            head = next;
        }else {
            pre.next=next;
        }

        if(null != next){
            next.pre=pre;
        }else {
            last = pre;
        }
        if(null == last){
            head = entry;
        }else {
            p.pre = last;
            last.next = p;
        }
        tail=p;

    }

    static class Entry<T>{
        T t;
        transient Entry<T> pre;
        transient Entry<T> next;
        String key ;

        public Entry(T t,String key){
            this.t=t;
            this.key=key;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }
}
