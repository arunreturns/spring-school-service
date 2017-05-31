package app.classroom.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import app.classroom.dto.Classroom;

@Aspect
@Component
public class ClassroomAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private void printArgs(Object[] args){
		for ( int i = 0; i < args.length; i++){
			String argNum = "Arg " + i + " - ";
			Object arg = args[i];
			if ( arg instanceof Classroom){
				Classroom classroom = (Classroom)arg;
				logger.info(argNum + classroom.toString());
			} else {
				logger.info(argNum + arg);
			}
		}
	}
	
	@Before("execution(* *(..)) && within(app.classroom..controller..*)")
	public void controllerAdviceBefore(JoinPoint joinPoint) throws Throwable{
		logger.info("[Enter Classroom Controller] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@Before("execution(* *(..)) && within(app.classroom..service..*)")
	public void serviceAdviceBefore(JoinPoint joinPoint) throws Throwable{
		logger.info("[Enter Classroom Service] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@Before("execution(* *(..)) && within(app.classroom..db..*)")
	public void databaseAdviceBefore(JoinPoint joinPoint) throws Throwable{
		logger.info("[Enter Classroom DB] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@After("execution(* *(..)) && within(app.classroom..controller..*)")
	public void controllerAdviceAfter(JoinPoint joinPoint) throws Throwable{
		logger.info("[Leaving Classroom Controller] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@After("execution(* *(..)) && within(app.classroom..service..*)")
	public void serviceAdviceAfter(JoinPoint joinPoint) throws Throwable{
		logger.info("[Leaving Classroom Service] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@After("execution(* *(..)) && within(app.classroom..db..*)")
	public void databaseAdviceAfter(JoinPoint joinPoint) throws Throwable{
		logger.info("[Leaving Classroom DB] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
}
