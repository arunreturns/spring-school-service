package app.staff.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import app.staff.dto.Staff;

@Aspect
@Component
public class StaffAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private void printArgs(Object[] args){
		for ( int i = 0; i < args.length; i++){
			String argNum = "Arg " + i + " - ";
			Object arg = args[i];
			if ( arg instanceof Staff){
				Staff staff = (Staff)arg;
				logger.info(argNum + staff.toString());
			} else {
				logger.info(argNum + arg);
			}
		}
	}
	
	@Before("execution(* *(..)) && within(app.staff..controller..*)")
	public void controllerAdviceBefore(JoinPoint joinPoint) throws Throwable{
		logger.info("[Enter Staff Controller] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@Before("execution(* *(..)) && within(app.staff..service..*)")
	public void serviceAdviceBefore(JoinPoint joinPoint) throws Throwable{
		logger.info("[Enter Staff Service] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@Before("execution(* *(..)) && within(app.staff..db..*)")
	public void databaseAdviceBefore(JoinPoint joinPoint) throws Throwable{
		logger.info("[Enter Staff DB] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@After("execution(* *(..)) && within(app.staff..controller..*)")
	public void controllerAdviceAfter(JoinPoint joinPoint) throws Throwable{
		logger.info("[Leaving Staff Controller] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@After("execution(* *(..)) && within(app.staff..service..*)")
	public void serviceAdviceAfter(JoinPoint joinPoint) throws Throwable{
		logger.info("[Leaving Staff Service] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@After("execution(* *(..)) && within(app.staff..db..*)")
	public void databaseAdviceAfter(JoinPoint joinPoint) throws Throwable{
		logger.info("[Leaving Staff DB] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
}
