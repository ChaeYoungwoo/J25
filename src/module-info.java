/**
 * 
 */
/**
 * 
 */
module J25 {
	
	//외부 패키지 사용 : JDK 1.9
	requires org.apache.logging.log4j;
	requires org.apache.logging.log4j.core;
	requires org.jsoup;
	requires com.google.gson;
	opens com.pcwk.ehr.ed02;
	opens com.pcwk.ehr.ed04;
	
}