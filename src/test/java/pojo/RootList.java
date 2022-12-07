package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RootList {

    private String name;
    private String age;
    private List<SomelistRequest> somelist;

    public RootList(String name, String age, List<SomelistRequest> somelist) {
        this.name = name;
        this.age = age;
        this.somelist = somelist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<SomelistRequest> getSomelist() {
        return somelist;
    }

    public void setSomelist(List<SomelistRequest> somelist) {
        this.somelist = somelist;
    }
}
