import a.b.CoreModule;
import a.b.spi.Module;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

/**
 * @author Jens Dahlmanns.
 */
public class Main {

	public static void main(String[] args) throws MalformedURLException {
		Iterable<Module> modules = loadModules("/home/jens/git/spi-guice/my-modules");
		Injector injector = Guice.createInjector(new CoreModule(modules));

		Set<String> strings = injector.getInstance(Key.get(new TypeLiteral<Set<String>>(){}));
		System.out.println();
		System.out.println("Strings:");
		strings.forEach(System.out::println);
	}

	private static Iterable<Module> loadModules(String path) throws MalformedURLException {
		File dir = new File(path);
		File[] files = dir.listFiles();
		if (files == null) {
			System.out.println("No files found");
			return Collections.emptyList();
		}
		URL[] urls = new URL[files.length];
		for (int i = 0; i < urls.length; i++) {
			urls[i] = files[i].toURI().toURL();
		}
		URLClassLoader classLoader = new URLClassLoader(urls);

		return ServiceLoader.load(Module.class, classLoader);
	}
}
