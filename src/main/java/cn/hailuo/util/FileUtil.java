package cn.hailuo.util;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static void createFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
