package org.garret.perst.impl;
import  java.lang.reflect.*;
import  java.util.*;

public class StandardReflectionProvider implements ReflectionProvider { 
    static final Class[] defaultConstructorProfile = new Class[0];

    public Constructor getDefaultConstructor(Class cls) throws Exception { 
        return cls.getDeclaredConstructor(defaultConstructorProfile);
    }

    public void setInt(Field field, Object object, int value) throws Exception { 
        field.setInt(object, value);
    }

    public void setLong(Field field, Object object, long value) throws Exception { 
        field.setLong(object, value);
    }

    public void setShort(Field field, Object object, short value) throws Exception { 
        field.setShort(object, value);
    }

    public void setChar(Field field, Object object, char value) throws Exception { 
        field.setChar(object, value);
    }

    public void setByte(Field field, Object object, byte value) throws Exception { 
        field.setByte(object, value);
    }

    public void setFloat(Field field, Object object, float value) throws Exception { 
        field.setFloat(object, value);
    }

    public void setDouble(Field field, Object object, double value) throws Exception { 
        field.setDouble(object, value);
    }

    public void setBoolean(Field field, Object object, boolean value) throws Exception { 
        field.setBoolean(object, value);
    }

    public void set(Field field, Object object, Object value) throws Exception { 
        field.set(object, value);
    }

    public int getInt(Field field, Object object) throws Exception { 
        return field.getInt(object);
    }

    public long getLong(Field field, Object object) throws Exception { 
        return field.getLong(object);
    }

    public short getShort(Field field, Object object) throws Exception { 
        return field.getShort(object);
    }

    public char getChar(Field field, Object object) throws Exception { 
        return field.getChar(object);
    }

    public byte getByte(Field field, Object object) throws Exception { 
        return field.getByte(object);
    }

    public float getFloat(Field field, Object object) throws Exception { 
        return field.getFloat(object);
    }

    public double getDouble(Field field, Object object) throws Exception { 
        return field.getDouble(object);
    }

    public boolean getBoolean(Field field, Object object) throws Exception { 
        return field.getBoolean(object);
    }

    public Object get(Field field, Object object) throws Exception { 
        return field.get(object);
    }
}
