
package com.pcwk.ehr.cmn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileComment {

	static final Logger log = LogManager.getLogger(FileComment.class);

	public static void main(String[] args) {

		// Log Level
		// FATAL > ERROR > WARN > INFO > DEBUG > TRACE

		log.trace("trace");
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("ERROR");
		log.fatal("fatal");

	}
}
