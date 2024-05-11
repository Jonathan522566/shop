package Manager_MainMene;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager_MainMenuAction implements ActionListener {
  private Manager_MainMenu mainMenu;
  public Manager_MainMenuAction(Manager_MainMenu mainMenu){
    this.mainMenu=mainMenu;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mainMenu.sales){
           mainMenu.card.show(mainMenu.cardPanel,"0");
        }else if(e.getSource()==mainMenu.stock){
          mainMenu.card.show(mainMenu.cardPanel,"1");
        }else if(e.getSource()==mainMenu.produce){
          mainMenu.card.show(mainMenu.cardPanel,"2");
        } else if(e.getSource()==mainMenu.stock1){
            mainMenu.card.show(mainMenu.cardPanel,"3");
        }
    }
}
