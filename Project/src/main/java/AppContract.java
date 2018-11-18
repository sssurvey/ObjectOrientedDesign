public interface AppContract {

	public String createPark(String parkJSON) throws Exception;

	public String updatePark(String pid, String parkJSON) throws Exception;

	public void deletePark(String pid) throws Exception;

	public String getAllParks();

	public String getParkDetail(String pid) throws Exception;

	public String createNoteAssociateToPark(String pid, String noteJSON) throws Exception;

	public String getAllNoteAssociateToPark(String pid) throws Exception;

	public String getNoteEntryViaNidAndPid(String pid, String nid) throws Exception;

	public String getAllNotes();

	public String getNoteViaNid(String nid) throws Exception;

	public String updateNoteByPid(String nid, String noteJSON) throws Exception;

	public String createOrder(String orderJSON) throws Exception;

	public String getAllOrder();

}