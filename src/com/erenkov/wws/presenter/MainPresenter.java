package com.erenkov.wws.presenter;

import com.erenkov.wws.view.MainView;

/**
 * Interface for main menu presenter
 */
public interface MainPresenter {

    /**
     * This method sets view for this presenter
     *
     * @param mainView view for this presenter
     */
    void setMainView(MainView mainView);


    /**
     * This method commands to start loading the page to the hard drive
     *
     * @param urlStr string with url
     * @return true if the page was loaded, or else false
     */
    boolean downloadPage(String urlStr);
}
