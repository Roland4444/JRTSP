package se.roland.client.abstractions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Weighing implements Serializable{

    public int id;
    public LocalDate date;
    public LocalTime time;
    public String plateNumber;
    public String metal;
    public Integer brutto;
    public Integer tare;
    public Float sor;
    public Integer trash;
    public String car;
    public Integer waybill;
    public Boolean transfer;
    public byte[] firstSnapshot;
    public byte[] secondSnapshaot;
    public String department;
    public String recPlate;


    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    /**
     * @return the plateNumber
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * @param plateNumber the plateNumber to set
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * @return the metal
     */
    public String getMetal() {
        return metal;
    }

    /**
     * @param metal the metal to set
     */
    public void setMetal(String metal) {
        this.metal = metal;
    }

    /**
     * @return the brutto
     */
    public Integer getBrutto() {
        return brutto;
    }

    /**
     * @param brutto the brutto to set
     */
    public void setBrutto(int brutto) {
        this.brutto = brutto;
    }

    /**
     * @return the tare
     */
    public Integer getTare() {
        return tare;
    }

    /**
     * @param tare the tare to set
     */
    public void setTare(int tare) {
        this.tare = tare;
    }

    /**
     * @return the sor
     */
    public Float getSor() {
        return sor;
    }

    /**
     * @param sor the sor to set
     */
    public void setSor(float sor) {
        this.sor = sor;
    }

    /**
     * @return the trash
     */
    public Integer getTrash() {
        return trash;
    }

    /**
     * @param trash the trash to set
     */
    public void setTrash(int trash) {
        this.trash = trash;
    }

    /**
     * @return the car
     */
    public String getCar() {
        return car;
    }

    /**
     * @param car the car to set
     */
    public void setCar(String car) {
        this.car = car;
    }

    /**
     * @return the waybill
     */
    public Integer getWaybill() {
        return waybill;
    }

    /**
     * @param waybill the waybill to set
     */
    public void setWaybill(int waybill) {
        this.waybill = waybill;
    }

    /**
     * @return the time
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return plateNumber;
    }

    /**
     * @return the transfer
     */
    public Boolean isTransfer() {
        return transfer;
    }

    /**
     * @param transfer the transfer to set
     */
    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }

    public Integer getNetto(){
        return this.getBrutto()-this.getTare();
    }

    public BigDecimal getResult(){
        int withoutPercentage = this.getNetto()-this.getTrash();
        float result = withoutPercentage - (percentageOf(withoutPercentage, this.getSor()));
        BigDecimal bd = new BigDecimal(result);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd;
    }

    private float percentageOf(int value, float percentage){
        return value*(percentage/100.0f);
    }

    /**
     * @return the firstSnapshot
     */
    public byte[] getFirstSnapshot() {
        return firstSnapshot;
    }

    /**
     * @param firstSnapshot the firstSnapshot to set
     */
    public void setFirstSnapshot(byte[] firstSnapshot) {
        this.firstSnapshot = firstSnapshot;
    }

    /**
     * @return the secondSnapshaot
     */
    public byte[] getSecondSnapshaot() {
        return secondSnapshaot;
    }

    /**
     * @param secondSnapshaot the secondSnapshaot to set
     */
    public void setSecondSnapshaot(byte[] secondSnapshaot) {
        this.secondSnapshaot = secondSnapshaot;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the recPlate
     */
    public String getRecPlate() {
        return recPlate;
    }

    /**
     * @param recPlate the recPlate to set
     */
    public void setRecPlate(String recPlate) {
        this.recPlate = recPlate;
    }

}
