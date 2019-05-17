/**
 * 
 */
package database;

/**
 * @author johnpauljoseph
 *
 */
public class OpenConnection {
	
	public static DBConnect db = null;

	/**
	 * 
	 */
	public OpenConnection() {
		
		db = new DBConnect();
	}

}
