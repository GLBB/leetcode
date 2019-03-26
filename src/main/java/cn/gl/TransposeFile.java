package cn.gl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 未通过
 */
public class TransposeFile {

    public static void main(String[] args) throws IOException {
        List<String> origin = Files.readAllLines(Path.of("file.txt"));
        List<String[]> list = origin.stream().map(line -> {
            String[] s = line.split(" ");
            return s;
        }).collect(Collectors.toList());
        int col = list.get(0).length;

        List<String> reuslt = new ArrayList<>();

        for (int i = 0; i < col; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < list.size(); j++) {
                if (j==list.size()-1) {
                    sb.append(list.get(j)[i]);
                }else {
                    sb.append(list.get(j)[i] + " ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
