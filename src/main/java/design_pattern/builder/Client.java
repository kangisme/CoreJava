package design_pattern.builder;

public class Client {
    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private String name;
    private int age;

    public Client(Builder builder) {
        super();
        this.name = builder.name;
        this.age = builder.age;
    }

    public static class Builder {
        private String name;
        private int age;

        public Builder() {
            super();
        }

        public Builder setName(String s) {
            this.name = s;
            return this;
        }

        public Builder setAge(int i) {
            this.age = i;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

}
