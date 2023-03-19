import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PizzaOrderFrame extends JFrame {
JPanel mainPnl;
JLabel titleLbl;
JRadioButton thinCrust;
JRadioButton regularCrust;
JRadioButton deepCrust;
JComboBox size;
JCheckBox pepperoni;
JCheckBox ham;
JCheckBox kale;
JCheckBox extraCheese;
JCheckBox olives;
JCheckBox tomato;
JPanel orderOptions;
JPanel pizzaSizePnl;
JPanel pizzaToppingPnl;
JPanel pizzaCrustPnl;
JPanel orderReceipt;
JPanel pizzaTopPnl;
JPanel buttons;
JScrollPane scroller;
double total;
double subtotal;
double tax;
String pizzaSize;
JButton order;
JButton clear;
JButton quit;
JTextArea receiptItems;
String sizes[] = { "  ", "small", "medium", "large", "extra large" };
PizzaOrderFrame(){
mainPnl = new JPanel();
    BorderLayout mainLayout = new BorderLayout();
    mainPnl.setLayout(mainLayout);
    createPizzaOptionsPnl();
    createOrderReceiptPnl();
    createButtonsPnl();

    add(mainPnl);
    mainPnl.add(orderOptions, BorderLayout.NORTH);
    mainPnl.add(orderReceipt, BorderLayout.CENTER);
    mainPnl.add(buttons, BorderLayout.SOUTH);
    setSize(600, 800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    mainLayout.setVgap(40);
}

private void createOrderReceiptPnl() {
    orderReceipt = new JPanel();

    receiptItems = new JTextArea(35, 40);
    receiptItems.setVisible(false);
    receiptItems.setEditable(false);
    scroller = new JScrollPane(receiptItems);
    orderReceipt.add(scroller);
    orderReceipt.add(receiptItems);
}
    private void createPizzaOptionsPnl(){
orderOptions  = new JPanel();
        BorderLayout layout = new BorderLayout();
        layout.setVgap(25);
        orderOptions.setLayout(layout);
//checkboxes toppings
        pizzatop();
        orderOptions.add(pizzaTopPnl, BorderLayout.NORTH);
//Crust
        pizzaCrusts();
        orderOptions.add(pizzaCrustPnl, BorderLayout.CENTER);
//size panel added
        pizzaSizes();
        orderOptions.add(pizzaSizePnl, BorderLayout.SOUTH);
    }
    //topping panel
    private void pizzatop(){ //topping final panel
    pizzaTopPnl = new JPanel();
    pizzaTopPnl.setLayout(new BorderLayout());
        JLabel toppingPrice = new JLabel("Toppings are an extra 1.00");
        pizzaToppings();
        pizzaTopPnl.add(toppingPrice, BorderLayout.NORTH);pizzaTopPnl.add(pizzaToppingPnl, BorderLayout.CENTER);
    }
    private void pizzaToppings(){ //topping checkboxes
    pizzaToppingPnl = new JPanel();

    pizzaToppingPnl.setLayout(new GridLayout(3, 3));
        pepperoni = new JCheckBox("pepperoni", false);
        ham = new JCheckBox("ham", false);
        extraCheese = new JCheckBox("extra cheese", false);
        olives = new JCheckBox("olives", false);
        tomato = new JCheckBox("tomato", false);
        kale = new JCheckBox("kale", false);
        pizzaToppingPnl.add(pepperoni);pizzaToppingPnl.add(ham);pizzaToppingPnl.add(extraCheese);
        pizzaToppingPnl.add(olives); pizzaToppingPnl.add(kale);pizzaToppingPnl.add(tomato);
    }
    //crust panel
private void pizzaCrusts() {
    pizzaCrustPnl = new JPanel();
        thinCrust = new JRadioButton("thin Crust", false);
        regularCrust = new JRadioButton("regular Crust", false);
        deepCrust = new JRadioButton("deep dish crust", false);
        pizzaCrustPnl.add(thinCrust); pizzaCrustPnl.add(regularCrust); pizzaCrustPnl.add(deepCrust);
    }
    //size panel
    private void pizzaSizes() {
    pizzaSizePnl = new JPanel();
    pizzaSizePnl.setLayout(new BorderLayout());
        JLabel sizeOption = new JLabel("Small:$8.00   Medium:$12.00   Large:$16.00    Extra-Large:$20.00");
        size = new JComboBox(sizes);

size.addActionListener((ActionEvent ae) -> {
    if(ae.equals("small")){
        pizzaSize = "small";
    } else if(ae.equals("medium")){
        pizzaSize ="medium"; ;
    } else if(ae.equals("large")){
        pizzaSize = "large";
    } else if(ae.equals("extra large")){
        pizzaSize = "extra large";
    }
});
        pizzaSizePnl.add(sizeOption, BorderLayout.NORTH);  pizzaSizePnl.add(size, BorderLayout.CENTER);
    }


    private void createButtonsPnl(){
buttons = new JPanel();
quit = new JButton("quit");
clear = new JButton("clear");
order = new JButton("order");
order.addActionListener((ActionEvent ae) ->  {
receiptItems.setVisible(true);
receiptItems.append("================================================================");
size.getSelectedItem();
if(size.getSelectedItem() == "small" && thinCrust.isSelected()){
    receiptItems.append("\nsmall thin crust                               8.00");
subtotal = subtotal + 8.00;
} else if(size.getSelectedItem() == "small" && regularCrust.isSelected()){
    receiptItems.append("\nsmall regular crust                             8.00");
    subtotal = subtotal + 8.00;
} else if(size.getSelectedItem() == "small" && deepCrust.isSelected()){
    receiptItems.append("\nsmall deep crust                                8.00");
    subtotal = subtotal + 8.00;
    //medium
} else if(size.getSelectedItem() == "medium" && thinCrust.isSelected()){
    receiptItems.append("\nmedium thin crust                               12.00");
    subtotal = subtotal + 12;
} else if(size.getSelectedItem() == "medium" && regularCrust.isSelected()){
    receiptItems.append("\nmedium regular crust                             12.00");
    subtotal = subtotal + 12;
} else if(size.getSelectedItem() == "medium" && deepCrust.isSelected()){
    receiptItems.append("\nmedium deep crust                                12.00");
    subtotal = subtotal + 12;
    //large
}else if(size.getSelectedItem() == "large" && thinCrust.isSelected()){
    receiptItems.append("\nlarge thin crust                                 16.00");
    subtotal = subtotal + 16;
} else if(size.getSelectedItem() == "large" && regularCrust.isSelected()){
    receiptItems.append("\nlarge regular crust                              16.00");
    subtotal = subtotal + 16;
} else if(size.getSelectedItem() == "large" && deepCrust.isSelected()){
    receiptItems.append("\nlarge deep crust                                  16.00");
    subtotal = subtotal + 16;
    // extra large
}else if(size.getSelectedItem() == "extra large" && thinCrust.isSelected()){
    receiptItems.append("\nextra large thin crust                            20.00");
    subtotal = subtotal + 20;
} else if(size.getSelectedItem() == "extra large" && regularCrust.isSelected()){
    receiptItems.append("\nextra large regular crust                         20.00");
    subtotal = subtotal + 20;
} else if(size.getSelectedItem() == "extra large" && deepCrust.isSelected()){
    receiptItems.append("\nextra large deep crust                             20.00");
    subtotal = subtotal + 20;
}
//toppings
if(pepperoni.isSelected()){
    receiptItems.append("\npepperoni                                               1.00");
    subtotal = subtotal + 1;
}
if(olives.isSelected()){
    receiptItems.append("\nolives                                                     1.00");
        subtotal = subtotal + 1;
    }
if(kale.isSelected()){
    receiptItems.append("\nkale                                                        1.00");
        subtotal = subtotal + 1;
    }
if(tomato.isSelected()){
    receiptItems.append("\ntomato                                                      1.00");
        subtotal = subtotal + 1;
    }
if(ham.isSelected()){
    receiptItems.append("\nham                                                         1.00");
        subtotal = subtotal + 1;
    }
if(extraCheese.isSelected()){
    receiptItems.append("\nextra cheese                                            1.00");
        subtotal = subtotal + 1;
    }
//total calculations
    tax = subtotal * .07;
    total = subtotal + tax;
    receiptItems.append("\n\n\n");
    receiptItems.append("\nsubtotal                                                  " + subtotal );
    receiptItems.append("\ntax                                                          " + tax );
receiptItems.append("\n------------------------------------------------------------------------------------------------");
receiptItems.append("\n total                                                      "  + total );
receiptItems.append("");
receiptItems.append("\n================================================================");
});
clear.addActionListener((ActionEvent ae) ->  {
           //crusts
            thinCrust.setSelected(false);
            regularCrust.setSelected(false);
            deepCrust.setSelected(false);
            //toppings
            pepperoni.setSelected(false);
            ham.setSelected(false);
            kale.setSelected(false);
            olives.setSelected(false);
            extraCheese.setSelected(false);
            tomato.setSelected(false);
            //size
            size.setSelectedItem("  ");
            //receipt invisible
            receiptItems.setVisible(false);
            receiptItems.setText("");
            subtotal = 0;
        });
quit.addActionListener((ActionEvent ae) ->  {
    System.exit(0);
        });
        buttons.add(order); buttons.add(clear); buttons.add(quit);
    }

}
