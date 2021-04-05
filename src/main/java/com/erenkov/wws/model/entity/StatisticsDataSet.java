package com.erenkov.wws.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * This is class for ORM Statistic.<br>
 * Fields: <br>
 * id - unique identifier<br>
 * word - word; <br>
 * count - words count <br>
 */
@Entity
@Table(name = "statistics")
public class StatisticsDataSet implements Serializable {
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "word", unique = true, updatable = false)
    private String word;

    @Column(name = "count", unique = true, updatable = true)
    private Long count;

    @SuppressWarnings("UnusedDeclaration")
    public StatisticsDataSet() {
    }

    /**
     * Constructor with parameters
     *
     * @param id    - identifier <br>
     * @param word  - unique word; <br>
     * @param count - words count. <br>
     */
    @SuppressWarnings("UnusedDeclaration")
    public StatisticsDataSet(long id, String word, Long count) {
        this.setId(id);
        this.setWord(word);
        this.setCount(count);
    }

    public StatisticsDataSet(String word, Long count) {
        this.setId(-1);
        this.setWord(word);
        this.setCount(count);
    }

    /**
     * get word
     *
     * @return word
     */
    @SuppressWarnings("UnusedDeclaration")
    public String getWord() {
        return word;
    }

    /**
     * set word
     *
     * @param word unique word
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Get id
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * set id
     *
     * @param id - id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * get word count
     *
     * @return count
     */
    @SuppressWarnings("UnusedDeclaration")
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
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", name='" + word + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsDataSet that = (StatisticsDataSet) o;
        return id == that.id &&
                word.equals(that.word) &&
                count.equals(that.count);
    }

    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, word, count);
    }
}