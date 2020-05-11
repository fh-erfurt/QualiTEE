package de.onenightcar.domain.parkingArea;

import java.util.ArrayList;

/** Represents a Parking Area Manager
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */

public class ParkingAreaManager {

    public static ArrayList<ParkingArea>            ParkingAreas;
    public static ArrayList<ElectricParkingArea>    ElectricParkingAreas;
    public int parkingAreaCounter;

    /**
     * Creates a ParkingAreaManager with empty lists and the initial counter = 1.
     */

    public ParkingAreaManager(){
        this.ParkingAreas           = new ArrayList<ParkingArea>();
        this.ElectricParkingAreas   = new ArrayList<ElectricParkingArea>();
        this.parkingAreaCounter = 1;
    }

    /**
     * returns the current counter an increments 1 for next ID
     * @return an int value which is used to create the IDs from Parking Areas
     */

    public  int getAndIncrementCounter(){
        int oldParkingAreaCounter = this.parkingAreaCounter;
        this.parkingAreaCounter++;
        return oldParkingAreaCounter;
    }

    /** Method to Add an electric Parking Area to the ArrayList
     * @param electricParkingArea the parking Area to which it should be assign
     * the Position of the added Area is at the End of the List
     */

    public void addElectricParkingAreaIntoElectricParkingAreas(ElectricParkingArea electricParkingArea){
        this.ElectricParkingAreas.add(electricParkingArea);
    }

    /** Method to Add an parking Area to the ArrayList
     * @param parkingArea the parking Area to which it should be assign
     * the Position of the added Area is at the End of the List
     */

    public void addParkingAreaIntoParkingAreas(ParkingArea parkingArea){
        this.ParkingAreas.add(parkingArea);
    }

    /** Method to remove an electric Parking Area from the Array List
     * @param electricParkingArea the new Parking Area
     */
    public void removeElectricParkingAreaIntoElectricParkingAreas(ElectricParkingArea electricParkingArea){
        this.ElectricParkingAreas.remove(electricParkingArea);
    }

    /** Method to remove an parking Area from the Array List
     * @param parkingArea the Parking area who need to be removed
     */
    public void removeParkingAreaIntoParkingAreas(ParkingArea parkingArea){
        this.ParkingAreas.remove(parkingArea);
    }

    /** gets the size of the ElectricParkingAreas list
     * @return  the size of ElectricParkingAreas
     */
    public int getSizeOfElectricParkingAreas() {return ElectricParkingAreas.size() ;}

    /** gets the size of the ParkingAreas list
     * @return  the size of ParkingAreas
     * */
    public int getSizeOfParkingAreas() {return ParkingAreas.size() ;}

    /** gets the Index(id) of the ElectricParkingAreas list
     * @param electricParkingArea from which Parking the Id is needed
     * @return  the Index of ElectricParkingAreas
     * */
    public int getParkIDFromElectricParkingAreas(ElectricParkingArea electricParkingArea) {
        return ElectricParkingAreas.indexOf(electricParkingArea);
    }

    /** gets the Index(id) of the ParkingAreas list
     * @param parkingArea from which Parking the Id is needed
     * @return  the Index of ParkingAreas
     * */
    public int getParkIDFromParkingAreas(ParkingArea parkingArea){
        return ParkingAreas.indexOf(parkingArea);
    }

    /** returns the OneNightCar.ParkingArea with Index(id)
     * @param parkingArea from which Parking the Id is needed
     * @return ParkingAreaIndex
     */
    protected int returnParkingAreaWithIndex(ParkingArea parkingArea) {                      //protected for Testing purposes
        int ParkingAreaIndex;
        for (ParkingAreaIndex = 0; ParkingAreaIndex < ParkingAreas.size(); ParkingAreaIndex++) {
            if (parkingArea == ParkingAreas.get(ParkingAreaIndex)) {
                break;
            }
        }
        return ParkingAreaIndex;
    }

    /** returns the ElectricParkingArea with Index(id)
     * @param electricParkingArea the parking area whose id is needed
     * @return an int value
     */
    protected int returnElectricParkingAreaWithIndex(ElectricParkingArea electricParkingArea) {                      //protected for Testing purposes
        int ElectricParkingAreaIndex;
        for (ElectricParkingAreaIndex = 0; ElectricParkingAreaIndex < ElectricParkingAreas.size();
             ElectricParkingAreaIndex++) {
            if (electricParkingArea == ParkingAreas.get(ElectricParkingAreaIndex)) {
                break;
            }
        }
        return ElectricParkingAreaIndex;

    }


}