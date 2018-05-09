package net.javabeat.spring.data.service;

import net.javabeat.spring.data.domain.Reservation;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface ReservationService {
	List<Reservation> findAll();
	void saveReservation(Reservation reservation);
	Reservation updateReservation(Reservation reservation);

	@Cacheable ("reservation")
	Reservation findOne(long id);
	void delete(Reservation reservation);

}
