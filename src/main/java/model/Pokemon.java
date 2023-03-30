


package model;
public class Pokemon {
private String name;
private String url;
private String base_experience;
private Integer height;
private Integer weight;
private Sprites sprites;
private Integer order;
private Results results;

public Pokemon (){
}

    


    public String getBase_experience() {
        return base_experience;
    }

    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBase_experience(String base_experience) {
        this.base_experience = base_experience;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    
    public Integer getHeight() {
        return height;
    }

     public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public String getUrl() {
        return url;
    }

    public Results getResults() {
        return results;
    }

    
    public void setHeight(Integer height) {
        this.height = height;
    }
    
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pokemon{");
        sb.append("name=").append(name);
        sb.append(", base_experience=").append(base_experience);
        sb.append(", height=").append(height);
        sb.append(sprites.toString()+'}');
        return sb.toString();
    }

   
 

}
