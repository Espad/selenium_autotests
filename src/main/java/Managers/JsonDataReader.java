package Managers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import DataTypes.FillFormData;

public class JsonDataReader {
    private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "formData.json";
    private List<FillFormData> customerList;

    public JsonDataReader(){
        customerList = getCustomerData();
    }

    private List<FillFormData> getCustomerData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(customerFilePath));
            FillFormData[] customers = gson.fromJson(bufferReader, FillFormData[].class);
            return Arrays.asList(customers);
        }catch(FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + customerFilePath);
        }finally {
            try { if(bufferReader != null) bufferReader.close();}
            catch (IOException ignore) {}
        }
    }

    public final FillFormData getCustomerByName(String customerName){
        return customerList.stream().filter(x -> x.firstName.equalsIgnoreCase(customerName)).findAny().get();
    }


}