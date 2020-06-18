package de.onenightcar.model.rental;

import de.onenightcar.util.AbstractDatabaseEntity;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.DAYS;


/** Represents a rental entry
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
  */
@MappedSuperclass
public abstract class Rental extends AbstractDatabaseEntity {
    /* /////////////////////Attributes///////////////////////// */

    protected float rentalPrice;
    protected long odometerBefore;
    protected long odometerAfter = 0;
    protected LocalDateTime date;
    protected LocalDateTime departure;
    protected LocalDateTime arrival;

    /* /////////////////////Methods/////////////////////////// */

    /** Creates a OneNightCar.Rental entry for a rental
     * @param date the date and time of the booking
     * @param departure the date and time at which the customer started the rental
     * @param arrival  the date and time at which the customer ended the rental
     */
    public Rental(LocalDateTime date, LocalDateTime departure,
                          LocalDateTime arrival){
        this.date = date;
        this.departure = departure;
        this.arrival = arrival;
    }

    /** Default Constructor for OneNightCar.Rental
     */
    public Rental(){
        this.date = LocalDateTime.now();
        this.departure = LocalDateTime.now();
        this.arrival = departure.plusWeeks(1);
    }

    /** Calculates the duration of a rental
     * @return the total amount of hours the rental has lasted
     */
    public long calculateElapsedDays(){
        return departure.until(arrival, DAYS);
    }

    /** Sets the odometer to the value after the rental
     */
    public void setOdometerAfter(){
        try {
            this.odometerAfter = odometerBefore + ((calculateElapsedDays() * 24) * 32); //Calculates the driven amount of kilometres by using the average speed of a car in Munich (as it can't be inspected)
        }
        catch(Exception e){
            System.out.print("Set Odometer has failed!");
        }
    }

    /** Gets the odometer after the rental
     * @return the odometer after the rental
     */
    public long getOdometerAfter(){
        return this.odometerAfter;
    }

    public LocalDateTime getDate () {
        return this.date;
    }

    public LocalDateTime getDepartureTime () {return this.departure;}

    public LocalDateTime getArrivalTime () {return this.arrival;}

}