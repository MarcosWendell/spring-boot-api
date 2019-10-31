package br.com.marcossantos.springbootapi.error;

public class CustomErrorType {
  private String errorMessage;

  public CustomErrorType(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  /**
   * @return the errorMessage
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   * @param errorMessage the errorMessage to set
   */
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}