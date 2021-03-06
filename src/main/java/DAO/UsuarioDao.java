package DAO;

import clases.Usuario;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class UsuarioDao {

    private Sql2o conexion = null;

    public void insertarUsuario(Usuario usuario) {
        String sql = "insert into usuario (id, username, nombre, password,administrator,autor,activo) values(:id,:username,:nombre,:password,:administrator,:autor,:activo)";
        Conexion con = new Conexion();
        conexion = con.getConexion();
        conexion.open();
        String lastId = "select top 1 * from usuario order by id desc";
        Long id = conexion.createQuery(lastId).executeScalar(Long.class)+1;
        System.out.println(id);
        conexion.createQuery(sql)
                .addParameter("id",id)
                .addParameter("username",usuario.getUsername())
                .addParameter("nombre", usuario.getNombre())
                .addParameter("password",usuario.getPassword())
                .addParameter("administrator",usuario.isAdministrador())
                .addParameter("autor",usuario.isAutor())
                .addParameter("activo",usuario.isActivo())
                .executeUpdate();



    }
}
