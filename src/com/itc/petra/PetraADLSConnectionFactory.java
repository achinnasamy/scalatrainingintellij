//package com.itc.petra;
//
//
//import com.microsoft.azure.datalake.store.ADLStoreClient;
//import com.microsoft.azure.datalake.store.oauth2.AccessTokenProvider;
//import com.microsoft.azure.datalake.store.oauth2.ClientCredsTokenProvider;
///**
// * Created by dharshekthvel on 29/6/17.
// */
//public class PetraADLSConnectionFactory
//{
//
//    private static String accountFQDN       = "adl://batpetradlanalyticsadls.azuredatalakestore.net";
//    private static String clientID          = "469b38a4-53d4-48ff-9445-a8079f8a7e3f";
//
//    private static String authTokenEndpoint = "https://login.windows.net/fe1ee738-e388-4237-a923-20a0d3dfcda2/oauth2/authorize";
//    //private static String authTokenEndpoint = "https://login.windows.net/fe1ee738-e388-4237-a923-20a0d3dfcda2/oauth2/token";
//    private static String clientKey         = "eVYLtIWkZH5bDoi98teFScJo+rgb6PQjV0cNA/QEuuY=";
//
//    static PetraADLSConnectionFactory petraADLSConnectionFactory
//                                            = new PetraADLSConnectionFactory();
//
//    private PetraADLSConnectionFactory() {   }
//
//
//    public static PetraADLSConnectionFactory getInstance() {
//        return petraADLSConnectionFactory;
//    }
//
//    public ADLStoreClient createConnection() {
//        AccessTokenProvider provider = new ClientCredsTokenProvider(authTokenEndpoint, clientID, clientKey);
//        ADLStoreClient client = ADLStoreClient.createClient(accountFQDN, provider);
//        return client;
//    }
//
//
//}
