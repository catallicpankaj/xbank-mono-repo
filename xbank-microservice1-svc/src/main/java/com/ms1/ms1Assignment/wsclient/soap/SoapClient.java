package com.ms1.ms1Assignment.wsclient.soap;

import java.util.concurrent.CompletableFuture;

public interface SoapClient {
	public  <T> CompletableFuture<T> soap(Class<T> responseClass, Object request ) ;

}
