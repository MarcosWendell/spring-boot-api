package br.com.marcossantos.springbootapi.error;

public class ResourceNotFoundDetails extends ErrorDetails {

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

    public ResourceNotFoundDetails build() {
      ResourceNotFoundDetails rnfDetails = new ResourceNotFoundDetails();
      rnfDetails.setDeveloperMessage(developerMessage);
      rnfDetails.setDetail(detail);
      rnfDetails.setStatus(status);
      rnfDetails.setTimestamp(timestamp);
      rnfDetails.setTitle(title);
      return rnfDetails;
    }
  }

}