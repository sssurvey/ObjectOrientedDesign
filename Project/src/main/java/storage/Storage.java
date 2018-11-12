package storage;

import park.Park;

public class Storage implements StorageContract {

    // TODO only one instance of this class shuld be existed...

    @Override
    public void savePark(Park park) {
        StorageEntity.addEntry(park);
    }

    @Override
    public void updatePark(Park park, String pid) {
        for (Park tempPark : StorageEntity.ALL_PARKS) {
            if (pid.equals(tempPark.getPid())) {
                StorageEntity.replaceEntryAtIndex(StorageEntity.ALL_PARKS.indexOf(tempPark), park);
            }
        }
    }

    @Override
    public void deletePark(String pid) {
        for (Park tempPark : StorageEntity.ALL_PARKS) {
            if (pid.equals(tempPark.getPid())) {
                StorageEntity.removePark(StorageEntity.ALL_PARKS.indexOf(tempPark));
                return; //no more loop after this
            }
        }
    }
}