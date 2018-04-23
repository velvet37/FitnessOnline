package net.javabeat.spring.data.service;

import net.javabeat.spring.data.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
//	@Autowired
//	private UserOwnRepository userOwnRepository;
//	@Autowired
//	private UserQueryRepositoryExample userQueryRepository;
//	@Autowired
//	private UserNamedQueryRepositoryExample userNamedQueryRepository;

	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

//	public List<User> findByName(String name) {
//		return userQueryRepository.findByName(name);
//	}
//
//	public List<User> findByNameMatch(String name) {
//		return userQueryRepository.findByNameMatch(name);
//	}
//
//	public List<User> findByNamedParam(String name, String author, long price) {
//		return userQueryRepository.findByNamedParam(name, author, price);
//	}

	public void saveReservation(Reservation reservation) {
        if (reservation != null) {
            reservationRepository.save(reservation);
        }
	}

	public Reservation updateReservation(Reservation reservation) {
		Reservation reservationToUpdate = new Reservation();
		if (reservation != null) {
			reservationToUpdate = this.findOne(reservation.getId());

			reservationToUpdate.setId(reservation.getId());
			reservationToUpdate.setCourseId(reservation.getCourseId());
			reservationToUpdate.setStatus(reservation.getStatus());
		}
		return reservationToUpdate;
	}

	public Reservation findOne(long id) {
		System.out.println("Cached Pages");
		return reservationRepository.findById(id).orElse(null);
	}

	public void delete(Reservation reservation) {
		reservationRepository.deleteById(reservation.getId());
	}
}
