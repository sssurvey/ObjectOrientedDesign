import park.Park;

public interface AppContract {

	public String createPark(String parkJSON) throws Exception;

	public String updatePark(String pid, String parkJSON);

	public String deletePark(String pid);

	public String getAllParks();

	public String getParkDetail(String pid);

	public String createNoteAssociateToPark(String pid, String noteJSON);

	public String getAllNoteAssociateToPark(String pid);

	public String getNoteEntryViaNidAndPid(String pid, String nid);

	public String getAllNotes();

	public String getNoteViaNid(String nid);

	public String updateNoteByPid(String nid, String noteJSON);

}