package com.erenkov.wws.presenter;

import com.erenkov.wws.view.StatisticView;

import java.util.Map;

/**
 * Interface for admin menu presenter
 */
public interface StatisticPresenter {

    /**
     * This method sets view for this presenter
     *
     * @param statisticView view for this presenter
     */
    void setStatisticView(StatisticView statisticView);

    /**
     * This method finds all users in storage
     *
     * @return string with all users
     */
    String getAllStatistic();

    /**
     * This method finds all users in storage
     *
     * @return string with all users
     */
    Map<String, Long> getLastPageStatistic();
}
