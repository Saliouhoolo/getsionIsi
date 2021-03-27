package com.mycompany.app.repository.jdbc;


;
import com.mycompany.app.domain.Professeur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class jdbcProfesseurRepository  implements  ProfesseurRepository{
    private final DataSource dataSource;

    public  jdbcProfesseurRepository(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    @Override
    public int add(Professeur professeur) {
        int ok = 0;
        String query = "INSERT INTO professeur (nom,prenom,tel,email,id_classe) VALUES(?,?,?,?)";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,professeur.getNom());
            statement.setString(2, professeur.getPrenom());
            statement.setString(3, professeur.getTel());
            statement.setString(3, professeur.getEmail());
            statement.setInt(4, 1);
            ok = statement.executeUpdate();

            if (ok > 0) {
                System.out.println("etudiant créé avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Professeur professeur) {
        int result = 0;
        String query = "UPDATE  professeur SET nom=?, prenom=?, tel=? email=?  where id=?";
        int ok = 0;
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, professeur.getNom());
            statement.setString(2, professeur.getPrenom());
            statement.setString(3, professeur.getTel());
            statement.setString(4, professeur.getEmail());
            ok = statement.executeUpdate();

            System.out.println(statement);
            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("etudiant est modifiée avec succés!");
            }
            result = ok;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }



    @Override
    public int delete(int idPro) {
        String query = "DELETE FROM professeur where id=?";
        int ok =0;
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idPro);
            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("professeur est suprimé!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Professeur[] getAll() {
        //requête sql pour récupèrer les infos
        String query = "SELECT * FROM etudiant e,classe c where e.id_classe = c.id";
        //mapper le résultat
        List<Professeur> professeurs = new ArrayList<Professeur>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int idPro = rs.getInt("idPro");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String tel = rs.getString("tel");
                String email = rs.getString("email");


                //mapping retour db (relationnel) avec objet Offre
                Professeur professeur= new Professeur( idPro, nom,prenom,tel,email);

                professeurs.add(professeur);
            }
            return professeurs.toArray(new Professeur[0]);

        }
        catch (SQLException e) {
            return new Professeur[0];
        }
        catch (Exception ex){
            return new Professeur[0];
        }
    }

    public abstract int deleteProfesseur();
}
