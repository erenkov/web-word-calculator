package com.erenkov.wws.data.repository.impl;

import com.erenkov.wws.model.entity.Statistic;

import java.util.HashSet;
import java.util.Set;

/**
 * This is simple implementation of the StatisticRepository interface.
 * The repository is Set with Statistic-entities.
 */
public class SimpleStatisticRepository implements com.erenkov.wws.data.repository.StatisticRepository {

    private final Set<Statistic> statistics = generateStatistics();

    private Set<Statistic> generateStatistics(){
        Set<Statistic> statistics = new HashSet<>();
        statistics.add(new Statistic("word0", 0));
        statistics.add(new Statistic("word1", 1));
        statistics.add(new Statistic("word2", 2));
        return statistics;
    }

    /**
     * @see com.erenkov.wws.data.repository.StatisticRepository#findStatisticByWord(String)
     */
    @Override
    public Statistic findStatisticByWord(String word) {
        return statistics
                .stream()
                .filter(s -> s.getUniqueWord().equals(word))
                .findFirst()
                .orElse(new Statistic());
    }

    /**
     * @see com.erenkov.wws.data.repository.StatisticRepository#saveAndFlushStatistic(Statistic)
     */
    @Override
    public boolean saveAndFlushStatistic(Statistic statistic) {
        return statistics.add(statistic);
    }

    /**
     * @see com.erenkov.wws.data.repository.StatisticRepository#deleteStatistic(Statistic)
     */
    @Override
    public boolean deleteStatistic(Statistic statistic) {
        return statistics.remove(statistic);
    }

    /**
     * @see com.erenkov.wws.data.repository.StatisticRepository#getAllStatistic()
     */
    @Override
    public Set<Statistic> getAllStatistic() {
        return statistics;
    }
}
