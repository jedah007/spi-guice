package a.b;

import a.b.spi.Module;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

/**
 * @author Jens Dahlmanns.
 */
public class ModuleB extends AbstractModule implements Module {

	@Override
	public String getName() {
		return "ModuleB";
	}

	@Override
	public AbstractModule get() {
		return this;
	}

	@Override
	protected void configure() {
		Multibinder<String> binder = Multibinder.newSetBinder(this.binder(), String.class);
		binder.addBinding().toInstance("ModuleB");
	}
}
