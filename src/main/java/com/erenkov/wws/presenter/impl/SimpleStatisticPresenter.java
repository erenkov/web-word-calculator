package com.erenkov.wws.presenter.impl;

import com.erenkov.wws.presenter.StatisticPresenter;
import com.erenkov.wws.service.WordCountService;
import com.erenkov.wws.view.StatisticView;

import java.util.Map;

/**
 * This is a simple implementation of the StatisticPresenter interface.
 * This class implements methods for counting and printing of statistics
 */
public class SimpleStatisticPresenter implements com.erenkov.wws.presenter.StatisticPresenter {

    private final WordCountService wordCountService;

    private StatisticView statisticView; // MVP

    /**
     * Constructor with parameter
     *
     * @param wordCountService service for counts word
     */
    public SimpleStatisticPresenter(WordCountService wordCountService) {
        this.wordCountService = wordCountService;
    }

    /**
     * @see com.erenkov.wws.presenter.StatisticPresenter#setStatisticView(StatisticView)
     */
    @Override
    public void setStatisticView(StatisticView statisticView) {
        this.statisticView = statisticView;
    }

    /**
     * @see StatisticPresenter#getLastPageStatistic()
     */
    @Override
    public Map<String, Long> getLastPageStatistic() {
        return wordCountService.countFileUniqueWord("temp.html");
    }
}
