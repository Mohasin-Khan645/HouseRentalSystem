import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class HouseRentSystem {
    private static List<House> houseList = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("House Management System");
        JButton registerButton = new JButton("Register House");
        JButton viewAllButton = new JButton("View All Houses");
        JButton searchButton = new JButton("Search by ID");
        JButton updateButton = new JButton("Update House");
        JButton deleteButton = new JButton("Delete House");
        JButton exitButton = new JButton("Exit");

        registerButton.setBounds(50, 50, 200, 30);
        viewAllButton.setBounds(50, 100, 200, 30);
        searchButton.setBounds(50, 150, 200, 30);
        updateButton.setBounds(50, 200, 200, 30);
        deleteButton.setBounds(50, 250, 200, 30);
        exitButton.setBounds(50, 300, 200, 30);

        frame.add(registerButton);
        frame.add(viewAllButton);
        frame.add(searchButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(exitButton);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Event Listeners for buttons
        registerButton.addActionListener(e -> registerHouse());
        viewAllButton.addActionListener(e -> viewAllHouses());
        searchButton.addActionListener(e -> searchHouseById());
        updateButton.addActionListener(e -> updateHouse());
        deleteButton.addActionListener(e -> deleteHouse());
        exitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Exiting the system. Goodbye!");
            frame.dispose();
        });
    }

    // Method to register a new house
    private static void registerHouse() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField cityField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField aadhaarField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField flatField = new JTextField();
        JTextField rentField = new JTextField();
        JTextField agreementField = new JTextField();

        Object[] fields = {
            "House ID:", idField,
            "Name:", nameField,
            "Phone:", phoneField,
            "City:", cityField,
            "Email:", emailField,
            "Aadhaar:", aadhaarField,
            "Joining Date (DD/MM/YYYY):", dateField,
            "Flat Number:", flatField,
            "Rent:", rentField,
            "Agreement:", agreementField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Register House", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String phone = phoneField.getText();
                String city = cityField.getText();
                String email = emailField.getText();
                String aadhaar = aadhaarField.getText();
                String date = dateField.getText();
                String flat = flatField.getText();
                double rent = Double.parseDouble(rentField.getText());
                String agreement = agreementField.getText();

                houseList.add(new House(id, name, phone, city, email, aadhaar, date, flat, rent, agreement));
                JOptionPane.showMessageDialog(null, "House Registered Successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Input! Please try again.");
            }
        }
    }

    // Method to view all houses
    private static void viewAllHouses() {
        if (houseList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No houses available.");
        } else {
            StringBuilder sb = new StringBuilder("All Houses:\n");
            for (House house : houseList) {
                sb.append(house).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    // Method to search a house by ID
    private static void searchHouseById() {
        String input = JOptionPane.showInputDialog("Enter House ID to search:");
        try {
            int id = Integer.parseInt(input);
            House house = findHouseById(id);
            if (house != null) {
                JOptionPane.showMessageDialog(null, house.toString());
            } else {
                JOptionPane.showMessageDialog(null, "House not found.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid ID! Please try again.");
        }
    }

    // Method to update a house
    private static void updateHouse() {
        String input = JOptionPane.showInputDialog("Enter House ID to update:");
        try {
            int id = Integer.parseInt(input);
            House house = findHouseById(id);
            if (house != null) {
                JTextField nameField = new JTextField(house.getName());
                JTextField phoneField = new JTextField(house.getPhone());
                JTextField cityField = new JTextField(house.getCity());
                JTextField emailField = new JTextField(house.getEmail());
                JTextField aadhaarField = new JTextField(house.getAadhaar());
                JTextField dateField = new JTextField(house.getJoiningDate());
                JTextField flatField = new JTextField(house.getFlatNumber());
                JTextField rentField = new JTextField(String.valueOf(house.getRent()));
                JTextField agreementField = new JTextField(house.getAgreement());

                Object[] fields = {
                    "Name:", nameField,
                    "Phone:", phoneField,
                    "City:", cityField,
                    "Email:", emailField,
                    "Aadhaar:", aadhaarField,
                    "Joining Date:", dateField,
                    "Flat Number:", flatField,
                    "Rent:", rentField,
                    "Agreement:", agreementField
                };

                int option = JOptionPane.showConfirmDialog(null, fields, "Update House", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    house.setName(nameField.getText());
                    house.setPhone(phoneField.getText());
                    house.setCity(cityField.getText());
                    house.setEmail(emailField.getText());
                    house.setAadhaar(aadhaarField.getText());
                    house.setJoiningDate(dateField.getText());
                    house.setFlatNumber(flatField.getText());
                    house.setRent(Double.parseDouble(rentField.getText()));
                    house.setAgreement(agreementField.getText());
                    JOptionPane.showMessageDialog(null, "House Updated Successfully!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "House not found.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Input! Please try again.");
        }
    }

    // Method to delete a house
    private static void deleteHouse() {
        String input = JOptionPane.showInputDialog("Enter House ID to delete:");
        try {
            int id = Integer.parseInt(input);
            House house = findHouseById(id);
            if (house != null) {
                houseList.remove(house);
                JOptionPane.showMessageDialog(null, "House Deleted Successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "House not found.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid ID! Please try again.");
        }
    }

    private static House findHouseById(int id) {
        for (House house : houseList) {
            if (house.getId() == id) { // Call getId() on the instance `house`
                return house;
            }
        }
        return null;
    }
    
}
