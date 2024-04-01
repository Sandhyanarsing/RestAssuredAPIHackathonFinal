package TestRequest;




import AbstractClass.AbstractMethod;
import EndPoints.URLs;
import TokenRetreiver.Authorization;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpec extends AbstractMethod {
	
	RequestSpecBuilder req = new RequestSpecBuilder();
	Authorization auth = new Authorization();
	Response response;

	@Override
	public RequestSpecification createReq(String endpoint) {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(endpoint);
		req.setContentType(ContentType.JSON);
		req.setAccept(ContentType.JSON);
		req.addHeader("Authorization", "Bearer "+auth.getAuthorisation());
		RequestSpecification reqspec = req.build();
		return reqspec;
	}

	@Override
	public RequestSpecification NoAuthMethod(String endpoint) {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(endpoint);
		req.setContentType(ContentType.JSON);
		req.setAccept(ContentType.JSON);
		RequestSpecification reqspec = req.build();
		return reqspec;
	}
	

}
	    
