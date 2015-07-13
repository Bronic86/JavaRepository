package module2.SeaPort.store;


import module2.SeaPort.box.Box;
import module2.SeaPort.store.exception.EmptyStoreException;
import module2.SeaPort.store.exception.FullStoreException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private static Store store;
    private List<Box> boxesOnStore;
    private final static int maxCapacity = 10;
    private Lock lock = new ReentrantLock();

    private Store() {
        boxesOnStore = new ArrayList<>();
    }

    public synchronized static Store getStore() {
        if (store == null) {
            store = new Store();
        }
        return store;
    }

    public void addBox(Box box) {
        try {
            lock.tryLock();
            if (boxesOnStore.size() < maxCapacity) {
                boxesOnStore.add(box);
            } else {
                throw new FullStoreException();
            }
        } finally {
            lock.unlock();
        }
    }

    public Box removeBox() {
        try {
            lock.tryLock();
            if (boxesOnStore.isEmpty()) {
                throw new EmptyStoreException();
            } else {
                Box box = boxesOnStore.get(boxesOnStore.size() - 1);
                boxesOnStore.remove(boxesOnStore.size() - 1);

                return box;
            }
        } finally {
            lock.unlock();
        }
    }

    public int getCapacity() {
        return boxesOnStore.size();
    }

}