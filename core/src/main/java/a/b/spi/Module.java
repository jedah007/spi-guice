package a.b.spi;

import com.google.inject.AbstractModule;

/**
 * @author Jens Dahlmanns.
 */
public interface Module {

	String getName();

	AbstractModule get();
}
