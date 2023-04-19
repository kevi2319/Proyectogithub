package org.alda.dsm.utl.examenbdsql;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerAlumno{
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrimerApellido;

    @FXML
    private TextField txtSegundoApellido;

    @FXML
    private TextField txtCarrera;

    @FXML
    private Button btnGuardar;

    @FXML
    private Label lblResultado;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnMostrar;

    public void insertar() throws SQLException {
        lblResultado.setText("Los datos se estan guardando o hubo un error");
        String sql="INSERT INTO Alumno(idAlumno, matricula, nombre, primerApellido, segundoApellido, carrera) " +
                                "VALUES(?, ?, ?, ?, ?, ?);";
        ConexionSQLNube connMySQL=new ConexionSQLNube();
        Connection conn=connMySQL.open();
        PreparedStatement pstm=conn.prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(txtId.getText()));
        pstm.setString(2, txtMatricula.getText());
        pstm.setString(3, txtNombre.getText());
        pstm.setString(4, txtPrimerApellido.getText());
        pstm.setString(5, txtSegundoApellido.getText());
        pstm.setString(6, txtCarrera.getText());
        pstm.executeUpdate();
        pstm.close();
        connMySQL.close();
        lblResultado.setText("Los datos se guardaron con exito.");
    }

    public void actualizar() throws SQLException{
        lblResultado.setText("Los datos se estan actualizando o hubo un error.");
        String sql="UPDATE Alumno" +
                    " SET matricula=?, nombre=?, primerApellido=?, segundoApellido=?, carrera=?" +
                    " WHERE idAlumno=?;";
        ConexionSQLNube connMySQL=new ConexionSQLNube();
        Connection conn= connMySQL.open();
        PreparedStatement pstm= conn.prepareStatement(sql);
        pstm.setString(1, txtMatricula.getText());
        pstm.setString(2, txtNombre.getText());
        pstm.setString(3, txtPrimerApellido.getText());
        pstm.setString(4, txtSegundoApellido.getText());
        pstm.setString(5, txtCarrera.getText());
        pstm.setInt(6, Integer.parseInt(txtId.getText()));
        pstm.executeUpdate();
        pstm.close();
        connMySQL.close();
        lblResultado.setText("Los datos se actualizaron con exito");
    }

    public void mostrar() throws SQLException{
        lblResultado.setText("Los datos se estan consultando o hubo un error.");
        String sql="SELECT * FROM Alumno;";
        ConexionSQLNube connMySQL=new ConexionSQLNube();
        Connection conn= connMySQL.open();
        PreparedStatement pstm= conn.prepareStatement(sql);
        ResultSet rs= pstm.executeQuery();
        Alumno alumno=new Alumno();
        while(rs.next()){
            alumno.setIdAlumno(rs.getInt("idAlumno"));
            alumno.setMatricula(rs.getString("matricula"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setPrimerApellido(rs.getString("primerApellido"));
            alumno.setSegundoApellido(rs.getString("segundoApellido"));
            alumno.setCarrera(rs.getString("carrera"));

            System.out.println("idAlumno: "+alumno.getIdAlumno());
            System.out.println("matricula: "+alumno.getMatricula());
            System.out.println("nombre: "+alumno.getNombre());
            System.out.println("primerApellido: "+alumno.getPrimerApellido());
            System.out.println("segundoApellido: "+alumno.getSegundoApellido());
            System.out.println("carrera"+alumno.getCarrera());
            System.out.println("-------------------------------------------------------");
        }
        rs.close();
        pstm.close();
        connMySQL.close();
        lblResultado.setText("Los datos fueron mostrados en la consola de manera correcta.");
    }

    public void eliminar() throws SQLException{
        lblResultado.setText("El registro se esta eliminando o hubo un error");
        String sql="DELETE FROM Alumno WHERE idAlumno=?;";
        ConexionSQLNube connMySQL=new ConexionSQLNube();
        Connection conn=connMySQL.open();
        PreparedStatement pstm= conn.prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(txtId.getText()));
        pstm.executeUpdate();
        pstm.close();
        connMySQL.close();
        lblResultado.setText("El registro se elimino con exito.");
    }
}
