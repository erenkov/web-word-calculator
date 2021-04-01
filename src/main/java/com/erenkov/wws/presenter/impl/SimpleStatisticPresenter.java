package com.erenkov.wws.presenter.impl;

import com.erenkov.wws.data.repository.StatisticRepository;
import com.erenkov.wws.view.StatisticView;

import java.util.stream.Collectors;

/**
 * This is a simple implementation of the StatisticPresenter interface.
 * This class implements methods for printing statistics
 */
public class SimpleStatisticPresenter implements com.erenkov.wws.presenter.StatisticPresenter {

    private final StatisticRepository statisticRepository;

    private StatisticView statisticView;

    /**
     * Constructor with parameter
     *
     * @param statisticRepository service for access to storage of statistics
     */
    public SimpleStatisticPresenter(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    /**
     * @see com.erenkov.wws.presenter.StatisticPresenter#setStatisticView(StatisticView)
     */
    @Override
    public void setStatisticView(StatisticView statisticView) {
        this.statisticView = statisticView;
    }

    /**
     * @see com.erenkov.wws.presenter.StatisticPresenter#getAllStatistic()*/
    @Override
    public String getAllStatistic() {
        return statisticRepository
                .getAllStatistic()
                .stream()
                .map(u -> u.toString() + "\n")
                .collect(Collectors.joining());
    }

    /**
     * @see com.erenkov.wws.presenter.StatisticPresenter#getAllStatistic()*/
    @Override
    public String getLastPageStatistic() {
        return "No connect";
    }
}
