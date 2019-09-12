package com.example;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.thoughtworks.xstream.converters.*;
import com.thoughtworks.xstream.io.*;

/**
 * @author Abhijit Jadeja
 */
public class XStreamSimpleMapConverter implements Converter
{

    Logger logger = Logger.getLogger(XStreamSimpleMapConverter.class.getName());

    

    @Override
    public boolean canConvert(Class map) {
        boolean isMap = Map.class.isAssignableFrom(map);
        logger.log(Level.FINE,"can convert"+map+"? "+isMap);
        return isMap;
    }

    @Override
    public void marshal(Object simpleMap, HierarchicalStreamWriter xmlWriter, MarshallingContext marshallingContext) {
        Map<String,Object> map = (Map<String,Object>) simpleMap;
        map.entrySet().stream().forEach(e->{
         xmlWriter.startNode(e.getKey());
         xmlWriter.setValue(e.getValue().toString());
         xmlWriter.endNode();
        });

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
        throw new RuntimeException("unmarshall not supported");
    }
}
