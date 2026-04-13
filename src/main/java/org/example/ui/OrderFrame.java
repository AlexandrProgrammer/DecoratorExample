package org.example.ui;

import org.example.dish.Dish;
import org.example.dish.DoubleVenisonDecorator;
import org.example.dish.FireSauceDecorator;
import org.example.dish.NordicFlatbreadDecorator;
import org.example.dish.NordicRagu;
import org.example.dish.SnowBerriesDecorator;
import org.example.model.Order;
import org.example.model.OrderHistory;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class OrderFrame extends JFrame {

    private static final int MAX_MODIFIERS = 3;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final JCheckBox fireSauceCheckBox;
    private final JCheckBox doubleVenisonCheckBox;
    private final JCheckBox snowBerriesCheckBox;
    private final JCheckBox flatbreadCheckBox;

    private final JLabel selectedCountLabel;
    private final JLabel previewLabel;

    private final DefaultListModel<String> listModel;
    private final OrderHistory orderHistory;

    public OrderFrame() {
        super("Нордское рагу — оформление заказа");

        orderHistory = new OrderHistory();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 1200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Оформление заказа: Нордское рагу", SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Модификаторы"));

        fireSauceCheckBox = new JCheckBox("Огненный соус (+10)");
        doubleVenisonCheckBox = new JCheckBox("Двойная порция оленины (+20)");
        snowBerriesCheckBox = new JCheckBox("Снежные ягоды (+5)");
        flatbreadCheckBox = new JCheckBox("Нордская лепёшка (+7)");

        fireSauceCheckBox.addActionListener(e -> updateModifierState());
        doubleVenisonCheckBox.addActionListener(e -> updateModifierState());
        snowBerriesCheckBox.addActionListener(e -> updateModifierState());
        flatbreadCheckBox.addActionListener(e -> updateModifierState());

        leftPanel.add(fireSauceCheckBox);
        leftPanel.add(doubleVenisonCheckBox);
        leftPanel.add(snowBerriesCheckBox);
        leftPanel.add(flatbreadCheckBox);

        selectedCountLabel = new JLabel("Выбрано добавок: 0 из 3");
        previewLabel = new JLabel("Текущий заказ: Нордское рагу | Цена: 50 септимов");

        leftPanel.add(selectedCountLabel);
        leftPanel.add(previewLabel);

        JButton orderButton = new JButton("Оформить заказ");
        orderButton.setAlignmentX(CENTER_ALIGNMENT);
        orderButton.addActionListener(e -> createOrder());

        leftPanel.add(orderButton);

        centerPanel.add(leftPanel, BorderLayout.WEST);

        listModel = new DefaultListModel<>();
        JList<String> historyList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(historyList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("История заказов"));
        scrollPane.setPreferredSize(new Dimension(380, 300));

        centerPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        updateModifierState();
    }

    private void updateModifierState() {
        int selectedCount = countSelectedModifiers();
        boolean limitReached = selectedCount >= MAX_MODIFIERS;

        fireSauceCheckBox.setEnabled(fireSauceCheckBox.isSelected() || !limitReached);
        doubleVenisonCheckBox.setEnabled(doubleVenisonCheckBox.isSelected() || !limitReached);
        snowBerriesCheckBox.setEnabled(snowBerriesCheckBox.isSelected() || !limitReached);
        flatbreadCheckBox.setEnabled(flatbreadCheckBox.isSelected() || !limitReached);

        Dish previewDish = buildDishFromSelection();
        selectedCountLabel.setText("Выбрано добавок: " + selectedCount + " из 3");
        previewLabel.setText("Текущий заказ: " + previewDish.getDescription() + " | Цена: " + previewDish.getCost() + " септимов");
    }

    private int countSelectedModifiers() {
        int count = 0;

        if (fireSauceCheckBox.isSelected()) {
            count++;
        }
        if (doubleVenisonCheckBox.isSelected()) {
            count++;
        }
        if (snowBerriesCheckBox.isSelected()) {
            count++;
        }
        if (flatbreadCheckBox.isSelected()) {
            count++;
        }

        return count;
    }

    private Dish buildDishFromSelection() {
        Dish dish = new NordicRagu();

        if (fireSauceCheckBox.isSelected()) {
            dish = new FireSauceDecorator(dish);
        }
        if (doubleVenisonCheckBox.isSelected()) {
            dish = new DoubleVenisonDecorator(dish);
        }
        if (snowBerriesCheckBox.isSelected()) {
            dish = new SnowBerriesDecorator(dish);
        }
        if (flatbreadCheckBox.isSelected()) {
            dish = new NordicFlatbreadDecorator(dish);
        }

        return dish;
    }

    private void createOrder() {
        Dish dish = buildDishFromSelection();
        String time = LocalTime.now().format(TIME_FORMATTER);

        Order order = new Order(time, dish.getDescription(), dish.getCost());
        orderHistory.add(order);
        listModel.addElement(order.toString());

        JOptionPane.showMessageDialog(
                this,
                "Заказ оформлен:\n" + order,
                "Успех",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}