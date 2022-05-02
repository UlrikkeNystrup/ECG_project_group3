package data.dto;

public class DoctorDto implements Doctor{
    //denne klasse bruger vi ikke endnu
    private String name;
    private String id;

    public DoctorDto(String name, String id) {
        this.name = name;
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
