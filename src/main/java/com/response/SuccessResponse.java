/**
 * 
 */
package com.response;

/**
 * @author sunil
 *
 */
public class SuccessResponse extends Response {
	
	Object data;
	
	 public SuccessResponse() {

		    this.setStatus("success");
		    this.setMessage("Service executed successfully");
	}

	
	public SuccessResponse(String message) {
		this.setStatus("success");
		this.setMessage(message);
	}
	
	 public SuccessResponse(Object data) {

		    this.setStatus("success");
		    this.setMessage("Service executed successfully");
		    this.data = data;
    }


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}

	 
}
