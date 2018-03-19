package com.example.advancedprison;

/**
 * Created by William on 19-3-2018.
 */

public class Prisoner {

    private String name;
    private String crime;
    private int age;
    private int sentenceLength;
    private boolean solitary;

    public Prisoner(String name, String crime, int age, int sentenceLength, boolean solitary) {
        this.name = name;
        this.solitary = solitary;
        this.age = age;
        this.sentenceLength = sentenceLength;
        this.crime = crime;
    }

    public String getName() {
        return name;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSentenceLength() {
        return sentenceLength;
    }

    public void setSentenceLength(int sentenceLength) {
        this.sentenceLength = sentenceLength;
    }

    public boolean getSolitary() {
        return solitary;
    }

    public void setSolitary(boolean solitary) {
        this.solitary = solitary;
    }

    public String toString() {
        return "Prisoner " +
                "Name = '" + name + '\'' +
                ", Crime = '" + crime + '\'' +
                ", Age = " + age +
                ", Sentenced for = " + sentenceLength +
                ", Solitary = '" + solitary + '\'';
    }
}