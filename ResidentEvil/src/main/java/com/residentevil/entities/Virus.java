package com.residentevil.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "viruses")
public class Virus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "side_effect")
    private String sideEffect;

    @Column(name = "creator")
    private String creator;

    @Column(name = "is_deadly")
    private boolean isDeadly;

    @Column(name = "is_curable")
    private boolean isCurable;

    @Enumerated(value = EnumType.STRING)
    private Mutation mutation;

    @Column(name = "turnover_rate")
    private double turnoverRate;

    @Column(name = "hours_to_turn")
    private int hoursToTurn;

    @Enumerated(value = EnumType.STRING)
    private Magnitude magnitude;

    @Column(name = "released_date")
    private Date releaseDate;


    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "virus_id"),
            inverseJoinColumns = @JoinColumn(name = "capital_id"))
    private Set<Capital> capitals;

    public Virus() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<Capital> getCapitals() {
        return capitals;
    }

    public void setCapitals(Set<Capital> capitals) {
        this.capitals = capitals;
    }
}
