package storage;

import java.util.ArrayList;
import java.util.List;

import model.noteModel.NoteModel;
import model.orderModel.OrderModel;
import model.visitorModel.VisitorModel;
import park.Park;

public class StorageEntity {
    // This is a fake Table in DB
    public static final List<Park> ALL_PARKS = new ArrayList<>();
    public static final List<NoteModel> ALL_NOTES = new ArrayList<>();
    public static final List<OrderModel> ALL_ORDERS = new ArrayList<>();
    public static final List<VisitorModel> ALL_VISITORS = new ArrayList<>();

    public static void addEntry(Park park) {
        ALL_PARKS.add(park);
    }

    public static void replaceEntryAtIndex(int index, Park park) {
        ALL_PARKS.set(index, park);
    }

    public static void removePark(int index) {
        ALL_PARKS.remove(index);
    }

    public static int getTotalParkCount() {
        return ALL_PARKS.size();
    }

    public static Park getParkAtIndex(int index) {
        return ALL_PARKS.get(index);
    }

    public static void addEntry(NoteModel noteModel) {
        ALL_NOTES.add(noteModel);
    }

    public static void removeNoteModel(int index) {
        ALL_NOTES.remove(index);
    }

    public static int getTotalNoteModelCount() {
        return ALL_NOTES.size();
    }

    public static NoteModel getNoteModelAtIndex(int index) {
        return ALL_NOTES.get(index);
    }

    public static void addEntry(OrderModel orderModel) {
        ALL_ORDERS.add(orderModel);
        ALL_VISITORS.add(orderModel.getVisitorModel());
    }

    public static int getTotalOrderCount() {
        return ALL_NOTES.size();
    }
}