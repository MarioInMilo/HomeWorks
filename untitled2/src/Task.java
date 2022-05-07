import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task {
    public static void main(String[] args) {
        // CREATED 1.txt
        String OneTxtPath = System.getProperty("user.dir") + File.separator + "1.txt";
        File fileOneTxt = new File(OneTxtPath);
        FileOutputStream fileOutputStream = null;
        if (!fileOneTxt.exists()) {
            try {
                fileOneTxt.createNewFile();
                byte[] txtTempByteArray = "Миша ездит на Жигули, а Катя на Мерседес".getBytes(StandardCharsets.UTF_8);
                fileOutputStream = new FileOutputStream(OneTxtPath);
                fileOutputStream.write(txtTempByteArray);
                System.out.println("File created");
            } catch (IOException e) {
                System.err.println("1.txt create ERROR" + e);
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("File already exists");
        }
        // CREATE FOLDER RESULT
        String folderResultPath = System.getProperty("user.dir") + File.separator + "Result";
        File fileResultFolder = new File(folderResultPath);
        if (!fileResultFolder.exists()) {
            fileResultFolder.mkdir();
            try {
                fileResultFolder.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // CREATE 2.txt in folder Result
        String twoTxtResultPath = System.getProperty("user.dir") + File.separator
                + "Result" + File.separator + "2.txt";
        File fileTwoTxt = new File(twoTxtResultPath);
        if (!fileTwoTxt.exists()) {
            try {
                fileTwoTxt.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 1.txt on byte[]
        FileInputStream oneTxtOnByteInput;
        FileOutputStream oneTxtOnByteOutput = null;
        byte[] oneTxtByteArray = new byte[0];
        try {
            oneTxtOnByteInput = new FileInputStream(fileOneTxt);
            oneTxtByteArray = new byte[oneTxtOnByteInput.available()];
            oneTxtOnByteInput.read(oneTxtByteArray);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // replace txt
        String byteToString = null;
        try {
            byteToString = new String(oneTxtByteArray, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byteToString = byteToString.replace("Жигули", "BMW")
                .replace("Мерседес", "РЕНО");
        // Write result to 2.txt
        try {
            oneTxtOnByteOutput = new FileOutputStream(twoTxtResultPath);
            byte[] saveToTwoTxt = byteToString.getBytes(StandardCharsets.UTF_8);
            oneTxtOnByteOutput.write(saveToTwoTxt);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oneTxtOnByteOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
