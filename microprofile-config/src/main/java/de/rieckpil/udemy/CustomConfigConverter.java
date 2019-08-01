package de.rieckpil.udemy;

import org.eclipse.microprofile.config.spi.Converter;

public class CustomConfigConverter implements Converter<Token> {

    @Override
    public Token convert(String value) {
        String[] chunks = value.split(",");
        Token result = new Token(chunks[0], chunks[1]);
        return result;
    }
}
