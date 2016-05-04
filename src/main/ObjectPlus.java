package main;

import exceptions.UniquenessException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class ObjectPlus implements Serializable {
    private static Hashtable<Class, Vector<ObjectPlus>> classInstances = new Hashtable<>();

    private static Map<String, Set<Object>> attributeValues = new HashMap<>();

    public ObjectPlus() {
        Vector<ObjectPlus> classInstancesVector = null;
        Class klass = this.getClass();

        if(classInstances.containsKey(klass)) {
            classInstancesVector = classInstances.get(klass);
        } else {
            classInstancesVector = new Vector<>();
            classInstances.put(klass, classInstancesVector);
        }
        classInstancesVector.add(this);
    }

    public void checkUniquenessOf(String attribute, Object value) throws UniquenessException {
        if (attributeValues.containsKey(attribute)) {
            for (Object o : attributeValues.get(attribute)) {
                if (o.equals(value)) {
                    throw new UniquenessException("Atrybut " + attribute + " klasy " + this.getClass().getSimpleName() + " o wartości " + value.toString() + " już istnieje!");
                }
            }
        } else {
            attributeValues.put(attribute, new HashSet<>());
        }

        attributeValues.get(attribute).add(value);
    }

    public static void saveClassInstances(ObjectOutputStream stream) throws IOException {
        stream.writeObject(classInstances);
    }

    public static void readClassInstances(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        classInstances = (Hashtable<Class, Vector<ObjectPlus>>) stream.readObject();
    }

    public static Vector<ObjectPlus> getClassInstancesVector(Class klass) {
        return classInstances.get(klass);
    }

    public static void printClassInstances(Class klass) throws Exception {
        Vector<ObjectPlus> classInstancesVector = null;
        if(classInstances.containsKey(klass)) {
            classInstancesVector = classInstances.get(klass);
        } else {
            throw new Exception("Nieznana klasa: " + klass);
        }

        System.out.println("Ekstensja klasy " + klass + ":");

        for(ObjectPlus o : classInstancesVector) {
            System.out.println(o);
        }
    }
}