package storage;

import park.Park;

public interface StorageContract {
    public void savePark(Park park);

    public void updatePark(Park park, String pid);
}