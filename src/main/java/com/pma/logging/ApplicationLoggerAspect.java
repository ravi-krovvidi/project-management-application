package com.pma.logging;

import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.slf4j.*;

//@Aspect
//@Component
public class ApplicationLoggerAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.pma.controllers..*)")
	public void defaultPackagePointCut() {
		// empty method just to name the location in pointcut
	}
	
	/*
	 * @After("defaultPackagePointCut()") public void log() {
	 * log.debug("---------------------------------------------------"); }
	 */
	@Around("defaultPackagePointCut()")
	public Object logAround(ProceedingJoinPoint jp) {
		// before the execution 
		log.debug("****Before Execution**** {}.{} () with argument[s] = {}",jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(), jp.getArgs());
		
		
		Object obj=null;
		try {
			obj = jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// After the execution 
				log.debug("\n \n \n****Befor Execution**** {}.{} () with argument[s] = {}",jp.getSignature().getDeclaringTypeName(),
						jp.getSignature().getName(), jp.getArgs());
				
		
		return obj;
		
	}
}
