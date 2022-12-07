package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootResponse {

   private List<data> data;

    public List<pojo.data> getData() {
        return data;
    }

    public void setData(List<pojo.data> data) {
        this.data = data;
    }
}
