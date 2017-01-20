package com.company;

import java.nio.file.FileSystemNotFoundException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Entity value = DoSomething.createEntity().
        System.out.println(value);
    }
}

@SuppressWarnings("unused")
class Entity {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class DoSomething {

    private static int counter;

    static Optional<Entity> createEntity() {
        counter++;

        if ( counter % 2 == 0 ) {
            return Optional.of(new Entity());
        }
        return Optional.empty();
    }

}
