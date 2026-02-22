

import java.awt.*;
import java.util.HashMap;

import javax.swing.*;

public class GymInterface{
    static GymManager m = new GymManager();
public static void main(String[] args) {
    // Load data from the database
    m.loadData();

    // Example GUI to display data
    GUI();
}
public static void GUI() {
JFrame frame = new JFrame("Gym Rats Login Form");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

// Outer panel with a neutral background
JPanel outerPanel = new JPanel(new GridBagLayout());
outerPanel.setBackground(new Color(240, 240, 240)); // Light gray for a clean look

// Login panel with a more spacious border
JPanel loginPanel = new JPanel(new GridBagLayout());
loginPanel.setPreferredSize(new Dimension(800, 600)); // Larger panel size
loginPanel.setBackground(Color.WHITE);
loginPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

// Layout constraints
GridBagConstraints gbc = new GridBagConstraints();
gbc.insets = new Insets(15, 15, 15, 15); // Increased spacing around components

// Title Label with a larger font
JLabel titleLabel = new JLabel("WELCOME TO THE GYM");
titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Larger font size for title
titleLabel.setForeground(new Color(0, 102, 204)); // Blue color for vibrancy
gbc.gridx = 0;
gbc.gridy = 0;
gbc.gridwidth = 2;
gbc.anchor = GridBagConstraints.CENTER;
loginPanel.add(titleLabel, gbc);

// Buttons Panel with larger buttons and more spacing
JPanel buttonPanel = new JPanel(new GridBagLayout());
buttonPanel.setBackground(Color.WHITE);

GridBagConstraints buttonGbc = new GridBagConstraints();
buttonGbc.insets = new Insets(10, 0, 10, 0); // Spacing between buttons
buttonGbc.gridx = 0;
buttonGbc.gridy = GridBagConstraints.RELATIVE; // Auto-increment row for each button
buttonGbc.fill = GridBagConstraints.HORIZONTAL; // Make buttons stretch horizontally

JButton adminButton = new JButton("ADMIN");
adminButton.setFont(new Font("Arial", Font.BOLD, 16)); // Larger font for buttons
adminButton.setPreferredSize(new Dimension(200, 40)); // Bigger buttons
buttonPanel.add(adminButton, buttonGbc);

JButton memberButton = new JButton("REGISTER MEMBER  ");
memberButton.setFont(new Font("Arial", Font.BOLD, 15)); // Larger font for buttons
memberButton.setPreferredSize(new Dimension(200, 40)); // Bigger buttons
buttonPanel.add(memberButton, buttonGbc);

JButton trainerButton = new JButton("REGISTER TRAINER ");
trainerButton.setFont(new Font("Arial", Font.BOLD, 15)); // Larger font for buttons
trainerButton.setPreferredSize(new Dimension(200, 40)); // Bigger buttons
buttonPanel.add(trainerButton, buttonGbc);

// Add the button panel to the login panel
gbc.gridy = 1;
gbc.gridwidth = 2;
gbc.anchor = GridBagConstraints.CENTER;
loginPanel.add(buttonPanel, gbc);

// Add login panel to outer panel
outerPanel.add(loginPanel);

// Add outer panel to the frame
frame.add(outerPanel);
frame.setVisible(true);

adminButton.addActionListener(e -> logIn());
memberButton.addActionListener(e ->  registerNewMember());
trainerButton.addActionListener(e -> showAddTrainerForm());


    }

    public static void logIn(){
     
    
        // Create the main frame
        JFrame frame = new JFrame("Gym Rats Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Outer panel with a neutral background
        JPanel outerPanel = new JPanel(new GridBagLayout());
        outerPanel.setBackground(new Color(240, 240, 240)); // Light gray for a clean look

        // Login panel with a more spacious border
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setPreferredSize(new Dimension(800, 600)); // Larger panel size
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        // Layout constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // Increased spacing around components

        // Title Label with a larger font
        JLabel titleLabel = new JLabel("GYM RATS");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Larger font size for title
        titleLabel.setForeground(new Color(0, 102, 204)); // Blue color for vibrancy
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(titleLabel, gbc);

        // Username Label and Text Field with larger components
        JLabel nameLabel = new JLabel("UserName:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Larger font for labels
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        loginPanel.add(nameLabel, gbc);

        JTextField nameField = new JTextField(25); // Wider text field
        nameField.setFont(new Font("Arial", Font.PLAIN, 16)); // Larger text for readability
        nameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        loginPanel.add(nameField, gbc);

        // Password Label and Password Field with larger components
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Larger font for labels
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        loginPanel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(25); // Wider password field
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16)); // Larger text for readability
        passwordField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        loginPanel.add(passwordField, gbc);

        // Buttons Panel with larger buttons and more spacing
        JPanel buttonPanel = new JPanel(); // Increased spacing between buttons
        buttonPanel.setBackground(Color.WHITE);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16)); // Larger font for buttons
        loginButton.setPreferredSize(new Dimension(150, 40)); // Bigger buttons
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 16)); // Larger font for buttons
        resetButton.setPreferredSize(new Dimension(150, 40)); // Bigger buttons 
        

        // Add buttons to panel
       // buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);
        buttonPanel.add(resetButton);

        // Add the button panel to the login panel
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(buttonPanel, gbc);

        // Add login panel to outer panel
        outerPanel.add(loginPanel);

        // Add outer panel to the frame
        frame.add(outerPanel);
        frame.setVisible(true);



    // Button Actions
    resetButton.addActionListener(e -> {
        nameField.setText("");
        passwordField.setText("");
    });

    loginButton.addActionListener(e -> {
        String username = nameField.getText();
        String password = new String(passwordField.getPassword());
        if (username.equals("admin") && password.equals("admin123")) {
            JOptionPane.showMessageDialog(loginPanel, "Login successful!");
            frame.dispose();
            showManagementGUI();
            
        } else {
            JOptionPane.showMessageDialog(loginPanel, "Invalid login. Please try again.");
        }
    });

    }

    public static void registerNewMember() {
        JFrame frame = new JFrame("Register New Member");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());

        // Outer panel with a neutral background
        JPanel outerPanel = new JPanel(new GridBagLayout());
        outerPanel.setBackground(new Color(240, 240, 240)); // Light gray background for a clean look

        // Registration panel
        JPanel registerPanel = new JPanel(new GridBagLayout());
        registerPanel.setBackground(Color.WHITE);
        registerPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)); // Border around the panel

        // Layout constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // Increased spacing between fields
        gbc.fill = GridBagConstraints.HORIZONTAL; // Stretch components horizontally

        // Title Label
        JLabel titleLabel = new JLabel("Register New Member");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Larger font size for title
        titleLabel.setForeground(new Color(0, 102, 204)); // Blue color for vibrancy
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4; // Span title across both columns
        gbc.anchor = GridBagConstraints.CENTER;
        registerPanel.add(titleLabel, gbc);

        // Reset constraints for form fields
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Define labels and fields for 15 attributes
        String[] labels = {
            "First Name:", "Last Name:", "Age:", "Gender (M/F):", "Birthdate (yyyy-mm-dd):",
            "Phone Number:", "Email:", "Address:", "Nationality:", "Emergency Contact:",
            "Workout Time:", "Start Date:", "Payment Status:", "Password:",
        };

        JTextField[] textFields = new JTextField[labels.length];
        JPasswordField passwordField = new JPasswordField(25);

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = (i % 2 == 0) ? 0 : 2; // Left column for even indices, right column for odd indices
            gbc.gridy = (i / 2) + 1; // Increment row after every two fields

            JLabel label = new JLabel(labels[i]);
            registerPanel.add(label, gbc);

            gbc.gridx = (i % 2 == 0) ? 1 : 3; // Place the text field next to the label
            if (labels[i].equals("Password:")) {
                passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
                passwordField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                registerPanel.add(passwordField, gbc);
            } else {
                textFields[i] = new JTextField(25);
                textFields[i].setFont(new Font("Arial", Font.PLAIN, 16));
                textFields[i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                registerPanel.add(textFields[i], gbc);
            }
        }

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Increased spacing between buttons
        buttonPanel.setBackground(Color.WHITE);

        JButton saveButton = new JButton("Register");
        JButton cancelButton = new JButton("Cancel");
        styleButton(saveButton);
        styleButton(cancelButton);

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        // Add button panel to the register panel
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 4; // Span buttons across all columns
        gbc.anchor = GridBagConstraints.CENTER;
        registerPanel.add(buttonPanel, gbc);

        // Add register panel to outer panel
        outerPanel.add(registerPanel);

        // Add outer panel to the frame
        frame.add(outerPanel);
        frame.setVisible(true);

        // Save Button Logic
        saveButton.addActionListener(e -> {
            String id = m.generateMemberID();
            String[] formData = new String[labels.length];
            for (int i = 0; i < textFields.length; i++) {
                if (textFields[i] != null) {
                    formData[i] = textFields[i].getText().trim();
                }
            }

            // Get password from password field
            String password = new String(passwordField.getPassword()).trim();
            formData[13] = password;

            // Validate fields
            for (int i = 0; i < formData.length; i++) {
                if (formData[i] == null || formData[i].isEmpty()) {
                    JOptionPane.showMessageDialog(frame, labels[i] + " is required.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Additional validations
            if (!formData[2].matches("\\d+") || Integer.parseInt(formData[2]) <= 0) { // Age validation
                JOptionPane.showMessageDialog(frame, "Age must be a positive integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!formData[5].matches("\\d{10}")) { // Phone number validation
                JOptionPane.showMessageDialog(frame, "Phone number must be exactly 10 digits.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!formData[6].matches("^[\\w-.]+@[\\w-]+\\.[a-z]{2,}$")) { // Email validation
                JOptionPane.showMessageDialog(frame, "Invalid email format.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!formData[3].equalsIgnoreCase("M") && !formData[3].equalsIgnoreCase("F")) { // Gender validation
                JOptionPane.showMessageDialog(frame, "Gender must be 'M' or 'F'.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Add member logic
            String[] newMember = new String[labels.length + 1];
            newMember[0] = id; // Add generated ID
            System.arraycopy(formData, 0, newMember, 1, formData.length); // Copy form data

            m.members.add(newMember); // Add to in-memory list
            m.refreshMemberTable(); // Refresh UI
            JOptionPane.showMessageDialog(frame, "Member registered successfully!");

            // Close the form
            frame.dispose();
            showMembershipOptions(id);;
        });

        // Cancel Button Logic
        cancelButton.addActionListener(e -> frame.dispose());
    }

    
    // Utility Method: Create labeled text fields
    public static JTextField createLabeledField(JPanel panel, GridBagConstraints gbc, String labelText) {
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel label = new JLabel(labelText);
        panel.add(label, gbc);

        gbc.gridx = 1;
        JTextField textField = new JTextField(25);
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setPreferredSize(new Dimension(200, 30));
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        panel.add(textField, gbc);

        return textField;
    }

    // Utility Method: Style buttons
    public static void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(150, 40));
    }

    public static void showAddTrainerForm() {
        JFrame frame = new JFrame("Add Trainer");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());
        
       

        // Outer panel with a neutral background
        JPanel outerPanel = new JPanel(new GridBagLayout());
        outerPanel.setBackground(new Color(240, 240, 240)); // Light gray background for a clean look

        // Registration panel
        JPanel registerPanel = new JPanel(new GridBagLayout());
        registerPanel.setBackground(Color.WHITE);
        registerPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)); // Border around the panel
        
        

        // Layout constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // Increased spacing between fields
        gbc.anchor = GridBagConstraints.WEST;

        // Title Label
        JLabel titleLabel = new JLabel("Register New Trainer");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Larger font size for title
        titleLabel.setForeground(new Color(0, 102, 204)); // Blue color for vibrancy
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        registerPanel.add(titleLabel, gbc);

        gbc.gridy++;
        
        // Form Fields
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Define labels for trainer attributes
        String[] labels = {
             "Name:", "Age:", "Gender (M/F):", "Expertise:", "Phone Number:", "Email:", "Address:",
            "Years of Experience:", "Certification:", "Hourly Rate:", "Availability:", "Preferred Clients:",
            "Bio:", "Special Achievements:"
        };

        JTextField[] textFields = new JTextField[labels.length];

        // Create fields for the trainer form dynamically
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            JLabel label = new JLabel(labels[i]);
            registerPanel.add(label, gbc);

            gbc.gridx = 1;
            textFields[i] = new JTextField(25);
            textFields[i].setFont(new Font("Arial", Font.PLAIN, 14));
            textFields[i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            registerPanel.add(textFields[i], gbc);

            gbc.gridy++; // Move to the next row
        }

        // Buttons Panel (Save and Cancel)
        JPanel buttonPanel = new JPanel(); // Increased spacing between buttons
        buttonPanel.setBackground(Color.WHITE);

        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");
        styleButton(saveButton);
        styleButton(cancelButton);

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        // Add button panel to the register panel
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        registerPanel.add(buttonPanel, gbc);

        // Add register panel to outer panel
        outerPanel.add(registerPanel);

        // Add outer panel to the frame
        frame.add(outerPanel);
        frame.setVisible(true);

        // Save Button Logic
        saveButton.addActionListener(e -> {
            String[] newTrainer = new String[labels.length];
            for (int i = 0; i < labels.length; i++) {
                newTrainer[i] = textFields[i].getText().trim();
            }

            // Validate fields
	     
            for (String field : newTrainer) {
                if (field.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Add new trainer logic
            m.addTrainer(newTrainer);
            JOptionPane.showMessageDialog(frame, "Trainer registered successfully!");
            frame.dispose();
        });

        // Cancel Button Logic
        cancelButton.addActionListener(e -> frame.dispose());
    }


    // Example GUI to display the management windows
    public static void showMembershipOptions(String username) {
        HashMap<String, Integer> prices = m.loadMembershipPrices(); // Always load the latest prices

        JFrame frame = new JFrame("Membership");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("MEMBERSHIP", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Bronze Panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        JPanel bronzePanel = createMembershipPanel(
            "BRONZE",
            "1 MONTH MEMBERSHIP\n24 HRS ACCESS IN GYM\nFOR ONLY ₱" + prices.get("Bronze"),
            "Purchase",
            username,
            "Bronze"
        );
        mainPanel.add(bronzePanel, gbc);

        // Gold Panel
        gbc.gridx = 1;
        gbc.gridy = 0;
        JPanel goldPanel = createMembershipPanel(
            "GOLD",
            "WITH TRAINOR\n2 MONTH MEMBERSHIP\n24 HRS ACCESS IN GYM\nFOR ONLY ₱" + prices.get("Gold"),
            "Purchase",
            username,
            "Gold"
        );
        mainPanel.add(goldPanel, gbc);

        // Platinum Panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        JPanel platinumPanel = createMembershipPanel(
            "PLATINUM",
            "WITH TRAINOR\n3 MONTH MEMBERSHIP\n24 HRS ACCESS IN GYM\nFOR ONLY ₱" + prices.get("Platinum"),
            "Purchase",
            username,
            "Platinum"
        );
        mainPanel.add(platinumPanel, gbc);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void showMembershipOptions1(String username) {
        JFrame frame = new JFrame("Membership");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Adjusted size for better spacing
        frame.setLayout(new BorderLayout());
    
        // Title Label
        JLabel titleLabel = new JLabel("MEMBERSHIP", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32)); // Larger title font
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        frame.add(titleLabel, BorderLayout.NORTH);
    
        // Main Panel for Memberships
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        // GridBagConstraints for uniform sizing and alignment
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Panels will expand to fill their grid cell
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing between panels
        gbc.weightx = 1.0; // Equal width for all panels
        gbc.weighty = 1.0; // Equal height for all panels
    
        // Add Bronze Panel
        gbc.gridx = 0; // Column 0
        gbc.gridy = 0; // Row 0
        JPanel bronzePanel = createMembershipPanel(
                "BRONZE",
                "1 MONTH MEMBERSHIP\n24 HRS ACCESS IN GYM\nFOR ONLY ₱800",
                "Purchase",
                username,
                "Bronze"
        );
        mainPanel.add(bronzePanel, gbc);
    
        // Add Gold Panel
        gbc.gridx = 1; // Column 1
        gbc.gridy = 0; // Row 0
        JPanel goldPanel = createMembershipPanel(
                "GOLD",
                "WITH TRAINOR\n2 MONTH MEMBERSHIP\n24 HRS ACCESS IN GYM\nFOR ONLY ₱1500",
                "Purchase",
                username,
                "Gold"
        );
        mainPanel.add(goldPanel, gbc);
    
        // Add Platinum Panel
        gbc.gridx = 0; // Centered horizontally (merged)
        gbc.gridy = 1; // Row 1
        gbc.gridwidth = 2; // Spans two columns
        JPanel platinumPanel = createMembershipPanel(
                "PLATINUM",
                "WITH TRAINOR\n3 MONTH MEMBERSHIP\n24 HRS ACCESS IN GYM\nFOR ONLY ₱2150",
                "Purchase",
                username,
                "Platinum"
        );
        mainPanel.add(platinumPanel, gbc);
    
        // Add the main panel to the frame
        frame.add(mainPanel, BorderLayout.CENTER);
    
        // Make the frame visible
        frame.setVisible(true);
    }
    
    public static JPanel createMembershipPanel(String title, String description, String buttonText, String username, String membershipType) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.setBackground(Color.WHITE);
    
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int scaledWidth = (int) (screenSize.width * 0.2); // 20% of screen width
        int scaledHeight = (int) (screenSize.height * 0.03); // 3% of screen height

        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, (int) (scaledHeight * 0.5))); // Adjust font size
        textField.setPreferredSize(new Dimension(scaledWidth, scaledHeight));
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        // Title Label
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Larger font for titles
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        // Description Label
        JLabel descriptionLabel = new JLabel("<html>" + description.replace("\n", "<br>") + "</html>", SwingConstants.CENTER);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Larger font for descriptions
        descriptionLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        // Purchase Button
        JButton button = new JButton(buttonText);
        button.setFont(new Font("Arial", Font.BOLD, 16)); // Larger button font
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    
        // Add action listener to the purchase button
        button.addActionListener(e -> {
            // Update the membership in the in-memory list
            for (String[] member : m.members) {
                if (member[0].equals(username)) { // Find the correct member
                    member[10] = membershipType; // Update the membership type
                    break;
                }
            }
    
            // Persist changes to the file
            m.saveData();// Persist to file
            m.refreshMemberTable();// Refresh the table display
            JOptionPane.showMessageDialog(panel, "You have successfully purchased the " + membershipType + " membership!");
    
            // Close the membership screen
            SwingUtilities.getWindowAncestor(panel).dispose();
        });
    
        // Add components to the panel
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(descriptionLabel, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);
    
        return panel;
    }
    
    public static void showManagementGUI() {
        JFrame frame = new JFrame("Gym Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(new Color(34, 139, 34)); // Green navigator background
        tabbedPane.setForeground(Color.WHITE); // White text for tabs

        // Member Management Tab
        JPanel memberPanel = new JPanel();
        memberPanel.setLayout(new BoxLayout(memberPanel, BoxLayout.Y_AXIS));

        JTable memberTable = new JTable(m.memberTableModel);
        memberTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Allow multiple selection
        JScrollPane memberScrollPane = new JScrollPane(memberTable);
        memberPanel.add(new JLabel("Members"));
        memberPanel.add(memberScrollPane);

        JButton addMemberButton = new JButton("Add Member");
        JButton editMemberButton = new JButton("Edit Member");
        JButton deleteMemberButton = new JButton("Delete Member");

        addMemberButton.addActionListener(e -> registerNewMember());
        editMemberButton.addActionListener(e -> m.editSelectedMember(memberTable));
        deleteMemberButton.addActionListener(e -> m.deleteSelectedMembers(memberTable)); // Multi-select delete

        JPanel memberButtonPanel = new JPanel();
        memberButtonPanel.add(addMemberButton);
        memberButtonPanel.add(editMemberButton);
        memberButtonPanel.add(deleteMemberButton);
        memberPanel.add(memberButtonPanel);

        tabbedPane.addTab("Members", memberPanel);

        // Trainer Management Tab
        JPanel trainerPanel = new JPanel();
        trainerPanel.setLayout(new BoxLayout(trainerPanel, BoxLayout.Y_AXIS));

        JTable trainerTable = new JTable(m.trainerTableModel);
        trainerTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Allow multiple selection
        JScrollPane trainerScrollPane = new JScrollPane(trainerTable);
        trainerPanel.add(new JLabel("Trainers"));
        trainerPanel.add(trainerScrollPane);

        JButton addTrainerButton = new JButton("Add Trainer");
        JButton editTrainerButton = new JButton("Edit Trainer");
        JButton deleteTrainerButton = new JButton("Delete Trainer");

        addTrainerButton.addActionListener(e -> showAddTrainerForm());
        editTrainerButton.addActionListener(e -> m.editSelectedTrainer(trainerTable));
        deleteTrainerButton.addActionListener(e -> m.deleteSelectedTrainers(trainerTable)); // Multi-select delete

        JPanel trainerButtonPanel = new JPanel();
        trainerButtonPanel.add(addTrainerButton);
        trainerButtonPanel.add(editTrainerButton);
        trainerButtonPanel.add(deleteTrainerButton);
        trainerPanel.add(trainerButtonPanel);

        tabbedPane.addTab("Trainers", trainerPanel);

        // Edit Rates Tab (no changes here)
        JPanel ratesPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel titleLabel = new JLabel("Edit Membership Rates");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        ratesPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;

        // Fields for membership rates
        gbc.gridy++;
        gbc.gridx = 0;
        ratesPanel.add(new JLabel("Bronze Rate (₱):"), gbc);
        gbc.gridx = 1;
        JTextField bronzeRateField = new JTextField(String.valueOf(m.loadMembershipPrices().get("Bronze")), 10);
        ratesPanel.add(bronzeRateField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        ratesPanel.add(new JLabel("Gold Rate (₱):"), gbc);
        gbc.gridx = 1;
        JTextField goldRateField = new JTextField(String.valueOf(m.loadMembershipPrices().get("Gold")), 10);
        ratesPanel.add(goldRateField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        ratesPanel.add(new JLabel("Platinum Rate (₱):"), gbc);
        gbc.gridx = 1;
        JTextField platinumRateField = new JTextField(String.valueOf(m.loadMembershipPrices().get("Platinum")), 10);
        ratesPanel.add(platinumRateField, gbc);

        // Save Button
        JButton saveRatesButton = new JButton("Save Rates");
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        ratesPanel.add(saveRatesButton, gbc);

        saveRatesButton.addActionListener(e -> {
            try {
                int bronzeRate = Integer.parseInt(bronzeRateField.getText());
                int goldRate = Integer.parseInt(goldRateField.getText());
                int platinumRate = Integer.parseInt(platinumRateField.getText());

                HashMap<String, Integer> newRates = new HashMap<>();
                newRates.put("Bronze", bronzeRate);
                newRates.put("Gold", goldRate);
                newRates.put("Platinum", platinumRate);
                m.saveMembershipPrices(newRates);

                JOptionPane.showMessageDialog(frame, "Rates updated successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        tabbedPane.addTab("Edit Rates", ratesPanel);
        
        

        frame.add(tabbedPane);
        m.refreshequipmentTable();
        m.refreshMemberTable();
        m.refreshTrainerTable();
        frame.setVisible(true);
        
        JPanel equipmentPanel = new JPanel();
        equipmentPanel.setLayout(new BoxLayout(equipmentPanel, BoxLayout.Y_AXIS));

        
      

        // Add sample equipment data
        //addSampleEquipmentData(equipmentTableModel);

        JTable equipmentTable = new JTable(m.equipmentTableModel);
        equipmentTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Allow multiple selection
        JScrollPane equipmentScrollPane = new JScrollPane(equipmentTable);
        equipmentPanel.add(new JLabel("Equipment"));
        equipmentPanel.add(equipmentScrollPane);

        JButton addEquipmentButton = new JButton("Add Equipment");
        JButton editEquipmentButton = new JButton("Edit Equipment");
        JButton deleteEquipmentButton = new JButton("Delete Equipment");

        addEquipmentButton.addActionListener(e -> showAddEquipmentForm());
        editEquipmentButton.addActionListener(e -> m.editSelectedEquipment(equipmentTable));
        deleteEquipmentButton.addActionListener(e -> m.deleteSelectedEquipment(equipmentTable)); // Multi-select delete

        JPanel equipmentButtonPanel = new JPanel();
        equipmentButtonPanel.add(addEquipmentButton);
        equipmentButtonPanel.add(editEquipmentButton);
        equipmentButtonPanel.add(deleteEquipmentButton);
        equipmentPanel.add(equipmentButtonPanel);

        tabbedPane.addTab("Equipment", equipmentPanel);

        // Add the tabbed pane to the frame
        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    
        
        // Add more equipment data here as needed...
    

    public static void showAddEquipmentForm() {
        // Create the form to add new equipment
        JFrame frame = new JFrame("Add Equipment");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(0, 2));

        // Labels for equipment attributes
        String[] labels = {
            "Name", "Category", "Brand", "Model", "Purchase Date", "Warranty Expiry Date", 
            "Condition", "Location", "Maintenance Schedule", "Power Consumption", "Max User Weight", 
            "Speed Range", "Incline Range", "Last Maintenance Date"
        };

        JTextField[] fields = new JTextField[labels.length];

        // Create form fields dynamically
        for (int i = 0; i < labels.length; i++) {
            frame.add(new JLabel(labels[i]));
            fields[i] = new JTextField();
            frame.add(fields[i]);
        }

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            // Retrieve data from fields
            String[] equipmentData = new String[fields.length];
            boolean isValid = true;

            // Validate and get input data
            for (int i = 0; i < fields.length; i++) {
                equipmentData[i] = fields[i].getText().trim();
                if (equipmentData[i].isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
                    isValid = false;
                    break;
                }
            }

            // Only add to the table if fields are valid
            if (isValid) {
            	
            	m.addequipment(equipmentData);
               
                m.equipmentTableModel.addRow(equipmentData); // Adds a new row to the table

                // Close the form after saving
                frame.dispose();
            }
        });
        
        m.refreshequipmentTable();
        frame.add(saveButton);
        frame.setVisible(true);
    }
}