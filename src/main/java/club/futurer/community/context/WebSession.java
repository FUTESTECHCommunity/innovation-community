package club.futurer.community.context;

import java.io.Serializable;
import java.util.Date;

public class WebSession implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 会话ID
	 */
	private String id;

	/**
	 * 会话的开始时间
	 */
	private Date startTime;
}
