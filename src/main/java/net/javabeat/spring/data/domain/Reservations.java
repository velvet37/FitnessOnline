package net.javabeat.spring.data.domain;

import java.util.List;
import java.io.Serializable;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Reservations")
public class Reservations implements Serializable {

    private static final long serialVersionUID = 1L;

    @JacksonXmlProperty(localName = "Reservation")
    @JacksonXmlElementWrapper(useWrapping = false)
    protected List<Reservation> reservations = null;

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
