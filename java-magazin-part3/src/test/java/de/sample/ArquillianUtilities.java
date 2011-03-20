package de.sample;

import java.io.IOException;

import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.Archives;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.impl.base.asset.ByteArrayAsset;

public class ArquillianUtilities {

	/**
	 * Create a pseudo java archive in order to allow arquillian to test CDI.
	 * Adds an empty beans.xml to the archive.
	 * 
	 * @param classes
	 *            those classes which are influenced by the dependency
	 *            injection, i.e. either supply or inject a bean
	 * @return the java archive
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
	public static JavaArchive createArchive(Class<?>... classes)
			throws IllegalArgumentException, IOException {
		return Archives.create("test.jar", JavaArchive.class)
				.addManifestResource(new ByteArrayAsset(new byte[0]),
						ArchivePaths.create("beans.xml")).addClasses(classes);
	}
}
