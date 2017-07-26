//package com.itc.petra;
//
//import com.microsoft.azure.datalake.store.ADLStoreClient;
//
///**
// * Created by dharshekthvel on 29/6/17.
// */
//public class PetraADLSClient {
//
//    public static void main(String args[]) {
//        ADLStoreClient adlsClient =  PetraADLSConnectionFactory.getInstance().createConnection();
//        PetraADLSUploadFunction upload = new PetraADLSUploadFunction();
//        Boolean hasFileBeenUploaded = upload.apply("/home/dharshekthvel/ac/a.csv", adlsClient);
//
//        if (hasFileBeenUploaded) {
//            System.out.println("File has been uploaded - who ha !!!");
//        }
//    }
//}
