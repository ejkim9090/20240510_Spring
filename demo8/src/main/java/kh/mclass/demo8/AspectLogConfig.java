package kh.mclass.demo8;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class AspectLogConfig {

	@Pointcut("execution(public * kh.mclass..*Repository.*(..))")
	//proxy 걸고 싶은 것을 pointcut 으로 설정 --> repository 를 잠깐 납치해서 밑에서 repository 에 있는 정보(메소드나 다른것들..)를 보여줌
	public void daoPointcut() {}
	
	@Pointcut("execution(public * kh.mclass..*Service.*(..))")
	public void servicePointcut() {}
	
	@Pointcut("execution(public * kh.mclass..*Controller.*(..))")
	public void controllerPointcut() {}

	@Around("daoPointcut()")
	public Object aroundDaoLog(ProceedingJoinPoint pjp) throws Throwable {
		Object returnObj = null;
		// pjp.getThis() : 클래스명
		// pjp.getSignature().getName(): 타겟메소드명
		log.debug("▶▶▶["+pjp.getThis()+":"+pjp.getSignature().getName()+"]");
		// pjp.getArgs() : 메소드의 파라메터 값들이 들어있음.
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length; i++) {
			log.debug("▽▽▽-args["+i+"] "+args[i]+"");
		}
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		// pjp.proceed() : 타겟메소드 호출함
		returnObj = pjp.proceed();
		//원래 하려던 메소드 진행해라 --> 메소드 실행하라고 허가하는 것
		stopwatch.stop();
		log.debug("▷▷▷[Dao ▷ "+stopwatch.getTotalTimeMillis()+"ms]"+returnObj);
		return returnObj;
		//return 된 값은 pointcut 에 걸려있는 내용물 그 자체이며 그 안에 있는 메소드가 실행되거나 그런것은 아님. 말 그대로 정보 그 자체.
		//return을 통해 다시 본 제자리로 돌아가서 실행됨. 납치한 얘를 다시 그 자리에 돌려놓아서 원래 있던 자리에서 다시 실행되도록 함
	}
	
	@Around("servicePointcut()")
	public Object aroundServiceLog(ProceedingJoinPoint pjp) throws Throwable {
		Object returnObj = null;
		// pjp.getThis() : 클래스명
		// pjp.getSignature().getName(): 타겟메소드명
		log.debug("▶▶["+pjp.getThis()+":"+pjp.getSignature().getName()+"]");
		// pjp.getArgs() : 메소드의 파라메터 값들이 들어있음.
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length; i++) {
			log.debug("▽▽-args["+i+"] "+args[i]+"");
		}
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		// pjp.proceed() : 타겟메소드 호출함
		returnObj = pjp.proceed();
		stopwatch.stop();
		log.debug("▷▷[Svc ▷ "+stopwatch.getTotalTimeMillis()+"ms]"+returnObj);
		return returnObj;
	}
	
	@Around("controllerPointcut()")
	public Object aroundControllerLog(ProceedingJoinPoint pjp) throws Throwable {
		Object returnObj = null;
		// pjp.getThis() : 클래스명
		// pjp.getSignature().getName(): 타겟메소드명
		log.debug("▶["+pjp.getThis()+":"+pjp.getSignature().getName()+"]");
		// pjp.getArgs() : 메소드의 파라메터 값들이 들어있음.
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length; i++) {
			log.debug("▽-args["+i+"] "+args[i]+"");
		}
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		// pjp.proceed() : 타겟메소드 호출함
		returnObj = pjp.proceed();
		stopwatch.stop();
		
//		log.info("▷[Ctrl ▷ "+stopwatch.getTotalTimeMillis()+"ms]"+ returnObj);

		//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Gson gson = new GsonBuilder().create();
		log.debug("▷[Ctrl ▷ "+stopwatch.getTotalTimeMillis()+"ms]"+ gson.toJson(returnObj));
		return returnObj;
	}
	
	
	
}
