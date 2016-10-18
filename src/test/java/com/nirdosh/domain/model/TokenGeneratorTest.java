package com.nirdosh.domain.model;

import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenGeneratorTest {

    @Test
    public void test_that_token_generation_works() {

        Token token = TokenGenerator.nextToken();

        assertThat(token).isNotNull();

        IntStream.range(1, 1000).forEach(
                i -> assertThat(TokenGenerator.nextToken()).isNotSameAs(TokenGenerator.nextToken())
        );

    }

}