package com.example;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.XStream;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class XStreamSimpleMapConverterTest 
{
    
    @Test
    public void getXML()
    {
        XStreamSimpleMapConverter converter = new XStreamSimpleMapConverter();
        XStream xstream = new XStream();
        xstream.registerConverter(converter,XStream.PRIORITY_VERY_HIGH);
        xstream.alias("person",Map.class);
        Map<String,Object> m = new HashMap<>();
        m.put("name","john doe");
        m.put("age",18);
        String xml =xstream.toXML(m);
        System.out.println(xml);
    }
}
