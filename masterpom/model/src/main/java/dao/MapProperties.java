package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 
 * @author Asus
 *
 */
class MapProperties extends Properties{
	private static final long		serialVersionUID			= 5289057445894568927L;
	private final static String	PROPERTIES_FILE_NAME	= "model.properties";
	private String	access	= "";
	private String terminaison = "" ;
	private int nberLevel = 0 ;
/**
 * 
 */
	public MapProperties() {
		InputStream inputStream;

		inputStream = this.getClass().getClassLoader().getResourceAsStream(MapProperties.PROPERTIES_FILE_NAME);

		if (inputStream != null) {
			try {
				this.load(inputStream);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			this.setAccess(this.getProperty("access"));
			this.setTerminaison(this.getProperty("terminaison")) ;
			this.setNberLevel(Integer.parseInt(this.getProperty("nberLevel"))) ;
		}
	}
/**
 * 
 * @return
 */
	public String getAccess() {
		return this.access;
	}
/**
 * 
 * @param access
 */
	private void setAccess(final String access) {
		this.access = access;
	}
/**
 * 
 * @return
 */
	public String getTerminaison() {
		return this.terminaison;
	}
/**
 * 
 * @param terminaison
 */
	private void setTerminaison(final String terminaison) {
		this.terminaison = terminaison;
	}
	/**
	 * 
	 * @return
	 */
	public int getNberLevel() {
		return this.nberLevel;
	}
/**
 * 
 * @param nberLevel
 */
	private void setNberLevel(final int nberLevel) {
		this.nberLevel = nberLevel;
	}
}
