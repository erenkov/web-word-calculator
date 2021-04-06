package com.erenkov.wws.service.impl;

import com.erenkov.wws.service.WordCountService;
import com.erenkov.wws.utils.SimpleLogger;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This is a simple implementation of the WordCountService interface.
 * This class implements methods for word counter
 */
public class SimpleWordCountService implements WordCountService {

    /**
     * @see WordCountService#countFileUniqueWord(String)
     */
    @Override
    public Map<String, Long> countFileUniqueWord(String fileName) {

        try (FileReader fileReader = new FileReader(new File(fileName));
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            Map<String, Long> statisticsMap;

            statisticsMap = bufferedReader.lines()
                    .flatMap(l -> Stream.of(l.split("[\\p{Punct}\\s]")) // Разбиваем по знакам пунктуации и
                            .filter(s -> s.matches("[A-Za-zА-Яа-я]+"))) // выбираем только из букв состоящие
                    .map(String::toUpperCase)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            return statisticsMap;

        } catch (IOException e) {
            e.printStackTrace();
            SimpleLogger.logWarning(e.toString());
            return new HashMap<>();
        }
    }
}
