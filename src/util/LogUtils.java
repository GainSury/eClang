package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils {
	public static String FILE_LOG_CONFIG="log4j2.xml";
	private static Logger logInfo = null;
	private static Logger logError = null;

	// 禁止实例对象
	private LogUtils() {
	}
	
	public static void initialLogger(){
		//1-设置日志配置文件
	    System.setProperty("log4j.configurationFile", LogUtils.FILE_LOG_CONFIG);
		//2-获得日志对象	
		logInfo = LogManager.getLogger("lj.info");
		logError = LogManager.getLogger("lj.error");
		System.out.println("日志对象初始化成�?....");
	}

	/***
	 * 信息日志
	 * @param msg
	 */
	public static void logInfo(String msg) {
		if(logInfo==null)
			initialLogger();
		logInfo.entry();
		logInfo.info(msg);
		logInfo.exit();
	}

	/***
	 * 错误日志
	 * @param msg
	 */
	public static void logError(String msg) {
		if(logError==null)
			initialLogger();
		logError.entry();
		logError.error(msg);
		logError.exit();
	}
	
	/**
	 * 日志异常信息
	 * @param tag
	 * @param e
	 */
	public static void logError(String tag,Exception e){
		if(logError==null)
			initialLogger();
		logError.entry();
		logError.error(e);
		logError.exit();
	}

}
