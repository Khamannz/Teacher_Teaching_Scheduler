public class Subject {
    private String name;

    private boolean available=true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Subject() {}
    public Subject(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        if(available){
            return
            "Subject{" +
                    "name='" + name + '\'' +
                    ", available=" + " ✅ "+
                    '}';
        }else{ return
            "Subject{" +
                    "name='" + name + '\'' +
                    ", available=" + " ❌ "+
                    '}';
        }
    }
}
