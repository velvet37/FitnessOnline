package net.javabeat.spring.data.web;

import net.javabeat.spring.data.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import net.javabeat.spring.data.service.ReservationService;
import java.util.List;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;


    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        reservationService.saveReservation(reservation);
        return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
    }



    @RequestMapping(value = "/addYoga")
    public Reservation yoga() {
        Reservation reservation = new Reservation();
        reservation.setId(9);
        reservation.setCourseId("Yoga");
        reservation.setStatus("Accepted");
        return reservation;
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable long id) {
        return new ResponseEntity<Reservation>(reservationService.findOne(id), HttpStatus.OK);
    }


    @RequestMapping(value = "/all")
    public ResponseEntity<List<Reservation>> getReservation() {
        return new ResponseEntity<List<Reservation>>(reservationService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.DELETE, value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> deleteUser(@RequestBody Reservation reservation) {
        reservationService.delete(reservation);
        return new ResponseEntity<Reservation>(HttpStatus.OK);
    }


    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        Reservation update = reservationService.updateReservation(reservation);
        return new ResponseEntity<Reservation>(update, HttpStatus.OK);
    }

}
