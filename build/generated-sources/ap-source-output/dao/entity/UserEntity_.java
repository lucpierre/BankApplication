package dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-16T16:10:51")
@StaticMetamodel(UserEntity.class)
public class UserEntity_ { 

    public static volatile SingularAttribute<UserEntity, Date> birthday;
    public static volatile SingularAttribute<UserEntity, String> password;
    public static volatile SingularAttribute<UserEntity, String> address;
    public static volatile SingularAttribute<UserEntity, String> civility;
    public static volatile SingularAttribute<UserEntity, String> mail;
    public static volatile SingularAttribute<UserEntity, Date> updated_at;
    public static volatile SingularAttribute<UserEntity, String> phone;
    public static volatile SingularAttribute<UserEntity, String> last_name;
    public static volatile SingularAttribute<UserEntity, Date> created_at;
    public static volatile SingularAttribute<UserEntity, Long> id;
    public static volatile SingularAttribute<UserEntity, String> login;
    public static volatile SingularAttribute<UserEntity, String> first_name;

}