package common;

public class ServiceCase {
    private String serviceType;
    private String serviceUrl;
    private String input;
    private String expectOutput;

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getExpectOutput() {
        return expectOutput;
    }

    public void setExpectOutput(String expectOutput) {
        this.expectOutput = expectOutput;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
