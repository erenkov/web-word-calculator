package com.erenkov.wws.view.impl;

import com.erenkov.wws.presenter.StatisticPresenter;
import com.erenkov.wws.view.StatisticView;
import com.erenkov.wws.utils.ConsoleIOUtility;

/**
 * This is a simple implementation of the StatisticView interface.
 * This class implements methods for displaying statistic on the console.
 */
public class ConsoleStatisticView implements StatisticView {

    private final StatisticPresenter statisticPresenter;

    /**
     * Constructor with parameter
     *
     * @param statisticPresenter presenter for this view
     */
    public ConsoleStatisticView(StatisticPresenter statisticPresenter) {
        this.statisticPresenter = statisticPresenter;
    }

    /**
     * @see StatisticView#start()
     */
    @Override
    public void start() {

        displayStatisticMenuHeader();

        StringBuilder buffer;  // buffer scanner
        boolean shouldRun = true;
        while (shouldRun) {    // FOREVER - чтение информации от пользователя. Выход - "0" => break

            buffer = displayWhatStatisticDialog();

            switch (buffer.toString().trim().toLowerCase()) {

                case "0":
                    shouldRun = false;
                    break;

                case "1":
                    displayLastPageStatistic();
                    break;

                case "2":
                    displayAllStatistic();
                    break;

                default:
                    displayInputError();
            }
        }
    }

    /**
     * @see StatisticView#displayStatisticNotFoundError()
     */
    @Override
    public void displayStatisticNotFoundError() {
        ConsoleIOUtility.print("------ Statistic not found! -----------------------");
        ConsoleIOUtility.printLine1();
    }

    /**
     * This method prints header to console
     */
    private void displayStatisticMenuHeader() {
        ConsoleIOUtility.printMenuHeader("STATISTIC");
    }

    /**
     * This method prints statistics from database
     */
    private void displayAllStatistic() {
        ConsoleIOUtility.print("Statistic from data base:\n");
        ConsoleIOUtility.print(statisticPresenter.getAllStatistic());
        ConsoleIOUtility.printLine1();
    }

    /**
     * This method calculate statistics from the last page
     */
    private void displayLastPageStatistic() {
        ConsoleIOUtility.print("Statistic from file:\n");
        ConsoleIOUtility.print(statisticPresenter.getLastPageStatistic());
        ConsoleIOUtility.printLine1();
    }

    /**
     * This method print error input msg
     */
    private void displayInputError() {
        ConsoleIOUtility.print("------ Input Error! Try again -------");
        displayPressEnterDialog();
    }

    /**
     * This method makes pause
     */
    private void displayPressEnterDialog() {
        ConsoleIOUtility.print("");
        ConsoleIOUtility.read("For continue press Enter...");
    }

    /**
     * This method prints a dialog about what statistics to display
     */
    private StringBuilder displayWhatStatisticDialog() {
        ConsoleIOUtility.print("");
        return ConsoleIOUtility.read(
                "Choose \"0\" for back to main menu" + "\n" + //
                "Choose \"1\" for calculate last page statistic" + "\n" + //
                "Choose \"2\" for all page statistic" );
    }
}
