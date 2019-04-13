package a.b;

import a.b.api.MyService;
import a.b.impl.MyServiceImpl1;
import a.b.spi.Module;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

/**
 * @author Jens Dahlmanns.
 */
public class ModuleA extends AbstractModule implements Module {

	@Override
	public String getName() {
		return "ModuleA";
	}

	@Override
	public AbstractModule get() {
		return this;
	}

	@Override
	protected void configure() {
		Multibinder<String> binder = Multibinder.newSetBinder(this.binder(), String.class);
		binder.addBinding().toInstance("ModuleA");

		Multibinder<MyService> binder2 = Multibinder.newSetBinder(this.binder(), MyService.class);
		binder2.addBinding().to(MyServiceImpl1.class);
	}
}
