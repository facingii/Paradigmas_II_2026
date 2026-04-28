package mx.uv.fiee.paradigmas.httpclient;

import javax.swing.*;
import java.awt.*;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.function.Function;


public class Window extends JFrame {

    private final JTextField nameField = new JTextField(20);
    private final JTextField lastNameField = new JTextField(20);
    private final JTextField emailField = new JTextField(20);
    private final JTextField addressField = new JTextField(20);
    private final JButton submitButton = new JButton("Submit");

    public Window() {
        setTitle("User Registration Form");
        setContentPane(buildFormPanel());
        pack();
        setMinimumSize(new Dimension(420, 260));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public void onClick (Function<String, Optional<HttpResponse<String>>> clickHandler)
    {
        submitButton.addActionListener(e -> {
            var response = clickHandler.apply(buildString());

            if (response.isPresent())
            {
                var message = response.get();

                if (response.get().statusCode() == 200 ||
                    response.get().statusCode() == 202 ||
                    response.get().statusCode() == 204)
                {
                    showOkDialog(message);
                }
                else
                {
                    showWrongRequestDialog(message);
                }
            }
        });
    }

    private String buildString ()
    {
        var name = nameField.getText();
        var lastName = lastNameField.getText();
        var email = emailField.getText();
        var address = addressField.getText();

        return String.format("name=%s&lastName=%s&email=%s&address=%s",
                name, lastName, email, address);
    }

    private void showOkDialog (HttpResponse<String> response)
    {
        var status = response.statusCode();
        var message = response.body() == null || response.body().isBlank()
                ? "No message returned by server."
                : response.body();

        var dialogType = status >= 200 && status < 300
                ? JOptionPane.INFORMATION_MESSAGE
                : JOptionPane.WARNING_MESSAGE;

        JOptionPane.showMessageDialog(
                this,
                String.format("Status: %d\nMessage: %s", status, message),
                "Server Response",
                dialogType
        );
    }

    private void showWrongRequestDialog (HttpResponse<String> response)
    {
        JOptionPane.showMessageDialog(
                this,
                response.body(),
                "Request Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    private JPanel buildFormPanel() {
        var panel = new JPanel(new GridBagLayout());
        var constraints = new GridBagConstraints();
        constraints.insets = new Insets(8, 10, 8, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        addRow(panel, constraints, 0, "Name:", nameField);
        addRow(panel, constraints, 1, "Last Name:", lastNameField);
        addRow(panel, constraints, 2, "Email:", emailField);
        addRow(panel, constraints, 3, "Address:", addressField);

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.NONE;
        panel.add(submitButton, constraints);

        return panel;
    }

    private void addRow(JPanel panel, GridBagConstraints constraints, int row, String labelText, JComponent field) {
        constraints.gridx = 0;
        constraints.gridy = row;
        constraints.weightx = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.NONE;
        panel.add(new JLabel(labelText), constraints);

        constraints.gridx = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(field, constraints);
    }


}
