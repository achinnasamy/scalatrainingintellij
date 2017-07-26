//package com.itc.petra;
//
//import com.microsoft.azure.datalake.store.ADLStoreClient;
//import com.microsoft.azure.datalake.store.IfExists;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.PrintStream;
//import java.util.function.BiFunction;
//import java.util.function.Function;
//
///**
// * Created by dharshekthvel on 29/6/17.
// */
//public class PetraADLSUploadFunction implements BiFunction<String,ADLStoreClient, Boolean> {
//
//    Boolean isUploaded = false;
//
//    @Override
//    public Boolean apply(String filePathToUpload, ADLStoreClient adlStoreClient) {
//
//        try {
//
//            adlStoreClient.createDirectory("adl://batpetradlanalyticsadls.azuredatalakestore.net/Global/property1");
//            OutputStream stream = adlStoreClient.createFile(filePathToUpload, IfExists.OVERWRITE  );
//            PrintStream out = new PrintStream(stream);
//            out.close();
//            isUploaded = true;
//
//        }
//        catch (IOException e) {
//            // Dont print it. Instead log this error
//            System.out.println(e);
//            isUploaded = false;
//        }
//
//
//        return isUploaded;
//    }
//
//}
