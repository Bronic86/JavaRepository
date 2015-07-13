package module2.SeaPort.LoadUnloadBox;


import module2.SeaPort.box.Box;
import module2.SeaPort.ship.Ship;
import module2.SeaPort.ship.exception.EmptyHoldException;
import module2.SeaPort.ship.exception.FullHoldException;
import module2.SeaPort.store.Store;
import module2.SeaPort.store.exception.EmptyStoreException;
import module2.SeaPort.store.exception.FullStoreException;

public class LoadUnloadBox {

    public static void start(Ship ship) {
        if (ship.isLoad()) {
            loadBoxes(ship);
        } else {
            unloadBoxes(ship);
        }
    }

    private static void unloadBoxes(Ship ship) {
        Box box = null;
        try {
            while (true) {
                box = ship.unloadBox();
                Store.getStore().addBox(box);
            }
        } catch (FullStoreException e) {
            System.out.println("Store is full. Ship is out.");
            ship.loadBox(box);
        } catch (EmptyHoldException e) {
            System.out.println("Ship is empty. Sink.");
        }
    }


    private static void loadBoxes(Ship ship) {
        Box box = null;
        try {
            while (true) {
                box = Store.getStore().removeBox();
                ship.loadBox(box);
            }
        } catch (FullHoldException e) {
            System.out.println("Ship is full. Sink.");
            Store.getStore().addBox(box);
        } catch (EmptyStoreException e) {
            System.out.println("Store is empty. Ship is out.");
        }
    }
}