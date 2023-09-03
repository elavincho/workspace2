package com.mycompany.login.Logica;

import com.mycompany.login.Logica.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-08-17T22:13:27")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Rol> unRol;
    public static volatile SingularAttribute<Usuario, String> contrasena;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile SingularAttribute<Usuario, String> nombreUsuario;

}