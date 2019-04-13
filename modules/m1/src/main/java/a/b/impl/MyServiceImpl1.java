package a.b.impl;

import a.b.api.MyService;

/**
 * @author Jens Dahlmanns.
 */
public class MyServiceImpl1 implements MyService {

	@Override
	public String getName() {
		return "M-1";
	}
}
