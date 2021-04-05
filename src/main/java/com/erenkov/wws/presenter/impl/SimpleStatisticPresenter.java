package com.erenkov.wws.presenter.impl;

import com.erenkov.wws.model.entity.StatisticsDataSet;
import com.erenkov.wws.service.DBException;
import com.erenkov.wws.service.DBService;
import com.erenkov.wws.service.WordCountService;
import com.erenkov.wws.view.StatisticView;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This is a simple implementation of the StatisticPresenter interface.
 * This class implements methods for printing statistics
 */
public class SimpleStatisticPresenter implements com.erenkov.wws.presenter.StatisticPresenter {

    private final DBService dbService;

    private final WordCountService wordCountService;

    private StatisticView statisticView;

    /**
     * Constructor with parameter
     *
     * @param dbService service for access to storage of statistics
     */
    public SimpleStatisticPresenter(DBService dbService, WordCountService wordCountService) {
        this.wordCountService = wordCountService;
        this.dbService = dbService;
    }

    /**
     * @see com.erenkov.wws.presenter.StatisticPresenter#setStatisticView(StatisticView)
     */
    @Override
    public void setStatisticView(StatisticView statisticView) {
        this.statisticView = statisticView;
    }

    /**
     * @see com.erenkov.wws.presenter.StatisticPresenter#getAllStatistic()
     */
    @Override
    public String getAllStatistic() {
        //todo !!!!!!!!!
//        return dbService.getAllStatistic()
//                .stream()
//                .map(u -> u.toString() + "\n")
//                .collect(Collectors.joining());
        return null;
    }

    /**
     * @see com.erenkov.wws.presenter.StatisticPresenter#getAllStatistic()
     */
    @Override
    public Map<String, Long> getLastPageStatistic() {
        Map<String, Long> lastPageStatistics = wordCountService.countFileUniqueWord("temp.html");

        lastPageStatistics.entrySet().stream().map(m -> {
            try {
                return dbService.addStatistics(m.getKey(), m.getValue());
            } catch (DBException e) {
//                e.printStackTrace();
                System.out.println("1!");
            }
            return null;
        });

        updateDb(lastPageStatistics);

        return lastPageStatistics;
    }

    private boolean updateDb(Map<String, Long> statLastPage) {

        Set<StatisticsDataSet> dbStat = new HashSet<StatisticsDataSet>();

        statLastPage.forEach((k, v) -> {
            StatisticsDataSet tempStatDS = null;

            try {
                tempStatDS = dbService.getStatistics(k);
            } catch (DBException e) {
                System.out.println("0!");
            }


            if (tempStatDS != null) {
                tempStatDS.setCount(tempStatDS.getCount() +
                        statLastPage.get(tempStatDS.getWord()));

                try {
                    dbService.updateStatistics(tempStatDS.getWord(), tempStatDS.getCount());
                } catch (DBException e) {
                    System.out.println("3!");
                }


            } else {
                try {
                    dbService.addStatistics(k, v);
                } catch (DBException e) {
                    System.out.println("2!");
                }
            }

        });

//
//        for ( StatisticsDataSet dataSetItem : dbStat ) {
//            if (statLastPage.containsKey(dataSetItem.getWord())){
//                dataSetItem.setCount(dataSetItem.getCount() +
//                        statLastPage.get(dataSetItem.getWord()));
//            }
//        }


//        dbStat = statLastPage.entrySet().stream()
//                .map(m -> {
//                    try {
//                        return dbService.getStatistics(m.getKey());
//                    } catch (DBException e) {
//                        e.printStackTrace();
//                        return null;
//                    }
//                })
//                .collect(Collectors.toSet());

//
//        for ( StatisticsDataSet dataSetItem : dbStat ) {
//            if (statLastPage.containsKey(dataSetItem.getWord())){
//                dataSetItem.setCount(dataSetItem.getCount() +
//                        statLastPage.get(dataSetItem.getWord()));
//            }
//        }


//        statLastPage.entrySet().stream()
//                .map(m -> {
//                    try {
//                         dbService.updateStatistics(m.getKey(), m.getValue());
//                    } catch (DBException e) {
//                        e.printStackTrace();
//                    }
//                    return null;
//                }); //todo !!!!!
//
//
        return true;//todo
    }
}
