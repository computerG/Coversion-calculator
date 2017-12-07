
package conversioncalculator;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author peter
 */
public class ConversionCalculator extends JFrame{
// variable declarations
    private JPanel panel,panelTemp,panelDistance,panelFuel;
    private JLabel lblTemperature;
    private JTextField txtTemperature;
    private JButton btnFahrenheit;
    private JButton btnCelsius;
    private JLabel lblDistance;
    private JTextField txtDistance;
    private JButton btnKm;
    private JButton btnMiles;
     private JLabel lblFuel;
    private JTextField txtFuel;
    private JButton btnGallon;
    private JButton btnLitres;
    private final int W_WIDTH=650;
    private final int W_HEIGHT=300;
    
    
    // constructor to initialize the frame 
    public ConversionCalculator() throws HeadlessException {
        super("Conversion Calculator");
        //JFrame frame= new JFrame("Enhanced Calculator");
        setSize(W_WIDTH, W_HEIGHT);// set size of the frame
        setLocationRelativeTo(null);// set loction relative to other components
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close the window 
        buildPanel();//call the buildpanel method 
        add(panel);//add the componet panel frame
        setVisible(true);//show the frame
        setResizable(false);
    }//end constructosetResizabler

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            // TODO code application logic here
           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            new ConversionCalculator(); //call the frame in main class
        } catch (InstantiationException ex) {
            Logger.getLogger(ConversionCalculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ConversionCalculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ConversionCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    private void buildPanel() {
        
       
        lblTemperature=new JLabel("Enter the temperature");
        txtTemperature=new JTextField(10);
        txtTemperature.setEditable(true);
        //
        //
        btnCelsius=new JButton("Calculate Celsius");
        btnFahrenheit=new JButton("Calculate Fahrenheit");
        
        btnCelsius.addActionListener(new ButtonListener());
        btnFahrenheit.addActionListener(new ButtonListener());
        
        lblDistance=new JLabel("Enter the Distance    ");
        txtDistance=new JTextField(10);
        txtDistance.setEditable(true);
        //
        //
        btnKm=new JButton("Calculate Kilometres");
        btnMiles=new JButton("Calculate Miles");
        
        btnKm.addActionListener(new ButtonListener());
        btnMiles.addActionListener(new ButtonListener());
        
        
        lblFuel=new JLabel("Enter Fuel            ");
        txtFuel=new JTextField(10);
        txtFuel.setSize(5, 3);
        txtFuel.setEditable(true);
        //
        //
        btnGallon=new JButton("Calculate Gallon");
        btnLitres=new JButton("Calculate Litres");
        
        //add action listeners for button
        btnGallon.addActionListener(new ButtonListener());
        btnLitres.addActionListener(new ButtonListener());
        
        
        panel=new JPanel();//create panel
        
        panelDistance=new JPanel();
        panelTemp=new JPanel();
        panelFuel=new JPanel();      
        
        panel.setLayout(new GridLayout(3,1,5,5));//border layout
        
        //panel for temperature conversion
        panel.add(panelTemp);
        panelTemp.setBorder(new TitledBorder("Temperature Conversion"));
        panelTemp.add(lblTemperature);
        panelTemp.add(txtTemperature); 
        panelTemp.add(btnFahrenheit);
        panelTemp.add(btnCelsius);
        
        panel.add(panelDistance);//panel for Distance conversion
        panelDistance.setBorder(new TitledBorder("Distance Conversion"));
        panelDistance.add(lblDistance);
        panelDistance.add(txtDistance);       
        panelDistance.add(btnKm);
        panelDistance.add(btnMiles);
        
        panel.add(panelFuel);//panel for fuel conversion
        panelFuel.setBorder(new TitledBorder("Fuel Conversion"));
        panelFuel.add(lblFuel);
        panelFuel.add(txtFuel);
        panelFuel.add(btnLitres);
        panelFuel.add(btnGallon);
        
        
    }//end build panel

    //private inner class
    private class ButtonListener implements ActionListener {
        DecimalFormat format=new DecimalFormat("00.##");//format output
        
        //variable declaration
        private  String strinput;
        private double fahren,celsius;
        private double litres;
        private double gallons;
        private double kilometres;
        private double miles;
        public ButtonListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
         if(e.getSource()==btnFahrenheit){
             
             strinput=txtTemperature.getText();
             if(strinput.isEmpty()){//check if string is empty
                 //display error message
               JOptionPane.showMessageDialog(null, "Empty Input","Error",JOptionPane.ERROR_MESSAGE);
             }
             //end if
             else{
             fahren=Double.parseDouble(strinput);
             celsius=(fahren-32)/1.8;
              //display result
             JOptionPane.showMessageDialog(null, strinput + "  Fahrenheit is "+ format.format(celsius)+ " Celsius", "Temperature conversion -Celsius",JOptionPane.PLAIN_MESSAGE);
             
         } //end else
         }
         //endif
         
         else  if(e.getSource()==btnCelsius){
             
             strinput=txtTemperature.getText();
             if(strinput.isEmpty()){//check if string is empty
               JOptionPane.showMessageDialog(null, "Empty Input","Error",JOptionPane.ERROR_MESSAGE);
             } //end iff
             else{
             celsius=Double.parseDouble(strinput);
             fahren=(celsius*1.8)+32;
              //display result
             JOptionPane.showMessageDialog(null, strinput + "  Celsius is "+ format.format(fahren)+ " Fahrenheit", "Temperature conversion -Fahrenheit",JOptionPane.PLAIN_MESSAGE);
             }//end else
         } //if
          else  if(e.getSource()==btnKm){
             
             strinput=txtDistance.getText();
             if(strinput.isEmpty()){ //check if string is empty
                  //display result
               JOptionPane.showMessageDialog(null, "Empty Input","Error",JOptionPane.ERROR_MESSAGE);
             }//end if
             else{
             miles=Double.parseDouble(strinput);
             kilometres=miles/0.6214;
              //display result
             JOptionPane.showMessageDialog(null, strinput + "  Miles is "+ format.format(kilometres)+ " Kilometers", "Temperature conversion -Kilometers",JOptionPane.PLAIN_MESSAGE);
             }//end else
         }//end if
          else  if(e.getSource()==btnMiles){
             
             strinput=txtDistance.getText();
             if(strinput.isEmpty()){//check if string is empty
               JOptionPane.showMessageDialog(null, "Empty Input","Error",JOptionPane.ERROR_MESSAGE);
             }//end if
             else{
             kilometres=Double.parseDouble(strinput);
             miles=kilometres*0.6214;
             //display result
             JOptionPane.showMessageDialog(null, strinput + "  Kilometers is "+ format.format(miles)+ " Miles", "Distance conversion -Miles",JOptionPane.PLAIN_MESSAGE);
             }//end else
         }//end if
          else  if(e.getSource()==btnGallon){
             
             strinput=txtFuel.getText();
             if(strinput.isEmpty()){//check if string is empty
               JOptionPane.showMessageDialog(null, "Empty Input","Error",JOptionPane.ERROR_MESSAGE);
             }//end if
             else{
             litres=Double.parseDouble(strinput);
             gallons=litres*0.2642;
              //display result
             JOptionPane.showMessageDialog(null, strinput + "  Litres is "+ format.format(gallons)+ " Gallons", "Fuel conversion -Gallons",JOptionPane.PLAIN_MESSAGE);
             }//end else
         }//end if
          else  if(e.getSource()==btnLitres){
             
             strinput=txtFuel.getText();
             if(strinput.isEmpty()){//check if string is empty
               JOptionPane.showMessageDialog(null, "Empty Input","Error",JOptionPane.ERROR_MESSAGE);
             }//end if
             else{
             gallons=Double.parseDouble(strinput);
             litres=gallons/0.2612;
              //display result
             JOptionPane.showMessageDialog(null, strinput + "  Gallons is "+ format.format(litres)+ " Litres", "Fuel conversion -Litres",JOptionPane.PLAIN_MESSAGE);
             
         }//end else
          }//end if
         
        }//end actionperformed
    }//end private class
    
} //end class
