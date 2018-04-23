package net.javabeat.spring.data.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import net.javabeat.spring.data.domain.Reservation;

public interface ReservationOwnRepository extends Repository<Reservation,Long>{
	List<Reservation> findById(long id);
}
