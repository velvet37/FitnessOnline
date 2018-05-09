package net.javabeat.spring.data.service;

import net.javabeat.spring.data.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
//    @Modifying
//    @Query("update Reservation r set r.id = ?3, r.courseId = ?2 where r.status = ?1")
    //void updateReservationById(long id, String courseId, String status);

}
