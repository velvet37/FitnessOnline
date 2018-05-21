package net.javabeat.spring.data.aspects;

import net.javabeat.spring.data.service.ReservationService;
import net.javabeat.spring.data.service.ReservationServiceImpl;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

//@EnableLoadTimeWeaving(aspectjWeaving = AspectJWeaving.ENABLED)
@Configuration
@EnableAspectJAutoProxy//(proxyTargetClass=true)
@EnableSpringConfigured
//@ComponentScan(basePackages = { "aspects", "net.javabeat.spring.data.domain" })
@ComponentScan(basePackages ="net.javabeat.spring.data.service" )
public class AspectConfig {

	@Bean
//    public MyAspect myLogicLoggingAspect() {
//        return Aspects.aspectOf(MyAspect.class);
    public MyAspect myAspect(){
	    return new MyAspect();
}
	@Bean
//	public InstrumentationLoadTimeWeaver loadTimeWeaver()  throws Throwable {
//	    InstrumentationLoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
//	    return loadTimeWeaver;
//	}
    public ReservationService reservationService(){
	    return new ReservationServiceImpl();
    }
	
	
}