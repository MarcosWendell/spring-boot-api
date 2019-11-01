package br.com.marcossantos.springbootapi.error;

public class ValidationErrorDetails extends ErrorDetails {
  private String field;
  private String fieldMessage;

  public String getField() {
    return this.field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getFieldMessage() {
    return this.fieldMessage;
  }

  public void setFieldMessage(String fieldMessage) {
    this.fieldMessage = fieldMessage;
  }

  public static final class Builder {
    private String title;
    private int status;
    private String detail;
    private String timestamp;
    private String developerMessage;
    private String field;
    private String fieldMessage;

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

    public Builder field(String field) {
      this.field = field;
      return this;
    }

    public Builder fieldMessage(String fieldMessage) {
      this.fieldMessage = fieldMessage;
      return this;
    }

    public ValidationErrorDetails build() {
      ValidationErrorDetails veDetails = new ValidationErrorDetails();
      veDetails.setDeveloperMessage(developerMessage);
      veDetails.setDetail(detail);
      veDetails.setStatus(status);
      veDetails.setTimestamp(timestamp);
      veDetails.setTitle(title);
      veDetails.field = this.field;
      veDetails.fieldMessage = this.fieldMessage;
      return veDetails;
    }
  }
}