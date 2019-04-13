import a.b.CoreModule;
import a.b.spi.Module;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import java.util.ServiceLoader;
import java.util.Set;

/**
 * @author Jens Dahlmanns.
 */
public class Main {

	public static void main(String[] args) {
		Iterable<Module> modules = loadModules();
		Injector injector = Guice.createInjector(new CoreModule(modules));

		Set<String> strings = injector.getInstance(Key.get(new TypeLiteral<Set<String>>(){}));
		System.out.println();
		System.out.println("Strings:");
		strings.forEach(System.out::println);
	}

	private static Iterable<Module> loadModules() {
		return ServiceLoader.load(Module.class);
	}
}
