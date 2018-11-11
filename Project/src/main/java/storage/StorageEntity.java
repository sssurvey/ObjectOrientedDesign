package storage;

import java.util.ArrayList;
import java.util.List;

import park.Park;

public class StorageEntity {
    // This is a fake Table in DB
    public static final List<Park> ALL_PARKS = new ArrayList<>();

    public static void addEntry(Park park) {
        ALL_PARKS.add(park);
    }

    public static void replaceEntryAtIndex(int index, Park park) {
        ALL_PARKS.set(index, park);
    }
}