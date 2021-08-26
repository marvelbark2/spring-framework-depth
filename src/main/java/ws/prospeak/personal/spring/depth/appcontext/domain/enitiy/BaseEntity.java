package ws.prospeak.personal.spring.depth.appcontext.domain.enitiy;

import java.io.Serializable;

public abstract class BaseEntity<T extends Serializable> {
    protected T id;
    public abstract  T getId();
    public abstract  void setId(T id);
}
