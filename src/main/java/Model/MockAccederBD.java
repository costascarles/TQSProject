package Model;

public class MockAccederBD implements AccederBD {

  //conectar bd de dades
  public boolean conect(){return true;};
  //dado un usaurio
  public int getnumgames(String Iduser){
    int games = 10;
    return games;
  };
  //ver lista nombres de jugadores
  public String[] listplayers(){
    String[] players = {"anastasia","pablo"};
    return players;
  }
  //ver lista juegos perdidos
  public int numlostgames(String Iduser){
    return 6;
  }
  //ver lista juegos ganados
  public int numwingames(String Iduser){
    return 4;
  }
  //hacer update
  public void update(String IdUser){
    //se supone que actualizamos cada vez que gana o pierde alguien.
    //no hay una base de datos ni nada
  }

}
