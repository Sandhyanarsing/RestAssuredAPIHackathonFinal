package AbstractClass;

import io.restassured.specification.RequestSpecification;

public  abstract class  AbstractMethod {
	
	public abstract RequestSpecification createReq( String endpoint);
//	public abstract RequestSpecification PostAndPutReqest( String endpoint);
//	public abstract RequestSpecification GetAndDelRequest( String endpoint);

}
