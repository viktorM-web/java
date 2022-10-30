package com.viktor.javalevel2.IOStream.homework;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

/**
 * Считать оба CSV файла и объединить их по полю ID в один result.csv, где будут следующие поля: ID,NAME,PRICE.
 * <p>
 * Желательно реализовать доп. функционал:
 * Если для каких-то ID не будет значений в обоих файлах, то записать их в один файл errors.csv,
 * где будет лишь одно поле ID.
 */
public class IORunner {
    public static void main(String[] args) {
        Path itemsName = Path.of("resources", "items-name.csv");
        Path itemsPrice = Path.of("resources", "items-price.csv");
        Path result = Path.of("resources", "result.csv");
        Path error = Path.of("resources", "errors.csv");
        try (Stream<String> streamItemsName = Files.lines(itemsName);
             Stream<String> streamItemsPrice = Files.lines(itemsPrice)
        ) {
            Map<Integer, String> mapItemsName = streamItemsName.skip(1L)
                    .map(string -> string.split(","))
                    .collect(Collectors.toMap((strings -> Integer.parseInt(strings[0])), (strings -> strings[1])));

            Map<Integer, Double> mapItemsPrice = streamItemsPrice.skip(1L)
                    .map(string -> string.split(","))
                    .collect(Collectors.toMap((strings -> Integer.parseInt(strings[0])),
                            (strings -> Double.parseDouble(strings[1]))));

            writeToFile(mapItemsName, mapItemsPrice, result, error);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(Map<Integer, String> names, Map<Integer, Double> prices, Path result, Path error) {
        Map<Integer, Map<String, Double>> mapResult = new HashMap<>();
        Set<Integer> errors = new TreeSet<>();
        for (Map.Entry<Integer, String> name : names.entrySet()) {
            if (prices.containsKey(name.getKey())) {
                mapResult.put(name.getKey(), new HashMap<>());
                mapResult.get(name.getKey()).put(name.getValue(), prices.get(name.getKey()));
            } else {
                errors.add(name.getKey());
            }
        }
        for (Integer key : prices.keySet()) {
            if (!(mapResult.containsKey(key))) {
                errors.add(key);
            }
        }
        if (!errors.isEmpty()) {
            writeError(error, errors);
        }
        if (!mapResult.isEmpty()) {
            writeResult(result, mapResult);
        }
    }

    private static void writeError(Path error, Set<Integer> errors) {
        try (BufferedWriter bufferedWriterForError = Files.newBufferedWriter(error, APPEND, CREATE)) {
            bufferedWriterForError.write("ID");
            for (Integer id : errors) {
                bufferedWriterForError.newLine();
                bufferedWriterForError.write(String.valueOf(id));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void writeResult(Path result, Map<Integer, Map<String, Double>> mapResult) {
        try (BufferedWriter bufferedWriterForResult = Files.newBufferedWriter(result, APPEND, CREATE)) {
            bufferedWriterForResult.write("ID,NAME,PRICE");
            for (Map.Entry<Integer, Map<String, Double>> entryResult : mapResult.entrySet()) {
                for (Map.Entry<String, Double> entryVolumeResult : entryResult.getValue().entrySet()) {
                    String stringResult = entryResult.getKey() + "," + entryVolumeResult.getKey() + "," +
                            entryVolumeResult.getValue();
                    bufferedWriterForResult.newLine();
                    bufferedWriterForResult.write(stringResult);
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
