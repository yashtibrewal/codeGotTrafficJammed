import java.io.File;
import java.security.MessageDigest;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileInputStream;

class FileNotCompletelyReadException extends Exception{
}

class GetBytes {
    private GetBytes(){}
    /**
     * Return all the bytes from the file
     * @param filePath
     * @return
     * @throws Exception
     */
    public static byte[] getBytes(String filePath){

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            byte[] data;
            long numberOfBytes;
            int readFeedback;
            // assuming the size is not too large, we will caste it to int
            // find the number of bytes in the file
            numberOfBytes = Files.size(Paths.get(filePath));
            data = new byte[(int)numberOfBytes];
            readFeedback = fileInputStream.read(data);
            if(readFeedback == -1){
                throw new FileNotCompletelyReadException();
                
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            Runtime.getRuntime().exit(-1);
        }
        return new byte[]{};
    }

}

/**
 * To compare two files and check if they are exactly the same.
 * Feasible Solution: Check the checksum of both the files and inform
 * accordingly.
 */
public class TestCaseChecker {
    /**
     * To check if the content of the two bytes is same.
     */
    public static boolean isEqual(byte[] arrayOne, byte[] arrayTwo) {
        if (arrayOne.length != arrayTwo.length)
            return false;
        for (int i = 0; i < arrayOne.length; i++) {
            if (arrayOne[i] != arrayTwo[i])
                return false;
        }
        return true;
    }

    public static String getExpectedOutputFilePath() {
        File file = new File("ExpectedOutput.txt");
        return file.getPath();
    }

    public static String getCodeOutputFilePath() {
        File file = new File("CodeOutput.txt");
        return file.getPath();
    }

    public static void booleanCompareFiles() {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            byte[] expectedOutputFileBytes = GetBytes.getBytes(getExpectedOutputFilePath());
            byte[] expectedOutputFileDigest = messageDigest.digest(expectedOutputFileBytes);
            byte[] codeOutputFileBytes = GetBytes.getBytes(getCodeOutputFilePath());
            byte[] codeOutputFileDigest = messageDigest.digest(codeOutputFileBytes);
            System.out.println(isEqual(expectedOutputFileDigest, codeOutputFileDigest));
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public static void main(String[] args) {
        booleanCompareFiles();
    }
}
