package AbstractClass;

import io.restassured.specification.RequestSpecification;

public  abstract class  AbstractMethod {
	
	public abstract RequestSpecification createReq( String endpoint);
	public abstract RequestSpecification NoAuthMethod( String endpoint);
   
}
