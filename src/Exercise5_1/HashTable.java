package Exercise5_1;

import java.util.LinkedList;

/**
 * Created by Miguel Emmara - 18022146
 */
public class HashTable {
    public static final int ARR_SIZE = 200;
    private final LinkedList<HTObject>[] arr = new LinkedList[ARR_SIZE];

    public HashTable() {
        //init values in array
        for (int i = 0; i < ARR_SIZE; i++) {
            arr[i] = null;
        }
    }

    private int getIndex(String key) {
        return Math.abs((key.hashCode() % ARR_SIZE));
    }

    private HTObject getObj(String key) {
        if (key == null) return null;
        int index = getIndex(key);
        LinkedList<HTObject> items = arr[index];
        if (items == null) return null;
        for (HTObject item : items) {
            if (item.key.equals(key)) return item;
        }
        return null;
    }

    public Student get(String key) {
        HTObject item = getObj(key);
        if (item == null) return null;
        else return item.value;
    }

    public void put(String key, Student value) {
        int index = getIndex(key);
        LinkedList<HTObject> items = arr[index];
        if (items == null) {
            items = new LinkedList<>();
            HTObject item = new HTObject();
            item.key = key;
            item.value = value;
            items.add(item);
            arr[index] = items;
        } else {
            for (HTObject item : items) {
                if (item.key.equals(key)) {
                    item.value = value;
                    return;
                }
            }
            HTObject item = new HTObject();
            item.key = key;
            item.value = value;
            items.add(item);
        }
    }

    public void delete(String key) {
        int index = getIndex(key);
        LinkedList<HTObject> items = arr[index];
        if (items == null) return;
        for (HTObject item : items) {
            if (item.key.equals(key)) {
                items.remove(item);
                return;
            }
        }
    }

    public static class HTObject {
        public String key;
        public Student value;
    }
}