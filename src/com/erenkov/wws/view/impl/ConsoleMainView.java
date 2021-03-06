package com.erenkov.wws.view.impl;

import com.erenkov.wws.utils.*;
import com.erenkov.wws.view.*;
import com.erenkov.wws.presenter.*;

/**
 * This is a simple implementation of the MainView interface.
 * This class implements methods of display on the console of the main menu view.
 */
public class ConsoleMainView implements MainView {

    private final MainPresenter mainPresenter;

    private final StatisticView statisticView;

    /**
     * Constructor with parameters
     *
     * @param mainPresenter      presenter for this view
     * @param statisticPresenter presenter for statistic view
     */
    public ConsoleMainView(MainPresenter mainPresenter,
                           StatisticPresenter statisticPresenter) {
        this.mainPresenter = mainPresenter;

        statisticView = new ConsoleStatisticView(statisticPresenter);

        mainPresenter.setMainView(this);
        statisticPresenter.setStatisticView(statisticView);
    }

    /**
     * @see MainView#start()
     */
    @Override
    public void start() {

        displayGreeting();

        StringBuilder buffer;  // buffer для scanner'а

        boolean shouldRun = true;
        while (shouldRun) {    // - FOREVER - чтение информации от пользователя. Выход - "0" => break

            buffer = displayMainMenuDialog();

            switch (buffer.toString().trim().toLowerCase()) { // Для возможности расширить функционал - case

                case "0":     // exit
                    shouldRun = false;
                    break;

                case "":      // continue
                    break;

                default:      // download page. template : <https://www.simbirsoft.com/>
                    if (mainPresenter.downloadPage(buffer.toString())) {
                        String successfulMsg = buffer.toString() + " page loaded successfully";
                        ConsoleIOUtility.print(successfulMsg);
                        ConsoleIOUtility.printLine1();
                        SimpleLogger.logInfo(successfulMsg);
                        statisticView.start();
                    } else {
                        displayPressEnterDialog();
                    }
            }
        }
        ConsoleIOUtility.print("Goodbye!");
    }

    /**
     * This method prints greeting to console
     */
    private void displayGreeting() {
        ConsoleIOUtility.printLine2();
        ConsoleIOUtility.print("   Hello! This is \"web-word-statistic\" utility by Erenkov Aleksandr. Let`s go!");
        ConsoleIOUtility.printLine2();
    }

    /**
     * This method prints a dialog about the scheduled task, and reads response
     *
     * @return String input
     */
    private StringBuilder displayMainMenuDialog() {
        ConsoleIOUtility.printMenuHeader("MAIN");
        return ConsoleIOUtility.read(
                "Please choose \"0\" for exit, or\n" + //
                        "input \"URL\" to load the page:");
    }

    /**
     * This method makes pause
     */
    private void displayPressEnterDialog() {
        ConsoleIOUtility.print("");
        ConsoleIOUtility.read("For continue press Enter...");
    }
}
