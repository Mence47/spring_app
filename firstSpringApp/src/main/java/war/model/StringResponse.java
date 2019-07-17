package war.model;

import com.fasterxml.jackson.annotation.JsonView;

public class StringResponse {

    // @JsonView(war.model.StringResponse.class)
    private String response;

    public StringResponse(String s) { 
       this.response = s;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
}