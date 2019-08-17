package de.rieckpil.blog;

public class Token {

    private String name;
    private String payload;

    public Token(String name, String payload) {
        this.name = name;
        this.payload = payload;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Token{" +
                "name='" + name + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
