package app.subject.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import app.subject.dto.Subject;

@Aspect
@Component
public class SubjectAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private void printArgs(Object[] args){
		for ( int i = 0; i < args.length; i++){
			String argNum = "Arg " + i + " - ";
			Object arg = args[i];
			if ( arg instanceof Subject){
				Subject subject = (Subject)arg;
				logger.info(argNum + subject.toString());
			} else {
				logger.info(argNum + arg);
			}
		}
	}
	
	@Before("execution(* *(..)) && within(app.subject..controller..*)")
	public void controllerAdviceBefore(JoinPoint joinPoint) throws Throwable{
		logger.info("[Enter Subject Controller] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@Before("execution(* *(..)) && within(app.subject..service..*)")
	public void serviceAdviceBefore(JoinPoint joinPoint) throws Throwable{
		logger.info("[Enter Subject Service] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@Before("execution(* *(..)) && within(app.subject..db..*)")
	public void databaseAdviceBefore(JoinPoint joinPoint) throws Throwable{
		logger.info("[Enter Subject DB] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@After("execution(* *(..)) && within(app.subject..controller..*)")
	public void controllerAdviceAfter(JoinPoint joinPoint) throws Throwable{
		logger.info("[Leaving Subject Controller] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@After("execution(* *(..)) && within(app.subject..service..*)")
	public void serviceAdviceAfter(JoinPoint joinPoint) throws Throwable{
		logger.info("[Leaving Subject Service] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@After("execution(* *(..)) && within(app.subject..db..*)")
	public void databaseAdviceAfter(JoinPoint joinPoint) throws Throwable{
		logger.info("[Leaving Subject DB] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
}
