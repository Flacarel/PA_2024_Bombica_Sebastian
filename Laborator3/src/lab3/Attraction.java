package lab3;

public abstract class Attraction implements Comparable<Attraction>{
    private String name;
    private String description;
    private String image;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Attraction(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Attraction() {
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public int compareTo(Attraction o) {
        if(name!=null)
            return name.compareTo(o.name);
        else
            return -1;
    }
}


