package br.com.marcossantos.springbootapi.error;

public class ErrorDetails {
  private String title;
  private int status;
  private String detail;
  private String timestamp;
  private String developerMessage;

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getStatus() {
    return this.status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getDetail() {
    return this.detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public String getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getDeveloperMessage() {
    return this.developerMessage;
  }

  public void setDeveloperMessage(String developerMessage) {
    this.developerMessage = developerMessage;
  }

  public static final class Builder {
    private String title;
    private int status;
    private String detail;
    private String timestamp;
    private String developerMessage;

    private Builder() {
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder status(int status) {
      this.status = status;
      return this;
    }

    public Builder detail(String detail) {
      this.detail = detail;
      return this;
    }

    public Builder timestamp(String timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public Builder developerMessage(String developerMessage) {
      this.developerMessage = developerMessage;
      return this;
    }

    public ErrorDetails build() {
      ErrorDetails errorDetails = new ErrorDetails();
      errorDetails.setDeveloperMessage(developerMessage);
      errorDetails.setDetail(detail);
      errorDetails.setStatus(status);
      errorDetails.setTimestamp(timestamp);
      errorDetails.setTitle(title);
      return errorDetails;
    }
  }

}