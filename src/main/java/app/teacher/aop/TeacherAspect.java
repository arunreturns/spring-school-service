package app.teacher.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import app.teacher.dto.Teacher;

@Aspect
@Component
public class TeacherAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private void printArgs(Object[] args){
		for ( int i = 0; i < args.length; i++){
			String argNum = "Arg " + i + " - ";
			Object arg = args[i];
			if ( arg instanceof Teacher){
				Teacher teacher = (Teacher)arg;
				logger.info(argNum + teacher.toString());
			} else {
				logger.info(argNum + arg);
			}
		}
	}
	
	@Before("execution(* *(..)) && within(app.teacher..controller..*)")
	public void controllerAdviceBefore(JoinPoint joinPoint) throws Throwable{
		logger.info("[Enter Teacher Controller] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@Before("execution(* *(..)) && within(app.teacher..service..*)")
	public void serviceAdviceBefore(JoinPoint joinPoint) throws Throwable{
		logger.info("[Enter Teacher Service] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@Before("execution(* *(..)) && within(app.teacher..db..*)")
	public void databaseAdviceBefore(JoinPoint joinPoint) throws Throwable{
		logger.info("[Enter Teacher DB] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@After("execution(* *(..)) && within(app.teacher..controller..*)")
	public void controllerAdviceAfter(JoinPoint joinPoint) throws Throwable{
		logger.info("[Leaving Teacher Controller] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@After("execution(* *(..)) && within(app.teacher..service..*)")
	public void serviceAdviceAfter(JoinPoint joinPoint) throws Throwable{
		logger.info("[Leaving Teacher Service] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
	
	@After("execution(* *(..)) && within(app.teacher..db..*)")
	public void databaseAdviceAfter(JoinPoint joinPoint) throws Throwable{
		logger.info("[Leaving Teacher DB] ==> " + joinPoint.getSignature().getName());
		printArgs(joinPoint.getArgs());
	}
}
