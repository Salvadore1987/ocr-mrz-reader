package uz.asbt.ocr.mrz.reader;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.library.path", "D:\\Bin_64\\");
        final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
        sysPathsField.setAccessible(true);
        sysPathsField.set(null, null);
        try(Scanner scanner = new Scanner("D:\\photo.jpg", "D:\\out.xml")) {
            scanner.scan();
            MRZData mrzData = scanner.getData();
            System.out.println(mrzData.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
