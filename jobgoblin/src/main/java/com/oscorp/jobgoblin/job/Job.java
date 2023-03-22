package com.oscorp.jobgoblin.job;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "job")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String descr;
    private long companyID;
    //must make plural
    private long recruiterID;//s
    private double rating;
    private int numRatings;
    private String datePosted;
    private int salaryHigh;
    private int salaryLow;
    private double quizID;
    Job(String name,
        String descr,
        long companyID,
        long recruiterID,
        double rating,
        int numRatings,
        String datePosted,
        int salaryHigh,
        int salaryLow,
        long quizID){

        this.name = name;
        this.descr = descr;
        this.companyID = companyID;
        this.recruiterID = recruiterID;
        this.rating = rating;
        this.numRatings = numRatings;
        this.datePosted = datePosted;
        this.salaryHigh = salaryHigh;
        this.salaryLow = salaryLow;
        this.quizID = quizID;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescr() {
        return descr;
    }

    public long getCompanyID() {
        return companyID;
    }

    public long getRecruiterID() {
        return recruiterID;
    }

    public double getRating() {
        return rating;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public int getSalaryHigh() {
        return salaryHigh;
    }

    public int getSalaryLow() {
        return salaryLow;
    }

    public double getQuizID() {
        return quizID;
    }
}
