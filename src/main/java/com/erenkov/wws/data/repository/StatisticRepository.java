package com.erenkov.wws.data.repository;

import com.erenkov.wws.model.entity.Statistic;
import java.util.Set;

/**
 * This interface contains statistic repository access methods.
 */
public interface StatisticRepository {

    /**
     * This method searches for a statistic by word
     *
     * @param word word.
     * @return statistic entity.
     */
    Statistic findStatisticByWord(String word);

    /**
     * This method stores the statistic in the repository.
     *
     * @param statistic statistic entity.
     * @return true, if the statistic has been saved.
     */
    boolean saveAndFlushStatistic(Statistic statistic);

    /**
     * This method removes the statistic from the repository.
     *
     * @param statistic statistic entity.
     * @return true, if the statistic has been deleted.
     */
    boolean deleteStatistic(Statistic statistic);

    /**
     * This method returns all statistic from the repository
     *
     * @return set of statistic
     */
    Set<Statistic> getAllStatistic();
}
