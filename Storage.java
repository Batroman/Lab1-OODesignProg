import java.util.ArrayList;

public class Storage<T extends Vehicle> {
    private final int maxLoad;
    private ArrayList<T> storageContents;
    public Storage(int maxLoadingCapacity) {
        storageContents = new ArrayList<>(maxLoadingCapacity);
        this.maxLoad = maxLoadingCapacity;
    }

    protected void loadStorage(T car) {
        if (storageContents.size() < maxLoad) {}
            storageContents.add(car);
    }

    protected void unloadStorage(){
       // T last = storageContents.getLast();
       // storageContents.remove(last);
        storageContents.removeLast();
    }

    protected ArrayList<T> getContents(){
        return storageContents;
    }

}
