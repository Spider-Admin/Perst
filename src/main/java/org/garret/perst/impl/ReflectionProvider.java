package org.garret.perst.impl;

import  java.lang.reflect.*;

public interface ReflectionProvider { 
    Constructor getDefaultConstructor(Class cls) throws Exception;

    void setInt(Field field, Object object, int value) throws Exception;

    void setLong(Field field, Object object, long value) throws Exception;
    
    void setShort(Field field, Object object, short value) throws Exception;

    void setChar(Field field, Object object, char value) throws Exception;

    void setByte(Field field, Object object, byte value) throws Exception;

    void setFloat(Field field, Object object, float value) throws Exception;

    void setDouble(Field field, Object object, double value) throws Exception;

    void setBoolean(Field field, Object object, boolean value) throws Exception;

    void set(Field field, Object object, Object value) throws Exception;

    int  getInt(Field field, Object object) throws Exception;

    long getLong(Field field, Object object) throws Exception;
    
    short getShort(Field field, Object object) throws Exception;

    char getChar(Field field, Object object) throws Exception;

    byte getByte(Field field, Object object) throws Exception;

    float getFloat(Field field, Object object) throws Exception;

    double getDouble(Field field, Object object) throws Exception;

    boolean getBoolean(Field field, Object object) throws Exception;

    Object get(Field field, Object object) throws Exception;
}
