package com.erenkov.wws.service.impl;

import java.io.*;
import java.net.HttpURLConnection;
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
        try{
            URL webPageUrl = new URL(urlStr);

            String tempFileName = "temp.html";
            File tempFile = new File(tempFileName);

            HttpURLConnection connection = (HttpURLConnection) webPageUrl.openConnection();

            try(InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                FileWriter fileWriter  = new FileWriter(tempFile);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter) ) {

                if (tempFile.createNewFile()) {
                    SimpleLogger.logInfo("Temporary file for web page created");
                } else {
                    SimpleLogger.logInfo("Temporary file for web page already exists");
                }

                String input = null;
                while ((input = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(input);
                }
            } catch (IOException e) {
                e.printStackTrace();
                SimpleLogger.logWarning(e.toString() + "\nPage:" + urlStr);
                return false;
            }

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            SimpleLogger.logWarning(e.toString() + "\nPage:" + urlStr);
            return false;
        }
    }
}
