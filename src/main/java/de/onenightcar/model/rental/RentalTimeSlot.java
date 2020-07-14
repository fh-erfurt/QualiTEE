package de.onenightcar.model.rental;

import de.onenightcar.util.AbstractDatabaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalTime;

@Entity
public class RentalTimeSlot extends AbstractDatabaseEntity {

    /* /////////////////////Attributes///////////////////////// */

    private LocalTime departureTime;
    private LocalTime arrivalTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private FuelRental fuelRental;

    @ManyToOne(fetch = FetchType.LAZY)
    private ElectricRental electricRental;

    /* /////////////////////Constructors/////////////////////////// */

    public RentalTimeSlot() {
    }

    public RentalTimeSlot(LocalTime departureTime, LocalTime arrivalTime) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public RentalTimeSlot(LocalTime departureTime, LocalTime arrivalTime, FuelRental fuelRental, ElectricRental electricRental) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.fuelRental = fuelRental;
        this.electricRental = electricRental;
    }

    /* /////////////////////Getter/Setters/////////////////////////// */

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public FuelRental getFuelRental() {
        return fuelRental;
    }

    public void setFuelRental(FuelRental fuelRental) {
        this.fuelRental = fuelRental;
    }

    public ElectricRental getElectricRental() {
        return electricRental;
    }

    public void setElectricRental(ElectricRental electricRental) {
        this.electricRental = electricRental;
    }

    /* /////////////////////Overrides/////////////////////////// */

    @Override
    public String toString() {
        return "RentalTimeSlot{" +
                "departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", fuelRental=" + fuelRental +
                ", electricRental=" + electricRental +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RentalTimeSlot that = (RentalTimeSlot) o;

        if (departureTime != null ? !departureTime.equals(that.departureTime) : that.departureTime != null)
            return false;
        if (arrivalTime != null ? !arrivalTime.equals(that.arrivalTime) : that.arrivalTime != null) return false;
        if (fuelRental != null ? !fuelRental.equals(that.fuelRental) : that.fuelRental != null) return false;
        return electricRental != null ? electricRental.equals(that.electricRental) : that.electricRental == null;
    }

    @Override
    public int hashCode() {
        int result = departureTime != null ? departureTime.hashCode() : 0;
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + (fuelRental != null ? fuelRental.hashCode() : 0);
        result = 31 * result + (electricRental != null ? electricRental.hashCode() : 0);
        return result;
    }
}
