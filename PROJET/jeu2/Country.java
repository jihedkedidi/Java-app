package jeu2;

public class Country {
    private String name;
    private String continent;
    private String capital;
    private String officialLanguage;
    private int population;
    private String area;

    public Country(String name, String continent, String capital, String officialLanguage, int population,
            String area) {
        this.name = name;
        this.continent = continent;
        this.capital = capital;
        this.officialLanguage = officialLanguage;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getOfficialLanguage() {
        return officialLanguage;
    }

    public void setOfficialLanguage(String officialLanguage) {
        this.officialLanguage = officialLanguage;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
