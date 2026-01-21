public class Medication {
    
    private String name;
    private String manufacturer;
    private String description;

    public Medication( String name, String manufacturer, String description) {
        
        this.name = name;
        this.manufacturer = manufacturer;
        this.description = description;
    }

    

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getDescription() {
        return description;
    }

   
    public void setName(String name) {
        this.name = name;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufacturer = manufactureDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  ", Medication Name: " + name +
                ", Manufacture Date: " + manufacturer +
                ", Description: " + description;
    }
}