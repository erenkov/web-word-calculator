package com.erenkov.wws.service;

import java.util.Map;

/**
 * Interface for word count service
 */
public interface WordCountService {

    /**
     * This method counts unique words from a file
     *
     * @param fileName fileName (String)
     * @return map of pairs "word - count"
     */
    Map<String, Long> countFileUniqueWord(String fileName);
}
