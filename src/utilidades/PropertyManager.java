package utilidades;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class PropertyManager {

	private boolean inClasspath;
	private String resourcePath;
	private Properties resourceData;

	public PropertyManager() {
		this.resourcePath = "";
		this.resourceData = new Properties();
	}

	public PropertyManager(String path) {
		this.resourcePath = path;
		this.resourceData = new Properties();
	}

	public PropertyManager(String path, boolean inClasspath) {
		this.resourcePath = path;
		this.resourceData = new Properties();
		this.inClasspath = inClasspath;
		this.init();
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public boolean isInClasspath() {
		return inClasspath;
	}

	public void setInClasspath(boolean inClasspath) {
		this.inClasspath = inClasspath;
	}

	public void init() {
		try {
			if (!this.isInClasspath()) {
				FileInputStream fin = new FileInputStream(this.resourcePath);
				this.resourceData.load(fin);
			} else {
				InputStream fin = PropertyManager.class.getClassLoader().getResourceAsStream(this.resourcePath);
				this.resourceData.load(fin);
			}
		} catch (Throwable e) {
			System.err.println("Error inicializando propiedades para: " + this.resourcePath);
			System.err.println("Error inicializando propiedades para: " + e.getMessage());
		}
	}

	/**
	 * Returns the keys in the bundle, starting with the given prefix
	 * @param prefix
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getKeysWithPrefix(String prefix) {

		List<String> keys = new ArrayList<String>();

		Enumeration ekeys = resourceData.propertyNames();
		while (ekeys.hasMoreElements()) {
			String key = (String)ekeys.nextElement();

			if (key != null && !"".equals(key) && key.startsWith(prefix)) {
				keys.add(key);
			}
		}

		return keys;
	}

	/**
	 * Returns the keys in the bundle, starting with the given prefix
	 * @param prefix
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Iterator<String> getKeys() {

		List<String> keys = new ArrayList<String>();

		if (resourceData != null && resourceData.size() > 0) {
			Enumeration ekeys = resourceData.propertyNames();
			while (ekeys.hasMoreElements()) {
				String key = (String)ekeys.nextElement();
				keys.add(key);
			}
		}

		return keys.iterator();
	}


	public String getString(String propertyName) {
		return this.resourceData.getProperty(propertyName);
	}
}
