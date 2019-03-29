package club.futurer.community.common;

import club.futurer.community.context.ThreadWebContextHolder;
import club.futurer.community.context.WebSession;
import club.futurer.community.exception.ApplicationErrorCode;
import club.futurer.community.exception.ApplicationException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.MessageFormat;

/**
 * the base action controller
 * 
 */
public abstract class BaseAction {
	private static Logger logger = LoggerFactory.getLogger(BaseAction.class.getName());

	public static final Integer IS_OK = 200;

	public static final Integer EXCEPTION = 500;
//	@Autowired
//	protected TopicUsed topicUsed;

//	/**
//	 * wrapper JSON view and set data version
//	 * @param object
//	 * @param version
//	 * @return
//	 */
//	public Object wrapperJsonView(Object object, long version) {
//		return new JsonWrapper<Object>(object, version);
//	}
//
//	/**
//	 * wrapper JSON view and set message
//	 * @param object
//	 * @return
//	 */
//	public Object wrapperJsonView(Object object, String message) {
//		return new JsonWrapper<Object>(object, message);
//	}
//
//	/**
//	 *  wrapper JSON view
//	 * @param object
//	 * @return
//	 */
//	public Object wrapperJsonView(Object object) {
//		return new JsonWrapper<Object>(object);
//	}
//
//	/**
//	 *   wrapper exception JSON view
//	 * @param throwable
//	 * @return
//	 */
//	public Object wrapperExceptionJsonView(Throwable throwable) {
//		return new JsonExceptionWrapper(throwable);
//	}
//
	/**
	 * get a String request parameter
	 * 
	 * @param key
	 * @return
	 */
	protected String getStringReqParam(String key) {
		HttpServletRequest request = getRequest();
		return request.getParameter(key);
	}

	/**
	 * get a long parameter from request
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	protected Long getLongReqParam(String key, Long defaultValue) {
		HttpServletRequest request = getRequest();
		try {
			return Long.valueOf(request.getParameter(key));
		} catch (Exception e) {
			logger.warn(MessageFormat
					.format("get {0} error, use default value: {1}, exception details: {2}",
							key, defaultValue, e));
			return defaultValue;
		}
	}

	/**
	 * get a integer parameter from request
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	protected Integer getIntegerReqParam(String key, Integer defaultValue) {
		HttpServletRequest request = getRequest();
		try {
			return Integer.valueOf(request.getParameter(key));
		} catch (Exception e) {
			logger.warn(MessageFormat
					.format("get {0} error, use default value: {1}, exception details: {2}",
							key, defaultValue, e));
			return defaultValue;
		}
	}

	/**
	 * get a double parameter from request
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	protected Double getDoubleReqParam(String key, Double defaultValue) {
		HttpServletRequest request = getRequest();
		try {
			return Double.valueOf(request.getParameter(key));
		} catch (Exception e) {
			logger.warn(MessageFormat
					.format("get {0} error, use default value: {1}, exception details: {2}",
							key, defaultValue, e));
			return defaultValue;
		}
	}

	/**
	 * Set an attribute in session.
	 * 
	 * @param key
	 * @param value
	 */
	protected void setSession(String key, Object value) {
		HttpServletRequest request = getRequest();
		request.getSession().setAttribute(key, value);
	}

	/**
	 * Get an <code>Object</code> attribute from session
	 * 
	 * @param key
	 * @return
	 */
	protected Object getSession(String key) {
		HttpServletRequest request = getRequest();
		return request.getSession().getAttribute(key);
	}

	/**
	 * Get a <code>String</code> attribute from session.
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	protected String getStringInSession(String key, String defaultValue) {
		HttpSession session = getRequest().getSession();
		try {
			return (String) session.getAttribute(key);
		} catch (Exception e) {
			logger.warn(MessageFormat
					.format("get {0} error, use default value: {1}, exception details: {2}",
							key, defaultValue, e));
			return defaultValue;
		}
	}

	/**
	 * get local disk path
	 * 
	 * @return
	 */
	protected String getLocalDiskPath() {
		HttpServletRequest request = getRequest();
		return request.getSession().getServletContext().getRealPath("/")
				+ File.separator;
	}

	/**
	 * get base path
	 * 
	 * @return
	 */
	protected String getBasePath() {
		HttpServletRequest request = getRequest();
		return WebUtils.Http.getBasePath(request);
	}

	protected String getBasePathNotPort() {
		HttpServletRequest request = getRequest();
		return WebUtils.Http.getBasePathNotPort(request);
	}
	
	public HttpServletRequest getRequest() {
		return ThreadWebContextHolder.getContext().getRequest();
	}
	
	public HttpServletResponse getResponse() {
		return ThreadWebContextHolder.getContext().getResponse();
	}

	public WebSession webSession () {
		WebSession session = WebUtils.Session.get();
//		GsonBuilder builder = new GsonBuilder();
//		Gson gson= builder.serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return session;
	}
	
//	/**
//	 * get a topic for current used
//	 * @return
//	 */
//	public Topic getTopUsed() {
//		Topic topic = Topic.parse(topicUsed.getTopicName());
//		if (null == topic) {
//			throw new InvalidOprationException("无效的Topic: " + topicUsed.getTopicName());
//		}
//		return topic;
//	}
}
