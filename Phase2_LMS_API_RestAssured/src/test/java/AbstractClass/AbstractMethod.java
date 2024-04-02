package AbstractClass;

import io.restassured.specification.RequestSpecification;

public  abstract class  AbstractMethod {
	
	public abstract RequestSpecification createReq( String endpoint);
  public abstract RequestSpecification createReqwithInvalidBaseurl( String endpoint);
  public abstract RequestSpecification NoAuthMethod( String endpoint);
  public abstract RequestSpecification createReq_noauth(String endpoint);
		// TODO Auto-generated method stub

}
