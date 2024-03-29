package test_data;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class DataObjectBuilder {
    public static <T> T buildDataObject(String filePath, Class<T> dataType) {
        T returnData = null;
        String absoluteFilePath = System.getProperty("user.dir").concat(filePath);
        try (
                Reader reader = Files.newBufferedReader(Paths.get(absoluteFilePath));
        ) {
            Gson gson = new Gson();
            returnData = gson.fromJson(reader, dataType);
        } catch (NoSuchFileException noSuchFileException) {
            throw new RuntimeException("[ERR] Can't locate file: " + absoluteFilePath);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception.getMessage());
        }
        return returnData;
    }
}
