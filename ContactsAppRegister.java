import java.awt.*;
import javax.swing.*;

public class ContactsAppRegister extends JPanel {
    private static final long serialVersionUID = 1L;

    String firstName = "", lastName = "", phoneNumber = "";
    int isFavourite;

    PhoneAppDB middleware = new PhoneAppDB();

    AppDefault tmp = new AppDefault();
    JLabel firstNameLabel = new JLabel("First Name");
    JLabel lastNameLabel = new JLabel("Last Name");
    JLabel numberLabel = new JLabel("Phone Number");
    JCheckBox favourite = new JCheckBox("Add to favourites");
    JTextField firstNameField = new JTextField();
    JTextField lastNameField = new JTextField();
    JTextField numberField = new JTextField();
    JButton addPhotoButton = new JButton(tmp.getIcon("add-photo"));
    JButton saveButton = new JButton("save", tmp.getIcon("save-sm"));
    int w = tmp.panelWidth, h = tmp.panelHeight;
    int fracX = (int) (w * 0.8);
    int alignX = (int) (w * 0.1);
    int labelH = 30, fieldH = 25;
    int startY = (int) (w * 0.15) + 80;
    int gutter = 10;
    int starY = startY + (gutter * 5) + labelH + fieldH;
    int staY = starY + (gutter * 5) + labelH + fieldH;
    int stY = staY + (gutter * 5) + labelH + fieldH;
    int gapping = labelH + 10;

    public ContactsAppRegister() {
        setLayout(null);
        setBackground(tmp.navColor);

        firstNameLabel.setForeground(Color.WHITE);
        firstNameLabel.setOpaque(false);
        firstNameLabel.setBounds(alignX, startY, fracX, labelH);
        firstNameLabel.setFont(new Font("Lato", Font.BOLD, 18));

        lastNameLabel.setForeground(Color.WHITE);
        lastNameLabel.setOpaque(false);
        lastNameLabel.setBounds(alignX, starY, fracX, labelH);
        lastNameLabel.setFont(new Font("Lato", Font.BOLD, 18));

        numberLabel.setForeground(Color.WHITE);
        numberLabel.setOpaque(false);
        numberLabel.setBounds(alignX, staY, fracX, labelH);
        numberLabel.setFont(new Font("Lato", Font.BOLD, 18));

        favourite.setForeground(Color.WHITE);
        favourite.setBounds(alignX, stY, fracX, labelH);
        favourite.setOpaque(false);
        favourite.setFocusable(false);
        favourite.setFont(new Font("Lato", Font.BOLD, 16));

        firstNameField.setOpaque(false);
        firstNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        firstNameField.setForeground(Color.WHITE);
        firstNameField.setBounds(alignX, startY + labelH + gutter, fracX, fieldH);
        firstNameField.setCaretColor(Color.LIGHT_GRAY);

        lastNameField.setOpaque(false);
        lastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        lastNameField.setForeground(Color.WHITE);
        lastNameField.setBounds(alignX, starY + labelH + gutter, fracX, fieldH);
        lastNameField.setCaretColor(Color.LIGHT_GRAY);

        numberField.setOpaque(false);
        numberField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        numberField.setForeground(Color.WHITE);
        numberField.setBounds(alignX, staY + labelH + gutter, fracX, fieldH);
        numberField.setCaretColor(Color.LIGHT_GRAY);

        addPhotoButton.setOpaque(false);
        addPhotoButton.setContentAreaFilled(false);
        addPhotoButton.setBorder(null);
        addPhotoButton.setBounds((int) (w * 0.4), (int) (w * 0.07), (int) (w * 0.15), (int) (w * 0.15));

        saveButton.setBorderPainted(false);
        saveButton.setBorder(null);
        saveButton.setFocusable(false);
        saveButton.setBackground(Color.GREEN.brighter().brighter().brighter());
        saveButton.setForeground(tmp.navColor);
        saveButton.setBounds(fracX - 80, stY + labelH + (gutter * 2), 120, 40);
        saveButton.addActionListener(e -> saveContact());

        add(addPhotoButton);
        add(firstNameLabel);
        add(lastNameLabel);
        add(numberLabel);
        add(firstNameField);
        add(lastNameField);
        add(numberField);
        add(favourite);
        add(saveButton);

    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void saveContact() {
        firstName = firstNameField.getText();
        lastName = lastNameField.getText();
        phoneNumber = numberField.getText();
        isFavourite = favourite.isSelected() ? 1 : 0;
        if ((firstName == "" && lastName == "") || (firstName == null && lastName == null))
            return;
        if (phoneNumber == null || phoneNumber == "")
            return;
        if (lastName == null || lastName == "")
            lastName = "";
        middleware.addContactsData(firstName, lastName, phoneNumber, isFavourite);
    }
}
