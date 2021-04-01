package com.erenkov.wws.service;

/**
 * Interface for page downloader
 */
public interface DownloadService {

    /**
     * This method downloads web page from url
     *
     * @param urlStr url (String)
     */
    void downloadWebPageFromUrl(String urlStr);
}
