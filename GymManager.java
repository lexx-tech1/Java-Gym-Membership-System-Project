

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GymManager {
	public static List<String[]> equipments = new ArrayList<>();
    public static List<String[]> members = new ArrayList<>();
    public static List<String[]> trainers = new ArrayList<>();
    public static DefaultTableModel memberTableModel = new DefaultTableModel(new String[]{"MemberId", "First Name", "Last Name", "Age", "Gender", "BirthDate", "Phone Number", "Email", "Address","Nationality:", "Membership Type",
            "Workout Time:", "Start Date:", "Payment Status:", "Password",}, 0);
    public static DefaultTableModel trainerTableModel = new DefaultTableModel(new String[]{ "Name:", "Age:", "Gender:", "Expertise:", "Phone Number:", "Email:", "Address:",
            "Years of Experience:", "Certification:", "Hourly Rate:", "Availability:", "Preferred Clients:",
            "Bio:", "Special Achievements:"}, 0);
    public static DefaultTableModel equipmentTableModel = new DefaultTableModel(new String[]{ "Name", "Category", "Brand", "Model", "Purchase Date", "Warranty Expiry Date", 
            "Condition", "Location", "Maintenance Schedule", "Power Consumption", "Max User Weight", "Speed Range", "Incline Range", "Last Maintenance Date"
},0);
           
           
     public static void loadData() {
        // Clear existing data
        members.clear();
        trainers.clear();
        equipments.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("newData.txt"))) {
            String line;
            boolean isMember = false, isTrainer = false, isEquipment = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // Identify section headers for members, trainers, and equipments
                if (line.equalsIgnoreCase("#MEMBERS")) {
                    isMember = true;
                    isTrainer = false;
                    isEquipment = false;
                } else if (line.equalsIgnoreCase("#TRAINERS")) {
                    isTrainer = true;
                    isMember = false;
                    isEquipment = false;
                } else if (line.equalsIgnoreCase("#EQUIPMENTS")) {
                    isEquipment = true;
                    isMember = false;
                    isTrainer = false;
                } else if (!line.isEmpty()) {
                    String[] data = line.split(",");

                    // Handle Member data
                    if (isMember) {
                        if (data.length == 10) { // If membership type is missing
                            data = Arrays.copyOf(data, 11); // Extend array
                            data[10] = "None"; // Default membership type
                        }
                        members.add(data);
                    }
                    // Handle Trainer data
                    else if (isTrainer) {
                        trainers.add(data);
                    }
                    // Handle Equipment data
                    else if (isEquipment) {
                        // If data length is less than 15, we may have a missing attribute, so we add a default one
                        if (data.length < 15) {
                            data = Arrays.copyOf(data, 15);
                            for (int i = data.length; i < 15; i++) {
                                data[i] = "N/A"; // Default for missing data
                            }
                        }
                        equipments.add(data);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading database file: " + e.getMessage());
        }
    }

    public static void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("newData.txt"))) {
            // Save Members
            writer.write("#MEMBERS\n");
            for (String[] member : members) {
                writer.write(String.join(",", member) + "\n");
            }

            // Save Trainers
            writer.write("\n#TRAINERS\n");
            for (String[] trainer : trainers) {
                writer.write(String.join(",", trainer) + "\n");
            }

            // Save Equipment
            writer.write("\n#EQUIPMENTS\n");
            for (String[] equipment : equipments) {
                writer.write(String.join(",", equipment) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to database file: " + e.getMessage());
        }
    }


    
    
    public static void refreshMemberTable() {
        memberTableModel.setRowCount(0); // Clear existing rows
        for (String[] member : members) {
            memberTableModel.addRow(member); // Add rows from the list
        }
    }
    
    public static void refreshequipmentTable() {
        equipmentTableModel.setRowCount(0); // Clear existing rows
        for (String[] equipment : equipments) {
            equipmentTableModel.addRow(equipment); // Add rows from the list
        }
    }
    
    public static void refreshTrainerTable() {
        trainerTableModel.setRowCount(0); // Clear existing rows
        for (String[] trainer : trainers) {
            trainerTableModel.addRow(trainer); // Add rows from the list
        }
    }

    // Add a new member
    public static void addMember(String[] newMember) {
        members.add(newMember);
        saveData();
        refreshMemberTable();
    }
    
    public static void addequipment(String[] newEquipment) {
        equipments.add(newEquipment);
        saveData();
        refreshequipmentTable();
    }

    // Add a new trainer
    public static void addTrainer(String[] newTrainer) {
        trainers.add(newTrainer);
        saveData();
        refreshTrainerTable();
    }

    public static String generateMemberID() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // Allowed characters (A-Z and 0-9)
        Random random = new Random();
        StringBuilder memberID = new StringBuilder();

        // Generate a random 8-character ID
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(characters.length());
            memberID.append(characters.charAt(index));
        }

        return memberID.toString();
        
        }

        // Utility Methods: Save and Load Membership Prices
    public static HashMap<String, Integer> loadMembershipPrices() {
        HashMap<String, Integer> prices = new HashMap<>();
        File file = new File("newData.txt");
        if (!file.exists()) {
            // Initialize default prices if the file doesn't exist
            prices.put("Bronze", 800);
            prices.put("Gold", 1500);
            prices.put("Platinum", 2150);
            saveMembershipPrices(prices);
            return prices;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                prices.put(parts[0], Integer.parseInt(parts[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prices;
    }

    public static void saveMembershipPrices(HashMap<String, Integer> prices) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("newData.txt"))) {
            for (Map.Entry<String, Integer> entry : prices.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
            System.out.println("Membership prices updated: " + prices); // Debugging log
        } catch (IOException e) {
            e.printStackTrace();
        }
    

    
    }

    public static void deleteSelectedTrainers(JTable trainerTable) {
        int[] selectedRows = trainerTable.getSelectedRows();
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(null, "Please select one or more trainers to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to delete the selected trainers?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            Arrays.sort(selectedRows); // Ensure rows are sorted
            for (int i = selectedRows.length - 1; i >= 0; i--) { // Remove from bottom to avoid index shifts
                trainers.remove(selectedRows[i]);
            }
            saveData();
            refreshTrainerTable();
            JOptionPane.showMessageDialog(null, "Selected trainers have been deleted.");
        }
        }
        
        public static void editSelectedMember(JTable memberTable) {
            int selectedRow = memberTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a member to edit.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] memberData = members.get(selectedRow);
            JFrame editFrame = new JFrame("Edit Member");
            editFrame.setSize(500,500);
            editFrame.setLayout(new GridLayout(0, 2));

            JTextField[] fields = new JTextField[memberData.length];
            for (int i = 0; i < memberData.length; i++) {
                editFrame.add(new JLabel(memberTableModel.getColumnName(i) + ":"));
                fields[i] = new JTextField(memberData[i]);
                editFrame.add(fields[i]);
            }

            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(e -> {
                for (int i = 0; i < memberData.length; i++) {
                    memberData[i] = fields[i].getText().trim();
                }
                members.set(selectedRow, memberData);
                saveData();
                refreshMemberTable();
                editFrame.dispose();
            });

            editFrame.add(saveButton);
            editFrame.pack();
            editFrame.setVisible(true);
        }

        // Method to edit a selected trainer
        public static void editSelectedTrainer(JTable trainerTable) {
            int selectedRow = trainerTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a trainer to edit.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] trainerData = trainers.get(selectedRow);
            JFrame editFrame = new JFrame("Edit Trainer");
            editFrame.setLayout(new GridLayout(0, 2));

            JTextField[] fields = new JTextField[trainerData.length];
            for (int i = 0; i < trainerData.length; i++) {
                editFrame.add(new JLabel(trainerTableModel.getColumnName(i) + ":"));
                fields[i] = new JTextField(trainerData[i]);
                editFrame.add(fields[i]);
            }

            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(e -> {
                for (int i = 0; i < trainerData.length; i++) {
                    trainerData[i] = fields[i].getText().trim();
                }
                trainers.set(selectedRow, trainerData);
                saveData();
                refreshTrainerTable();
                editFrame.dispose();
            });

            editFrame.add(saveButton);
            editFrame.pack();
            editFrame.setVisible(true);
        
    }
        
        public static void editSelectedEquipment(JTable EquipmentrTable) {
            int selectedRow = EquipmentrTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a trainer to edit.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] trainerData = trainers.get(selectedRow);
            JFrame editFrame = new JFrame("Edit Trainer");
            editFrame.setLayout(new GridLayout(0, 2));

            JTextField[] fields = new JTextField[trainerData.length];
            for (int i = 0; i < trainerData.length; i++) {
                editFrame.add(new JLabel(trainerTableModel.getColumnName(i) + ":"));
                fields[i] = new JTextField(trainerData[i]);
                editFrame.add(fields[i]);
            }

            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(e -> {
                for (int i = 0; i < trainerData.length; i++) {
                    trainerData[i] = fields[i].getText().trim();
                }
                trainers.set(selectedRow, trainerData);
                saveData();
                refreshequipmentTable();
                editFrame.dispose();
            });

            editFrame.add(saveButton);
            editFrame.pack();
            editFrame.setVisible(true);
        
    }

    public static void deleteSelectedMembers(JTable memberTable) {
        int[] selectedRows = memberTable.getSelectedRows();
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(null, "Please select one or more members to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to delete the selected members?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            Arrays.sort(selectedRows); // Ensure rows are sorted
            for (int i = selectedRows.length - 1; i >= 0; i--) { // Remove from bottom to avoid index shifts
                members.remove(selectedRows[i]);
            }
            saveData();
            refreshMemberTable();
            JOptionPane.showMessageDialog(null, "Selected members have been deleted.");
        }
    }  

    public static void deleteSelectedEquipment(JTable equipmentTable) {
        int[] selectedRows = equipmentTable.getSelectedRows();
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(null, "Please select one or more equipment to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to delete the selected equipment?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            Arrays.sort(selectedRows); // Ensure rows are sorted
            for (int i = selectedRows.length - 1; i >= 0; i--) { // Remove from bottom to avoid index shifts
                equipments.remove(selectedRows[i]); // Remove from the list
            }
            saveData(); // Persist changes to file
            refreshequipmentTable(); // Refresh the table display
            JOptionPane.showMessageDialog(null, "Selected equipment have been deleted.");
        }
    }
    
   

}

