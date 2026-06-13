package main.model;

public record Person(String name, Integer age, String address,String email) {
    public Category category() {

        if (age == null) {
            return null;
        }

        return age > 18
                ? Category.ADULT
                : Category.KID;
    }
}
