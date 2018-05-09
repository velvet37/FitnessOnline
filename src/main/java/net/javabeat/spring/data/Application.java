package net.javabeat.spring.data;

import net.javabeat.spring.data.domain.Reservations;
import net.javabeat.spring.data.domain.Reservation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.ArrayList;

@Configuration
@SpringBootApplication
@EnableJpaRepositories
@EnableCaching
public class Application {

	static Reservations rsvs = new Reservations();
	static
	{   rsvs.setReservations(new ArrayList<Reservation>());
		//sts.setStudents();
		//Create two employees
		Reservation rsv1 = new Reservation();
		rsv1.setCourseId("Yoga");
		rsv1.setStatus("Accepted");
		rsv1.setId(1L);
		Reservation rsv2 = new Reservation();
		rsv2.setCourseId("Boxing");
		rsv2.setStatus("Accepted");
		rsv2.setId(2L);
		//Add the employees in list
		rsvs.getReservations().add(rsv1);
		rsvs.getReservations().add(rsv2);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
