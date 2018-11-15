package model.noteModel;

import util.DateHelper;
import util.IdGenerator;
import util.NumberFormatter;

public class NoteEntry {

    private final String nid;
    private final String vid;
    private String date;
    private String title;
    private String text;

    public NoteEntry(String title, String text, String vid) {
        this.title = title;
        this.text = text;
        this.vid = vid;
        this.nid = NumberFormatter.formatToSixDigitStringNid(IdGenerator.generateNid());
        this.date = DateHelper.addDateStamp();
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the nid
     */
    public String getNid() {
        return nid;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
}