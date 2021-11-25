import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;
class CurrencyConverter extends JFrame{

    private double Amount;
    private String fromCurrency, toCurrency;
    CurrencyConverter(){


        String[] Country = {"IND Rupess(INR)", "US Dollars(USD)","Euro(EUR)","Chinese Yuan(CNY)"};

        JLabel label = new JLabel();
        label.setText("Currency Converter");
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.TOP);
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Arial",Font.BOLD,20));
        label.setBounds(10, 12, 600, 40);

        JLabel text1 = new JLabel();
        text1.setText("Convert this ammount:");
        text1.setFont(new Font("Arial",Font.PLAIN,12));
        text1.setHorizontalAlignment(JLabel.LEFT);
        text1.setVerticalAlignment(JLabel.TOP);
        text1.setBounds(5, 5, 190, 20);

        JLabel text2 = new JLabel();
        text2.setText("Frome this currency:");
        text2.setFont(new Font("Arial",Font.PLAIN,12));
        text2.setHorizontalAlignment(JLabel.LEFT);
        text2.setVerticalAlignment(JLabel.TOP);
        text2.setBounds(5, 5, 190, 20);

        JLabel text3 = new JLabel();
        text3.setText("To this currency:");
        text3.setFont(new Font("Arial",Font.PLAIN,12));
        text3.setHorizontalAlignment(JLabel.LEFT);
        text3.setVerticalAlignment(JLabel.TOP);
        text3.setBounds(5, 5, 190, 20);

        JLabel text4 = new JLabel();
        text4.setText("Result ");
        text4.setFont(new Font("Arial",Font.BOLD,18));
        text4.setBounds(230, 1, 100, 30);

        JTextField textField = new JTextField();
        textField.setBounds(5, 25, 160, 30);
        

        JTextField textFieldResult = new JTextField();
        textFieldResult.setBounds(310, 1, 160, 30);
        textFieldResult.setEditable(false);
        textFieldResult.setFont(new Font("Arial",Font.BOLD,18));

        JButton bClose = new JButton();
        bClose.setText("Close");
        bClose.setBounds(568,5,85,34);
        

        JButton bConvert = new JButton();
        bConvert.setText("Convert");
        bConvert.setBounds(460,5,100,34);

        JComboBox list1 = new JComboBox(Country);
        list1.setBounds(5, 25, 160, 30);

        JComboBox list2 = new JComboBox(Country);
        list2.setBounds(5, 25, 160, 30);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(15, 65, 200, 60);
        

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(230, 65, 200, 60);
        

        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(445, 65, 200, 60);

        JPanel panel5 = new JPanel();
        panel5.setLayout(null);
        panel5.setBounds(5, 180, 660, 48);

        JPanel panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setBounds(5, 280, 660, 48);
        
    
        this.setTitle("Currency Converter");
        
        bConvert.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(textField.getText().isEmpty()){
                JOptionPane.showMessageDialog(textFieldResult,"Enter an amont to Convert");  
                }
                else{
                Amount = Double.parseDouble(textField.getText());
                fromCurrency = list1.getSelectedItem().toString();
                toCurrency = list2.getSelectedItem().toString();
                double result = convert_method(Amount, fromCurrency, toCurrency);

                textFieldResult.setText(String.valueOf(result));
                }
                
            }
        });

        bClose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(670,380);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.add(label);

        textField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               String value = textField.getText();
               int l = value.length();
               if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyCode() ==  KeyEvent.VK_BACK_SPACE ) {
                  textField.setEditable(true);
               } 
               else if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                if(textField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(textFieldResult,"Enter an amont to Convert");  
                    }
                    else{
                    Amount = Double.parseDouble(textField.getText());
                    fromCurrency = list1.getSelectedItem().toString();
                    toCurrency = list2.getSelectedItem().toString();
                    double result = convert_method(Amount, fromCurrency, toCurrency);
    
                    textFieldResult.setText(String.valueOf(result));
                    }
               }
               else {
                  textField.setEditable(false);
                  JOptionPane.showMessageDialog(textFieldResult,"Enter numbers only");
               }
            }
         });

        panel1.add(text1);
        panel1.add(textField);
        this.add(panel1);

        panel2.add(text2);
        panel2.add(list1);
        this.add(panel2);

        panel3.add(text3);
        panel3.add(list2);
        this.add(panel3);

        panel5.add(text4);
        panel5.add(textFieldResult);
        this.add(panel5);

        panel4.add(bConvert);
        panel4.add(bClose);
        this.add(panel4);

    }
    public static double convert_method(double ammount,String FCurrency,String TCurrency){
        HashMap<String,Double> exchangeRates = new HashMap<String,Double>();
        switch(FCurrency){
            case "IND Rupess(INR)":
              exchangeRates.put("IND Rupess(INR)",1.0);
              exchangeRates.put("US Dollars(USD)",0.013);
              exchangeRates.put("Euro(EUR)",0.012);
              exchangeRates.put("Chinese Yuan(CNY)", 0.086);
              break;
            
            case "US Dollars(USD)":
              exchangeRates.put("IND Rupess(INR)",74.46);
              exchangeRates.put("US Dollars(USD)",1.0);
              exchangeRates.put("Euro(EUR)",0.87);
              exchangeRates.put("Chinese Yuan(CNY)",6.40);
              break;
            case "Euro(EUR)":
              exchangeRates.put("IND Rupess(INR)", 85.53);
              exchangeRates.put("US Dollars(USD)",1.15);
              exchangeRates.put("Euro(EUR)",1.0);
              exchangeRates.put("Chinese Yuan(CNY)",7.36);
              break;
            case "Chinese Yuan(CNY)":
              exchangeRates.put("IND Rupess(INR)", 11.63);
              exchangeRates.put("US Dollars(USD)",0.16);
              exchangeRates.put("Euro(EUR)",0.14);
              exchangeRates.put("Chinese Yuan(CNY)",1.0);
        }

        double rates = exchangeRates.get(TCurrency);
        double result = ammount*rates;
        result = Math.round(result*100d)/100d;
        return result;
    }
    public static void main(String[] args) {
        CurrencyConverter myFrame = new CurrencyConverter();
    }
}
