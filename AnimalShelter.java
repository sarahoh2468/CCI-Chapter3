import java.util.LinkedList;

abstract class Animal {
    /* An animal shelter, which holds dogs and cats, operates on first in, first out. People must adopt the oldest of
    all animals or may choose what type of animal. Create the data structures to maintain this system and implement
    operations such as enqueue, dequeueAny, dequeueDog, dequeueCat. You may use the built-in LinkedList data structure
     */
    private int order;
    protected String name;
    public Animal(String n) {
        name = n;
    }
    public void setOrder(int ord) {
        order = ord;
    }
    public int getOrder() {
        return order;
    }
    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}

class AnimalShelter {
    LinkedList<Animal> dogs = new LinkedList<Animal>();
    LinkedList<Animal> cats = new LinkedList<Animal>();
    private int order = 0;

    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;
        if (a.name == "dog") {
            dogs.addLast(a);
        }
        else if (a.name == "cat") {
            cats.addLast(a);
        }

    }
    public Animal dequeueAny() {
        Animal dog = dogs.peek();
        Animal cat = cats.peek();
        if (dogs.size() == 0) {
            return dequeueCats();
        }
        if (cats.size() == 0) {
            return dequeueDogs();
        }
        if (dog.getOrder() < cat.getOrder()) {
            return dequeueDogs();
        }
        else {
            return dequeueCats();
        }
    }
    public Animal dequeueDogs() {
        return dogs.poll();
    }
    public Animal dequeueCats() {
        return cats.poll();
    }
}