package ws.prospeak.personal.spring.depth.appcontext.domain;

import ws.prospeak.personal.spring.depth.appcontext.domain.enitiy.TrackedEntity;

public class Users extends TrackedEntity<Long> {
    private String name;

    public Users(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deleted=" + isDeleted() +
                '}';
    }
}
