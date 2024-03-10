package io.artcreativity.auth.application.dto;

public class ApiResponse {
    private Boolean success;
    private String message;
    private ResponseType responseType;

    public ApiResponse() {
    }

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(Boolean success, ResponseType responseType) {
        super();
        this.success = success;
        this.responseType = responseType;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the responseType
     */
    public ResponseType getResponseType() {
        return responseType;
    }

    /**
     * @param responseType the responseType to set
     */
    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }



    public enum ResponseType{
        USERNAME_EXISTS,
        EMAIL_EXISTS,
        ACCOUNT_IS_WAITING_TO_ACTIVE,
        CODE_ERROR
    }
}
