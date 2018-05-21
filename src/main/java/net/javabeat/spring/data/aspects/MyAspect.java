/*
 * LoggingWithAspectJ - Logging with AspectJ
 * Copyright (C) 2007 Christian Schenk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */
package net.javabeat.spring.data.aspects;

import net.javabeat.spring.data.service.StatisticRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import net.javabeat.spring.data.domain.Statistic;

@Aspect
@Component
public class MyAspect {

	/**
	 * Will log every execution of Student's methods
	 */
//	@Around("execution(* net.javabeat.spring.data.domain.Reservation.*(..))")
//	public Object doThing(final ProceedingJoinPoint thisJoinPoint) throws Throwable {
//		final String joinPointName = thisJoinPoint.getThis().getClass().getSimpleName() + "." + thisJoinPoint.getSignature().getName() + "()";
//		System.out.println("Entering [" + joinPointName + "]");
//		Object retVal = thisJoinPoint.proceed();
//		System.out.println("Leaving  [" + joinPointName + "]");
//		return retVal;
//	}

    @Autowired
    StatisticRepository statisticRepository;

    @Before("execution(* net.javabeat.spring.data.service.ReservationService.findAll(..))")
    public void beforeFindAll()
    {
        System.out.println("FINDALL METHOD USED");
        long id = 1;
        Statistic stat = statisticRepository.getOne(id);
        stat.setOpenTime(stat.getOpenTime()+1);
        statisticRepository.save(stat);

    }
}