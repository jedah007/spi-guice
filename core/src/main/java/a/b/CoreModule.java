package a.b;

import a.b.spi.Module;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

/**
 * @author Jens Dahlmanns.
 */
public class CoreModule extends AbstractModule {

	private final Iterable<Module> externalModules;

	public CoreModule(Iterable<Module> externalModules) {
		this.externalModules = externalModules;
	}

	@Override
	protected void configure() {
		for (Module m : this.externalModules) {
			System.out.println("Installing: " + m.getName());
			this.install(m.get());
		}

		Multibinder<String> binder = Multibinder.newSetBinder(this.binder(), String.class);
		binder.addBinding().toInstance("CoreModule");
	}
}
