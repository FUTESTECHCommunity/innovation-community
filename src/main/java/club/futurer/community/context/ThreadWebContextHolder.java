package club.futurer.community.context;

public class ThreadWebContextHolder {
	private static final ThreadLocal<WebContext> THREAD_LOCAL = new ThreadLocal<WebContext>();

	public static WebContext getContext() {
		return THREAD_LOCAL.get();
	}

	public static void setContext(WebContext value) {
		THREAD_LOCAL.set(value);
	}

	public static void removeContext() {
		WebContext session = THREAD_LOCAL.get();
		if (null != session) {
			THREAD_LOCAL.remove();
		}
	}
}
