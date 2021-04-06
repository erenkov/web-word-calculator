package com.erenkov.wws;

import com.erenkov.wws.presenter.MainPresenter;
import com.erenkov.wws.presenter.StatisticPresenter;
import com.erenkov.wws.presenter.impl.SimpleMainPresenter;
import com.erenkov.wws.presenter.impl.SimpleStatisticPresenter;
import com.erenkov.wws.service.DownloadService;
import com.erenkov.wws.service.WordCountService;
import com.erenkov.wws.service.impl.SimpleDownloadService;
import com.erenkov.wws.service.impl.SimpleWordCountService;
import com.erenkov.wws.utils.SimpleLogger;
import com.erenkov.wws.view.MainView;
import com.erenkov.wws.view.impl.ConsoleMainView;

/**
 * Web Word Calculator
 */
public class WebWordCalculator {
    /**
     * This is program start point <br>
     * This method is called the interactive user interface.
     * And here dependencies are defined
     *
     * @param args command line args - not used
     */
    public static void main(String[] args) {

        SimpleLogger.logLabel("Program run"); // В логгер отметка о начале программы

        DownloadService downloadService = new SimpleDownloadService();  // Сервис выполняющий загрузку web-страницы
                                                                        //       во временный файл "temp.html"

        WordCountService wordCountService = new SimpleWordCountService(); // Сервис выполняющий подсчёт уникальных слов
                                                                          //       из временного файла "temp.html"

        // Далее реалиизован паттерн MVP
        MainPresenter mainPresenter = new SimpleMainPresenter(downloadService);
        StatisticPresenter statisticPresenter = new SimpleStatisticPresenter(wordCountService);

        MainView mainView = new ConsoleMainView(mainPresenter, statisticPresenter);

        // Запуск диалога с пользователем
        mainView.start(); //run view

        SimpleLogger.logLabel("Program finish"); //В логгер отметка о начале программы

    }
}
