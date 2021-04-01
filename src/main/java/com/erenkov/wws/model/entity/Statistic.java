package com.erenkov.wws.model.entity;

import java.util.Objects;

/**
 * This is class for ORM Statistic.<br>
 * Fields: <br>
 * uniqueWord - word; <br>
 * count - words count <br>
 */
public class Statistic {

    private String uniqueWord;

    private long count;

    /**
     * Constructor without parameters
     */
    public Statistic() {
    }

    /**
     * Constructor with parameters
     *
     * @param uniqueWord - unique word;
     * @param count      - word count.
     */
    public Statistic(String uniqueWord, long count) {
        this.uniqueWord = uniqueWord;
        this.count = count;
    }

    /**
     * get unique word
     *
     * @return word
     */
    public String getUniqueWord() {
        return uniqueWord;
    }

    /**
     * set unique word
     *
     * @param uniqueWord unique word
     */
    public void setUniqueWord(String uniqueWord) {
        this.uniqueWord = uniqueWord;
    }

    /**
     * get word count
     *
     * @return count
     */
    public long getCount() {
        return count;
    }

    /**
     * set word count
     *
     * @param count count
     */
    public void setCount(long count) {
        this.count = count;
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistic statistic = (Statistic) o;
        return count == statistic.count &&
                uniqueWord.equals(statistic.uniqueWord);
    }

    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(uniqueWord, count);
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Statistic{" +
                "uniqueWord='" + uniqueWord + '\'' +
                ", count=" + count +
                '}';
    }
}




