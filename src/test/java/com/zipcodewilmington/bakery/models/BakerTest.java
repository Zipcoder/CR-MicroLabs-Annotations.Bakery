package com.zipcodewilmington.bakery.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;


public class BakerTest {
    @Test
    public void testClassSignatureAnnotations() {
        Assert.assertTrue(Baker.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Baker baker = new Baker();
        String json = jsonWriter.writeValueAsString(baker);
    }
}
