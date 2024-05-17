package kh.mclass.test1r.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import kh.mclass.test1r.member.model.service.MemberService;

@Aspect
@Component
public class AdviceLog {
	private Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Pointcut("execution(public * kh..*Dao.*(..))")
	public void daoPointcut() {}
	
	@Pointcut("execution(public * kh..*Service.*(..))")
	public void servicePointcut() {}
	
	@Pointcut("execution(public * kh..*Controller.*(..))")
	public void controllerPointcut() {}

	@Around("daoPointcut()")
	public Object aroundDaoLog(ProceedingJoinPoint pjp) throws Throwable {
		Object returnObj = null;
		// pjp.getThis() : 클래스명
		// pjp.getSignature().getName(): 타겟메소드명
		logger.debug("▷▷▷["+pjp.getThis()+":"+pjp.getSignature().getName()+"]");
		// pjp.getArgs() : 메소드의 파라메터 값들이 들어있음.
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length; i++) {
			logger.debug("▷▷▷-args["+i+"] "+args[i]+"");
		}
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		// pjp.proceed() : 타겟메소드 호출함
		returnObj = pjp.proceed();
		stopwatch.stop();
		logger.debug("▷▷▷[Dao ▷ "+stopwatch.getTotalTimeMillis()+"ms]"+returnObj);
		return returnObj;
	}
	
	@Around("controllerPointcut()")
	public Object aroundControllerLog(ProceedingJoinPoint pjp) throws Throwable {
		Object returnObj = null;
		// pjp.getThis() : 클래스명
		// pjp.getSignature().getName(): 타겟메소드명
		logger.debug("▷["+pjp.getThis()+":"+pjp.getSignature().getName()+"]");
		// pjp.getArgs() : 메소드의 파라메터 값들이 들어있음.
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length; i++) {
			logger.debug("▷-args["+i+"] "+args[i]+"");
		}
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		// pjp.proceed() : 타겟메소드 호출함
		returnObj = pjp.proceed();
		stopwatch.stop();
		logger.debug("▷[Ctrl ▷ "+stopwatch.getTotalTimeMillis()+"ms]"+returnObj);
		return returnObj;
	}
	
	//@Before("controllerPointcut()")
	public void bctrlLog(JoinPoint jp) {
		// pjp.getThis() : 클래스명
		// pjp.getSignature().getName(): 타겟메소드명
		logger.debug("▷["+jp.getThis()+":"+jp.getSignature().getName()+"]");
		// pjp.getArgs() : 메소드의 파라메터 값들이 들어있음.
		Object[] args = jp.getArgs();
		for(int i=0; i<args.length; i++) {
			logger.debug("▷-args["+i+"] "+args[i]+"");
		}
		
	}
	
	
	
}
