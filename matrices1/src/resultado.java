import javax.swing.*;
import java.awt.*;

public class resultado extends JFrame {
  int columnas;
  int filas;
  JTextField[][] matrix;
  public resultado(int filas, int columnas, JTextField[][] textFields){
    super("Resultado");
    this.columnas = columnas;
    this.filas = filas;
    matrix = textFields;
    setSize(500,500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    initComponents();
    setVisible(true);
  }
  private void initComponents(){
    JPanel ventanaP = new JPanel();
    this.setContentPane(ventanaP);
    ventanaP.setLayout(new GridLayout(1,2));
    JPanel matriz1 = new JPanel();
    matriz1.setLayout(new GridLayout(this.columnas,this.filas));
    matriz1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    for (int i = 0; i < this.columnas; i++) {
      for (int j = 0; j < this.filas; j++) {
        matrix[i][j].setFont(new Font("ComicSans",Font.BOLD,40));
        matrix[i][j].setForeground(new Color(0x3300cc));
        matrix[i][j].setEnabled(false);
        matriz1.add(matrix[i][j]);
      }
    }
    ventanaP.add(matriz1);
  }
}
