package Model;

public interface AccederBD {

  //conectar bd de dades
  public boolean conect();

  //dado un usaurio
  int getnumgames(String Iduser);

  //ver lista nombres de jugadores
  String[] listplayers();

  //ver lista juegos perdidos
  public int numlostgames(String Iduser);

  //ver lista juegos ganados
  public int numwingames(String Iduser);

  //hacer update
  public void update(String IdUser);

}
