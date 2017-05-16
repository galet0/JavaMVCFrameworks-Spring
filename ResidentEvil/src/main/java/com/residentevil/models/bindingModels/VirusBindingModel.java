package com.residentevil.models.bindingModels;


import com.residentevil.annotations.IsInTheFuture;
import com.residentevil.entities.Magnitude;
import com.residentevil.entities.Mutation;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class VirusBindingModel {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 10, message = "Invalid name")
    private String name;

    @NotBlank(message = "Description cannot be blank")
    @Size(min = 5, max = 100, message = "Invalid description")
    private String description;

    @Size(max = 50, message = "Invalid side effect")
    private String sideEffect;

    @Pattern(regexp = "^.*[cC]orp.*$", message = "Invalid creator")
    private String creator;

    private boolean isDeadly;

    private boolean isCurable;

    @NotNull(message = "Mutation cannot be null")
    private Mutation mutation;

    @Range(min = 0, max = 100, message = "Invalid turnover rate")
    private double turnoverRate;

    @Range(min = 1, max = 12)
    private int hoursToTurn;

    @NotNull(message = "Magnitude cannot be null")
    private Magnitude magnitude;

    @IsInTheFuture(message = "Is in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    @NotEmpty(message = "You must select a capital")
    private String[] capitals;

    public VirusBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public boolean getIsDeadly() {
        return isDeadly;
    }

    public void setIsDeadly(boolean deadly) {
        isDeadly = deadly;
    }

    public boolean getIsCurable() {
        return isCurable;
    }

    public void setIsCurable(boolean curable) {
        isCurable = curable;
    }

    public Mutation getMutation() {
        return mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    public double getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(double turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public int getHoursToTurn() {
        return hoursToTurn;
    }

    public void setHoursToTurn(int hoursToTurn) {
        this.hoursToTurn = hoursToTurn;
    }

    public Magnitude getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String[] getCapitals() {
        return capitals;
    }

    public void setCapitals(String[] capitals) {
        this.capitals = capitals;
    }
}
