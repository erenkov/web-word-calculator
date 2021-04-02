package com.erenkov.wws.presenter.impl;

import com.erenkov.wws.presenter.MainPresenter;
import com.erenkov.wws.service.DownloadService;
import com.erenkov.wws.view.MainView;

/**
 * This is a simple implementation of the MainPresenter interface.
 * This class implements methods for main menu view
 */
public class SimpleMainPresenter implements MainPresenter {

    private MainView mainView;
    private final DownloadService downloadService;

    /**
     * Constructor with parameter
     *
     * @param downloadService service to load the page
     */
    public SimpleMainPresenter(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    /**
     * @see MainPresenter#setMainView(MainView)
     */
    @Override
    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    /**
     * @see MainPresenter#downloadPage(String)
     */
    @Override
    public boolean downloadPage(String urlStr) {
        return downloadService.downloadWebPageFromUrl(urlStr);
    }

}

