package com.erenkov.wws.service.impl;

import java.io.*;
import java.net.URL;

import com.erenkov.wws.utils.SimpleLogger;
import com.erenkov.wws.service.DownloadService;

/**
 * This is a simple implementation of the DownloadService interface.
 * This class implements methods for downloader
 */
public class SimpleDownloadService implements DownloadService {

    /**
     * @see com.erenkov.wws.service.DownloadService#downloadWebPageFromUrl(String)
     */
    @Override
    public boolean downloadWebPageFromUrl(String urlStr) {

        String tempFileName = "temp.html"; // Временное хранилище загруженной web-страницы
        File tempFile;

        try (InputStreamReader inputStreamReader = new InputStreamReader(
                (new URL(urlStr)).openConnection().getInputStream());
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(tempFile = new File(tempFileName));
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            if (tempFile.createNewFile()) {
                SimpleLogger.logInfo("Temporary file for web page created");
            } else {
                SimpleLogger.logInfo("Temporary file for web page already exists");
            }

            String bufIOStr;
            while ((bufIOStr = bufferedReader.readLine()) != null) {
                bufferedWriter.write(bufIOStr);
            }

        } catch (IOException e) {
            e.printStackTrace();
            SimpleLogger.logWarning(e.toString() + "\nPage:" + urlStr);
            return false;
        }
        return true;
    }
}
