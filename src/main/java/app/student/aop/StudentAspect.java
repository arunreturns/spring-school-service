package app.student.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import app.student.dto.Student;

@Aspect
@Component
public class StudentAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private void printArgs(Object[] args){
		for ( int i = 0; i < args.length; i++){
			String argNum = "Arg " + i + " - ";
			Object arg = args[i];
			if ( arg instanceof Student){
				Student student = (Student)arg;
				logger.info(argNum + student.toString());
			} else {
				logger.info(argNum + arg);
			}
		}
	}
	
	@Before("execution(* *(..)) && within(app.student..controller..*)")
	public void controllerAdviceBefore(JoinPoint joinPoint) throws Throwable{
		logger.info("[Enter Student Controller] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@Before("execution(* *(..)) && within(app.student..service..*)")
	public void serviceAdviceBefore(JoinPoint joinPoint) throws Throwable{
		logger.info("[Enter Student Service] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@Before("execution(* *(..)) && within(app.student..db..*)")
	public void databaseAdviceBefore(JoinPoint joinPoint) throws Throwable{
		logger.info("[Enter Student DB] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@After("execution(* *(..)) && within(app.student..controller..*)")
	public void controllerAdviceAfter(JoinPoint joinPoint) throws Throwable{
		logger.info("[Leaving Student Controller] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@After("execution(* *(..)) && within(app.student..service..*)")
	public void serviceAdviceAfter(JoinPoint joinPoint) throws Throwable{
		logger.info("[Leaving Student Service] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@After("execution(* *(..)) && within(app.student..db..*)")
	public void databaseAdviceAfter(JoinPoint joinPoint) throws Throwable{
		logger.info("[Leaving Student DB] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
}
