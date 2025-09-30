class StdClass {
    private int id;
    private String name;

    public StdClass() {
    }

    public StdClass(int id,String name) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Class1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}