package com.carpark.springcarpark.api.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "booking_office")
public class BookingOffice {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long officeId;

    private Date endContractDeadline;

    private String officeName;

    private String officePhone;

    private String officePlace;

    private Long officePrice;

    private Date startContractDeadline;
    @ManyToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "trip_id")
    private Trip trip;


    public BookingOffice() {
    }


    public BookingOffice(Date endContractDeadline, String officeName, String officePhone, String officePlace,
                         Long officePrice, Date startContractDeadline) {
        this.endContractDeadline = endContractDeadline;
        this.officeName = officeName;
        this.officePhone = officePhone;
        this.officePlace = officePlace;
        this.officePrice = officePrice;
        this.startContractDeadline = startContractDeadline;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public Date getEndContractDeadline() {
        return endContractDeadline;
    }

    public void setEndContractDeadline(Date endContractDeadline) {
        this.endContractDeadline = endContractDeadline;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getOfficePlace() {
        return officePlace;
    }

    public void setOfficePlace(String officePlace) {
        this.officePlace = officePlace;
    }

    public Long getOfficePrice() {
        return officePrice;
    }

    public void setOfficePrice(Long officePrice) {
        this.officePrice = officePrice;
    }

    public Date getStartContractDeadline() {
        return startContractDeadline;
    }

    public void setStartContractDeadline(Date startContractDeadline) {
        this.startContractDeadline = startContractDeadline;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

}
