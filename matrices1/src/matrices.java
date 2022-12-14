import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class matrices extends JFrame {
  int columnas = 4;
  int filas = 4;
  JTextField[][] textFields = new JTextField[columnas][filas];
  JTextField[][] textFields1 = new JTextField[columnas][filas];

  public matrices() {
    super("Matrices");
    setSize(1000, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    initComponents();
    setVisible(true);
  }

  private void initComponents() {
    filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las filas"));
    columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las columnas"));
    JPanel ventanaP = new JPanel();
    this.setContentPane(ventanaP);
    ventanaP.setLayout(new GridLayout(1, 2));
    JPanel matriz1 = new JPanel();
    matriz1.setLayout(new GridLayout(this.columnas, this.filas));
    matriz1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    for (int i = 0; i < this.columnas; i++) {
      for (int j = 0; j < this.filas; j++) {
        textFields[i][j] = new JTextField();
        matriz1.add(textFields[i][j]);
      }
    }
    JButton sumar = new JButton("Sumar matrices");
    sumar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        sumarFuncion(actionEvent);
      }
    });
    JButton restar = new JButton("Restar matrices");
    restar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        restarFuncion(actionEvent);
      }
    });
    JButton trazo = new JButton("Trazar matriz");
    trazo.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        trazoFuncion(actionEvent);
      }
    });
    JButton determinante = new JButton("Determinante de la matriz");
    determinante.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        determinanteFuncion(actionEvent);
      }
    });

    JPanel matriz2 = new JPanel();
    matriz2.setLayout(new GridLayout(this.columnas, this.filas));
    matriz2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    for (int i = 0; i < this.columnas; i++) {
      for (int j = 0; j < this.filas; j++) {
        textFields1[i][j] = new JTextField();
        matriz2.add(textFields1[i][j]);
      }
    }
    ventanaP.add(matriz1);
    JPanel botones = new JPanel();
    botones.add(sumar);
    botones.add(restar);
    botones.add(trazo);
    botones.add(determinante);
    ventanaP.add(botones);
    ventanaP.add(matriz2);
  }

  public void sumarFuncion(ActionEvent e) {
    JTextField[][] resultado = new JTextField[this.columnas][this.filas];
    for (int i = 0; i < this.columnas; i++) {
      for (int j = 0; j < this.filas; j++) {
        resultado[i][j] = new JTextField();
        if (textFields[i][j].getText().equals("")) textFields[i][j].setText("0");
        if (textFields1[i][j].getText().equals("")) textFields1[i][j].setText("0");
        resultado[i][j].setText(String.valueOf(Integer.parseInt(textFields[i][j].getText()) + Integer.parseInt(textFields1[i][j].getText())));
      }
    }
    new resultado(this.filas, this.columnas, resultado);
  }

  public void restarFuncion(ActionEvent e) {
    JTextField[][] resultado = new JTextField[this.columnas][this.filas];
    for (int i = 0; i < this.columnas; i++) {
      for (int j = 0; j < this.filas; j++) {
        resultado[i][j] = new JTextField();
        if (textFields[i][j].getText().equals("")) textFields[i][j].setText("0");
        if (textFields1[i][j].getText().equals("")) textFields1[i][j].setText("0");
        resultado[i][j].setText(String.valueOf(Integer.parseInt(textFields[i][j].getText()) - Integer.parseInt(textFields1[i][j].getText())));
      }
    }
    new resultado(this.filas, this.columnas, resultado);
  }

  public void trazoFuncion(ActionEvent e) {
    if (this.filas == this.columnas) {
      int resultado = 0;
      for (int i = 0; i < this.columnas; i++) {
        for (int j = 0; j < this.filas; j++) {
          if (textFields[i][j].getText().equals("")) textFields[i][j].setText("0");
          if (i == j) resultado = resultado + Integer.parseInt(textFields[i][j].getText());
        }
      }
      JOptionPane.showMessageDialog(null, "la traza de la matriz es: " + resultado);
    } else {
      JOptionPane.showMessageDialog(null, "La matriz no es cuadrada");
    }
  }

  public void determinanteFuncion(ActionEvent e) {
    int resultado = 0;
    if (this.filas == 2 && this.columnas == 2) {
      resultado = (Integer.parseInt(textFields[0][0].getText()) *
          Integer.parseInt(textFields[1][1].getText())) -
          Integer.parseInt(textFields[1][0].getText()) *
          Integer.parseInt(textFields[0][1].getText());
      JOptionPane.showMessageDialog(null, "la determinante de la matriz es: " + resultado);
    } else if (this.filas == 3 && this.columnas == 3) {
      resultado = (Integer.parseInt(textFields[0][0].getText()) * Integer.parseInt(textFields[1][1].getText()) * Integer.parseInt(textFields[2][2].getText())) +
          (Integer.parseInt(textFields[0][1].getText()) * Integer.parseInt(textFields[1][2].getText()) * Integer.parseInt(textFields[2][0].getText())) +
          (Integer.parseInt(textFields[0][2].getText()) * Integer.parseInt(textFields[1][0].getText()) * Integer.parseInt(textFields[2][1].getText())) -
          (Integer.parseInt(textFields[0][2].getText()) * Integer.parseInt(textFields[1][1].getText()) * Integer.parseInt(textFields[2][0].getText())) -
          (Integer.parseInt(textFields[0][0].getText()) * Integer.parseInt(textFields[1][2].getText()) * Integer.parseInt(textFields[2][1].getText())) -
          (Integer.parseInt(textFields[0][1].getText()) * Integer.parseInt(textFields[1][0].getText()) * Integer.parseInt(textFields[2][2].getText()));
      JOptionPane.showMessageDialog(null, "la determinante de la matriz es: " + resultado);
    } else {
      JOptionPane.showMessageDialog(null,"solo validas matrices de 2x2 y 3x3");
    }
  }

  public static void main(String[] args) {
    new matrices();
  }
}
