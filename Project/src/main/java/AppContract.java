public interface AppContract {

	public String createPark(String parkJSON) throws Exception;

	public String updatePark(String pid, String parkJSON) throws Exception;

	public void deletePark(String pid) throws Exception;

	public String getAllParks();

	public String getParkDetail(String pid) throws Exception;

	public String createNoteAssociateToPark(String pid, String noteJSON);

	public String getAllNoteAssociateToPark(String pid);

	public String getNoteEntryViaNidAndPid(String pid, String nid);

	public String getAllNotes();

	public String getNoteViaNid(String nid);

	public String updateNoteByPid(String nid, String noteJSON);

}